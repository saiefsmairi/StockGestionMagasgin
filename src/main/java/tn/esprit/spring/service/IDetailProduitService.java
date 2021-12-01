package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.DetailProduit;
import tn.esprit.entity.Rayon;

public interface IDetailProduitService {
	  List<DetailProduit> retrieveAllDetailProducts();

	  DetailProduit addDetailProduct(DetailProduit	d);

	  void deleteDetailProduct(Long	id);
	  DetailProduit updateDetailProduct(DetailProduit u);

	  DetailProduit retrieveDetailProduct(Long	id);

}
