package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.entity.Client;
import tn.esprit.entity.Facture;
import tn.esprit.entity.Produit;

public interface IProduitService {
	List<Produit> retrieveAllProduits();
	 //Produit addProduit(Produit p, Long idRayon, Long idStock);
	 Produit addProduit(Produit p);

	 Produit findById(Long id);

	 Produit updateProduit(Produit produit, Long id);

     

	 void delete(long id);
	 void assignProduitToStock(Long	idProduit,Long idStock);
	 float getRevenuBrutProduit(Long idProduit,	Date startDate,	Date endDate);
	 public List<Produit> getProductsPriceASC();
	 public List<Produit> getProductsPriceDESC();
	 public List<Produit> getProductAlimentaire();
	 public List<Produit> getAllProductElectromeanger();
	 public List<Produit> getAllProductQuincaillerie();
	 public List<Integer>getPercentageGroupByCategorie();
	 public List<Float>getPercentageGroupByCategory();
	 public List<String>getCategories();

	 void retrieveStatusStock();
}
