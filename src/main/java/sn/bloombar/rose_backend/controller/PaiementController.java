package sn.bloombar.rose_backend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.bloombar.rose_backend.modele.Categorie;
import sn.bloombar.rose_backend.modele.Paiement;
import sn.bloombar.rose_backend.service.CategorieService;
import sn.bloombar.rose_backend.service.PaiementService;

import java.util.List;

@RestController
@RequestMapping("api/paiement")
public class PaiementController {

    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping("/liste")
    public List<Paiement> getPaiements() {
        return paiementService.getAllPaiements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paiement createPaiement(@RequestBody Paiement paiement) {
        return paiementService.createPaiement(paiement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        return paiementService.deletePaiement(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> updateCategorie(@PathVariable Long id, @RequestBody Paiement updatedPaiement) {
        return paiementService.updatePaiement(id, updatedPaiement)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
