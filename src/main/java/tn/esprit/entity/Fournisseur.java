package tn.esprit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Entity
public class Fournisseur {

@Id
@GeneratedValue( strategy = GenerationType.IDENTITY )
@Column
private long idFournisseur;



@Column
String code;

@Column
String libelle;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "T_PRODUIT_FOURNISSEUR",joinColumns={@JoinColumn(name="idFournisseur")},inverseJoinColumns={@JoinColumn(name ="idproduit")})
private Set<Produit> produits;

public Fournisseur() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Fournisseur [idFournisseur=" + idFournisseur + ", code=" + code + ", libelle=" + libelle + ", produits="
			+ produits + "]";
}



}
