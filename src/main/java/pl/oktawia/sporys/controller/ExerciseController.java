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
import pl.oktawia.sporys.model.Result;
import pl.oktawia.sporys.service.ExerciseService;
import pl.oktawia.sporys.service.ResultService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class ExerciseController {

    private static final String EXERCISE = "exercise";
    private static final String RESULT = "result";
    private static final String END = "end";


    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ResultService resultService;

    private List<Exercise> exerciseList;
//
//    @RequestMapping(method = RequestMethod.GET, value = "/{exerciseId}")
//    public String exerciseById(Model model, @PathVariable Long id) {
//        Exercise exercise = exerciseService.getByCategoryId(id);
//        model.addAttribute("Exercise", exercise);
//        return EXERCISE;
//
//    }

    //@RequestMapping(method = RequestMethod.GET, value = "/{exerciseId}/{resultId}")
    //public String resultById(Model model, @PathVariable Long resultId) {
    //    Result result = resultService.getByExerciseId(resultId);
    //    model.addAttribute("Result", result);
    //    return RESULT;
   // }

    @RequestMapping(method = RequestMethod.GET, value = "/ex")
    public String chooseCategory(Model model, @RequestParam(value = "exType", required = false) Types type) {

        List<Exercise> exercises = exerciseService.getAllExercisesByType(Types.ADDITION);
        model.addAttribute( "exercises", exercises );
        if (exercises.isEmpty()) {
                  return "pusto";
               }
        return EXERCISE;
    }

}
