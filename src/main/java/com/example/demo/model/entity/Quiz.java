package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qid;

    
    private String title;

    private String description;

    private String maxMarks;

    private String numberOfQuestions;
    
    private boolean active  = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Question> question = new HashSet<>();


    public Quiz() {
    }

    public Quiz(String title, String description, String maxMarks, String numberOfQuestions, boolean active, Category category) {
        this.title = title;
        this.description = description;
        this.maxMarks = maxMarks;
        this.numberOfQuestions = numberOfQuestions;
        this.active = active;
        this.category = category;
    }

    

    
}
