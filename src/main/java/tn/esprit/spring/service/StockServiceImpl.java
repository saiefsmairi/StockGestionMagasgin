package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.entity.Stock;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.StockRepository;

public class StockServiceImpl implements IStockService {
	@Autowired
	StockRepository stockRepository;
	@Override
	public List<Stock> retrieveAllStocks() {
	
		return 	(List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		stockRepository.save(s);
		return s;
	}

	@Override
	public Stock updateStock(Stock u) {
		stockRepository.save(u);
		return u;
	}

	@Override
	public Stock retrieveStock(Long id) {
		stockRepository.findById(id);
		return null;
	}

	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);

		
	}

	@Override
	public String retrieveStatusStock() {
		// TODO Auto-generated method stub
		return null;
	}



}
