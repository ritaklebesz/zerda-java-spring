package com.greenfox.exams.spring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Rita on 2017-01-11.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String name;
    private String type;

    public Project(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + ": " + type;
    }
}
