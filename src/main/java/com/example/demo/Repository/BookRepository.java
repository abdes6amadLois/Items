package com.example.demo.Repository;

import com.example.demo.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookRepository extends JpaRepository<Livre, Integer> {


    List<Livre> findByTitleContainsIgnoreCase(String title);

    @Query("SELECT l FROM Livre l WHERE lower(l.title) LIKE lower(concat('%',:keyword,'%')) or lower(l.description) LIKE lower(concat('%',:keyword,'%'))")
    List<Livre> findBooksByKeyword(@Param("keyword") String keyword);
}
