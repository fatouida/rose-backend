package sn.bloombar.rose_backend.modele;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date datepaiement;
    private int montant;
    private int ref;

    @OneToOne
    @JoinColumn(name = "Commande_id", nullable = false)
    private Commande commande;

    public Paiement(){}


    public int getId() {
        return id;
    }

    public Commande getCommande(){
        return commande;
    }

    public Date getDatepaiement() {
        return datepaiement;
    }

    public int getMontant() {
        return montant;
    }

    public int getRef() {
        return ref;
    }

    public void setCommande(Commande commande){
        this.commande = commande;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDatepaiement(Date datepaiement) {
        this.datepaiement = datepaiement;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }
}
