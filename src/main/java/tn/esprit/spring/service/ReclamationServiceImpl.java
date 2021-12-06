package tn.esprit.spring.service;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.entity.Facture;
import tn.esprit.entity.Fournisseur;
import tn.esprit.entity.Produit;
import tn.esprit.entity.Reclamation;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.ReclamationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ReclamationServiceImpl implements IReclamationService{

    @Autowired
    private ReclamationRepository fournisseurRepository;
    @Autowired
	ProduitRepository produitRepository;
	@Override
	public List<Reclamation> findAll() {
		   return fournisseurRepository.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation f) {
        return fournisseurRepository.save(f);

	}

	@Override
	public void deleteReclamation(Long id) {
		fournisseurRepository.deleteById(id);

		
	}

	@Override
	public Reclamation updateReclamation(Reclamation f) {
	
		//fournisseurRepository.updateFournisseur(f.getIdFournisseur(), f.getLibelle(), f.getAdresse(), f.getNumero());
		return null;
	}

	@Override
	public Reclamation findById(Long id) {
		return fournisseurRepository.findById(id).orElse(null);

	}



	
}
