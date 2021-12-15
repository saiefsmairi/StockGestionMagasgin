package tn.esprit.control;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entity.Facture;
import tn.esprit.entity.detailFacture;
import tn.esprit.spring.service.IFactureService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/dtfacture")
public class DetailFactureRestController {
	
	@Autowired
	IDetailFactureService detailFactureService;
	
	@PostMapping("/add-dtfacture/{facture-id}/{product-id}")
	@ResponseBody
	public detailFacture addfacture(@RequestBody detailFacture d,@PathVariable("facture-id") Long factureID,@PathVariable("product-id") Long productID)
	{
		detailFacture df = detailFactureService.addDetailFacture(d, factureID,productID) ;
		return df;
	}
	
	@PostMapping("/all")
	@ResponseBody
	public ArrayList<detailFacture> addfacture()
	{
		ArrayList<detailFacture> dfs = detailFactureService.findAll() ; 
		return dfs ; 
	}
	
	

}
