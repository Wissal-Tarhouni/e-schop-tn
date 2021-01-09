package tn.rnu.isi.echop.service;

import java.util.List;

import tn.rnu.isi.echop.model.*;
 


public interface ProduitService {

	public Long save (Produit produit) throws Exception ;
	
	List<Produit> getAll();
 
	Produit getByIdProduit(Long idProduit) throws Exception;
	
	int updateId (Long idProduit);
	
  	int updateDesig (String desigProduit, Long qteProduit, Long idProduit); 
  	
  	void deleteProduit(Long idProduit);
  	
   
}
