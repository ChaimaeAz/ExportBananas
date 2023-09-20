package asios.sh.repositories;

import java.util.ArrayList;
import java.util.List;

import asios.sh.entities.Destinataire;

public class DestinataireRepository {

	private List<Destinataire> listdestinataireEnStock = new ArrayList<>();
	
	public List<Destinataire> consulterdestinataires() {
		return listdestinataireEnStock;
	}

	public void creerDestinataire(Destinataire destinataireACreer) {
		// TODO Auto-generated method stub
		listdestinataireEnStock.add(destinataireACreer);
	}

	public void supprimerDestinataire(Destinataire destinataireASupprimer) {
		listdestinataireEnStock.remove(destinataireASupprimer);
	}

	public void majDestinataire(Destinataire destinataireAMaj) {
		for (Destinataire destinataire : listdestinataireEnStock) {
            if (destinataire.getIdentifiantDestinataire() == destinataireAMaj.getIdentifiantDestinataire()) {
                destinataire.setNom(destinataireAMaj.getNom());
                destinataire.setAdresse(destinataireAMaj.getAdresse());
                destinataire.setCodePostal(destinataireAMaj.getCodePostal());

                break;
            }
        }
	}

}
