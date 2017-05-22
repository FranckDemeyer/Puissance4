package controleur;
/** define a token.
*@author Fr@nck D.
*/
public class Jeton {
	/* d�claration des variables */
	private Couleur couleur;
	/* d�claration des constructeurs */
	/** initialize the token with a color.
	* @param couleur the color to which the token has to be initialized.
	* @see Couleur
	*/
	public Jeton(Couleur couleur) {
		this.couleur = couleur;
	}
	/* d�claration des Getters et des Setters */
	/** return the color of the token
	* @return RED or YELLOW
	* @see Couleur
	*/
	public Couleur getCouleur() {
		return couleur;
	}
}
