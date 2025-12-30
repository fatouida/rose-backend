package sn.bloombar.rose_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.bloombar.rose_backend.modele.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
