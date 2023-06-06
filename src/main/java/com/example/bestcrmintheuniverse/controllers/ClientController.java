package com.example.bestcrmintheuniverse.controllers;

import com.example.bestcrmintheuniverse.entities.Client;
import com.example.bestcrmintheuniverse.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/client")
@Controller
public class ClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("clients", this.clientRepository.findAll());
        return "client/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("client", new Client());
        return "client/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Client client) {
        this.clientRepository.save(client);
        return "redirect:/client/";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        System.out.println("delete client with id " + id);
        this.clientRepository.deleteById(id);
        return "redirect:/client/";
    }
}
