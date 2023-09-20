package asios.sh.services;

import java.util.List;

import asios.sh.entities.Commande;
import asios.sh.entities.Destinataire;

public interface CommandeService {
	
	public List<Commande> consulterCommandesParDestinataire(Destinataire destinataire);

	public void creerCommande(Commande commandeACreer);

	public void supprimerCommande(Commande commandeASupprimer);

	public void majCommande(Commande commandeAMaj);
}
