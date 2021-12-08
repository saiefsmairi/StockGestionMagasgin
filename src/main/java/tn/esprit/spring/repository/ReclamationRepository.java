package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.entity.Client;
import tn.esprit.entity.Fournisseur;
import tn.esprit.entity.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {

	@Modifying
	@Transactional
	@Query("update Reclamation u set u.reponse = :reponse , u.isresponded=1  where u.id = :id")
	void updateFournisseur(@Param(value = "id") long id, @Param(value = "reponse") String reponse);
	
	@Query("select u from Reclamation u where u.isresponded=0") 
	List<Reclamation> ReclamationNotResponded();
	
	@Query("select u from Reclamation u where u.isresponded=1 and u.client.idClient=13") 
	List<Reclamation> ReclamationRespondedPerClient();

}
