package at.hakimst.studentenverwaltung.controller;

import at.hakimst.studentenverwaltung.domain.Student;
import at.hakimst.studentenverwaltung.services.StudentenService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/v1/studenten")
public class StudentThymeleafController {


    private StudentenService studentenService;

    public StudentThymeleafController(StudentenService studentenService) {
        this.studentenService = studentenService;
    }

    @GetMapping
    public String gibAlleStudenten(Model model) {
        model.addAttribute("allStudents", this.studentenService.alleStudenten());
        return "allestudenten";
    }

    @GetMapping("/insert")
    public String studentenEinfuegenFormular(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "studenteneinfuegen";
    }

    @PostMapping("/insert")
    public String studentEinfuegen(@Valid Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "studenteneinfuegen";
        } else {
            this.studentenService.studentEinfuegen(student);
            return "redirect:/web/v1/studenten";
        }
    }
}
