package tn.esprit.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entity.Produit;
import tn.esprit.entity.Review;
import tn.esprit.spring.service.IReviewService;
import tn.esprit.spring.service.ReviewServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/reviews")
public class ReviewRestController{
	
	@Autowired
	ReviewServiceImpl reviewService;
	
	@GetMapping()
	@ResponseBody
	public List<Review> getClients() {
	List<Review> listReviews = reviewService.retrieveAllReviews();
	return listReviews;
	}
	
	@PostMapping("/add-produit")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit c)
	{
		System.out.println(c);
		Review p = review.addProduit(c, c.getRayon().getIdRayon(), c.getStock().getIdstock());
	return p;
	}
}