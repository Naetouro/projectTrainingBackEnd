package com.projecttraining.controllers;

import com.projecttraining.business.TrainingExerciseBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ControllerTrainingExercise {

    @Autowired
    private TrainingExerciseBO trainingExerciseBO;

    @DeleteMapping(value = "/users/{idUser}/trainings/{idTraining}/exercises/{idExercise}")
    public void delete(@PathVariable final int idUser, @PathVariable int idTraining, @PathVariable int idExercise) {
        trainingExerciseBO.delete(idUser, idTraining, idExercise);
    }

    @PostMapping(value = "/users/{idUser}/trainings/{idTraining}/exercises/{idExercise}")
    public void save(@PathVariable final int idUser, @PathVariable int idTraining, @PathVariable int idExercise) {
        trainingExerciseBO.save(idUser, idTraining, idExercise);
    }
}
