package tn.esprit.spring.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entity.Client;
import tn.esprit.entity.Facture;
import tn.esprit.entity.Produit;
import tn.esprit.entity.Rayon;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FactureRepository;


@Service
public class FactureServiceImpl implements IFactureService {
	@Autowired
	FactureRepository factureRepository;

	@Autowired
	ClientRepository clientRepository;


	@Override
	public List<Facture> retrieveAllFactures() {
	
		return (List<Facture>) factureRepository.findAll();
	}

	@Override
	public List<Facture> getFacturesByClient(Long idClient) {
		Client p = clientRepository.findById(idClient) .orElse(null);

		return factureRepository.getFacturesByClient(p);
	}

	@Override
	public Facture addFacture(Facture f, Long idClient) {
		Client p = clientRepository.findById(idClient) .orElse(null);

		f.setClient(p);
		f.setDateFacture(new Date());
		factureRepository.save(f);
		return  f;
	}

	@Override
	public void cancelFacture(Long id) {
		factureRepository.cancelFacture(id);
		
	}

	@Override
	public Facture retrieveFacture(Long id) {
		
		return 	factureRepository.findById(id).orElse(null);
	}



	
}
