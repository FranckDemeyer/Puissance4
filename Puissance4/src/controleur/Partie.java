package controleur;
public class Partie {
	/* d�claration des variables */
		/* priv�es */
	private boolean partieFinie;
	private boolean parAbandon;
	private Grille grille;
	private Joueur gagnant;
	private Joueur joueurCourant;
	private Joueur[] joueurs;
	/* d�claration des Constructeur */
	public Partie(Joueur[] joueurs) {
		partieFinie = false;
		parAbandon = false;
		grille = new Grille();
		gagnant = null;
		joueurCourant = tireAuSort(joueurs);
		this.joueurs = joueurs;
	}
	/* d�claration des Getters et Setters */
	public boolean isPartieFinie() {
		return partieFinie;
	}
	public void setPartieFinie(boolean partieFinie) {
		this.partieFinie = partieFinie;
	}
	public boolean isParAbandon() {
		return parAbandon;
	}
	public void setParAbandon(boolean parAbandon) {
		this.parAbandon = parAbandon;
	}
	public Grille getGrille() {
		return grille;
	}
	public Joueur getGagnant() {
		return gagnant;
	}
	public void setGagnant(Joueur gagnant) {
		this.gagnant = gagnant;
	}
	public Joueur getJoueurCourant() {
		return joueurCourant;
	}
	public void setJoueurCourant(Joueur joueurCourant) {
		this.joueurCourant = joueurCourant;
	}
	public Joueur[] getJoueurs() {
		return joueurs;
	}
	/* d�claration des M�thodes et Fonctions */
		/* priv�es */
	private Joueur tireAuSort(Joueur[] joueurs) {
		return joueurs[((int)(Math.random()) * 2) % 2];
	}
}
