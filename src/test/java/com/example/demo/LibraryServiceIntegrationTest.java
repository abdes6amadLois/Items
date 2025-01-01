package com.example.demo;

import com.example.demo.Repository.BookRepositoryElastic;
import com.example.demo.controller.LivreController;
import com.example.demo.model.Livre;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Services.LibraryService;
import com.example.demo.model.LivreE;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class LibraryServiceIntegrationTest {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BookRepositoryElastic bookRepositoryElastic;

//    @Test
//    public void searchBookByTitle_IntegrationTest() throws Exception {
//        Livre livre = new Livre(0, "Spring Boot", "A comprehensive guide");
//        bookRepository.save(livre);
//
//        List<Livre> result = libraryService.serchBookByTitle("Spring Boot");
//
//        mockMvc.perform(get("http://localhost:8080/api/Livres/title/spring")).andExpect(status().isOk());
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Spring Boot", result.get(0).getTitle());
//    }

//    @Test
//    public void searchBookByKeyword_IntegrationTest() throws Exception {
//        Livre livre1 = new Livre(1, "Spring Boot", "A comprehensive guide");
//        Livre livre2 = new Livre(2, "Intro To C++", "A comprehensive guide");
//        bookRepository.save(livre1);
//        bookRepository.save(livre2);
//
//        List<Livre> result = libraryService.findBooksByKeyword("Spring,C++");
//
//
//
//        mockMvc.perform(get("http://localhost:8080/api/Livres/searchG?q=Spring,c++")).andExpect(status().isOk());
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertTrue(result.stream().anyMatch(l -> l.getTitle().equals("Spring Boot")));
//        assertTrue(result.stream().anyMatch(l -> l.getTitle().equals("Intro To C++")));
//    }

    @Test
    public void searchBookByKeywordEl_IntegrationTest() throws Exception {
        LivreE livre1 = new LivreE(1, "Spring Boot", "A comprehensive guide");
        LivreE livre2 = new LivreE(2, "Intro To C++", "A comprehensive guide");
        bookRepositoryElastic.save(livre1);
        bookRepositoryElastic.save(livre2);

//        Iterable<LivreE> result = libraryService.getAllLivresElastic();
//        List<LivreE> livresList = StreamSupport.stream(result.spliterator(), false)
//                .collect(Collectors.toList());
//        List<LivreE> result1 = libraryService.serchBookByTitleAndDesc(".",0,10);
//
//
//        assertNotNull(result);
//        assertTrue(result1.stream().anyMatch(l -> l.getTitle().equals("Spring Boot")));
//        //assertEquals(2, result.size());
//        assertTrue(livresList.stream().anyMatch(l -> l.getTitle().equals("Spring Boot")));
//        assertTrue(livresList.stream().anyMatch(l -> l.getTitle().equals("Intro To C++")));
    }
}

