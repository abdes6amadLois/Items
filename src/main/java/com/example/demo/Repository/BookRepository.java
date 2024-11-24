package com.example.demo.Repository;

import com.example.demo.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookRepository extends JpaRepository<Livre, Integer> {


}
