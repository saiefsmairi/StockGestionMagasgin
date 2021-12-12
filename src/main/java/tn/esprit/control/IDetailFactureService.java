package tn.esprit.control;

import java.util.ArrayList;

import tn.esprit.entity.DetailProduit;
import tn.esprit.entity.detailFacture;

public interface IDetailFactureService {
	
	  detailFacture addDetailFacture(detailFacture	d , long idFacture , long idProduct);
	  ArrayList<detailFacture> findAll();

}
