package tn.esprit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Promotion {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long id;
	
	@Column
	String name ;
	
	@Column
	String description ;
	
	@Column
	Long pourcentage ;
	
	@Column
	Date dateBegin ;

	@Column
	Date endate ;
	
	@OneToOne
	Produit produit;
}
