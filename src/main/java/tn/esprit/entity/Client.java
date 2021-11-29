package tn.esprit.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Entity
public class Client {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long idClient;

	@Column
	String nom;
	@Column
	String prenom;
	@Column
	@Temporal(TemporalType.DATE)
	Date dateNaissance;
	@Column
	String email;
	@Column
	String password;
	@Column
	@Enumerated(EnumType.STRING)
	CategorieClient categorieClient ;
	@Column
	@Enumerated(EnumType.STRING)
	Profession Profession ;
	
	@OneToMany(mappedBy="client")
	private Set<Facture> factures;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	

}
