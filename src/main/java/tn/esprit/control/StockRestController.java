package tn.esprit.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import tn.esprit.spring.service.IProduitService;
import tn.esprit.spring.service.IStockService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/stock")
@JsonIgnoreProperties
public class StockRestController {
	@Autowired
	IStockService stockService;
	
}
