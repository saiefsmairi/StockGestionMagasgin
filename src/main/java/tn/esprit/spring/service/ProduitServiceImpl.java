package tn.esprit.spring.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.CategorieProduit;
import tn.esprit.entity.Client;
import tn.esprit.entity.DetailProduit;
import tn.esprit.entity.Produit;
import tn.esprit.entity.Rayon;
import tn.esprit.entity.Stock;
import tn.esprit.spring.ClientServiceTest;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.repository.StockRepository;


@Service
@EnableScheduling
@Slf4j

public class ProduitServiceImpl implements IProduitService {
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	RayonRepository rayonRepository;
	@Autowired
	StockRepository stockRepository;

	
	@Override
	public List<Produit> retrieveAllProduits() {
		
		return (List<Produit>) produitRepository.findAll();
	}

	@Override
	public Produit addProduit(Produit p) {
		//Rayon r = rayonRepository.findById(idRayon) .orElse(null);
		//Stock s = stockRepository.findById(idStock) .orElse(null);
		CategorieProduit c=CategorieProduit.Electromeanger;
		DetailProduit detailProduit=new DetailProduit(new Date(),new Date(),7.99f,c,p);
		//p.setRayon(r);
		//p.setStock(s);
		//p.setImage("img.png");
	return	produitRepository.save(p);
		
	}
	@Override
	 public Produit updateProduit(Produit produit, Long id) {
		return produitRepository.save(produit);
	}

	@Override
	public Produit findById(Long id) {
		return produitRepository.findById(id).orElse(null);

		
	}

	@Override
	public void delete(long id) {
		produitRepository.deleteById(id);
		
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit p = produitRepository.findById(idProduit) .orElse(null);
		Stock s = stockRepository.findById(idStock) .orElse(null);
		p.setStock(s);
		produitRepository.save(p);
		
	}

	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		Produit p = produitRepository.findById(idProduit) .orElse(null);

		return produitRepository.getRevenuBrutProduit(p, startDate, endDate);
	}



	    @Override
	@Scheduled(cron = "0 0 22 * * *") 
	public void retrieveStatusStock() {
	  produitRepository.retrieveStatusStock()
	          .forEach(produit -> log.warn("PRODUIT "+produit.getIdproduit()+" CODE : "+produit.getCode()+" est epuisé !"));
	}

		@Override
		public List<Produit> getProductsPriceASC() {
			return (List<Produit>) produitRepository.getAllProductPriceASC();
		}

		@Override
		public List<Produit> getProductsPriceDESC() {
			// TODO Auto-generated method stub
			return (List<Produit>) produitRepository.getAllProductPriceDesc();
		}

		@Override
		public List<Produit> getProductAlimentaire() {
			// TODO Auto-generated method stub
			return (List<Produit>) produitRepository.getAllProductAlimentaire();
		}

		@Override
		public List<Produit> getAllProductElectromeanger() {
			// TODO Auto-generated method stub
			return (List<Produit>) produitRepository.getAllProductElectromeanger();
		}

		@Override
		public List<Produit> getAllProductQuincaillerie() {
			// TODO Auto-generated method stub
			return (List<Produit>) produitRepository.getAllProductQuincaillerie();
		}

		@Override
		public List<Integer> getPercentageGroupByCategorie() {
			// TODO Auto-generated method stub
			return  (List<Integer>) produitRepository.getPercentageGroupByCategorie();
		}

		@Override
		public List<Float> getPercentageGroupByCategory() {
			// TODO Auto-generated method stub
			return  (List<Float>) produitRepository.getPercentageGroupByCategory();
		}

		@Override
		public List<String> getCategories() {
			// TODO Auto-generated method stub
			return  (List<String>) produitRepository.getAllCategories();
		}

		

		
}
