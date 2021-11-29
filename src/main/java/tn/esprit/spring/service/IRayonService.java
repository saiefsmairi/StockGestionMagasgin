package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.entity.Rayon;

public interface IRayonService {

	  List<Rayon> retrieveAllRayons();

	  Rayon addRayon(Rayon	r);

	  void deleteRayon(Long	id);
	  Rayon updateRayon(Rayon	u);

	  Rayon retrieveRayon(Long	id);








}
