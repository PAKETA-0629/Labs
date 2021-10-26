package net.proselyte.springbootdemo.service;


import net.proselyte.springbootdemo.model.Teacher;
import net.proselyte.springbootdemo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository userRepository) {
        this.teacherRepository = userRepository;
    }

    public Teacher findById(Long id){
        return teacherRepository.getOne(id);
    }

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    public Teacher saveUser(Teacher user){
        return teacherRepository.save(user);
    }

    public void deleteById(Long id){
        teacherRepository.deleteById(id);
    }
}
