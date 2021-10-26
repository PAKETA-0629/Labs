package net.proselyte.springbootdemo.controller;


import net.proselyte.springbootdemo.model.Student;
import net.proselyte.springbootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/student-create")
    public String createUserForm(Student student){
        return "student-create";
    }


    @PostMapping("/student-create")
    public String createUser(Student user){
        studentService.saveUser(user);
        return "redirect:/";
    }


    @GetMapping("student-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/student-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("students", student);
        return "student-update";
    }


    @PostMapping("/student-update")
    public String updateUser(Student student){
        studentService.saveUser(student);
        return "redirect:/";
    }
}
