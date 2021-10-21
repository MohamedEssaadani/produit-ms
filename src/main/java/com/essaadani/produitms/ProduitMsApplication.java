package com.essaadani.produitms;

import com.essaadani.produitms.dao.ProduitRepository;
import com.essaadani.produitms.entities.Produit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProduitMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitMsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProduitRepository produitRepository,
                            RepositoryRestConfiguration restConfiguration){
        return args -> {
            produitRepository.save(new Produit(null, "DELL XPS 13", 120, 1500));
            produitRepository.save(new Produit(null, "Samsung S9", 99, 500));
            produitRepository.save(new Produit(null, "Mac Book Pro", 63, 2500));

            produitRepository.findAll()
                    .forEach(produit -> {
                        System.out.println(produit.getName());
                    });

            restConfiguration.exposeIdsFor(Produit.class);
        };
    }
}
