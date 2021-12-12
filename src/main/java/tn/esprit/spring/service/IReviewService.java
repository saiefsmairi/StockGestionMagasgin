package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.Client;
import tn.esprit.entity.Produit;
import tn.esprit.entity.Review;

public interface IReviewService {
	List<Review> retrieveAllReviews();
	Review addReview(Review r);
	Review retrieveReview(Long id);
	void delete(long id);
	Review findReviewByClientAndProduct(Client client,Produit product);
	Review update(Review review);
	 List<Review> getProductReviews(Produit product);
	 Client findByRole();
}
