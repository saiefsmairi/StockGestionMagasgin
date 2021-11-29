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
import tn.esprit.entity.Produit;
import tn.esprit.spring.service.IClientService;
import tn.esprit.spring.service.IFactureService;
import tn.esprit.spring.service.IProduitService;
@CrossOrigin(origins = "*", maxAge = 3600)

	@RestController
	@RequestMapping("/facture")
	public class FactureRestController {
	
	@Autowired
	IFactureService factureService;
	
	@GetMapping("/retrieve-all-factures")
	@ResponseBody
	public List<Facture> getClients() {
	List<Facture> listFacture = factureService.retrieveAllFactures();
	return listFacture;
	}
	
	
	@GetMapping("/retrieve-facture/{facture-id}")
	@ResponseBody
	public Facture retrieveProduit(@PathVariable("facture-id") Long factureID) {
	return factureService.retrieveFacture(factureID);
	}
	
	@GetMapping("/retrieve-factureClient/{client-id}")
	@ResponseBody
	public  List<Facture> retrieveFactureByClient(@PathVariable("client-id") Long ClientID) {
	return factureService.getFacturesByClient(ClientID);
	}
	
	@PostMapping("/add-facture")
	@ResponseBody
	public Facture addfacture(@RequestBody Facture c)
	{
		Facture p = factureService.addFacture(c, c.getClient().getIdClient());
	return p;
	}
	
	@DeleteMapping("/remove-facture/{facture-id}")
	@ResponseBody
	public void removefacture(@PathVariable("facture-id") Long factureID) {
		factureService.cancelFacture(factureID);
	}
	



}
