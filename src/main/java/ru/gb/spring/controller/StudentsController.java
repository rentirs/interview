package ru.gb.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.persist.Student;
import ru.gb.spring.persist.StudentRepository;

@Controller
public class StudentsController {

    private final StudentRepository repository;

    public StudentsController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("students", repository.findAll());
        model.addAttribute("student", new Student());
        return "index";
    }

    @GetMapping("/add")
    public String showAdd() {
        return "add";
    }

    @PostMapping("/add")
    public String addStudent(Student student) {
        repository.save(student);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") long id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable("id") long id, Model model) {
        model.addAttribute("student", repository.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String saveStudent(@ModelAttribute Student student) {
        repository.save(student);
        return "redirect:/";
    }
}
