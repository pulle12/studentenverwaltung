package at.hakimst.studentenverwaltung.controller;

import at.hakimst.studentenverwaltung.services.StudentenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "alleStudenten";
    }
}
