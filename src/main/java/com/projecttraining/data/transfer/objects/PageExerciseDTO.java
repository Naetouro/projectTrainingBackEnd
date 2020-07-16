package com.projecttraining.data.transfer.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PageExerciseDTO {
    private List<TrainingDTO> trainingList;
    private ExerciseDTO exercise;
}
