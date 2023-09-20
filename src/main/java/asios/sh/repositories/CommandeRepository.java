package asios.sh.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import asios.sh.entities.Commande;
import asios.sh.entities.Destinataire;

public class CommandeRepository {
	
	private List<Commande> listCommandeEnStock = new ArrayList<>();
	private Map<Integer, List<Commande>> listCommandeEnStockParDest = new HashMap<Integer, List<Commande>>();
	
	public List<Commande> consulterCommandesParDestinataire(Destinataire destinataire) {
		return listCommandeEnStockParDest.get(destinataire.getIdentifiantDestinataire());
	}

	public void creerCommande(Commande commandeACreer) {
		listCommandeEnStock.add(commandeACreer);
	}

	public void supprimerCommande(Commande commandeASupprimer) {
		listCommandeEnStock.remove(commandeASupprimer);
	}

	public void majCommande(Commande commandeAMaj) {
		listCommandeEnStock.stream()
        .filter(cmd -> cmd.getIdentifiantCommande() == commandeAMaj.getIdentifiantCommande())
        .findFirst()
        .ifPresent(cm -> {
            cm.setDateLivraison(commandeAMaj.getDateLivraison());
            cm.setDestinataire(commandeAMaj.getDestinataire());
            cm.setPrix(commandeAMaj.getPrix());          
            cm.setQuantite(commandeAMaj.getQuantite());          
        });	
	}

}
