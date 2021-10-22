package com.essaadani.produitms.web;

import com.essaadani.produitms.dao.ProduitRepository;
import com.essaadani.produitms.dto.ProduitRequestDTO;
import com.essaadani.produitms.dto.ProduitResponseDTO;
import com.essaadani.produitms.entities.Produit;
import com.essaadani.produitms.mappers.ProduitMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProduitRestAPI {
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;

    @GetMapping("/produits")
    public List<ProduitResponseDTO> getAllProduits(){

        return produitRepository
                .findAll()
                .stream()
                .map(produitMapper::toProduitResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/produits/{id}")
    public ProduitResponseDTO getProduit(@PathVariable Long id){
        Produit produit = produitRepository.findById(id).get();
        return produitMapper.toProduitResponseDTO(produit);
    }

    @PostMapping("/produits")
    public ProduitResponseDTO save(@RequestBody ProduitRequestDTO produitRequestDTO){
        Produit produit = produitMapper.toProduit(produitRequestDTO);
        Produit savedProduit = produitRepository.save(produit);
        return produitMapper.toProduitResponseDTO(savedProduit);
    }

    @PutMapping("/produits/{id}")
    public ProduitResponseDTO update(@PathVariable Long id, @RequestBody ProduitRequestDTO produitRequestDTO){
        Produit produit = produitMapper.toProduit(produitRequestDTO);
        produit.setId(id);
        Produit savedProduit = produitRepository.save(produit);

        return produitMapper.toProduitResponseDTO(savedProduit);
    }

    @DeleteMapping("/produits/{id}")
    public void delete(@PathVariable Long id){
        produitRepository.deleteById(id);
    }
}
