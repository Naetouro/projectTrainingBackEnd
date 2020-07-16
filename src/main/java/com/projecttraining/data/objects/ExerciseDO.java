package com.projecttraining.data.objects;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "exercises", schema = "public", catalog = "projecttraining")
public class ExerciseDO {
    private Integer id;
    private String name;
    private String description;
   // private List<MuscleDO> primaryMuscles;
   // private List<MuscleDO> secondaryMuscles;
    private MuscleDO muscleGroup;
    private List<TrainingExerciseDO> trainingsExercisesById;
    private String image;
    private Collection<ExercisePrimaryMuscleDO> exercisePrimaryMuscleList;
    private Collection<ExerciseSecondaryMuscleDO> exerciseSecondaryMuscleList;

    public ExerciseDO() {
    }

    public ExerciseDO(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public ExerciseDO(Integer id, String name, MuscleDO muscleGroup) {
        this.id = id;
        this.name = name;
        this.muscleGroup = muscleGroup;
    }

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

    @Basic
    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/*
    @ManyToMany
    @JoinTable(name = "exercises_primary_muscles", catalog = "projecttraining", schema = "public", joinColumns = @JoinColumn(name = "id_exercise", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_muscle", referencedColumnName = "id", nullable = false))
    public List<MuscleDO> getPrimaryMuscles() {
        return primaryMuscles;
    }

    public void setPrimaryMuscles(List<MuscleDO> primaryMuscles) {
        this.primaryMuscles = primaryMuscles;
    }

    @ManyToMany
    @JoinTable(name = "exercises_secondary_muscles", catalog = "projecttraining", schema = "public", joinColumns = @JoinColumn(name = "id_exercise", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_muscle", referencedColumnName = "id", nullable = false))
    public List<MuscleDO> getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public void setSecondaryMuscles(List<MuscleDO> secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles;
    }
*/
    @ManyToOne
    @JoinColumn(name = "id_muscle_group", referencedColumnName = "id")
    public MuscleDO getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(MuscleDO muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    @OneToMany(mappedBy = "exercise")
    public List<TrainingExerciseDO> getTrainingsExercisesById() {
        return trainingsExercisesById;
    }

    public void setTrainingsExercisesById(List<TrainingExerciseDO> trainingsExercisesById) {
        this.trainingsExercisesById = trainingsExercisesById;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @OneToMany(mappedBy = "exercise")
    public Collection<ExercisePrimaryMuscleDO> getExercisePrimaryMuscleList() {
        return exercisePrimaryMuscleList;
    }

    public void setExercisePrimaryMuscleList(Collection<ExercisePrimaryMuscleDO> exercisesPrimaryMusclesById) {
        this.exercisePrimaryMuscleList = exercisesPrimaryMusclesById;
    }

    @OneToMany(mappedBy = "exercise")
    public Collection<ExerciseSecondaryMuscleDO> getExerciseSecondaryMuscleList() {
        return exerciseSecondaryMuscleList;
    }

    public void setExerciseSecondaryMuscleList(Collection<ExerciseSecondaryMuscleDO> exercisesSecondaryMusclesById) {
        this.exerciseSecondaryMuscleList = exercisesSecondaryMusclesById;
    }
}
