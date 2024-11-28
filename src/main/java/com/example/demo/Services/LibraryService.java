package com.example.demo.Services;

import com.example.demo.Repository.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


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

    public List<Livre> serchBookByTitle(String title) {
        return bookRepo.findByTitleContainsIgnoreCase(title);
    }

    public List<Livre> serchBookByKeyword(String keywords) {
        String [] keywordsArray = keywords.split(",");
        List<Livre> list = new ArrayList<>();
        for(int i=0;i<keywordsArray.length;i++) {
            list.addAll(bookRepo.findByTitleContainsIgnoreCase(keywordsArray[i]));
        }
        return list;
    }

    public List<Livre> findBooksByKeyword(String keywords) {
        String [] keywordsArray = keywords.split(",");
        HashSet<Livre> hashSet = new HashSet<>();
        for(int i=0;i<keywordsArray.length;i++) {
            hashSet.addAll(bookRepo.findBooksByKeyword(keywordsArray[i]));
        }
        return new ArrayList<>(hashSet);
    }
}
