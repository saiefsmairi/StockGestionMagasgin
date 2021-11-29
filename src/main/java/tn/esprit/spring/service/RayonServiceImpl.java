package tn.esprit.spring.service;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.entity.Rayon;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.RayonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class RayonServiceImpl implements IRayonService{

    @Autowired
    private RayonRepository rayonRepository;

	@Override
	public List<Rayon> retrieveAllRayons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rayon addRayon(Rayon r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRayon(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rayon updateRayon(Rayon u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
