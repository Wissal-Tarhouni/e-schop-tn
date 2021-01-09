package tn.rnu.isi.eschop.service;

import java.util.Date;
import java.util.List;

import tn.rnu.isi.eschop.model.*; 


public interface CommandeService {

	public Long save (Commande commande) throws Exception ;
	
	List<Commande> getAll();
 
	Commande getByIdCommande(Long idCommande) throws Exception;
	
	int updateId (Long idCommande);
	
	int updateDesigCommande(Date dateCommande, Long qteCommande, Long idCommande);
	
  	void deleteCommandeByIdProduit(Long idProduit); 

	void deleteCommande(Long idCommande);

   
}
