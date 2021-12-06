package tn.esprit.control;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.MimeMessage;

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
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import tn.esprit.configuration.MailFournisseur;
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
	
	  @Autowired
	    SpringTemplateEngine templateEngine;

	    @Autowired
	    private JavaMailSender sender;
	
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
	
	
	@PutMapping("/updateFournisseur/{fournisseur-id}")
	@ResponseBody
	public void updatefournisseuer(@PathVariable("fournisseur-id") Long fournisseurId,@RequestBody Fournisseur c) {
	
		FournisseurService.updateFournisseur(c);
	}

	
	

	@PutMapping("/assignFournisseurToProduit/{fournisseur-id}/{produit-id}")
	@ResponseBody
	public void assignProduitToStock(@PathVariable("fournisseur-id") Long fournisseurId,@PathVariable("produit-id") Long produitId) {
		
		FournisseurService.assignFournisseurToProduit(fournisseurId, produitId);
	}

	@GetMapping("/retrieve-productsParFournisseur/{fournisseur-id}")
	@ResponseBody
	public Set<Produit> retrieveProduitFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
	return  FournisseurService.retrieveProduitFournisseur(fournisseurId);
	}
	
	
	

    @RequestMapping("/sendMailfournisseur")
    public @ResponseBody MailFournisseur sendMail(@RequestBody MailFournisseur details) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name",details.getName());
        model.put("description",details.getDescription());
        model.put("email",details.getEmail());
        model.put("productName",details.getProductName());


        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);

        try {
            helper.setTo(details.getEmail());
            helper.setText(html,true);
            helper.setSubject("Augmentation du stock Pour notre Magasin");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }



}
