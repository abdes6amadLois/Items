package com.example.demo.Services;

import com.example.demo.Repository.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Livre;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;


import java.util.List;
import java.util.Optional;

@Service
public class LibraryService  {
    @Autowired
    private BookRepository bookRepo;

    public List<Livre> getAllLivres() {
        return bookRepo.findAll();
    }

    public Livre getLivreById(int id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livre avec ID " + id + "est non trouvé !!!!"));
    }

    public Livre saveLivre(Livre livre) {
        return bookRepo.save(livre);
    }

    public void deleteLivre(int id) {
        bookRepo.deleteById(id);
    }
}
