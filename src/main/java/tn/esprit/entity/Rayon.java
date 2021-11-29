package tn.esprit.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter


@Entity
@JsonIgnoreProperties
public class Rayon {

@Id
@GeneratedValue( strategy = GenerationType.IDENTITY )
@Column
private long idRayon;

@Column
String code;

@Column
String libelle;

@OneToMany(mappedBy="rayon")
private List<Produit> produits;

public Rayon(long idRayon, String code, String libelle, List<Produit> produits) {
	super();
	this.idRayon = idRayon;
	this.code = code;
	this.libelle = libelle;
	this.produits = produits;
}

public Rayon() {
	super();
}

@Override
public String toString() {
	return "Rayon [idRayon=" + idRayon + ", code=" + code + ", libelle=" + libelle + ", produits=" + produits + "]";
}



}
