package com.greenfox.exams.spring.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Rita on 2017-01-11.
 */
@Data
@Entity
@Table(name = "user_inputs")
public class UserInput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String experience;
    private int scale;
    private String email;
}
