package com.example.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.produits.entities.Produit;
import com.example.produits.repos.ProduitRepository;
import com.example.produits.service.ProduitService;

@SpringBootTest
class ProduitsApplicationTests {
	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private ProduitService produitService;
	
	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("PC Asus",1800.500,new Date());
		produitRepository.save(prod);
	}
	
	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}
	
	@Test
	public void testUpdateProduit()
	{
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(1000.0);
		produitRepository.save(p);
	}
	
	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllProduits() {
		List<Produit> prods = produitRepository.findAll();
		
		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindByNomProduitContains() {
		Page<Produit> prods = produitService.getAllProduitsParPage(0,2);
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getTotalPages());
		prods.getContent().forEach(p -> {System.out.println(p.toString());});
		/*ou bien
		for (Produit p : prods.getContent())
		{
		System.out.println(p);
		} */
	}
}
