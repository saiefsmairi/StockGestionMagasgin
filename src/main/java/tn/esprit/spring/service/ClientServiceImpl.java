package tn.esprit.spring.service;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
@Slf4j
public class ClientServiceImpl implements IClientService{
	private static final Logger logger = LogManager.getLogger(ClientServiceImpl.class);
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client, Long id) {
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
}
