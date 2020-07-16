package com.projecttraining.data.objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trainings_exercises", schema = "public", catalog = "projecttraining")
public class TrainingExerciseDO {
    private int id;
    private Integer idTraining;
    private Integer idExercise;
    private TrainingDO training;
    private ExerciseDO exercise;
    private List<ProgressionDO> progressions;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "id_training", nullable = false)
    public Integer getIdTraining() {
        return idTraining;
    }

    public void setIdTraining(Integer idTraining) {
        this.idTraining = idTraining;
    }

    @Column(name = "id_exercise", nullable = false)
    public Integer getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(Integer idExercise) {
        this.idExercise = idExercise;
    }

    @ManyToOne
    @JoinColumn(name = "id_training", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public TrainingDO getTraining() {
        return training;
    }

    public void setTraining(TrainingDO trainingsByIdTraining) {
        this.training = trainingsByIdTraining;
    }

    @ManyToOne
    @JoinColumn(name = "id_exercise", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ExerciseDO getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseDO exercisesByIdExercise) {
        this.exercise = exercisesByIdExercise;
    }

    @OneToMany(mappedBy = "trainingExercise", cascade = CascadeType.REMOVE)
    public List<ProgressionDO> getProgressions() {
        return progressions;
    }

    public void setProgressions(List<ProgressionDO> progressions) {
        this.progressions = progressions;
    }
}
