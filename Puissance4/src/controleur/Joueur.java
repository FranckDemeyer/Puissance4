package controleur;
public class Joueur {
	/* d�claration des Variables */
		/* priv�es */
	private Couleur nom;
	private int nbCoupJoues;
	/* d�claration des Constructeurs */
	public Joueur(Couleur nom) {
		this.nom = nom;
		nbCoupJoues = 0;
	}
	/* d�claration des Getters et des Setters */
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
