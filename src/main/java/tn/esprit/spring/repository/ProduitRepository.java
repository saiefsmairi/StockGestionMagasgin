package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.CategorieClient;
import tn.esprit.entity.Client;
import tn.esprit.entity.Produit;
import tn.esprit.entity.Stock;
@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
	@Query("SELECT sum(df.prixTotal*df.qte) FROM detailFacture df where df.produit=:produit and df.facture.dateFacture between :startDate and :endDate ")
	float getRevenuBrutProduit(@Param("produit") Produit produit,@Param("startDate") Date startDate ,@Param("endDate") Date endDate );
	
	
	  @Query(value = "SELECT p FROM Produit p JOIN p.stock s WHERE s.qte<s.qteMin ")
	    List<Produit> retrieveStatusStock();
	  @Query(value="Select * from produit order by prix_unitaire desc",nativeQuery = true)
		public List<Produit> getAllProductPriceDesc();
	  @Query(value="Select * from produit order by prix_unitaire",nativeQuery = true)
		public List<Produit> getAllProductPriceASC();
	  @Query(value="Select * from produit p where p.category_name = 'Alimentaire'",nativeQuery = true)
		public List<Produit> getAllProductAlimentaire();
	  @Query(value="Select * from produit p where p.category_name = 'Electromeanger'",nativeQuery = true)
		public List<Produit> getAllProductElectromeanger();
	  @Query(value="Select * from produit p where p.category_name = 'Quincaillerie'",nativeQuery = true)
			public List<Produit> getAllProductQuincaillerie();
	  @Query(value="Select COUNT(*) from produit GROUP BY category_name",nativeQuery = true)
		public List<Integer> getPercentageGroupByCategorie();
	  @Query(value="Select (COUNT(*)/(Select COUNT(*) from produit) *100) from produit GROUP BY category_name",nativeQuery = true)
		public List<Float> getPercentageGroupByCategory();
	  @Query(value="Select DISTINCT category_name from produit ",nativeQuery = true)
		public List<String> getAllCategories();
}
