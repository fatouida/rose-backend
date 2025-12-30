package sn.bloombar.rose_backend.dto;

import jakarta.validation.constraints.NotBlank;

public class CommandeDto {
    @NotBlank(message = "Ce champ ne doit pas etre vide")
    private int total;
    @NotBlank(message = "Veillez entrer l'id de l'utilisateur")
    private Long user_id;
    @NotBlank(message = "Veillez entrer l'id du produit")
    private int produit_id;
}
