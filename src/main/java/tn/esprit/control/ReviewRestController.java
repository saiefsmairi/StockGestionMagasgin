package tn.esprit.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entity.Produit;
import tn.esprit.entity.Review;
import tn.esprit.spring.service.ClientServiceImpl;
import tn.esprit.spring.service.IReviewService;
import tn.esprit.spring.service.ProduitServiceImpl;
import tn.esprit.spring.service.ReviewServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/reviews")
public class ReviewRestController{
	
	@Autowired
	ReviewServiceImpl reviewService;
	
	@Autowired
	ClientServiceImpl clientService;
	
	@Autowired
	ProduitServiceImpl produitService;
	
	@GetMapping()
	@ResponseBody
	public List<Review> getClients() {
	List<Review> listReviews = reviewService.retrieveAllReviews();
	return listReviews;
	}
	
	@GetMapping("/product/{id}")
	@ResponseBody
	public List<Review> getProductReviews(@PathVariable("id") Long id) {
	List<Review> listReviews = reviewService.getProductReviews(produitService.findById(id));
	return listReviews;
	}
	
	@PostMapping("/new")
	@ResponseBody
	public Review add(@RequestBody Review r)
	{
		Review p =reviewService.addReview(r);
	return r;
	}

	@GetMapping("/checkReview/{client}/{product}")
	@ResponseBody
	public Review checkReview(@PathVariable("client") Long clientId,@PathVariable("product") Long productId)
	{
		produitService.findById(productId);
		
		Review review = reviewService.findReviewByClientAndProduct( clientService.findById(clientId),produitService.findById(productId));
		return review;
	}
	
	@PutMapping("/update")
	@ResponseBody
	public Review update(@RequestBody Review r)
	{
		return reviewService.update(r);	
	}

	@DeleteMapping("/delete/{review}")
	@ResponseBody
	public void delete(@PathVariable("review") Long review) {
		reviewService.delete(review);
	}
	
	
	
}