package com.essaadani.produitms.dto;

import lombok.Data;

@Data
public class ProduitRequestDTO {
    private String name;
    private int quantity;
    private double price;
}
