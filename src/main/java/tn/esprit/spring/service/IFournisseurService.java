package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.entity.Fournisseur;

public interface IFournisseurService {
	  List<Fournisseur> retrieveAllFournisseurs();

	  Fournisseur addFournisseur(Fournisseur	f);

	  void deleteFournisseur(Long	id);

	  Fournisseur updateFournisseur(Fournisseur	f);

	  Fournisseur retrieveFournisseur(Long	id);

	  void assignFournisseurToProduit(Long	fournisseurId,	Long produitId);


}
