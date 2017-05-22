package controleur;
/**the most important part,
 * defines the game itself. */
public class Partie {
	/* déclaration des variables */
		/* privées */
	private boolean partieFinie;
	private boolean parAbandon;
	private Grille grille;
	private Joueur gagnant;
	private Joueur joueurCourant;
	private Joueur[] joueurs;
	/* déclaration des Constructeur */
	/** initializes the game with players.
	* @param joueurs the players for the game.
	*/
	public Partie(Joueur[] joueurs) {
		partieFinie = false;
		parAbandon = false;
		grille = new Grille();
		gagnant = null;
		joueurCourant = tireAuSort(joueurs);
		this.joueurs = joueurs;
	}
	/* déclaration des Getters et Setters */
	/** @return the end of this game. */
	public boolean isPartieFinie() {
		return partieFinie;
	}
	/** set the end of this game.
	* @param partieFinie.
	*/
	public void setPartieFinie(boolean partieFinie) {
		this.partieFinie = partieFinie;
	}
	/** @return if the game has been earned by surrender. */
	public boolean isParAbandon() {
		return parAbandon;
	}
	/** set if the game has been earned by surrender.
	* @param parAbandon.
	*/
	public void setParAbandon(boolean parAbandon) {
		this.parAbandon = parAbandon;
	}
	/** @return game grid. */
	public Grille getGrille() {
		return grille;
	}
	/** @return the player who won this game. */
	public Joueur getGagnant() {
		return gagnant;
	}
	/** set the player who won this game.
	* @param gagnant.
	*/
	public void setGagnant(Joueur gagnant) {
		this.gagnant = gagnant;
	}
	/** @return current player. */
	public Joueur getJoueurCourant() {
		return joueurCourant;
	}
	/** set current player.
	* @param joueurCourant.
	*/
	public void setJoueurCourant(Joueur joueurCourant) {
		this.joueurCourant = joueurCourant;
	}
	/** @return game players. */
	public Joueur[] getJoueurs() {
		return joueurs;
	}
	/* déclaration des Méthodes et Fonctions */
		/* privées */
	private Joueur tireAuSort(Joueur[] joueurs) {
		return joueurs[(int)(Math.random() * 2) % 2];
	}
}
