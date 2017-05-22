package controleur;
/** defines a player. */
public class Joueur {
	/* déclaration des Variables */
		/* privées */
	private Couleur nom;
	private int nbCoupJoues;
	/* déclaration des Constructeurs */
	/** initializes player with is color.
	* @param nom the color of the player.
	*/
	public Joueur(Couleur nom) {
		this.nom = nom;
		nbCoupJoues = 0;
	}
	/* déclaration des Getters et des Setters */
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
