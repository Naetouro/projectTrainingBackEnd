package com.projecttraining.data.objects;

import javax.persistence.*;

@Entity
@Table(name = "exercises_primary_muscles", schema = "public", catalog = "projecttraining")
@IdClass(ExercisePrimaryMuscleDOPK.class)
public class ExercisePrimaryMuscleDO {
    private Integer idExercise;
    private Integer idMuscle;
    private ExerciseDO exercise;
    private MuscleDO muscle;

    @Id
    @Column(name = "id_exercise", nullable = false)
    public Integer getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(Integer idExercise) {
        this.idExercise = idExercise;
    }

    @Id
    @Column(name = "id_muscle", nullable = false)
    public Integer getIdMuscle() {
        return idMuscle;
    }

    public void setIdMuscle(Integer idMuscle) {
        this.idMuscle = idMuscle;
    }

    @ManyToOne
    @JoinColumn(name = "id_exercise", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ExerciseDO getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseDO exercise) {
        this.exercise = exercise;
    }

    @ManyToOne
    @JoinColumn(name = "id_muscle", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public MuscleDO getMuscle() {
        return muscle;
    }

    public void setMuscle(MuscleDO muscle) {
        this.muscle = muscle;
    }
}
