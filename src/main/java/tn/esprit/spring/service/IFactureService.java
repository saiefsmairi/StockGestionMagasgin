package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.Client;
import tn.esprit.entity.Facture;

public interface IFactureService {

	    
	    List<Facture> retrieveAllFactures();

	    List<Facture> getFacturesByClient(Long	  idClient);

	    Facture addFacture(Facture	  f, Long idClient);

	    void cancelFacture(Long	  id);

	    Facture retrieveFacture(Long	  id);


			}
