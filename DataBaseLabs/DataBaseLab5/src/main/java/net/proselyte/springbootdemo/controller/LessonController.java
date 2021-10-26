package net.proselyte.springbootdemo.controller;


import net.proselyte.springbootdemo.repository.LessonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lessons")
public class LessonController {
    private final LessonRepositoryImpl lessonRepositoryImpl;

    @Autowired
    public LessonController(LessonRepositoryImpl lessonRepositoryImpl) {
        this.lessonRepositoryImpl = lessonRepositoryImpl;
    }

    @GetMapping("/select")
    public String listArtistsSelect(Model model) {
        return "lessons";
    }

    @PostMapping("/select")
    public String listArtistsSelectByName(String galleryName, String pictureName, Object maxPrice, Model model) {
        model.addAttribute("listPeople", lessonRepositoryImpl.getAllPeople());
        return "lessons";
    }

    @PostMapping("/getTeacherLessons")
    public String getTeacherLessons(String teacherID, Model model) {
        model.addAttribute("teacherLessons", lessonRepositoryImpl.getTeacherLessons(teacherID));
        return "teacherLessons";
    }

    @PostMapping("/getStudentsMark")
    public String getStudentsMarks(Model model) {
        model.addAttribute("studentsMarks", lessonRepositoryImpl.getStudentsMarks());
        return "marks";
    }


}
