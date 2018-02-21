package pl.oktawia.sporys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;
import pl.oktawia.sporys.service.ExerciseService;
import pl.oktawia.sporys.service.ResultService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
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

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String checkExercise(Model model) {

        return NOTHING;
    }

}
