package tn.esprit.spring.service;


import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
@Slf4j
public class ClientServiceImpl implements IClientService{
	private static final Logger logger = LogManager.getLogger(ClientServiceImpl.class);
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private JavaMailSender mailSender;
 

    @Override
    public Client add(Client client) throws UnsupportedEncodingException, MessagingException {
    	client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
    	String randomCode = RandomString.make(64);
    	client.setVerificationCode(randomCode);
    	sendVerificationEmail(client);
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client, Long id) {
    	if(clientRepository.findById(id).isPresent()){
            Client cl = clientRepository.findById(id).get();
            cl.setNom(client.getNom());
            cl.setPrenom(client.getPrenom());
            cl.setEmail(client.getEmail());
            cl.setDateNaissance(client.getDateNaissance());
            cl.setProfession(client.getProfession());
            cl.setCategorieClient(client.getCategorieClient());
            cl.setFactures(client.getFactures());
            return clientRepository.save(cl);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }


    @Override
    public Client findById(Long id) {
		return clientRepository.findById(id).orElse(null);

    }

	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient) {
		return clientRepository.getChiffreAffaireParCategorieClient(categorieClient);
	}

	@Override
	public Client findByEmail(String email) {
		this.log.info(this.clientRepository.findByEmail(email).toString());
		return this.clientRepository.findByEmail(email);
	}
	public void sendVerificationEmail(Client client) throws MessagingException, UnsupportedEncodingException {
		logger.info("mailing");
	    String toAddress = client.getEmail();
	    String fromAddress = "bootspring69@gmail.com";
	    String senderName = "Lieblings";
	    String subject = "Please verify your registration";
	    String content = "Dear [[name]],<br>"
	            + "Please click the link below to verify your registration:<br>"
	            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
	            + "Thank you,<br>"
	            + "Your company name.";
	     
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", client.getPrenom());
	    String verifyURL ="http://localhost:8089/client/verify/" + client.getVerificationCode();
	     
	    content = content.replace("[[URL]]", verifyURL);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	     
	}
	@Override
	public boolean verify(String verificationCode) {
	    Client client = new Client();
	    client = clientRepository.findByVerificationCode(verificationCode);
	  // logger.info(client.toString());
	    if (client == null) {
	        return false;
	    } else {
	        client.setVerificationCode(null);
	        client.setActive(true);
	        clientRepository.save(client);
	         
	        return true;
	    }
	     
	}

	@Override
	public Client findByVerificationCode(String code) {
				return clientRepository.findByVerificationCode(code);
	}

	@Override
	public int activeAccount() {
		return this.clientRepository.activeAccount();
	}

	@Override
	public int desactiveAccount() {
		return this.clientRepository.desactiveAccount();
	}

	@Override
	public int premuimAccount() {
		return this.clientRepository.premuimAccount();
	}

	@Override
	public int ordinaireAccount() {
		return this.clientRepository.ordinaireAccount();
	}

	@Override
	public int fideleAccount() {
		return this.clientRepository.fideleAccount();
	}

	@Override
	public boolean updatePassword(Long id, String currentPassword, String newPassword) {
		Client client = new Client();
		client = this.clientRepository.findById(id).get();
		if (bCryptPasswordEncoder.matches(currentPassword, client.getPassword())) {
			client.setNom(client.getNom());
			client.setPrenom(client.getPrenom());
			client.setEmail(client.getEmail());
			client.setPassword(bCryptPasswordEncoder.encode(newPassword));
			client.setDateNaissance(client.getDateNaissance());
			client.setProfession(client.getProfession());
			client.setCategorieClient(client.getCategorieClient());
			client.setFactures(client.getFactures());
            clientRepository.save(client);
            return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean resetPassword(String email, String newPassword) {
		Client client = new Client();
		client = this.clientRepository.findByEmail(email);
		if (client == null) {
	        return false;
	    } else {
	    	client.setNom(client.getNom());
			client.setPrenom(client.getPrenom());
			client.setEmail(client.getEmail());
			client.setPassword(bCryptPasswordEncoder.encode(newPassword));
			client.setDateNaissance(client.getDateNaissance());
			client.setProfession(client.getProfession());
			client.setCategorieClient(client.getCategorieClient());
			client.setFactures(client.getFactures());
            clientRepository.save(client);
	        return true;
	    }
	}

	@Override
	public int docteurProfession() {
		return this.clientRepository.docteurProfession();
	}

	@Override
	public int ingenieurProfession() {
		return this.clientRepository.ingenieurProfession();
	}

	@Override
	public int etudiantProfession() {
		return this.clientRepository.etudiantProfession();
	}

	@Override
	public int commercialProfession() {
		return this.clientRepository.commercialProfession();
	}

	@Override
	public int cadreProfession() {
		return this.clientRepository.cadreProfession();
	}

	@Override
	public int autreProfession() {
		return this.clientRepository.autreProfession();
	}
}
