package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Client;
import tn.esprit.entity.Produit;
import tn.esprit.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	@Query("SELECT r FROM Review r where r.client = :client and r.product = :product")
	Review findReviewByClientAndProduct(@Param("client") Client client, @Param("product") Produit product);
	
	@Query("SELECT r FROM Review r where  r.product = :product")
	List<Review> getProductReviews(@Param("product") Produit product);
	

}
