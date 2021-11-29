package tn.esprit.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class detailFacture {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long idDetailFacture;

	@Column
	int qte;

	@Column
	float prixTotal;

	@Column
	int pourcentageRemise;
	
	@Column
	float montantRemise;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "idProduit")
	    private Produit produit;


	@ManyToOne
	@JoinColumn(name="FK_FACTURE_ID")
	Facture facture;


	public detailFacture() {
		super();
		// TODO Auto-generated constructor stub
	}


}
