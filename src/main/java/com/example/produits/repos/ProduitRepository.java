package com.example.produits.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.produits.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
}
