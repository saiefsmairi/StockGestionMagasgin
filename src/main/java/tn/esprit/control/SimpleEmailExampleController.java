package tn.esprit.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entity.Client;
import tn.esprit.spring.service.ClientServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/")
public class SimpleEmailExampleController {

	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private ClientServiceImpl clientServiceImpl ; 
	
	
	@GetMapping("/send_mail/{client-id}")
	void sendEmail(@PathVariable("client-id") Long ClientID) {
		Client c = clientServiceImpl.findById(ClientID);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(c.getEmail());

        msg.setSubject("new Order");
        msg.setText("there is a new order");

        javaMailSender.send(msg);

    }


}
