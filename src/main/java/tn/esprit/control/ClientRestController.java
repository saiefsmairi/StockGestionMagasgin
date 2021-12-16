package tn.esprit.control;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.spring.service.IClientService;
import tn.esprit.spring.service.MyUserDetailsService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/client")
public class ClientRestController {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@Autowired
	IClientService clientService;
	@Autowired
	MyUserDetailsService userDetailsService;

	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@GetMapping("/retrieve-all-clients")

	public List<Client> getClients() {
		return clientService.findAll();
	}

	// http://localhost:8089/SpringMVC/client/retrieve-client/8
	@GetMapping("/retrieve-client/{client-id}")
	@ResponseBody
	public Client retrieveClient(@PathVariable("client-id") Long clientId) {
		return clientService.findById(clientId);
	}

	// http://localhost:8089/client/add-client
	@PostMapping("/add-client")
	@ResponseBody
	public Client addClient(@RequestBody Client c) throws UnsupportedEncodingException, MessagingException {
		Client client = clientService.add(c);
		return client;
	}

	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-client/{client-id}")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
		clientService.delete(clientId);
	}

	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-client/{client-id}")
	@ResponseBody
	public Client modifyClient(@RequestBody Client client, @PathVariable("client-id") Long clientId) {
		return clientService.update(client, clientId);
	}

	@GetMapping("/verify/{code}")
	@ResponseBody
	public String verifyByVerificationCode(@PathVariable("code") String code) throws ParseException {
		if (clientService.verify(code)) {
			return "<div class=\"container text-center\">\r\n"
					+ "    <h3>Congratulations, your account has been verified.</h3>\r\n"
					+ "    <h4><a href=\"http://localhost:4200/auth/login\">Click here to Login</a></h4>\r\n"
					+ "</div>";
		}
		return "<div class=\"container text-center\">\r\n"
				+ "    <h3>Sorry, we could not verify account. It maybe already verified,\r\n"
				+ "        or verification code is incorrect.</h3>\r\n" + "</div>";
	}

	@GetMapping("/chiffre-perCateg/{categ}")
	@ResponseBody
	public float getChiffreAffaireParCategorieClient(@PathVariable("categ") CategorieClient categ)
			throws ParseException {
		return clientService.getChiffreAffaireParCategorieClient(categ);
	}

	// http://localhost:8089/client/login/{client-email}
	@GetMapping("/login/{client-email}/{client-password}")
	@ResponseBody
	public Client findByEmail(@PathVariable("client-email") String email,
			@PathVariable("client-password") String password) {
		Client c = clientService.findByEmail(email);
		if (passwordEncoder.matches(password, c.getPassword())) {
			return c;
		}
		return null;
	}

	@GetMapping("/code/{code}")
	@ResponseBody
	public Client findByVerificationCode(@PathVariable("code") String code) {
		return clientService.findByVerificationCode(code);

	}

	@GetMapping("/active-account")

	public int getActiveAccount() {
		return clientService.activeAccount();
	}

	@GetMapping("/desactive-account")
	public int getDesactiveAccount() {
		return clientService.desactiveAccount();
	}

	@GetMapping("/premuim")
	public int getPremuimAccount() {
		return clientService.premuimAccount();
	}

	@GetMapping("/ordinaire")
	public int getOrdinaireAccount() {
		return clientService.ordinaireAccount();
	}

	@GetMapping("/fidele")
	public int getFideleAccount() {
		return clientService.fideleAccount();
	}
	// http://localhost:8089/client/modify-password/{client-id}/{password}/{newPassword}
	@GetMapping("/modify-password/{client-id}/{password}/{newPassword}")
	public boolean modifyPasswword(@PathVariable("client-id") Long clientId,@PathVariable("password") String password,@PathVariable("newPassword") String newPassword) {
		return this.clientService.updatePassword(clientId, password, newPassword);
	}
	
	// http://localhost:8089/client/modify-password/{client-id}/{password}/{newPassword}
	@GetMapping("/reset-password/{email}/{newPassword}")
	public boolean resetPassword(@PathVariable("email") String email, @PathVariable("newPassword") String newPassword) {
		return this.clientService.resetPassword(email, newPassword);
	}
	@GetMapping("/docteur")
	public int getDocteurProfession() {
		return clientService.docteurProfession();
	}
	@GetMapping("/ingenieur")
	public int getIngenieurProfessionn() {
		return clientService.ingenieurProfession();
	}
	@GetMapping("/etudiant")
	public int getEtudiantProfession() {
		return clientService.etudiantProfession();
	}
	@GetMapping("/commercial")
	public int getCommercialProfessio() {
		return clientService.commercialProfession();
	}
	@GetMapping("/cadre")
	public int getCadreProfession() {
		return clientService.cadreProfession();
	}
	@GetMapping("/autre")
	public int getAutreProfession() {
		return clientService.autreProfession();
	}
}
