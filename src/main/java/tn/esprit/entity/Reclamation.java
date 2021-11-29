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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Reclamation {

@Id
@GeneratedValue( strategy = GenerationType.IDENTITY )
@Column
private long idReclamation;


@Column
String detail;

@Column
Date date;

@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_CLIENT_ID")
 @JsonBackReference
	Client client;

}
