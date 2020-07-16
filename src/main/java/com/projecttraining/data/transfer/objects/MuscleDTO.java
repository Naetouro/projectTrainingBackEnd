package com.projecttraining.data.transfer.objects;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MuscleDTO {
    private int id;
    private String name;

    public MuscleDTO() {
    }

    public MuscleDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
