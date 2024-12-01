package com.example.demo;


import com.example.demo.Repository.BookRepository;
import com.example.demo.Services.LibraryService;
import com.example.demo.model.Livre;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

    @Mock
    private BookRepository bookRepo;

    @InjectMocks
    private LibraryService libraryService;

    @Test
    public void serchBookByTitle_HappyPath() {
        String title = "Spring Boot";
        Livre livre = new Livre(1, "Spring Boot", "A comprehensive guide");
        when(bookRepo.findByTitleContainsIgnoreCase(title)).thenReturn(Collections.singletonList(livre));

        List<Livre> result = libraryService.serchBookByTitle(title);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Spring Boot", result.get(0).getTitle());
        //verify(bookRepo, times(1)).findByTitleContainsIgnoreCase(title);
    }

    @Test
    public void serchBookByTitle_ErrorPath() {
        // Arrange
        String title = "Unknown Title";
        when(bookRepo.findByTitleContainsIgnoreCase(title)).thenReturn(Collections.emptyList());

        List<Livre> result = libraryService.serchBookByTitle(title);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(bookRepo, times(1)).findByTitleContainsIgnoreCase(title);
    }

    @Test
    public void serchBookByKeyword_HappyPath() {
        String keywords = "Spring,Java";
        Livre livre1 = new Livre(1, "Spring Boot", "Guide for Java developers");
        Livre livre2 = new Livre(2, "Java Basics", "Introduction to Java");
        when(bookRepo.findByTitleContainsIgnoreCase("Spring")).thenReturn(Collections.singletonList(livre1));
        when(bookRepo.findByTitleContainsIgnoreCase("Java")).thenReturn(Collections.singletonList(livre2));

        List<Livre> result = libraryService.serchBookByKeyword(keywords);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Spring Boot", result.get(0).getTitle());
        assertEquals("Java Basics", result.get(1).getTitle());
        verify(bookRepo, times(1)).findByTitleContainsIgnoreCase("Spring");
        verify(bookRepo, times(1)).findByTitleContainsIgnoreCase("Java");
    }

    @Test
    public void serchBookByKeyword_ErrorPath() {
        String keywords = "Python,Ruby";
        when(bookRepo.findByTitleContainsIgnoreCase(anyString())).thenReturn(Collections.emptyList());

        List<Livre> result = libraryService.serchBookByKeyword(keywords);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(bookRepo, times(2)).findByTitleContainsIgnoreCase(anyString());
    }

//    @Test
//    public void testT(){
//        assertEquals(3, 2);
//    }
}

