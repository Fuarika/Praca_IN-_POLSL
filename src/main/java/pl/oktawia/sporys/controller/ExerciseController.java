package pl.oktawia.sporys.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.oktawia.sporys.algorithm.Arithmetic;
import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;
import pl.oktawia.sporys.model.Result;
import pl.oktawia.sporys.request.ExerciseRequest;
import pl.oktawia.sporys.service.ExerciseService;
import pl.oktawia.sporys.service.ResultService;

import java.util.ArrayList;
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
        while (test.size() < 5){
           Exercise ex = exerciseService.getRandomExercise(exercises);
            if (!test.contains(ex)){
                test.add(ex);
            }
        }
        if (test.isEmpty()) {
            return NOTHING;
        }
        model.addAttribute("test", test);
        return TEST;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addNewExercise")
    public String addExerciseForm(Model model){
        Exercise ex = new Exercise();
        model.addAttribute("exerciseForm", ex);
        return "addNewExercise";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addNewExercise")
    public @ResponseBody String addExerciseSave(Model model,
                                    @RequestParam(required=false, name="exerciseForm") Exercise exerciseForm) {

       String arg1_m = exerciseForm.getMantiseArg1();
       String arg1_c = exerciseForm.getCellingArg1();
       String arg2_m = exerciseForm.getMantiseArg2();
       String arg2_c = exerciseForm.getCellingArg2();
       Types type = exerciseForm.getType();
       int p = 10;

       if(arg1_m != null && arg1_m.length() > 0 && arg1_c != null && arg1_c.length() > 0
               && arg2_m != null && arg2_m.length() > 0 && arg2_c != null && arg2_c.length() > 0){

           if(arg1_m.matches("[-+]?[0-9]*\\.?[0-9]+") && arg2_m.matches("[-+]?[0-9]*\\.?[0-9]+")
                   && arg1_c.matches("[-+]?[0-9]") && arg2_c.matches("[-+]?[0-9]")) {

                if(type.compareTo(Types.ADDITION) == 0 || type.compareTo(Types.SUBTRATION) == 0 ){

                  // Integer resultId = Arithmetic.addOrSubFloatingPoint(type, arg1_m, arg1_c, arg2_m,arg2_c, p);

                }else if (type.compareTo(Types.MULTIPLICATION) == 0){



                }else if (type.compareTo(Types.DIVISION) == 0){



                }
               Exercise exerciseNew = new Exercise();
                // dodanie nowego zadania podajac dane :D

           }else {
               return "to nie są liczby";
           }

       }else {
           return "nie sa wypelnione pola poprawnie,sprawdz jeszcze raz";
       }


        return "aaa";

    }

}
