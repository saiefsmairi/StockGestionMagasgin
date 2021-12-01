package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.DetailProduit;
import tn.esprit.entity.Rayon;
import tn.esprit.entity.Stock;
import tn.esprit.spring.repository.DetailProduitRepository;
@Service
@Slf4j
public class DetailProduitServiceImpl implements  IDetailProduitService{
@Autowired 
DetailProduitRepository detailProduitRepository ;
	@Override
	public List<DetailProduit> retrieveAllDetailProducts() {
		
		return (List<DetailProduit>) detailProduitRepository.findAll();
	}

	@Override
	public DetailProduit addDetailProduct(DetailProduit d) {
	
		return detailProduitRepository.save(d);
	}

	@Override
	public void deleteDetailProduct(Long id) {
		detailProduitRepository.deleteById(id);
		
	}

	@Override
	public DetailProduit updateDetailProduct(DetailProduit u) {
		
		return detailProduitRepository.save(u);
	}

	@Override
	public DetailProduit retrieveDetailProduct(Long id) {
		
		return detailProduitRepository.findById(id).orElse(null);
	}

	
}
