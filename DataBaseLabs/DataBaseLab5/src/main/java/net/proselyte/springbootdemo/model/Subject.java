package net.proselyte.springbootdemo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;
    @Column(name = "hours")
    private int hours;

    public void setName(String name) {
        this.subjectName = name;
    }
}