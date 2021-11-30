package tn.esprit.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import tn.esprit.entity.Stock;
import tn.esprit.spring.service.IStockService;


@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/stock")
@JsonIgnoreProperties
public class StockRestController {
	
	@Autowired
	 IStockService  stockService ;
	
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<Stock> getStocks() {
	List<Stock> listStocks = stockService.retrieveAllStocks();
	return listStocks ;
	}
	
	
	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public Stock retrieveStock(@PathVariable("stock-id") Long stockID) {
	return stockService.retrieveStock(stockID);
	}
	
	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock stock)
	{
		System.out.println(stock);
	
		Stock s = stockService.addStock(stock);
	return s;
	}
	
	
		@PutMapping("/modify-stock")
		@ResponseBody
		public Stock modifyStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
		}
	
	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockID) {
		stockService.deleteStock(stockID);
		
	}
}
