package controleur;
/** Takes care of the entire control of the game. */
public class Puissance4 {
	/* déclaration des variables */
		/* privées */
	private Partie puissance4;
	/* déclaration des Constructeurs */
	/** initialiizes the game */
	public Puissance4() {
		Joueur[] joueurs = new Joueur[2];
		joueurs[0] = new Joueur(Couleur.JAUNE);
		joueurs[1] = new Joueur(Couleur.ROUGE);
		puissance4 = new Partie(joueurs);
	}
	/** initializes the game with a part saved previously.
	* @param puissance4 the game previously saved.
	*/
	public Puissance4(Partie puissance4) {
		this.puissance4 = puissance4;
	}
	/* déclaration des Méthodes et Fonctions */
		/* private */
	private Joueur autreJoueur() {
		int i = 0, l;
		Joueur autreJoueur, courant;
		autreJoueur = courant = puissance4.getJoueurCourant();
		Joueur[] joueurs = puissance4.getJoueurs();
		l = joueurs.length;
		while(i < l && autreJoueur.equals(courant)) {
			if (!joueurs[i].equals(courant)){autreJoueur = joueurs[i];}
			i++;
		}
		return autreJoueur;
	}
		/* publiques */
	/** @return state of the game, true if the game is over, false otherwise. */
	public boolean gameIsOver() {
		return puissance4.isPartieFinie();
	}
	/** surrender the game :
	 * <ul>
	 * 	<li> sets end of part to true.</li>
	 * 	<li> sets surrender to true.</li>
	 * 	<li> sets other player as winner.</li>
	 * </ul>
	 */
	public void abandonner() {
		puissance4.setPartieFinie(true);
		puissance4.setParAbandon(true);
		puissance4.setGagnant(autreJoueur());
	}
	/** Place a token in the grid if the move is valid, otherwise request another move
	* @param numColonne the number of the column where to play.
	* @throws ArrayIndexOutOfBoundsException if numColonne is out of the array bounds.
	* @throws Puissance4Exception if numColonne is full.
	*/
	public void jouer(int numColonne) throws Exception {
		if (!gameIsOver()) {
			boolean continuer;
			int numLigne;
			Jeton jeton = new Jeton(puissance4.getJoueurCourant().getNom());
			numLigne = puissance4.getGrille().insererJeton(jeton, numColonne);
			Position position = new Position(numLigne, numColonne);
			puissance4.getGrille().setJeton(jeton, position);
			continuer = (puissance4.getJoueurCourant().getNbCoupJoues() > 3) ? (puissance4.getGrille().isFullGrille()) ? false : !puissance4.getGrille().alignementRealise(position) : true;
			if (continuer) {
				puissance4.getJoueurCourant().setNbCoupJoues();
				puissance4.setJoueurCourant(autreJoueur());
			} else {
				puissance4.setPartieFinie(true);;
				if(!puissance4.getGrille().isFullGrille() && !puissance4.isParAbandon()) {puissance4.setGagnant(puissance4.getJoueurCourant());}
			}
		}
	}
	/** @return the color of the player who to play. */
	public Couleur aQuiDeJouer() {
		return puissance4.getJoueurCourant().getNom();
	}
	/** @return the game played. */
	public Partie getPartie() {
		return this.puissance4;
	}
}
