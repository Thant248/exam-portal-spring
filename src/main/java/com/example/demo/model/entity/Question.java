package com.example.demo.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 5000)
    private String content;
    private String image;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @JsonIgnore
    private String answer;

    @Transient
    private String givenAnswers;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;

    public Question(){}


}
