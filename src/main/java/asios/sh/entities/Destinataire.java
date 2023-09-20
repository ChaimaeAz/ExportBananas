package asios.sh.entities;

import javax.validation.constraints.NotBlank;

public class Destinataire {
	
    @NotBlank
	private int identifiantDestinataire;

    @NotBlank(message = "Le nom du destinataire est obligatoire")
	private String nom;
    
    @NotBlank(message = "L'adresse du destinataire est obligatoire")
	private String adresse;
    
    @NotBlank(message = "La ville du destinataire est obligatoire")
	private String ville;
    
    @NotBlank(message = "Le pays du destinataire est obligatoire")
	private String pays;
    
    @NotBlank(message = "Le code postal du destinataire est obligatoire")
    private String codePostal;
	
	public int getIdentifiantDestinataire() {
		return identifiantDestinataire;
	}
	public void setIdentifiantDestinataire(int identifiantDestinataire) {
		this.identifiantDestinataire = identifiantDestinataire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public Destinataire(int identifiant, String nom, String adresse, String ville, String pays, String codePostal) {
		super();
		this.identifiantDestinataire = identifiant;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
		this.codePostal = codePostal;
	}
	
	
	
}
