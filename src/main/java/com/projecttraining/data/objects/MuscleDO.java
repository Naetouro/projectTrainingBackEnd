package com.projecttraining.data.objects;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "muscles", schema = "public", catalog = "projecttraining")
public class MuscleDO {
    private Integer id;
    private String name;
   // private List<ExerciseDO> exercisesPrimaryMuscles;
    //private List<ExerciseDO> exercisesSecondaryMuscles;
    private List<ExerciseDO> exercisesMuscleGroup;
    private Collection<ExercisePrimaryMuscleDO> exercisePrimaryMuscleList;
    private Collection<ExerciseSecondaryMuscleDO> exerciseSecondaryMuscleList;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    @ManyToMany(mappedBy = "primaryMuscles")
    public List<ExerciseDO> getExercisesPrimaryMuscles() {
        return exercisesPrimaryMuscles;
    }

    public void setExercisesPrimaryMuscles(List<ExerciseDO> exercisesPrimaryMuscles) {
        this.exercisesPrimaryMuscles = exercisesPrimaryMuscles;
    }

    @ManyToMany(mappedBy = "secondaryMuscles")
    public List<ExerciseDO> getExercisesSecondaryMuscles() {
        return exercisesSecondaryMuscles;
    }

    public void setExercisesSecondaryMuscles(List<ExerciseDO> exercisesSecondaryMuscles) {
        this.exercisesSecondaryMuscles = exercisesSecondaryMuscles;
    }
*/
    @OneToMany(mappedBy = "muscleGroup")
    public List<ExerciseDO> getExercisesMuscleGroup() {
        return exercisesMuscleGroup;
    }

    public void setExercisesMuscleGroup(List<ExerciseDO> exercisesMuscleGroup) {
        this.exercisesMuscleGroup = exercisesMuscleGroup;
    }

    @OneToMany(mappedBy = "muscle")
    public Collection<ExercisePrimaryMuscleDO> getExercisePrimaryMuscleList() {
        return exercisePrimaryMuscleList;
    }

    public void setExercisePrimaryMuscleList(Collection<ExercisePrimaryMuscleDO> exercisesPrimaryMusclesById) {
        this.exercisePrimaryMuscleList = exercisesPrimaryMusclesById;
    }

    @OneToMany(mappedBy = "muscle")
    public Collection<ExerciseSecondaryMuscleDO> getExerciseSecondaryMuscleList() {
        return exerciseSecondaryMuscleList;
    }

    public void setExerciseSecondaryMuscleList(Collection<ExerciseSecondaryMuscleDO> exercisesSecondaryMusclesById) {
        this.exerciseSecondaryMuscleList = exercisesSecondaryMusclesById;
    }
}
