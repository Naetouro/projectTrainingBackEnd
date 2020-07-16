package com.projecttraining.repositories;

import com.projecttraining.data.objects.TrainingDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ITrainingRepository extends JpaRepository<TrainingDO, Integer> {

    @Query("select new TrainingDO(t.id, t.name) from TrainingDO t where t.user.id = :idUser")
    List<TrainingDO> findAllIdNameWhereUserId(int idUser);

    Optional<TrainingDO> findByIdAndIdUser(int idTraining, int idUser);
}
