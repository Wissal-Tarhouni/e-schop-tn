package tn.rnu.isi.eschop.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tn.rnu.isi.eschop.model.Produit;
import tn.rnu.isi.eschop.service.CommandeService;
import tn.rnu.isi.eschop.service.ProduitService;

@Controller("produitController")
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	ProduitService produitService;

	@Autowired
	CommandeService commandeService;

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Long id, Model model) throws Exception {
		model.addAttribute("produitToShow", produitService.getByIdProduit(id));
		return "produit/showProduit"; // Afficher la page showProduit qui se trouve sous /produit
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOrUpdate(@ModelAttribute("produitForm") Produit produit, Model model,
			final RedirectAttributes redirectAttributes) throws Exception {
		try {

			if (produit.getIdProduit() != null) {

				produitService.save(produit);

				redirectAttributes.addFlashAttribute("typeAlert", "update");
				redirectAttributes.addFlashAttribute("msgAlert",
						"Produit dont ID : " + produit.getIdProduit() + " a été mis à jour.");

			} else {

				Long idProduit = produitService.save(produit);

				redirectAttributes.addFlashAttribute("typeAlert", "new");
				redirectAttributes.addFlashAttribute("msgAlert",
						"Nouveau Produit a été enregsitrée avec ID : " + idProduit);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/produit/listAll";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model, final RedirectAttributes redirectAttributes)
			throws Exception {
		Produit produit = produitService.getByIdProduit(id);
		model.addAttribute("produitForm", produit);
		return "produit/addUpdateProduit";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id, final RedirectAttributes redirectAttributes) throws Exception {
		commandeService.deleteCommandeByIdProduit(id);
		produitService.deleteProduit(id);

		redirectAttributes.addFlashAttribute("typeAlert", "delete");
		redirectAttributes.addFlashAttribute("msgAlert", "Produit dont ID : " + id + " a été supprimé.");

		return "redirect:/produit/listAll";
	}

	@RequestMapping(value = "/clear")
	public String deleteAll() throws Exception {
		List<Produit> listeProduits = produitService.getAll();
		for (Produit produit : listeProduits) {
			commandeService.deleteCommandeByIdProduit(produit.getIdProduit());
			produitService.deleteProduit(produit.getIdProduit());
		}

		return "redirect:/produit/listAll";
	}

}
