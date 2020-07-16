package com.projecttraining.business;

import com.projecttraining.data.objects.ProgressionDO;
import com.projecttraining.data.objects.TrainingExerciseDO;
import com.projecttraining.data.transfer.objects.ProgressionDTO;
import com.projecttraining.data.transfer.objects.ProgressionItemDTO;
import com.projecttraining.repositories.IProgressionRepository;
import com.projecttraining.repositories.ITrainingExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProgressionBO {

    @Autowired
    private IProgressionRepository progressionRepository;

    @Autowired
    private ITrainingExerciseRepository trainingExerciseRepository;

    public List<ProgressionDTO> findAllLastMonths(int idUser, int idTraining, int idExercise, int nbMonths){
        Date date = new Date();
        date.setTime(date.getTime() - (2592000000L*nbMonths));

        final List<ProgressionDO> progressionDOList = progressionRepository.findAllLastMonths(idUser, idTraining, idExercise, date);

        final List<ProgressionDTO> progressionDTOList = new ArrayList<>();
        List<ProgressionItemDTO> progressionItemDTOList;

        for (int i=0; i<progressionDOList.size(); i++){
            Date progressionDate = progressionDOList.get(i).getDate();
            System.out.println(progressionDate);
            final ProgressionDTO progressionDTO = new ProgressionDTO();
            progressionItemDTOList = new ArrayList<>();
            progressionDTO.setDate(progressionDate);
            System.out.println(progressionDTO.getDate());

            while (progressionDate.compareTo(progressionDOList.get(i).getDate()) == 0){
                ProgressionDO progressionDO = progressionDOList.get(i);
                ProgressionItemDTO progressionItemDTO = new ProgressionItemDTO();
                progressionItemDTO.setId(progressionDO.getId());
                progressionItemDTO.setReps(progressionDO.getReps());
                progressionItemDTO.setWeight(progressionDO.getWeight());

                progressionItemDTOList.add(progressionItemDTO);
                i++;
                progressionDate = progressionDO.getDate();

                if(i >= progressionDOList.size()){
                    break;
                }
            }

            i--;

            progressionDTO.setProgressions(progressionItemDTOList);
            progressionDTOList.add(progressionDTO);
        }

        return progressionDTOList;
    }

    public void delete(int idUser, int idTraining, int idExercise, int idProgression){
        final ProgressionDO progressionDO = progressionRepository.findByUserIdAndTrainingIdAndExerciseIdProgressionId(idUser, idTraining, idExercise, idProgression).orElseThrow(RuntimeException::new);
        progressionRepository.delete(progressionDO);
    }

    public void save(int idUser, int idTraining, int idExercise, final ProgressionItemDTO progressionItemDTO){
        final TrainingExerciseDO trainingExerciseDO = trainingExerciseRepository.findByUserIdTrainingIdAndExerciseId(idUser, idTraining, idExercise).orElseThrow(RuntimeException::new);

        final ProgressionDO progressionDO = new ProgressionDO();
        progressionDO.setReps(progressionItemDTO.getReps());
        progressionDO.setWeight(progressionItemDTO.getWeight());
        progressionDO.setTrainingExercise(trainingExerciseDO);

        progressionRepository.save(progressionDO);
    }

    public void update(int idUser, int idTraining, int idExercise, int idProgression, final ProgressionItemDTO progressionItemDTO){
        final ProgressionDO progressionDO = progressionRepository.findByUserIdAndTrainingIdAndExerciseIdProgressionId(idUser, idTraining, idExercise, idProgression).orElseThrow(RuntimeException::new);
        progressionDO.setReps(progressionItemDTO.getReps());
        progressionDO.setWeight(progressionItemDTO.getWeight());
        System.out.println(progressionDO.getReps());
        System.out.println(progressionItemDTO.getReps());
        System.out.println(progressionDO.getWeight());
        System.out.println(progressionItemDTO.getWeight());

       progressionRepository.save(progressionDO);
    }
}
