package controleur;
/** s'occupe de toute la partie controle du jeu de puissance 4 */
public class Puissance4 {
	/* déclaration des variables */
		/* privées */
	private Partie puissance4;
	/* déclaration des Constructeurs */
	public Puissance4() {
		Joueur[] joueurs = new Joueur[2];
		joueurs[0] = new Joueur(Couleur.JAUNE);
		joueurs[1] = new Joueur(Couleur.ROUGE);
		puissance4 = new Partie(joueurs);
	}
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
		}
		return autreJoueur;
	}
		/* publiques */
	public boolean gameIsOver() {
		return puissance4.isPartieFinie();
	}
	public void abandonner() {
		puissance4.setPartieFinie(true);
		puissance4.setParAbandon(true);
		puissance4.setGagnant(autreJoueur());
	}
	public void jouer(int numColonne) {
		if (!gameIsOver()) {
			boolean continuer;
			int numLigne;
			Jeton jeton = new Jeton(puissance4.getJoueurCourant().getNom());
			try {
				numLigne = puissance4.getGrille().insererJeton(jeton, numColonne);
				Position position = new Position(numLigne, numColonne);
				continuer = (puissance4.getJoueurCourant().getNbCoupJoues() > 3) ? (puissance4.getGrille().isFullGrille()) ? !puissance4.getGrille().alignementRealise(position) : false : true;
				if (continuer) {
					puissance4.getGrille().setJeton(jeton, position);
					puissance4.getJoueurCourant().setNbCoupJoues();
					puissance4.setJoueurCourant(autreJoueur());
				} else {
					puissance4.setPartieFinie(true);;
					if(!puissance4.getGrille().isFullGrille()) {puissance4.setGagnant(puissance4.getJoueurCourant());}
				}
			} catch(IllegalArgumentException e) {
				
			}
		}
	}
	public Couleur aQuiDeJouer() {
		return puissance4.getJoueurCourant().getNom();
	}
	public Partie getPartie() {
		return this.puissance4;
	}
}
