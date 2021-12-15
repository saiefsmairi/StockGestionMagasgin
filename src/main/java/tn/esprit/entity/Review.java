package tn.esprit.entity;

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
public class Review {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private long id;

@Column
private String description;

@Column
private int rating;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="CLIENT_ID")
private Client client;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="PRODUCT_ID")
private Produit product;

}
