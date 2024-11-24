package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Livres")
public class Livre {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private String description;

        //public Livre() {}

        /*public Livre(String title, String description) {
            this.title = title;
            this.description = description;
        }*/

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
}
