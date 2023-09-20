package asios.sh.services;

import java.util.List;

import asios.sh.entities.Destinataire;

public interface DestinataireService {
	
	public List<Destinataire> consulterDestinataire();		
	
	public void creerDestinataire(Destinataire DestinataireACreer);		
	
	public void supprimerDestinataire(Destinataire DestinataireASupprimer);		
	
	public void majDestinataire(Destinataire DestinataireAMaj);

}
