package com.projecttraining.business;

import com.projecttraining.data.objects.ExerciseDO;
import com.projecttraining.data.objects.ExercisePrimaryMuscleDO;
import com.projecttraining.data.objects.ExerciseSecondaryMuscleDO;
import com.projecttraining.data.objects.MuscleDO;
import com.projecttraining.data.transfer.objects.ExerciseDTO;
import com.projecttraining.data.transfer.objects.MuscleDTO;
import com.projecttraining.repositories.IExerciseRepository;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ExerciseBO {

    @Autowired
    private IExerciseRepository repo;

    public List<ExerciseDTO> findAll(){
        final List<ExerciseDTO> exerciseDTOList = new ArrayList<>();
        final List<ExerciseDO> exerciseDOList = repo.findAll();

        for(ExerciseDO exerciseDO : exerciseDOList){
            final ExerciseDTO exerciseDTO =  new ExerciseDTO(exerciseDO.getId(), exerciseDO.getName(), exerciseDO.getMuscleGroup().getName());
            exerciseDTO.setPrimaryMuscles(new ArrayList<>());
            exerciseDTO.setSecondaryMuscles(new ArrayList<>());

            exerciseDTOList.add(exerciseDTO);
        }

        return exerciseDTOList;
    }

    public List<ExerciseDTO> findAllExercisesByUserIdAndTrainingId(final int idUser, final int idTraining){
        final List<ExerciseDTO> exerciseDTOList = new ArrayList<>();
        final List<ExerciseDO> exerciseDOList = repo.findAllByUserAndTrainings(idUser, idTraining);

        for(ExerciseDO exerciseDO : exerciseDOList){
            final ExerciseDTO exerciseDTO =  new ExerciseDTO(exerciseDO.getId(), exerciseDO.getName());
            exerciseDTO.setPrimaryMuscles(new ArrayList<>());
            exerciseDTO.setSecondaryMuscles(new ArrayList<>());

            exerciseDTOList.add(exerciseDTO);
        }

        return exerciseDTOList;
    }

    public ExerciseDTO findById(final int idExercise) throws IOException {
        final ExerciseDO exerciseDO = repo.findById(idExercise).orElseThrow(RuntimeException::new);
        final ExerciseDTO exerciseDTO = new ExerciseDTO();
        final List<MuscleDTO> primaryMuscles = new ArrayList<>();
       final List<MuscleDTO> secondaryMuscles = new ArrayList<>();

        exerciseDTO.setId(exerciseDO.getId());
        exerciseDTO.setName(exerciseDO.getName());
        exerciseDTO.setDescription(exerciseDO.getDescription());
        setImage(exerciseDO.getImage(), exerciseDTO);

        for(ExercisePrimaryMuscleDO primaryMuscleDO : exerciseDO.getExercisePrimaryMuscleList()){
            final MuscleDO muscleDO = primaryMuscleDO.getMuscle();
            final MuscleDTO muscleDTO = new MuscleDTO(muscleDO.getId(), muscleDO.getName());
            primaryMuscles.add(muscleDTO);
        }

        exerciseDTO.setPrimaryMuscles(primaryMuscles);

        for(ExerciseSecondaryMuscleDO secondaryMuscleDO : exerciseDO.getExerciseSecondaryMuscleList()){
            final MuscleDO muscleDO = secondaryMuscleDO.getMuscle();
            final MuscleDTO muscleDTO = new MuscleDTO(muscleDO.getId(), muscleDO.getName());
            secondaryMuscles.add(muscleDTO);
        }

        exerciseDTO.setSecondaryMuscles(secondaryMuscles);

        return exerciseDTO;
    }

    public List<ExerciseDTO> findAllByPrimaryMuscleId(int idMuscle){
        final List<ExerciseDO> exerciseDOList = repo.findAllByPrimaryMusclesId(idMuscle);
        final List<ExerciseDTO> exerciseDTOList = new ArrayList<>();

        for(ExerciseDO exerciseDO: exerciseDOList){
            final ExerciseDTO exerciseDTO = new ExerciseDTO(exerciseDO.getId(), exerciseDO.getName());
            exerciseDTO.setPrimaryMuscles(new ArrayList<>());
            exerciseDTO.setSecondaryMuscles(new ArrayList<>());
            exerciseDTOList.add(exerciseDTO);
        }

        return exerciseDTOList;
    }

    void setImage(final String image, ExerciseDTO pokemonDTO) throws IOException {
        ClassPathResource cpr = new ClassPathResource("static/images/"+image);
        System.out.println(cpr.exists());
        if (cpr.exists()) {
            byte[] fileContent = FileUtil.readAsByteArray(cpr.getInputStream());
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            pokemonDTO.setImage(encodedString);
        }
    }


}
