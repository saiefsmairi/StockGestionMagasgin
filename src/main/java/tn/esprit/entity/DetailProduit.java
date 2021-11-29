package tn.esprit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DetailProduit {
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long idDetailProduit;

	@Column
	Date dateCreation;

	@Column
	Date dateDerniéreModification;

	@Column
	Float prixUnitaire;

	@Column
	@Enumerated(EnumType.STRING)
	CategorieProduit categorieProduit;
	
	@OneToOne(mappedBy="detailProduit")
	private Produit produit;



	public DetailProduit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailProduit( Date dateCreation, Date dateDerniéreModification, Float prixUnitaire,
			CategorieProduit categorieProduit, Produit produit) {
		super();
		
		this.dateCreation = dateCreation;
		this.dateDerniéreModification = dateDerniéreModification;
		this.prixUnitaire = prixUnitaire;
		this.categorieProduit = categorieProduit;
		this.produit = produit;
	}
	
	
}
