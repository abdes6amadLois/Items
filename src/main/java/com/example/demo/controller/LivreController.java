package com.example.demo.controller;

import com.example.demo.Services.LibraryService;
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

    @GetMapping("/title/{title}")
    public List<Livre> getLivreByTitle(@PathVariable String title) {
        return libraryService.serchBookByTitle(title);
    }

    @GetMapping("/search")
    public List<Livre> getLivreByKeywords(@RequestParam String q) {
        return libraryService.serchBookByKeyword(q);
    }

    @GetMapping("/searchG")
    public List<Livre> getLivreByKeyword(@RequestParam String q) {
        return libraryService.findBooksByKeyword(q);
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
