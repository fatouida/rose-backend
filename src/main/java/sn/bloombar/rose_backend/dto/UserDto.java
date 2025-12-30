package sn.bloombar.rose_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDto {

    @NotBlank(message = "Error, veillez entrer votre nom")
    private String nom;
    @NotBlank(message = "Error, veillez entrer votre nom")
    private String prenom;
    @NotBlank(message = "Ce champ ne peut etre vide")
    private int numero;

}
