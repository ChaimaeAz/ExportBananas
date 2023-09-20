package asios.sh.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;

import asios.sh.entities.Destinataire;
import asios.sh.repositories.DestinataireRepository;

public class DestinataireServiceImpl  implements DestinataireService{
	
	@Autowired
	DestinataireRepository destinataireRepository;

	@Override
	public List<Destinataire> consulterDestinataire() {
		// TODO Auto-generated method stub
		return destinataireRepository.consulterdestinataires();
	}

	@Override
	public void creerDestinataire(Destinataire destinataireACreer) {
		
        // Valider Destinataire
        Set<ConstraintViolation<Destinataire>> champsNonValides = Validation.buildDefaultValidatorFactory()
        		.getValidator().validate(destinataireACreer);

        boolean isDestExiste = verifierSiDestinataireExiste(destinataireACreer, consulterDestinataire());
      
        if (champsNonValides.isEmpty() && !isDestExiste) {
        	destinataireRepository.creerDestinataire(destinataireACreer);
        }
    
	}

	@Override
	public void supprimerDestinataire(Destinataire DestinataireASupprimer) {
		destinataireRepository.supprimerDestinataire(DestinataireASupprimer);
	}

	@Override
	public void majDestinataire(Destinataire DestinataireAMaj) {
		destinataireRepository.majDestinataire(DestinataireAMaj);
	}

	
	private boolean verifierSiDestinataireExiste(Destinataire destinataireACreer,
			List<Destinataire> listeDestinataires) {
		for (Destinataire existant : listeDestinataires) {
            if (sontIdentiques(existant, destinataireACreer)) {
                return true;
            }
        }
		return false;
	}
	
	private boolean sontIdentiques(Destinataire destinataire1, Destinataire destinataire2) {
        return destinataire1.getNom().equals(destinataire2.getNom())
                && destinataire1.getAdresse().equals(destinataire2.getAdresse())
                && destinataire1.getPays().equals(destinataire2.getPays())
                && destinataire1.getVille().equals(destinataire2.getVille())
                && destinataire1.getCodePostal().equals(destinataire2.getCodePostal());
    }
}
