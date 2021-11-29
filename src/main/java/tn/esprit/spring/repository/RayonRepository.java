package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.entity.Client;
import tn.esprit.entity.Rayon;


public interface RayonRepository extends CrudRepository<Rayon,Long> {
	
}
