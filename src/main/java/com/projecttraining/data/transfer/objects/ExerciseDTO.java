package com.projecttraining.data.transfer.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ExerciseDTO {
    private int id;
    private String name;
    private String description;
    private String muscleGroup;
    private List<MuscleDTO> primaryMuscles;
    private List<MuscleDTO> secondaryMuscles;
    private String image;

    public ExerciseDTO() {
    }

    public ExerciseDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ExerciseDTO(int id, String name, String muscleGroup) {
        this.id = id;
        this.name = name;
        this.muscleGroup = muscleGroup;
    }
}
