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

import tn.esprit.entity.Client;
import tn.esprit.entity.Facture;
import tn.esprit.entity.Fournisseur;
import tn.esprit.entity.Produit;
import tn.esprit.entity.Reclamation;
import tn.esprit.spring.service.IClientService;
import tn.esprit.spring.service.IFactureService;
import tn.esprit.spring.service.IFournisseurService;
import tn.esprit.spring.service.IProduitService;
import tn.esprit.spring.service.IReclamationService;
@CrossOrigin(origins = "*", maxAge = 3600)

	@RestController
	@RequestMapping("/reclamation")
	public class ReclamationRestController {
	
	@Autowired
	IReclamationService FournisseurService;
	
	@GetMapping("/retrieve-all-reclamation")
	@ResponseBody
	public List<Reclamation> getfournisseurs() {
	List<Reclamation> listfournisseur = FournisseurService.findAll();
	return listfournisseur;
	}
	
	
	@GetMapping("/retrieve-reclamation/{reclamation-id}")
	@ResponseBody
	public Reclamation retrieveProduit(@PathVariable("reclamation-id") Long fournisseurID) {
	return FournisseurService.findById(fournisseurID);
	}
	

	
	@PostMapping("/add-reclamation")
	@ResponseBody
	public Reclamation addreclamation(@RequestBody Reclamation c)
	{
		Reclamation p = FournisseurService.addReclamation(c);
	return p;
	}
	
	@DeleteMapping("/remove-reclamation/{reclamation-id}")
	@ResponseBody
	public void removefacture(@PathVariable("reclamation-id") Long fournisseurID) {
		FournisseurService.deleteReclamation(fournisseurID);
	}
	
	
	@PutMapping("/updatereclamation/{reclamation-id}")
	@ResponseBody
	public void updatefournisseuer(@PathVariable("reclamation-id") Long fournisseurId,@RequestBody Reclamation c) {
	
		FournisseurService.updateReclamation(c);
	}

	
	


}
