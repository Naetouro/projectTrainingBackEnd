package com.projecttraining.data.objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trainings", schema = "public", catalog = "projecttraining")
public class TrainingDO {
    private Integer id;
    private String name;
    private UserDO user;
    private Integer idUser;
    private List<TrainingExerciseDO> trainingsExercises;

    public TrainingDO() {
    }

    public TrainingDO(String name, UserDO user) {
        this.name = name;
        this.user = user;
    }

    public TrainingDO(int id, String name) {
        this.id = id;
        this.name = name;
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
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "id_user", insertable = false, updatable = false)
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO usersByIdUser) {
        this.user = usersByIdUser;
    }

    @OneToMany(mappedBy = "training")
    public List<TrainingExerciseDO> getTrainingsExercises() {
        return trainingsExercises;
    }

    public void setTrainingsExercises(List<TrainingExerciseDO> trainingsExercises) {
        this.trainingsExercises = trainingsExercises;
    }
}
