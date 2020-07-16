package com.projecttraining.business;

import com.projecttraining.data.objects.MuscleDO;
import com.projecttraining.data.transfer.objects.MuscleDTO;
import com.projecttraining.repositories.IMuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MuscleBO {
    @Autowired
    private IMuscleRepository repo;

    public List<MuscleDTO> findAll(){
        final List<MuscleDTO> muscleDTOList = new ArrayList<>();
        final List<MuscleDO> muscleDOList = repo.findAll();

        for(MuscleDO muscleDO : muscleDOList){
            final MuscleDTO muscleDTO = new MuscleDTO(muscleDO.getId(), muscleDO.getName());
            muscleDTOList.add(muscleDTO);
        }

        return muscleDTOList;
    }



}
