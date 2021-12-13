package tn.esprit.control;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.models.Response;
import tn.esprit.entity.Client;
import tn.esprit.entity.Fournisseur;
import tn.esprit.entity.Produit;
import tn.esprit.entity.Stock;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.service.IClientService;
import tn.esprit.spring.service.IProduitService;
@CrossOrigin(origins = "*", maxAge = 3600)
	@RestController
	@RequestMapping("/produit")
		@JsonIgnoreProperties
	public class ProduitRestController {
	@Autowired
	FournisseurRepository fournisseurRepository;
	
	
	@Autowired
	StockRepository stockRepository;
	
	
	@Autowired
	IProduitService produitService;
	@Autowired
	ServletContext context ;
	@Autowired
	ProduitRepository productRepository;
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
	List<Produit> listProduits = produitService.retrieveAllProduits();
	return listProduits;
	}
	@GetMapping("/get-all-Categories")
	@ResponseBody
	public List<String> getAllCategories() {
	List<String> categories = produitService.getCategories();
	return categories;
	}
	@GetMapping("/get-produits-number-ByCateg")
	@ResponseBody
	public List<Integer> getProduitsNumberByCateg() {
	List<Integer> listNbrs = produitService.getPercentageGroupByCategorie();
	return listNbrs;
	}
	@GetMapping("/get-produits-pourcentage-ByCateg")
	@ResponseBody
	public List<Float> getProduitsPourcentageByCateg() {
	List<Float> listDesPourcentages = produitService.getPercentageGroupByCategory();
	return listDesPourcentages;
	}
	
	@GetMapping("/retrieve-all-produits-Asc")
	@ResponseBody
	public List<Produit> getProduitsAsc() {
	List<Produit> listProduits = produitService.getProductsPriceASC();
	return listProduits;
	}
	@GetMapping("/retrieve-all-produits-Desc")
	@ResponseBody
	public List<Produit> getProduitsDesc(){
	List<Produit> listProduits = produitService.getProductsPriceDESC();
	return listProduits;
	}
	@GetMapping("/retrieve-all-produits-Cat-Alimentaire")
	@ResponseBody
	public List<Produit> getProduitsAlimentaires(){
	List<Produit> listProduits = produitService.getProductAlimentaire();
	return listProduits;
	}
	@GetMapping("/retrieve-all-produits-Cat-Electromeanger")
	@ResponseBody
	public List<Produit> getProduitsElectromeangers(){
	List<Produit> listProduits = produitService.getAllProductElectromeanger();
	return listProduits;
	}
	@GetMapping("/retrieve-all-produits-Cat-Quincaillerie")
	@ResponseBody
	public List<Produit> getProduitsQuincailleries(){
	List<Produit> listProduits = produitService.getAllProductQuincaillerie();
	return listProduits;
	}
	
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveProduit(@PathVariable("produit-id") Long produitID) {
	return produitService.findById(produitID);
	}
	
	@PostMapping("/add-produit")
	@ResponseBody
	//required=false,name=
	public ResponseEntity<Response> addProduit(@RequestParam("produit") String produit,@RequestParam("fournisseur") long fournisseurId,
			@RequestParam("idstock") long idstock,
			@RequestParam("file") MultipartFile file) throws JsonMappingException, JsonProcessingException
	{ 
		Produit prod = new ObjectMapper().readValue(produit,Produit.class);
	boolean isExit = new File(context.getRealPath("/Images/")).exists();
	if(!isExit)
	{ 
		new File (context.getRealPath("/Images/")).mkdir();
		
	}
		String filename = file.getOriginalFilename();
		String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
		File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
		
		try
		{
			System.out.println(idstock);
			
			FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
		}catch(Exception e) {e.printStackTrace();}
		prod.setImage(newFileName);
		Fournisseur f = fournisseurRepository.findById(fournisseurId) .orElse(null);
		
		Stock s = stockRepository.findById(idstock) .orElse(null);
		prod.setStock(s);
		f.getProduits().add(prod);

		Produit pro = productRepository.save(prod);
		if(pro != null)
		{return new ResponseEntity<Response>(new Response (), HttpStatus.OK);}
		else
		{
			return new ResponseEntity<Response>(new Response(),HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping(path="/Imgproduits/{id}")
	public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
		Produit Produit = productRepository.findById(id).get();
		return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+Produit.getImage()));
	}
	
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
		if (file == null) {
			throw new RuntimeException("You must select the a file for uploading");
		}
		InputStream inputStream = file.getInputStream();
		String originalName = file.getOriginalFilename();
		String name = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();
		System.out.println("inputStream: " + inputStream);
		System.out.println("originalName: " + originalName);
		System.out.println("name: " + name);
		System.out.println("contentType: " + contentType);
		System.out.println("size: " + size);
		
		// Do processing with uploaded file data in Service layer
		return new ResponseEntity<String>(originalName, HttpStatus.OK);
	}
 
	
	@PutMapping("/modify-produit/{id}")
	  public ResponseEntity<Produit> updateArticle(@PathVariable("id") long id, @RequestParam("produit") String produit,
			  @RequestParam("file") MultipartFile file) throws JsonMappingException, JsonProcessingException {
		Produit prod = new ObjectMapper().readValue(produit,Produit.class);
	    System.out.println("Update Product with ID = " + id + "...");
	    Optional<Produit> ProductInfo = productRepository.findById(id);
	    if (ProductInfo.isPresent()) {
	    	Produit product = ProductInfo.get();
	    	   
	    	   product.setCode(prod.getCode());
	    	   product.setLibelle(prod.getLibelle());
	    	   boolean isExit = new File(context.getRealPath("/Images/")).exists();
	   		if(!isExit)
	   		{ 
	   			new File (context.getRealPath("/Images/")).mkdir();
	   			
	   		}
	   			String filename = file.getOriginalFilename();
	   			String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	   			File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
	   			
	   			try
	   			{
	   				System.out.println("Image");
	   				FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
	   			}catch(Exception e) {e.printStackTrace();}
	   			prod.setImage(newFileName);
	    	   product.setImage(prod.getImage());
	           product.setPrixUnitaire(prod.getPrixUnitaire());
	           product.setCategoryName(prod.getCategoryName());
	           product.setStockName(prod.getStockName());
	           product.setDescription(prod.getDescription());
	          
	           return new ResponseEntity<>(productRepository.save(prod), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	
	
	
	
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitID) {
		/*Produit p= produitService.findById(produitID);
		System.out.println("-----------");
		System.out.println(p.getIdproduit());*/
		produitService.delete(produitID);
		
	}
	
	
	
	
	@PutMapping("/assignProduitToStock/{produit-id}/{stock-id}")
	@ResponseBody
	public void assignProduitToStock(@PathVariable("produit-id") Long produitID,@PathVariable("stock-id") Long stockID) {
		produitService.assignProduitToStock(produitID, stockID);
	}

	@GetMapping("/getRevenuBrutProduit/{produit-id}/{datedeb}/{datefin}")
	@ResponseBody
	public float getRevenuBrutProduit(@PathVariable("produit-id") Long produitID,@PathVariable("datedeb") Date datedeb,@PathVariable("datefin") Date datefin) {
	return produitService.getRevenuBrutProduit(produitID, datedeb, datefin);
	}
	
	
}
