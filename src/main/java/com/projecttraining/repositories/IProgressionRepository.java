package com.projecttraining.repositories;

import com.projecttraining.data.objects.ProgressionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IProgressionRepository extends JpaRepository<ProgressionDO, Integer> {

    @Query("select new ProgressionDO (p.id, p.reps, p.weight, p.date) from ProgressionDO p inner join TrainingExerciseDO te on te.id = p.trainingExercise.id inner join TrainingDO t on te.idTraining = t.id inner join UserDO u on t.user.id = u.id where u.id = :idUser and te.idTraining = :idTraining and te.idExercise = :idExercise and p.date >= :date group by p.id, p.date order by p.date desc, p.id asc ")
    List<ProgressionDO> findAllLastMonths(int idUser, int idTraining, int idExercise, Date date);

    @Query("select p from ProgressionDO p inner join TrainingExerciseDO te on p.trainingExercise.id = te.id inner join TrainingDO t on te.idExercise = t.id inner join UserDO u on t.idUser = u.id where u.id = :idUser and te.idTraining = :idTraining and te.idExercise = :idExercise and p.id = :idProgression")
    Optional<ProgressionDO> findByUserIdAndTrainingIdAndExerciseIdProgressionId(int idUser, int idTraining, int idExercise, int idProgression);
}
