package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.entity.Fournisseur;
import tn.esprit.entity.Reclamation;

public interface IReclamationService {
	  List<Reclamation> findAll();

	  Reclamation addReclamation(Reclamation	f);

	  void deleteReclamation(Long	id);

	  Reclamation updateReclamation(Reclamation	f);

	  Reclamation findById(Long	id);



}
