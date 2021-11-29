package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Client;
import tn.esprit.entity.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture,Long> {
	@Modifying
	@Transactional
	@Query("update Facture f set f.active=true where f.idFacture=:id")
	void cancelFacture( @Param("id")Long id);
	
	@Query("select f from Facture f where f.client=client")
	List<Facture> getFacturesByClient(@Param("client")Client client);
	

}
