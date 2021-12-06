package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.entity.Fournisseur;
import tn.esprit.entity.Produit;

public interface IFournisseurService {
	  List<Fournisseur> retrieveAllFournisseurs();

	  Fournisseur addFournisseur(Fournisseur	f);

	  void deleteFournisseur(Long	id);

	  Fournisseur updateFournisseur(Fournisseur	f);

	  Fournisseur retrieveFournisseur(Long	id);

	  void assignFournisseurToProduit(Long	fournisseurId,	Long produitId);

	  Set<Produit> retrieveProduitFournisseur(Long	fournisseurId);
	  
}
