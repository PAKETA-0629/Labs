package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.Student;
import net.proselyte.springbootdemo.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentsRepository studentsRepository;

    @Autowired
    public StudentService(StudentsRepository userRepository) {
        this.studentsRepository = userRepository;
    }

    public Student findById(Long id){
        return studentsRepository.getOne(id);
    }

    public List<Student> findAll(){
        return studentsRepository.findAll();
    }

    public Student saveUser(Student user) { return studentsRepository.save(user); }

    public void deleteById(Long id){
        studentsRepository.deleteById(id);
    }
}
