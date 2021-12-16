package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.Promotion;

public interface IPromotionService {

	public Promotion add(Promotion promotion,long id);
	public Promotion update(Promotion promotion,long id);
	public void delete(long id);
	public List<Promotion> findAll();
	public Promotion findById(Long id);
	public Integer[] stat();

}
