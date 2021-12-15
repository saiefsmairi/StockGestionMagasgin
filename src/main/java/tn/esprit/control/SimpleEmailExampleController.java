package tn.esprit.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/")
public class SimpleEmailExampleController {

	@Autowired
    private JavaMailSender javaMailSender;
	
	
	@GetMapping("/send_mail")
	void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("marzouga.saif@gmail.com");

        msg.setSubject("new Order");
        msg.setText("there is a new order");

        javaMailSender.send(msg);

    }


}
