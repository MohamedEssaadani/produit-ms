package com.essaadani.produitms.dao;

import com.essaadani.produitms.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    @RestResource(path = "byName")
    Page<Produit> findByNameContains(@Param("keyword") String name, Pageable pageable);
}
