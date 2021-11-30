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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import tn.esprit.entity.DetailProduit;
import tn.esprit.entity.Stock;
import tn.esprit.spring.service.IDetailProduitService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/detailProduit")
@JsonIgnoreProperties
public class DetailProduitRestController {
	@Autowired
	IDetailProduitService iDetailProduitService;
	@GetMapping("/retrieve-all-detailProducts")
	@ResponseBody
	public List<DetailProduit> getDetailProducts() {
	List<DetailProduit> listProducts = iDetailProduitService.retrieveAllDetailProducts();
	return  listProducts ;
	}
	
	
	@GetMapping("/retrieve-detailProduit/{detailProduit-id}")
	@ResponseBody
	public DetailProduit retrieveDetailProduit(@PathVariable("detailProduit-id") Long detailPtroduitID) {
	return iDetailProduitService.retrieveDetailProduct(detailPtroduitID);
	}
	
	@PostMapping("/add-detailProduit")
	@ResponseBody
	public DetailProduit addDetailProduit(@RequestBody DetailProduit d)
	{
		
	
		 DetailProduit detProd= iDetailProduitService.addDetailProduct(d);
		 return detProd;
	
	}
	
	
		@PutMapping("/modify-detailProduit")
		@ResponseBody
		public DetailProduit modifyDetailProduit(@RequestBody DetailProduit s) {
		return  iDetailProduitService.updateDetailProduct(s);
		}
	
	@DeleteMapping("/remove-detailProduit/{detailProduit-id}")
	@ResponseBody
	public void removeDetailProduit(@PathVariable("detailProduit-id") Long detailProduitID) {
		iDetailProduitService.deleteDetailProduct(detailProduitID);
		
	}
	
}
