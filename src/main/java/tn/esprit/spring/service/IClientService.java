package tn.esprit.spring.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;

public interface IClientService {
    Client add(Client client) throws UnsupportedEncodingException, MessagingException;
    Client update(Client client, Long id);
    void delete(long id);
    List<Client> findAll();
    Client findById(Long id);
    float getChiffreAffaireParCategorieClient(CategorieClient  categorieClient);
    Client findByEmail(String email);
    Client findByVerificationCode(String code);
	public boolean verify(String verificationCode);
	void sendVerificationEmail(Client client)throws MessagingException, UnsupportedEncodingException ;
	public int activeAccount();
	public int desactiveAccount();
	public int premuimAccount();
	public int ordinaireAccount();
	public int fideleAccount();

}
