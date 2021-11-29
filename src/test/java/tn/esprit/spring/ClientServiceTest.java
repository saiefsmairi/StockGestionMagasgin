package tn.esprit.spring;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.Client;
import tn.esprit.spring.service.IClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ClientServiceTest {
    @Autowired
    private IClientService clientService;

    @Test
    @Ignore
    public void testAddClient() {
        List<Client> clients = clientService.findAll();
        int expected = clients.size();
        Client client = new Client("smairi", "Saief3");
        Client savedClient = clientService.add(client);
        assertEquals(expected + 1, clientService.findAll().size());
        assertNotNull(savedClient.getNom());
        
    }

    
    @Test
    public void testListClient() {
        List<Client> clients = clientService.findAll();
        	for (Client client2 : clients) {
        		log.info("Client :"+ client2);
			}

    }
    
}