package sn.bloombar.rose_backend.modele;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private int numero;
    private String role = "User Simple";
    @OneToMany(mappedBy = "user")
    private List<Commande> commandes  = new ArrayList<>();;


    public User(){}

    public Long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setRole(String role) {
        this.role = role;
    }


}

