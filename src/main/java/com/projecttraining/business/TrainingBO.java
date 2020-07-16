package com.projecttraining.business;

import com.projecttraining.data.objects.TrainingDO;
import com.projecttraining.data.objects.UserDO;
import com.projecttraining.data.transfer.objects.TrainingDTO;
import com.projecttraining.repositories.ITrainingRepository;
import com.projecttraining.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingBO {

    @Autowired
    private ITrainingRepository trainingRepository;

    @Autowired
    private IUserRepository userRepository;

    public List<TrainingDTO> findAll(final int idUser){
        final List<TrainingDTO> trainingDTOList = new ArrayList<>();
        final List<TrainingDO> trainingDOList = trainingRepository.findAllIdNameWhereUserId(idUser);

        for(TrainingDO trainingDO : trainingDOList){
            final TrainingDTO trainingDTO = new TrainingDTO(trainingDO.getId(), trainingDO.getName());

            trainingDTOList.add(trainingDTO);
        }

        return trainingDTOList;
    }

    public void save(final int idUser, final String name){
        final UserDO userDO = userRepository.findById(idUser).orElseThrow(RuntimeException::new);
        final TrainingDO trainingDO = new TrainingDO(name, userDO);
        trainingRepository.save(trainingDO);
    }

    public void delete(final int idUser, final int idTraining){
        final TrainingDO trainingDO = trainingRepository.findByIdAndIdUser(idTraining, idUser).orElseThrow(RuntimeException::new);
        trainingRepository.delete(trainingDO);
    }
}
