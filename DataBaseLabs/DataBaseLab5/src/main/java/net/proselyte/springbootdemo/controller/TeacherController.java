package net.proselyte.springbootdemo.controller;


import net.proselyte.springbootdemo.model.Teacher;
import net.proselyte.springbootdemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TeacherController {

    private final TeacherService teacherService;


    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping("/teacher-create")
    public String createTeacherForm(Teacher teacher){
        return "teacher-create";
    }


    @PostMapping("/teacher-create")
    public String createTeacher(Teacher teacher){
        teacherService.saveUser(teacher);
        return "redirect:/";
    }


    @GetMapping("teacher-delete/{id}")
    public String deleteTeacher(@PathVariable("id") Long id){
        teacherService.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/teacher-update/{id}")
    public String updateTeacherForm(@PathVariable("id") Long id, Model model){
        Teacher teacher = teacherService.findById(id);
        model.addAttribute("teachers", teacher);
        return "teacher-update";
    }


    @PostMapping("/teacher-update")
    public String updateTeacher(Teacher user){
        teacherService.saveUser(user);
        return "redirect:/";
    }


}
