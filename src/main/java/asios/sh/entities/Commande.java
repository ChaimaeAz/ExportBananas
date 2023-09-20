package asios.sh.entities;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

public class Commande {
	
	private int identifiantCommande;

	@NotBlank(message = "Quantité non rensignée")
	private int quantite;
    
    @NotBlank(message = "Prix non rensignée")
	private double prix;
    
    @NotBlank(message = "Date de livraison non rensignée")
	private LocalDate dateLivraison;

    @NotBlank(message = "Destinataire non rensignée")
	private Destinataire destinataire;

    
    public int getIdentifiantCommande() {
		return identifiantCommande;
	}

	public void setIdentifiantCommande(int identifiantCommande) {
		this.identifiantCommande = identifiantCommande;
	}
	
	public LocalDate getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(LocalDate dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Destinataire getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Destinataire destinataire) {
		this.destinataire = destinataire;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Commande(int identifiant, int quantite, double prix, LocalDate date, Destinataire destinataire) {
		super();
		this.identifiantCommande = identifiant;
		this.quantite = quantite;
		this.prix = prix;
		this.dateLivraison = date;
		this.destinataire = destinataire;
	}
}
