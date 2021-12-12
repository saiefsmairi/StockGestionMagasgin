package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.entity.Produit;
import tn.esprit.entity.Review;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements IReviewService{

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Override
	public List<Review> retrieveAllReviews() {
		// TODO Auto-generated method stub
		return reviewRepository.findAll();
	}

	@Override
	public Review addReview(Review r) {
		// TODO Auto-generated method stub
		Client c = clientRepository.findById(r.getClient().getIdClient()).orElse(null);
		r.setClient(c);
		return reviewRepository.save(r);
	}

	@Override
	public Review retrieveReview(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		 reviewRepository.deleteById(id);;
	}
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	void sendEmail(Review review) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(clientRepository.findByCategorieClient(CategorieClient.admin).getEmail());

        msg.setSubject("This is a new review posted by "+review.getClient().getNom());
        msg.setText(review.getClient().getPrenom() + " "+ review.getClient().getNom() +" \n" + " Rating: "+review.getRating() + " \n "+review.getDescription() );

        javaMailSender.send(msg);

    }

	@Override
	public Review findReviewByClientAndProduct(Client client,Produit product) {
		// TODO Auto-generated method stub
		
		return reviewRepository.findReviewByClientAndProduct(client, product);		
	}
	
	@Override
	public List<Review> getProductReviews(Produit product) {
		// TODO Auto-generated method stub
		
		return reviewRepository.getProductReviews(product);		
	}

	@Override
	public Review update(Review review) {
		// TODO Auto-generated method stub
		
		sendEmail(review);
		return reviewRepository.save(review);
	}

	@Override
	public Client findByRole() {
		// TODO Auto-generated method stub
		return null;
	}

}
