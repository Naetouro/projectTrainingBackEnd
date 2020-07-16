package com.projecttraining.repositories;

import com.projecttraining.data.objects.ExerciseDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IExerciseRepository extends JpaRepository<ExerciseDO, Integer> {

    @Query("select new ExerciseDO(e.id, e.name, e.muscleGroup) from ExerciseDO e")
    List<ExerciseDO> findAll();

    @Query("select new ExerciseDO (e.id , e.name ) from ExerciseDO e inner join TrainingExerciseDO te on te.idExercise = e.id inner join TrainingDO t on te.idTraining = t.id inner join UserDO u on t.user.id = u.id where u.id = :idUser and t.id = :idTraining")
    List<ExerciseDO> findAllByUserAndTrainings(int idUser, int idTraining);

    @Query("select new ExerciseDO(e.id, e.name) from ExerciseDO e inner join ExercisePrimaryMuscleDO pm on e.id = pm.idExercise where pm.idMuscle = :idMuscle")
    List<ExerciseDO> findAllByPrimaryMusclesId(int idMuscle);
}
