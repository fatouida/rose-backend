package sn.bloombar.rose_backend.service;

import org.springframework.stereotype.Service;
import sn.bloombar.rose_backend.modele.Commande;
import sn.bloombar.rose_backend.modele.Paiement;
import sn.bloombar.rose_backend.repository.CommandeRepository;
import sn.bloombar.rose_backend.repository.PaiementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    private final PaiementRepository paiementRepository;
    private final CommandeRepository commandeRepository;
    public PaiementService(PaiementRepository paiementRepository, CommandeRepository commandeRepository) {
        this.paiementRepository = paiementRepository;
        this.commandeRepository = commandeRepository;
    }

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Optional<Paiement> getPaiementById(Long id) {
        return paiementRepository.findById(id);
    }

    public Paiement createPaiement(Paiement paiement) {
        Commande cat = commandeRepository.findById(paiement.getCommande().getId())
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));
        paiement.setCommande(cat);
        return paiementRepository.save(paiement);
    }

    public boolean deletePaiement(Long id) {
        if (paiementRepository.existsById(id)) {
            paiementRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Paiement> updatePaiement(Long id, Paiement updatedPaiement) {
        return paiementRepository.findById(id).map(paiement -> {
            paiement.setDatepaiement(updatedPaiement.getDatepaiement());
            paiement.setMontant(updatedPaiement.getMontant());
            paiement.setRef(updatedPaiement.getRef());
            return paiementRepository.save(paiement);
        });
    }
}
