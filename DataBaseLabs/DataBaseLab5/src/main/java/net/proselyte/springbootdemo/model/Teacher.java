package net.proselyte.springbootdemo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String firstName;
    @Column(name = "LName")
    private String lastName;
    @Column(name = "TeacherID")
    private String teacherID;


}
