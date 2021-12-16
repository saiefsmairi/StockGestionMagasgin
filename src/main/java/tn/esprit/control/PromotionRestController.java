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

import tn.esprit.entity.Promotion;
import tn.esprit.spring.service.IPromotionService;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/promotion")
public class PromotionRestController {
	
	@Autowired
	IPromotionService promotionService;
	
	

	@GetMapping("/getAll")
	public List<Promotion> getPromotion() {
	return  promotionService.findAll();
	}
	
	
	@GetMapping("/getById/{id}")
	@ResponseBody
	public Promotion retrievePromotion(@PathVariable("id") Long id) {
	return promotionService.findById(id);
	}
	
	
	@PostMapping("/add/{id}")
	@ResponseBody
	public Promotion addPromotion( @RequestBody Promotion p , @PathVariable("id") Long id)
	{
		
		Promotion promotion = promotionService.add(p,id);
		return promotion;
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void removePromotion(@PathVariable("id") Long id) {
		promotionService.delete(id);
	}
	
	@PutMapping("/modify/{id}")
	@ResponseBody
	public Promotion modifyPromotion(@RequestBody Promotion promotion,@PathVariable("id") Long id) {
		
		return promotionService.update(promotion , id );
	}
	
	@GetMapping("/stat")
	@ResponseBody
	public Integer[] stat()
	{
		return promotionService.stat();
	}
	

	
	

}
