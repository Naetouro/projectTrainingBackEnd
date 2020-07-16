package com.projecttraining.controllers;

import com.projecttraining.business.ExerciseBO;
import com.projecttraining.business.TrainingBO;
import com.projecttraining.data.transfer.objects.ExerciseDTO;
import com.projecttraining.data.transfer.objects.PageExerciseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ControllerExercise {

    @Autowired
    private ExerciseBO exerciseBO;

    @Autowired
    private TrainingBO trainingBO;

    @GetMapping(value = "/exercises")
    public List<ExerciseDTO> findAllExercises(){
        return exerciseBO.findAll();
    }

    @GetMapping(value = "/exercises/{idExercise}")
    public PageExerciseDTO findExerciseById(@PathVariable int idExercise, @RequestParam int idUser) throws IOException {
        final PageExerciseDTO pageExerciseDTO = new PageExerciseDTO();
        pageExerciseDTO.setExercise(exerciseBO.findById(idExercise));
        pageExerciseDTO.setTrainingList(trainingBO.findAll(idUser));

        return pageExerciseDTO;
    }

    @GetMapping(value = "/users/{idUser}/trainings/{idTraining}/exercises")
    public List<ExerciseDTO> findAllTrainingExercises(@PathVariable final int idUser, @PathVariable final int idTraining){
        return exerciseBO.findAllExercisesByUserIdAndTrainingId(idUser, idTraining);
    }

    @GetMapping(value = "/muscles/{idMuscle}/exercises")
    public List<ExerciseDTO> findAllByPrimaryMuscleId(@PathVariable final int idMuscle){
        return exerciseBO.findAllByPrimaryMuscleId(idMuscle);
    }

}
