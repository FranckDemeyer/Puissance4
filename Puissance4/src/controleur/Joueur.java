package controleur;
public class Joueur {
	/* déclaration des Variables */
		/* privées */
	private Couleur nom;
	private int nbCoupJoues;
	/* déclaration des Constructeurs */
	public Joueur(Couleur nom) {
		this.nom = nom;
		nbCoupJoues = 0;
	}
	/* déclaration des Getters et des Setters */
	public Couleur getNom() {
		return nom;
	}
	public int getNbCoupJoues() {
		return nbCoupJoues;
	}
	public void setNbCoupJoues() {
		nbCoupJoues++;
	}
}
