package com.example.demo.Repository;

import com.example.demo.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.*;
import java.util.List;


public interface BookRepository extends JpaRepository<Livre, Integer> {


    List<Livre> findByTitleContainsIgnoreCase(String title);

    @Query(value = "SELECT * FROM Livres WHERE lower(title) LIKE lower(concat('%',:keyword,'%')) OR lower(description) LIKE lower(concat('%',:keyword,'%'))", nativeQuery = true)
    List<Livre> findBooksByKeyword(@Param("keyword") String keyword);

}


