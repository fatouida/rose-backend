package sn.bloombar.rose_backend.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String statue;
    private int total;
    @ManyToOne
    @JoinColumn(name = "Produit_id", nullable = false)
    private Produit produit;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;



    public Commande(){}

    public User getUser() {
        return user;
    }

    public Produit getproduit(){
        return produit;
    }

    public Long getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }

    public String getStatue() {
        return statue;
    }

    public void setUser(User user){this.user = user;}

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setProduit(Produit produit){
        this.produit = produit;
    }


}
