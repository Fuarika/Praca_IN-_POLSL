package pl.oktawia.sporys.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.oktawia.sporys.algorithm.Arithmetic;
import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;
import pl.oktawia.sporys.model.Result;
import pl.oktawia.sporys.request.ExerciseRequest;
import pl.oktawia.sporys.service.ExerciseService;
import pl.oktawia.sporys.service.ResultService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
@Slf4j
public class ExerciseController {

    private static final String EXERCISE = "exercise";
    private static final String NOTHING = "index";
    private static final String TEST = "test";


    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ResultService resultService;


    @RequestMapping(method = RequestMethod.GET, value = "/{type}")
    public String chooseCategory(Model model, @PathVariable("type") String type) {

        if (type.equals("addition")){
            List<Exercise> exercises = exerciseService.getAllExercisesByType(Types.ADDITION);
            model.addAttribute( "exercises", exercises );
            if (exercises.isEmpty()) {
                return NOTHING;
            }
            return EXERCISE;
        } else if(type.equals("subtration")) {
            List<Exercise> exercises = exerciseService.getAllExercisesByType(Types.SUBTRATION);
            model.addAttribute("exercises", exercises);
            model.addAttribute("exerciseRequest", new ExerciseRequest());
            if (exercises.isEmpty()) {
                return NOTHING;
            }
            return EXERCISE;
        } else if(type.equals("multiplation")) {
            List<Exercise> exercises = exerciseService.getAllExercisesByType(Types.MULTIPLICATION);
            model.addAttribute("exercises", exercises);
            if (exercises.isEmpty()) {
                return NOTHING;
            }
            return EXERCISE;
        } else if(type.equals("division")) {
            List<Exercise> exercises = exerciseService.getAllExercisesByType(Types.DIVISION);
            model.addAttribute("exercises", exercises);
            if (exercises.isEmpty()) {
                return NOTHING;
            }
            return EXERCISE;
        } else
            {return NOTHING;}
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String chooseTest(Model model) {
        LinkedList<Exercise> test= new LinkedList<>();
        List<Exercise> exercises = exerciseService.getAll();
        for(Exercise ex: exercises) {
            ex = exerciseService.getRandomExercise(exercises);
            if (!test.contains(ex)){
                test.add(ex);
            }

            if (test.size() >= 5) {
                break;
            }
        }
//        while (test.size() < 5){
//           Exercise ex = exerciseService.getRandomExercise(exercises);
//            if (!test.contains(ex)){
//                test.add(ex);
//            }
//        }
        if (test.isEmpty()) {
            return NOTHING;
        }
        model.addAttribute("test", test);
        return TEST;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addNewExercise")
    public String addExerciseForm(Model model){
        Exercise exerciseForm = new Exercise();
        List<String> type = Arrays.asList("Dodawanie", "Odejmowanie", "Mnożenie", "Dzielenie");
        model.addAttribute("exerciseForm", exerciseForm);
        model.addAttribute("type", type);
        return "addNewExercise";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/addNewExercise"})
    @ResponseBody
    public String addExerciseSave(Model model, @Valid @ModelAttribute("exerciseForm") Exercise exerciseForm){

        try{
            String arg1_mS = String.valueOf(exerciseForm.getMantiseArg1());
            String arg1_cS = String.valueOf(exerciseForm.getCellingArg1());
            String arg2_mS = String.valueOf(exerciseForm.getMantiseArg2());
            String arg2_cS =  String.valueOf(exerciseForm.getCellingArg2());
            //String typeS = String.valueOf(exerciseForm.getType());
            Integer p = 10;
            Types type = Types.ADDITION;

            /// zamienilam stringi na typy nie zapomniec zmienic opocz type



            if (arg1_mS.matches("[-+]?[0-9]*\\.?[0-9]+") && arg2_mS.matches("[-+]?[0-9]*\\.?[0-9]+") &&
                arg1_cS.matches("[-+]?[0-9]") && arg2_cS.matches("[-+]?[0-9]") ) {

                Double arg1_m = Double.parseDouble(arg1_mS);
                Double arg2_m = Double.parseDouble(arg2_mS);
                Integer arg1_c = Integer.parseInt(arg1_cS);
                Integer arg2_c = Integer.parseInt(arg2_cS);

                if (type.compareTo(Types.ADDITION) == 0 || type.compareTo(Types.SUBTRATION) == 0) {
                    Arithmetic calculate = new Arithmetic();
                    Result result = calculate.addOrSubFloatingPoint(type, arg1_m, arg1_c, arg2_m,
                            arg2_c, p);
                    String content;
                    if (type.compareTo(Types.ADDITION) == 0) {
                        content = "Oblicz równanie: X + Y<br/> " +
                                "gdzie: X = " + arg1_m + " x 10^" + arg1_cS + "&nbsp;&nbsp;&nbsp;" + "Y = " + arg2_mS + " x 10^" + arg2_cS + "<br/>";
                    } else {
                        content = "Oblicz równanie: X - Y " +
                                "gdzie: X = " + arg1_mS + " x 10^" + arg1_cS + "&nbsp;&nbsp;&nbsp;" + "Y = " + arg2_mS + " x 10^" + arg2_cS + "<br/>";
                    }

                    resultService.addResult(result);
                    exerciseService.addExercise(type, content, arg1_m, arg1_c,
                            arg2_m, arg2_c, p, result);


                } else if (type.compareTo(Types.MULTIPLICATION) == 0) {

                    Arithmetic calculate = new Arithmetic();
                    Result result = calculate.multiplicatonFlatingPoint(arg1_m, arg1_c, arg2_m,
                            arg2_c, p);

                    String content = "Oblicz równanie: X x Y<br/> " +
                            "gdzie: X = " + arg1_m + " x 10^" + arg1_c + "       " + "Y = " + arg2_m + " x 10^" + arg2_c + "<br/>";

                    resultService.addResult(result);
                    exerciseService.addExercise(type, content, arg1_m, arg1_c,
                            arg2_m, arg2_c, p, result);

                } else if (type.compareTo(Types.DIVISION) == 0) {

                    Arithmetic calculate = new Arithmetic();
                    Result result = calculate.divisionFlatingPoint(arg1_m, arg1_c,
                            arg2_m, arg2_c, p);
                    String content = "Oblicz równanie: X / Y <br/> " +
                            "gdzie: X = " + arg1_m + " x 10^" + arg1_c + "&nbsp;&nbsp;&nbsp;" + "Y = " + arg2_m + " x 10^" + arg2_c + "<br/>";

                    resultService.addResult(result);
                    exerciseService.addExercise(type, content, arg1_m, arg1_c,
                            arg2_m, arg2_c, p, result);

                }
            }else {return "nie sa liczby";}
        } catch (NullPointerException e) {
            return "pola nie sa wypełnione poprawnie";
        }



        String error = "uzupelnij pola ";
        model.addAttribute("errorMessage", error);
        return "/addNewExercise";

    }
    @ModelAttribute("types")
    public List<Types> typeOfExercise()
    {
        return Arrays.asList(Types.values());
    }
}
