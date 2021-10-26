package net.proselyte.springbootdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "Name")
        private String firstName;
        @Column(name = "LName")
        private String lastName;
        @Column(name = "StudentID")
        private String studentID;

        public void setName(String name) {
                this.firstName = name;
        }

        public void setSurname(String surname) {
                this.lastName = surname;
        }
}
