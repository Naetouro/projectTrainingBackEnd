package com.projecttraining.data.objects;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "progression", schema = "public", catalog = "projecttraining")
public class ProgressionDO{
    private Integer id;
    private Integer reps;
    private Double weight;
    private Date date;
    private TrainingExerciseDO trainingExercise;

    public ProgressionDO() {
    }

    public ProgressionDO(int id, int reps, double weight) {
        this.id = id;
        this.reps = reps;
        this.weight = weight;
    }

    public ProgressionDO(int reps, double weight) {
        this.reps = reps;
        this.weight = weight;
    }

    public ProgressionDO(int id, int reps, double weight, Date date) {
        this.id = id;
        this.reps = reps;
        this.weight = weight;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reps", nullable = true, precision = 0)
    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    @Basic
    @Column(name = "weight", nullable = true, precision = 3)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "id_training_exercise", referencedColumnName = "id")
    public TrainingExerciseDO getTrainingExercise() {
        return trainingExercise;
    }

    public void setTrainingExercise(TrainingExerciseDO trainingExercise) {
        this.trainingExercise = trainingExercise;
    }
}
