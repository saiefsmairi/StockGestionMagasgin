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

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
	@Modifying
	@Transactional
	@Query("update Fournisseur u set u.libelle = :libelle , u.adresse = :adresse , u.numero = :numero  where u.id = :id")
	void updateFournisseur(@Param(value = "id") long id, @Param(value = "libelle") String libelle,@Param(value = "adresse") String adresse, @Param(value = "numero") String numero);

}
