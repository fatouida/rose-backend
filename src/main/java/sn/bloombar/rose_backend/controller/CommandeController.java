package sn.bloombar.rose_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.bloombar.rose_backend.modele.Commande;
import sn.bloombar.rose_backend.service.CommandeService;

import java.util.List;

@RestController
@RequestMapping("api/commande")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/liste")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Commande createCommande(@RequestBody Commande commande, @RequestParam Long userId) {
        return commandeService.createCommande(commande, userId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande updatedCommande) {
        return commandeService.updateCommande(id, updatedCommande)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        return commandeService.deleteCommande(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
