package classes;
public class Etudiant {
	private int numero;
	private String nom;
	private int anneeEtude;
	private boolean doubleur;
	private boolean ancien;
	public Etudiant(int numero, String nom) {
		this.numero = numero;
		this.nom = nom;
		this.anneeEtude = 1;
		this.doubleur = this.ancien = false;
	}
	public Etudiant(int numero, String nom, int anneeEtude) {
		this.numero = numero;
		this.nom = nom;
		this.anneeEtude = anneeEtude;
		if (anneeEtude >= 4) {ancien = true; }
	}
	public Etudiant(int numero, String nom, boolean doubleur) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.anneeEtude = 1;
		this.doubleur = doubleur;
	}
	public Etudiant(int numero, String nom, int anneeEtude, boolean doubleur) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.anneeEtude = anneeEtude;
		this.doubleur = doubleur;
		if (anneeEtude >= 4) {ancien = true; }
	}
	public int getNumero() {
		return numero;
	}
	public String getNom() {
		return nom;
	}
	public int getAnneeEtude() {
		return anneeEtude;
	}
	public boolean isDoubleur() {
		return doubleur;
	}
	public boolean isAncien() {
		return ancien;
	}
	public void aRate() {
		doubleur = true;
	}
	public void aReussi() {
		doubleur = false;
		anneeEtude++;
		if(anneeEtude ==4) ancien = true;
	}
	@Override
	public String toString() {
		return "Etudiant : " + nom + " numéro d'etudiant : " + numero + ", anneeEtude : " + anneeEtude + ", redoublant :" + (doubleur ? "oui" : "non")
				+ ", ancien :" + (ancien ? "oui" : "non");
	}
}
