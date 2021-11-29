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
import tn.esprit.spring.service.IClientService;
import tn.esprit.spring.service.IFactureService;
import tn.esprit.spring.service.IFournisseurService;
import tn.esprit.spring.service.IProduitService;
@CrossOrigin(origins = "*", maxAge = 3600)

	@RestController
	@RequestMapping("/fournisseur")
	public class FournisseurRestController {
	
	@Autowired
	IFournisseurService FournisseurService;
	
	@GetMapping("/retrieve-all-fournisseur")
	@ResponseBody
	public List<Fournisseur> getfournisseurs() {
	List<Fournisseur> listfournisseur = FournisseurService.retrieveAllFournisseurs();
	return listfournisseur;
	}
	
	
	@GetMapping("/retrieve-fournisseur/{fournisseur-id}")
	@ResponseBody
	public Fournisseur retrieveProduit(@PathVariable("fournisseur-id") Long fournisseurID) {
	return FournisseurService.retrieveFournisseur(fournisseurID);
	}
	

	
	@PostMapping("/add-fournisseur")
	@ResponseBody
	public Fournisseur addfacture(@RequestBody Fournisseur c)
	{
		Fournisseur p = FournisseurService.addFournisseur(c);
	return p;
	}
	
	@DeleteMapping("/remove-fournisseur/{fournisseur-id}")
	@ResponseBody
	public void removefacture(@PathVariable("fournisseur-id") Long fournisseurID) {
		FournisseurService.deleteFournisseur(fournisseurID);
	}
	
	

	@PutMapping("/assignFournisseurToProduit/{fournisseur-id}/{produit-id}")
	@ResponseBody
	public void assignProduitToStock(@PathVariable("fournisseur-id") Long fournisseurId,@PathVariable("produit-id") Long produitId) {
		
		FournisseurService.assignFournisseurToProduit(fournisseurId, produitId);
	}




}
