package sn.bloombar.rose_backend.dto;


import jakarta.validation.constraints.NotBlank;

public class CategorieDto {
    @NotBlank(message = "Le champ nom est obligatoire")
    private String nom;
}
