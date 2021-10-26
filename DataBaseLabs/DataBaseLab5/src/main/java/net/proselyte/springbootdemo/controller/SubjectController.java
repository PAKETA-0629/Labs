package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.Subject;
import net.proselyte.springbootdemo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SubjectController {

    private final SubjectService subjectService;


    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @GetMapping("/subject-create")
    public String createTeacherForm(Subject subject){
        return "subject-create";
    }


    @PostMapping("/subject-create")
    public String createSubject(Subject subject){
        subjectService.saveUser(subject);
        return "redirect:/";
    }


    @GetMapping("subject-delete/{id}")
    public String deleteSubject(@PathVariable("id") Long id){
        subjectService.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/subject-update/{id}")
    public String updateSubjectForm(@PathVariable("id") Long id, Model model){
        Subject subject = subjectService.findById(id);
        model.addAttribute("subjects", subject);
        return "subject-update";
    }


    @PostMapping("/subject-update")
    public String updateTeacher(Subject subject){
        subjectService.saveUser(subject);
        return "redirect:/";
    }
}