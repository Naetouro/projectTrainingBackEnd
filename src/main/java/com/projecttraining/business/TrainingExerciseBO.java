package com.projecttraining.business;

import com.projecttraining.data.objects.ExerciseDO;
import com.projecttraining.data.objects.TrainingDO;
import com.projecttraining.data.objects.TrainingExerciseDO;
import com.projecttraining.repositories.IExerciseRepository;
import com.projecttraining.repositories.ITrainingExerciseRepository;
import com.projecttraining.repositories.ITrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingExerciseBO {

    @Autowired
    private ITrainingExerciseRepository trainingExerciseRepository;
    @Autowired
    private ITrainingRepository trainingRepository;
    @Autowired
    private IExerciseRepository exerciseRepository;

    public void delete(final int idUser, final int idTraining, final int idExercise){
        final TrainingExerciseDO trainingExerciseDO = trainingExerciseRepository.findByUserIdTrainingIdAndExerciseId(idUser, idTraining, idExercise).orElseThrow(RuntimeException::new);

        trainingExerciseRepository.delete(trainingExerciseDO);
    }

    public void save(final int idUser, final int idTraining, final int idExercise){
        final TrainingDO trainingDO = trainingRepository.findByIdAndIdUser(idTraining, idUser).orElseThrow(RuntimeException::new);
        final ExerciseDO exerciseDO = exerciseRepository.findById(idExercise).orElseThrow(RuntimeException::new);
        final TrainingExerciseDO trainingExerciseDO = new TrainingExerciseDO();
        trainingExerciseDO.setTraining(trainingDO);
        trainingExerciseDO.setIdTraining(idTraining);
        trainingExerciseDO.setExercise(exerciseDO);
        trainingExerciseDO.setIdExercise(idExercise);

        trainingExerciseRepository.save(trainingExerciseDO);
    }
}
