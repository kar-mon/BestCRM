package com.example.bestcrmintheuniverse.controllers;

import com.example.bestcrmintheuniverse.entities.Client;
import com.example.bestcrmintheuniverse.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/save")
    public String save() {
        Client client = new Client();
        client.setName("Karczex");
        client.setAddress("Ulica 18");
        client.setCountry("Poland");
        client.setEmail("info@karczex.pl");
        this.clientRepository.save(client);
        return "redirect:/";
    }
}
