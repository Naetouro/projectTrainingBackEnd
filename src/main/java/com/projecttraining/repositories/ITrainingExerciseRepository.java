package com.projecttraining.repositories;

import com.projecttraining.data.objects.TrainingExerciseDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITrainingExerciseRepository extends JpaRepository<TrainingExerciseDO, Integer> {

    @Query("select te from TrainingExerciseDO te inner join TrainingDO t on te.idTraining = t.id inner join UserDO u on t.idUser = u.id where u.id = :idUser and te.idTraining = :idTraining and te.idExercise = :idExercise")
    Optional<TrainingExerciseDO> findByUserIdTrainingIdAndExerciseId(int idUser, int idTraining, int idExercise);
}
