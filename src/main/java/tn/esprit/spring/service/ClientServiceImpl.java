package tn.esprit.spring.service;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
@Slf4j
public class ClientServiceImpl implements IClientService{
	private static final Logger logger = LogManager.getLogger(ClientServiceImpl.class);
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client add(Client client) {
    	client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client, Long id) {
    	if(clientRepository.findById(id).isPresent()){
            Client cl = clientRepository.findById(id).get();
            cl.setNom(client.getNom());
            cl.setPrenom(client.getPrenom());
            cl.setEmail(client.getEmail());
            cl.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
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
}
