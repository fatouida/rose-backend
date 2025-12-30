package sn.bloombar.rose_backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class PaiementDto {

    @NotNull(message = "Ce champ ne doit pas etre nul")
    @Min(value = 15000, message = "Le montant doit etre minimum 15000")
    private int montant;
    @Max(value = 13, message = "L'id de la commande doit etre au max 13")
    private long ID_commande;
}
