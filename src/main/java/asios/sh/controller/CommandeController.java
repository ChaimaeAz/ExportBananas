package asios.sh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asios.sh.entities.Commande;
import asios.sh.entities.Destinataire;
import asios.sh.services.CommandeService;

@RestController
@RequestMapping("/commande")
public class CommandeController {

	@Autowired
	CommandeService commandeService;
	
	@GetMapping("/consulterCommandes/{destinataire}")
    public List<Commande> consulterCommandesParDestinataire(@PathVariable Destinataire destinataire) {
        return commandeService.consulterCommandesParDestinataire(destinataire);
    }
}