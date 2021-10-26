package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.STDMARK;
import net.proselyte.springbootdemo.model.Student;
import net.proselyte.springbootdemo.model.Subject;
import net.proselyte.springbootdemo.model.Teacher;
import net.proselyte.springbootdemo.service.StudentService;
import net.proselyte.springbootdemo.service.SubjectService;
import net.proselyte.springbootdemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

@RequestMapping("/")
public class MainController {

    private final StudentService studentService;
    private final TeacherService teacherService;
    private final SubjectService subjectService;

    @Autowired
    public MainController(StudentService studentService, TeacherService teacherService, SubjectService subjectService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @GetMapping("/")
    public String findAll(Model model){
        List<Student> students = studentService.findAll();
        List<Teacher> teachers = teacherService.findAll();
        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("students", students);
        model.addAttribute("teachers", teachers);
        model.addAttribute("subjects", subjects);
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("stdmark", new STDMARK());
        return "main";
    }
}
