package sn.bloombar.rose_backend.service;

import org.springframework.stereotype.Service;
import sn.bloombar.rose_backend.modele.Commande;
import sn.bloombar.rose_backend.modele.User;
import sn.bloombar.rose_backend.repository.CommandeRepository;
import sn.bloombar.rose_backend.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    private final UserRepository userRepository;  // il faut cette déclaration

    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository, UserRepository userRepository) {
        this.commandeRepository = commandeRepository;
        this.userRepository = userRepository;
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }

    public Commande createCommande(Commande commande, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) throw new RuntimeException("Utilisateur introuvable");

        commande.setUser(userOpt.get());
        return commandeRepository.save(commande);
    }


    public boolean deleteCommande(Long id) {
        if (commandeRepository.existsById(id)) {
            commandeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Commande> updateCommande(Long id, Commande updatedCommande) {
        return commandeRepository.findById(id).map(commande -> {
            commande.setStatue(updatedCommande.getStatue());
            commande.setTotal(updatedCommande.getTotal());
            return commandeRepository.save(commande);
        });
    }
}
