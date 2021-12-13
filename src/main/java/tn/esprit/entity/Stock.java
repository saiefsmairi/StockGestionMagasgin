package tn.esprit.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter


public class Stock {

@Id
@GeneratedValue( strategy = GenerationType.IDENTITY )
@Column
private long idstock;
@Column
String productsName;
@Column
String fournisseursName;
@Column
int qte;

@OneToOne
@JsonIgnore
private Fournisseur fournisseur ;


@Column
int idfourn;

@Column
int qteMin;

@Column
String libelleStock;

@OneToMany(mappedBy="stock")
@JsonIgnore

private List<Produit> produits;



public Stock() {
	super();
	// TODO Auto-generated constructor stub
}


public Stock(int qte, int qteMin, String libelleStock) {
	super();
	this.qte = qte;
	this.qteMin = qteMin;
	this.libelleStock = libelleStock;
}


@Override
public String toString() {
	return "Stock [idstock=" + idstock + ", productsName=" + productsName + ", fournisseursName=" + fournisseursName
			+ ", qte=" + qte + ", fournisseur=" + fournisseur + ", idfourn=" + idfourn + ", qteMin=" + qteMin
			+ ", libelleStock=" + libelleStock + ", produits=" + produits + "]";
}


public Stock(long idstock, String productsName, String fournisseursName, int qte, Fournisseur fournisseur, int idfourn,
		int qteMin, String libelleStock, List<Produit> produits) {
	super();
	this.idstock = idstock;
	this.productsName = productsName;
	this.fournisseursName = fournisseursName;
	this.qte = qte;
	this.fournisseur = fournisseur;
	this.idfourn = idfourn;
	this.qteMin = qteMin;
	this.libelleStock = libelleStock;
	this.produits = produits;
}





}
