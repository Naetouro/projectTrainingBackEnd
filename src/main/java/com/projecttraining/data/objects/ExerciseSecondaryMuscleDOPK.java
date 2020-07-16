package com.projecttraining.data.objects;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ExerciseSecondaryMuscleDOPK implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExerciseSecondaryMuscleDOPK that = (ExerciseSecondaryMuscleDOPK) o;

        if (idExercise != null ? !idExercise.equals(that.idExercise) : that.idExercise != null) return false;
        if (idMuscle != null ? !idMuscle.equals(that.idMuscle) : that.idMuscle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idExercise != null ? idExercise.hashCode() : 0;
        result = 31 * result + (idMuscle != null ? idMuscle.hashCode() : 0);
        return result;
    }
}
