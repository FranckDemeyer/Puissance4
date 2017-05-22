package controleur;
/** defines a player. */
public class Joueur {
	/* d�claration des Variables */
		/* priv�es */
	private Couleur nom;
	private int nbCoupJoues;
	/* d�claration des Constructeurs */
	/** initializes player with is color.
	* @param nom the color of the player.
	*/
	public Joueur(Couleur nom) {
		this.nom = nom;
		nbCoupJoues = 0;
	}
	/* d�claration des Getters et des Setters */
	/** @return the color of the player. */
	public Couleur getNom() {
		return nom;
	}
	/** @return the number of moves played. */
	public int getNbCoupJoues() {
		return nbCoupJoues;
	}
	/** set the number of moves played. */
	public void setNbCoupJoues() {
		nbCoupJoues++;
	}
}
