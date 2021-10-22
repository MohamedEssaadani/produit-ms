package com.essaadani.produitms.mappers;

import com.essaadani.produitms.dto.ProduitRequestDTO;
import com.essaadani.produitms.dto.ProduitResponseDTO;
import com.essaadani.produitms.entities.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
    Produit toProduit(ProduitRequestDTO produitRequestDTO);
    ProduitResponseDTO toProduitResponseDTO(Produit produit);
}
