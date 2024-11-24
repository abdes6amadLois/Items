package com.example.demo.controller;

import com.example.demo.Services.LibraryService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Livres")
public class LivreController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<Livre> getAllLivres() {
        return libraryService.getAllLivres();
    }

    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable int id) {
        return libraryService.getLivreById(id);
    }

    @PostMapping
    public Livre createLivre(@RequestBody Livre livre) {
        return libraryService.saveLivre(livre);
    }

    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable int id) {
        libraryService.deleteLivre(id);
    }
}
