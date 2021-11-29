package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.entity.Client;
import tn.esprit.entity.Facture;
import tn.esprit.entity.Produit;

public interface IProduitService {
	List<Produit> retrieveAllProduits();
	 Produit addProduit(Produit p, Long idRayon, Long idStock);
	 Produit findById(Long id);

	 void delete(long id);
	 void assignProduitToStock(Long	idProduit,Long idStock);
	 float getRevenuBrutProduit(Long idProduit,	Date startDate,	Date endDate);
	 void retrieveStatusStock();
}
