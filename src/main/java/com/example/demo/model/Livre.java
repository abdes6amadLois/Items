package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Livres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livre {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private String description;
}
