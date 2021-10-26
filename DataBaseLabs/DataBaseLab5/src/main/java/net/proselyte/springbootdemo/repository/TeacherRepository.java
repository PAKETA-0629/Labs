package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
