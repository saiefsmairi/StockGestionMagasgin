package tn.esprit.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.control.IDetailFactureService;
import tn.esprit.entity.Facture;
import tn.esprit.entity.Produit;
import tn.esprit.entity.detailFacture;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.repository.DetailProduitRepository;

@Service
@Slf4j
public class detailFactureImpl implements IDetailFactureService {
	
	@Autowired 
	DetailFactureRepository detailFactureRepository ;
	
	@Autowired
	IFactureService factureService;
	
	@Autowired
	IProduitService produitService;

	@Override
	public detailFacture addDetailFacture(detailFacture d,long idFacture,long idProduit) {
		Facture facture = factureService.retrieveFacture(idFacture);
		Produit produit = produitService.findById(idProduit) ; 
		d.setFacture(facture);
		d.setProduit(produit);
		return detailFactureRepository.save(d) ;
	}

	@Override
	public ArrayList<detailFacture> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
