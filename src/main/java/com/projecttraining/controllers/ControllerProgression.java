package com.projecttraining.controllers;

import com.projecttraining.business.ProgressionBO;
import com.projecttraining.data.transfer.objects.ProgressionDTO;
import com.projecttraining.data.transfer.objects.ProgressionItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ControllerProgression {

    @Autowired
    private ProgressionBO progressionBO;

    @GetMapping(value = "/users/{idUser}/trainings/{idTraining}/exercises/{idExercise}/progression/lastMonths/{nbMonths}")
    public List<ProgressionDTO> findAll(@PathVariable int idUser, @PathVariable int idTraining, @PathVariable int idExercise, @PathVariable int nbMonths) {
        List<ProgressionDTO> list =
        progressionBO.findAllLastMonths(idUser, idTraining, idExercise, nbMonths);

        for(ProgressionDTO progressionDTO : list){
            System.out.println(progressionDTO.getDate());
        }
        return list;
    }

    @PostMapping(value = "/users/{idUser}/trainings/{idTraining}/exercises/{idExercise}/progression")
    public void save(@PathVariable int idUser, @PathVariable int idTraining, @PathVariable int idExercise, @RequestBody ProgressionItemDTO progressionItemDTO) {
        progressionBO.save(idUser, idTraining, idExercise, progressionItemDTO);
    }

    @DeleteMapping(value = "/users/{idUser}/trainings/{idTraining}/exercises/{idExercise}/progression/{idProgression}")
    public void delete(@PathVariable int idUser, @PathVariable int idTraining, @PathVariable int idExercise, @PathVariable int idProgression) {
        progressionBO.delete(idUser, idTraining, idExercise, idProgression);
    }

    @PostMapping(value = "/users/{idUser}/trainings/{idTraining}/exercises/{idExercise}/progression/{idProgression}")
    public void update(@PathVariable int idUser, @PathVariable int idTraining, @PathVariable int idExercise, @PathVariable int idProgression, @RequestBody ProgressionItemDTO progressionItemDTO) {
        progressionBO.update(idUser, idTraining, idExercise, idProgression, progressionItemDTO);
    }
}
