package sn.bloombar.rose_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;
import sn.bloombar.rose_backend.modele.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
