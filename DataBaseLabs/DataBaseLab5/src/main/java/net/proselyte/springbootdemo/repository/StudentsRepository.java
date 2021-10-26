package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student, Long> {

}
