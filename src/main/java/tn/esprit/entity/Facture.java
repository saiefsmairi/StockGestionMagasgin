package tn.esprit.entity;

import java.util.Date;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Facture {



	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long idFacture;

	@Column
	float montantRemise;

	@Column
	float montantFacture;


	@Column
	Date dateFacture;

	@Column
	boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_CLIENT_ID")
    @JsonBackReference
	Client client;
	
	@OneToMany(mappedBy="facture")
	private Set<detailFacture> detailFactures;
	


	public Facture(float f, float g, boolean b) {
		super();
		// TODO Auto-generated constructor stub
	}


}
