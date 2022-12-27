package com.example.coursesapp.topics;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Topic {

    public Topic(){

    }

    @Id
    private int id;
    private String name;
    private String description;

    public Topic(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
