package sn.bloombar.rose_backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProduitDto {

    @NotBlank(message = "Ce champ ne doit pas etre vide")
    private String nom;
    @NotBlank(message = "Ce champ ne doit pas etre vide")
    private String taille;
    @NotNull(message = "Ce champ ne doit pas etre nul")
    private int prix;
    @Max(value = 3, message = "Le chiffre ne peut depasser 3")
    private long categorie_id;
}
