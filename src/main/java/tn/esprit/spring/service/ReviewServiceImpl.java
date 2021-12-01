package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entity.Review;
import tn.esprit.spring.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements IReviewService{

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override
	public List<Review> retrieveAllReviews() {
		// TODO Auto-generated method stub
		return reviewRepository.findAll();
	}

	@Override
	public Review addReview(Review r, Long idClient, Long idProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review retrieveReview(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
