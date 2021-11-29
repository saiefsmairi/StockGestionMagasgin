package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Client;
import tn.esprit.entity.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {


}
