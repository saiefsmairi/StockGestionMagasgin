package tn.esprit.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
	MyUserDetailsService  userDetailsService;
	
	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@GetMapping("/retrieve-all-clients")
	
	public List<Client> getClients() {
	return  clientService.findAll();
	}
	
	
	//http://localhost:8089/SpringMVC/client/retrieve-client/8
	@GetMapping("/retrieve-client/{client-id}")
	@ResponseBody
	public Client retrieveClient(@PathVariable("client-id") Long clientId) {
	return clientService.findById(clientId);
	}
	
	//http://localhost:8089/SpringMVC/client/add-client
	@PostMapping("/add-client")
	@ResponseBody
	public Client addClient(@RequestBody Client c)
	{
	Client client = clientService.add(c);
	return client;
	}
	
	//http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-client/{client-id}")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
	clientService.delete(clientId);
	}
	
	//http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-client/{client-id}")
	@ResponseBody
	public Client modifyClient(@RequestBody Client client,@PathVariable("client-id") Long clientId) {
	return clientService.update(client,clientId);
	}
	
	@GetMapping("/chiffre-perCateg/{categ}")
	@ResponseBody
	public float getChiffreAffaireParCategorieClient(@PathVariable("categ") CategorieClient categ) throws ParseException {
	return clientService.getChiffreAffaireParCategorieClient(categ);
	}
	//http://localhost:8089/client/login/{client-email}
	@GetMapping("/login/{client-email}/{client-password}")
	@ResponseBody
	public Client findByEmail(@PathVariable("client-email") String email,@PathVariable("client-password") String password) {
		Client c = clientService.findByEmail(email);
		if(passwordEncoder.matches(password, c.getPassword())) {
			return c;
		}
		return null; 
	}
	
}
