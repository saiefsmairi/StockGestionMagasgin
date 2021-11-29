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
import tn.esprit.entity.Stock;
import tn.esprit.spring.service.IClientService;
import tn.esprit.spring.service.IStockService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StockServiceTest {
    @Autowired
    private IStockService stockService;

    @Test
    public void testAddStock() {
        List<Stock> stocks = stockService.retrieveAllStocks();
        int expected = stocks.size();
        Stock stock = new Stock(20,2,"stock 1");
        Stock savedStock= stockService.addStock(stock);
        assertEquals(expected + 1, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getIdstock());
        stockService.deleteStock(savedStock.getIdstock());
    }

    @Test
    public void testListStock() {
        stockService.retrieveAllStocks()
                .forEach( stock -> log.info("Stock :"+ stock));
    }
}