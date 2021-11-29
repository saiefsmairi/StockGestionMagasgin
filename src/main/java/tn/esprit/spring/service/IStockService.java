package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.Produit;
import tn.esprit.entity.Stock;

public interface IStockService {
	  List<Stock> retrieveAllStocks();

	  Stock addStock(Stock	s);

	  void deleteStock(Long	id);

	  Stock updateStock(Stock	u);

	  Stock retrieveStock(Long	id);

	  String retrieveStatusStock();



}
