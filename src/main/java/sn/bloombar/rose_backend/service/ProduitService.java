package sn.bloombar.rose_backend.service;

import org.springframework.stereotype.Service;
import sn.bloombar.rose_backend.modele.Categorie;
import sn.bloombar.rose_backend.modele.Produit;
import sn.bloombar.rose_backend.repository.CategorieRepository;
import sn.bloombar.rose_backend.repository.ProduitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;

    public ProduitService(ProduitRepository produitRepository, CategorieRepository categorieRepository) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    public Produit createProduit(Produit produit) {

        Categorie cat = categorieRepository.findById(produit.getCategorie().getId())
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
        produit.setCategorie(cat);
        return produitRepository.save(produit);
    }

    public boolean deleteProduit(Long id) {
        if (produitRepository.existsById(id)) {
            produitRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Produit> updateProduit(Long id, Produit updatedProduit) {
        return produitRepository.findById(id).map(produit -> {
            produit.setNom(updatedProduit.getNom());
            produit.setPrix(updatedProduit.getPrix());
            produit.setTaille(updatedProduit.getTaille());
            produit.setDescription(updatedProduit.getDescription());
            return produitRepository.save(produit);
        });
    }
}