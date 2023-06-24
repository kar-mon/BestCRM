package com.example.bestcrmintheuniverse.controllers;

import com.example.bestcrmintheuniverse.entities.Person;
import com.example.bestcrmintheuniverse.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
@Controller
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {this.personRepository = personRepository;}

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("employees", this.personRepository.findAll());
                return"employee/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("employee", new Person());
        return "employee/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Person employee){
        this.personRepository.save(employee);
        return "redirect:/employee/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        this.personRepository.deleteById(id);
        return "redirect:/employee/";
    }
}
