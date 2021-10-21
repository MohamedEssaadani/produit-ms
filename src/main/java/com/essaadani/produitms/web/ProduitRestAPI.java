package com.essaadani.produitms.web;

import com.essaadani.produitms.dao.ProduitRepository;
import com.essaadani.produitms.entities.Produit;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProduitRestAPI {
    private final ProduitRepository produitRepository;

    @GetMapping("/produits")
    public List<Produit> getAllProduits(){
        return produitRepository.findAll();
    }

    @GetMapping("/produits/{id}")
    public Produit getProduit(@PathVariable Long id){
        return produitRepository.findById(id).get();
    }

    @PostMapping("/produits")
    public Produit save(@RequestBody Produit produit){
        return produitRepository.save(produit);
    }

    @PutMapping("/produits/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit produit){
        produit.setId(id);
        return produitRepository.save(produit);
    }

    @DeleteMapping("/produits/{id}")
    public void delete(@PathVariable Long id){
        produitRepository.deleteById(id);
    }
}
