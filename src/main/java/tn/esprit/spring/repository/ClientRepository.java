package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
@Query("SELECT c FROM Client c where c.dateNaissance between '01/01/1995' and '31/12/1995'")
	public List<Client> ClientBetweenDate();


@Query("select sum(fac.montantFacture) from Facture fac ,Client c where c=fac.client and c.categorieClient=:categorieClient ")
float getChiffreAffaireParCategorieClient(@Param("categorieClient") CategorieClient categorieClient);
}


