package tn.esprit.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@JsonIgnoreProperties

public class Stock {

@Id
@GeneratedValue( strategy = GenerationType.IDENTITY )
@Column
private long idstock;

@Column
int qte;

@Column
int qteMin;

@Column
String libelleStock;

@OneToMany(mappedBy="stock")

@JsonManagedReference(value="stockref")
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
	return "Stock [idstock=" + idstock + ", qte=" + qte + ", qteMin=" + qteMin + ", libelleStock=" + libelleStock
			+ ", produits=" + produits + "]";
}
 

}
