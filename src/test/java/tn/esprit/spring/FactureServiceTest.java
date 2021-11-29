package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.Client;
import tn.esprit.entity.Facture;
import tn.esprit.spring.service.IClientService;
import tn.esprit.spring.service.IFactureService;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceTest {
    @Autowired
    private IFactureService factureService;

    @Test
    public void testAddFacture() {
        List<Facture> factures = factureService.retrieveAllFactures();
        int expected = factures.size();
        Facture facture = new Facture(12.5F,15.2F,true);
        Facture savedFacture= factureService.addFacture(facture,facture.getClient().getIdClient());
        assertEquals(expected + 1, factureService.retrieveAllFactures().size());
        assertNotNull(savedFacture.getIdFacture());
        factureService.cancelFacture(savedFacture.getIdFacture());
    }

    @Test
    public void testListFacture() {
        factureService.retrieveAllFactures()
                .forEach( facture -> log.info("Facture :"+ facture));
    }
}