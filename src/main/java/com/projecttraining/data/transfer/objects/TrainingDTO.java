package com.projecttraining.data.transfer.objects;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TrainingDTO {
    private int id;
    private String name;

    public TrainingDTO() {
    }

    public TrainingDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
