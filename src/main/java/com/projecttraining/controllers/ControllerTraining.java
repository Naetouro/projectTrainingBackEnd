package com.projecttraining.controllers;

import com.projecttraining.business.TrainingBO;
import com.projecttraining.data.transfer.objects.TrainingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ControllerTraining {

    @Autowired
    private TrainingBO trainingBO;

    @GetMapping(value = "/users/{idUser}/trainings")
    public List<TrainingDTO> findAllTrainings(@PathVariable final int idUser){
        return trainingBO.findAll(idUser);
    }

    @PostMapping(value = "/users/{idUser}/trainings")
    public void createTraining(@PathVariable final int idUser, @RequestParam String name){
        trainingBO.save(idUser, name);
    }

    @DeleteMapping(value = "/users/{idUser}/trainings/{idTraining}")
    public void deleteTraining(@PathVariable final int idUser, @PathVariable int idTraining){
        trainingBO.delete(idUser, idTraining);
    }
}
