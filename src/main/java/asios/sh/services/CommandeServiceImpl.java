package asios.sh.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;

import asios.sh.entities.Commande;
import asios.sh.entities.Destinataire;
import asios.sh.repositories.CommandeRepository;

public class CommandeServiceImpl implements CommandeService {

	@Autowired
	CommandeRepository commandeRepository;
	
	private static double prixParKg = 2.50;
	
	@Override
	public List<Commande> consulterCommandesParDestinataire(Destinataire destinataire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creerCommande(Commande commandeACreer) {
		 
		//Vérification des champs obligatoires
		Set<ConstraintViolation<Commande>> champsNonValides = Validation.buildDefaultValidatorFactory()
	        		.getValidator().validate(commandeACreer);
		

		// Vérifier si la date de livraison est au moins une semaine (7 jours) dans le futur
		 long daysDiff = ChronoUnit.DAYS.between(LocalDate.now(), commandeACreer.getDateLivraison());
		 
		 //Vérifier si quantité valide
		 Boolean isQuantiteValide = isBananaQuantiteValide(commandeACreer.getQuantite());
		 
		 if(champsNonValides.isEmpty() && daysDiff >= 7 && isQuantiteValide) {
			 
			 double prix = prixCalcule(commandeACreer.getQuantite());
			 commandeACreer.setPrix(prix);
			 commandeRepository.creerCommande(commandeACreer);
		 }
		 
	}

	@Override
	public void supprimerCommande(Commande commandeASupprimer) {
		commandeRepository.supprimerCommande(commandeASupprimer);
	}

	@Override
	public void majCommande(Commande commandeAMaj) {
		commandeRepository.majCommande(commandeAMaj);
	}

	private boolean isBananaQuantiteValide(int quantite) {
	    // Vérifiez si la quantité est comprise entre 0 et 10,000
	    if (quantite < 0 || quantite > 10000) {
	        return false;
	    }
	    
	    // Vérifiez si la quantité est un multiple de 25
	    if (quantite % 25 == 0) {
	        return true;
	    }
	    
	    return false;
	}

	private double prixCalcule(int quantite) {
		return quantite * prixParKg;
	}
}
