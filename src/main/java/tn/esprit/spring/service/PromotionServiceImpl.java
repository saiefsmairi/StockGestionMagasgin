
package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entity.Produit;
import tn.esprit.entity.Promotion;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.PromotionRepository;

@Service
public class PromotionServiceImpl implements IPromotionService {
	
	@Autowired
	private PromotionRepository promotionRepository;

	@Autowired
	private ProduitRepository produitRepository ;
	
	@Override
	public Promotion add(Promotion promotion,long id)
	{
		Produit p = produitRepository.findById(id).orElse(null);
		promotion.setProduit(p);
		return promotionRepository.save(promotion);
	}

	@Override
	public Promotion update(Promotion promotion,long id) {
		Produit p = produitRepository.findById(id).orElse(null);
		promotion.setProduit(p);
		return promotionRepository.save(promotion);
	}

	@Override
	public void delete(long id) {
        promotionRepository.deleteById(id);
		
	}

	@Override
	public List<Promotion> findAll() {
        return promotionRepository.findAll();
	}

	@Override
	public Promotion findById(Long id) {
		return promotionRepository.findById(id).orElse(null);

	}

	@Override
	public Integer[] stat() {
		Integer[] monthStat = new Integer[4] ;
		for (int i=0 ; i < 4 ; i++)
		{
			monthStat[i] = 0 ;
		}
		List<Promotion> list = (List<Promotion>) promotionRepository.findAll() ;
		
		for (Promotion promotion : list) {
			
			Date date = promotion.getDateBegin();
			int quarter = (date.getMonth() / 3) ; 

			
			monthStat[quarter] = monthStat[quarter]+1 ;
		}
		
		return monthStat ; 
	}
	
	

}
