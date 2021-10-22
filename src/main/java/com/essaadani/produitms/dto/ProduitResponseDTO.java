package com.essaadani.produitms.dto;

import lombok.Data;

@Data
public class ProduitResponseDTO {
    private String name;
    private int quantity;
    private double price;
}
