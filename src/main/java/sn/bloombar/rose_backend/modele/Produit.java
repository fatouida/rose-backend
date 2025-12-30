package sn.bloombar.rose_backend.modele;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String taille;
    private String description;
    private int prix;
    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;
    @OneToMany(mappedBy = "produit")
    private List<Commande> commandes;


    public Produit(){}

    public String getNom() {return nom;}

    public Categorie getCategorie(){return categorie;}


    public int getId() {return id;}

    public int getPrix() {return prix;}

    public String getTaille() {return taille;}

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;}

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setCategorie(Categorie categorie){this.categorie = categorie;}

    public void setTaille(String taille) {
        this.taille = taille;
    }


}
