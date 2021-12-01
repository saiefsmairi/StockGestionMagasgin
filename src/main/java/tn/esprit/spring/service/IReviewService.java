package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.Review;

public interface IReviewService {
	List<Review> retrieveAllReviews();
	Review addReview(Review r, Long idClient, Long idProduct);
	Review retrieveReview(Long id);
	void delete(long id);
}
