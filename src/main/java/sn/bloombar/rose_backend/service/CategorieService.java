package sn.bloombar.rose_backend.service;
import org.springframework.stereotype.Service;
import sn.bloombar.rose_backend.modele.Categorie;
import sn.bloombar.rose_backend.repository.CategorieRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Optional<Categorie> getCategorieById(Long id) {
        return categorieRepository.findById(id);
    }

    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public boolean deleteCategorie(Long id) {
        if (categorieRepository.existsById(id)) {
            categorieRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Categorie> updateCategorie(Long id, Categorie updatedCategorie) {
        return categorieRepository.findById(id).map(categorie -> {
            categorie.setNom(updatedCategorie.getNom());
            return categorieRepository.save(categorie);
        });
    }
}
