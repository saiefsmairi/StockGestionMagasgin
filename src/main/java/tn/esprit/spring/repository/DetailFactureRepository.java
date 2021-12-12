package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.entity.DetailProduit;
import tn.esprit.entity.detailFacture;

public interface DetailFactureRepository extends JpaRepository<detailFacture,Long> {

}
