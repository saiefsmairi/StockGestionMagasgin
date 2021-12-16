package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Fournisseur;
import tn.esprit.entity.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
	

}
