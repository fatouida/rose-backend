package sn.bloombar.rose_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.bloombar.rose_backend.dto.ProduitDto;
import sn.bloombar.rose_backend.modele.Produit;
import sn.bloombar.rose_backend.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/api/produit")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/liste")
    public List<Produit> getProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        return produitService.deleteProduit(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit updatedProduit) {
        return produitService.updateProduit(id, updatedProduit)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}