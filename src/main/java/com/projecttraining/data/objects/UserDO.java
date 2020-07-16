package com.projecttraining.data.objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", schema = "public", catalog = "projecttraining")
public class UserDO {
    private Integer id;
    private String name;
    private String mail;
    private String password;
    private String image;
    private Double weight;
    private List<TrainingDO> trainings;

    public UserDO() {
    }

    public UserDO(String name, String password) {
        this.name = name;
        this.password = password;
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
    @Column(name = "name", nullable = true, length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "mail", unique = true, nullable = true, length = 50)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 25)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 50)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "weight", nullable = true, precision = 0)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @OneToMany(mappedBy = "user")
    public List<TrainingDO> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<TrainingDO> trainingsById) {
        this.trainings = trainingsById;
    }
}
