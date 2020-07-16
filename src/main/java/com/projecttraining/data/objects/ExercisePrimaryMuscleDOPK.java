package com.projecttraining.data.objects;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ExercisePrimaryMuscleDOPK implements Serializable {
    private Integer idExercise;
    private Integer idMuscle;

    @Column(name = "id_exercise", nullable = false)
    @Id
    public Integer getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(Integer idExercise) {
        this.idExercise = idExercise;
    }

    @Column(name = "id_muscle", nullable = false)
    @Id
    public Integer getIdMuscle() {
        return idMuscle;
    }

    public void setIdMuscle(Integer idMuscle) {
        this.idMuscle = idMuscle;
    }

}
