package controleur;
/** game grid */
public class Grille {
	/* déclaration des constantes */
		/* publiques */
	/** define number of columns from Config */
	public static final int NB_COLONNES = Config.NB_COLONNES;
	/** define number of line from Config */
	public static final int NB_LIGNES = Config.NB_LIGNES;
		/* privées */
	private static final String MSG_ERR_COLONNE_INVALIDE = "le numéro de colonne doit etres compris entre 1 et " + NB_COLONNES;
	private static final String MSG_ERR_LIGNE_INVALIDE = "le numéro de ligne doit etres compris entre 1 et " + NB_LIGNES;
	/* déclaration des variables */
		/* privées */
	private Jeton[][] plateauJetons;
	/* déclaration des Constructeurs */
	/** initiate game by creating an array of NB_LIGNES * NB_COLONNES */
	public Grille() {
		this.plateauJetons = new Jeton[NB_LIGNES][NB_COLONNES];
	}
	/** get array from previous saved game to continue */
	public Grille(Jeton[][] plateauJetons) {
		this.plateauJetons = plateauJetons;
	}
	/* déclaration des Méthodes et Fonctions */
		/* privées */
	private boolean alignementDiagonalDG(Position position) {
		boolean memeCouleur = true;
		int ligne = position.getLigne(), colonne = position.getColonne(), nbAlignes = 1;
		Jeton jetonVerifie;
		Position positionVerifiee;
		while(memeCouleur && colonne < NB_COLONNES && ligne > 0 && nbAlignes <= 4) {
			colonne++;
			ligne--;
			positionVerifiee = new Position(ligne, colonne);
			jetonVerifie = getJeton(positionVerifiee);
			memeCouleur = (jetonVerifie != null && jetonVerifie.getCouleur() == getJeton(position).getCouleur());
			if (memeCouleur) {nbAlignes++;}
		}
		return (nbAlignes == 4) ? true : false;	
	}
	private boolean alignementDiagonalGD(Position position) {
		boolean memeCouleur = true;
		int ligne = position.getLigne(), colonne = position.getColonne(), nbAlignes = 1;
		Jeton jetonVerifie;
		Position positionVerifiee;
		while(memeCouleur && colonne > 0 && ligne > 0 && nbAlignes <= 4) {
			colonne--;
			ligne--;
			positionVerifiee = new Position(ligne, colonne);
			jetonVerifie = getJeton(positionVerifiee);
			memeCouleur = (jetonVerifie != null && jetonVerifie.getCouleur() == getJeton(position).getCouleur());
			if (memeCouleur) {nbAlignes++;}
		}
		return (nbAlignes == 4) ? true : false;	
	}
	private boolean alignementHorizontal(Position position) {
		boolean memeCouleur = true;
		int ligne = position.getLigne(), colonne = position.getColonne(), nbAlignes = 1;
		Jeton jetonVerifie;
		Position positionVerifiee;
		while(memeCouleur && colonne > 0 && nbAlignes <= 4) {
			colonne--;
			positionVerifiee = new Position(ligne, colonne);
			jetonVerifie = getJeton(positionVerifiee);
			memeCouleur = (jetonVerifie != null && jetonVerifie.getCouleur() == getJeton(position).getCouleur());
			if (memeCouleur) {nbAlignes++;}
		}
		colonne = position.getColonne();
		memeCouleur = true;
		while(memeCouleur && colonne < NB_COLONNES && nbAlignes <= 4) {
			colonne++;
			positionVerifiee = new Position(ligne, colonne);
			jetonVerifie = getJeton(positionVerifiee);
			memeCouleur = (jetonVerifie != null && jetonVerifie.getCouleur() == getJeton(position).getCouleur());
			if (memeCouleur) {nbAlignes++;}
		}
		return (nbAlignes == 4) ? true : false;
	}
	private boolean alignementVertical(Position position) {
		boolean memeCouleur = true;
		int ligne = position.getLigne(), colonne = position.getColonne(), nbAlignes = 1;
		Jeton jetonVerifie;
		Position positionVerifiee;
		while(memeCouleur && ligne > 0 && nbAlignes <= 4) {
			ligne--;
			positionVerifiee = new Position(ligne, colonne);
			jetonVerifie = getJeton(positionVerifiee);
			memeCouleur = (jetonVerifie != null & jetonVerifie.getCouleur() == getJeton(position).getCouleur());
			if (memeCouleur) {nbAlignes++;}
		}
		return (nbAlignes == 4) ? true : false;
	}
	private int numLigne(int numColonne) {
		int numLigne = -1, i = 0;
		do {
			if (plateauJetons[i][numColonne] == null) {
				numLigne = i;
			}
			i++;
		} while (i < NB_LIGNES && numLigne == -1);
		return numLigne;
	}
		/* publique */
	/** check if 4 tokens are aligned
	 * return a boolean */
	public boolean alignementRealise(Position position) {
		boolean alignement = false;
		alignement = alignementDiagonalDG(position);
		if(!alignement) {alignement = alignementDiagonalGD(position);}
		if(!alignement) {alignement = alignementHorizontal(position);}
		if(!alignement) {alignement = alignementVertical(position);}
		return alignement;
	}
	/** check if column passed in parameters is full.
	 * return IllegalArgumentException if column is out of Array bounds or return a boolean */
	public boolean isFullColonne(int numColonne) {
		boolean full = false;
		if (numColonne >= NB_COLONNES || numColonne < 0) {throw new IllegalArgumentException(MSG_ERR_COLONNE_INVALIDE);}
		if (plateauJetons[NB_LIGNES - 1][numColonne] != null) {full = true;}
		return full;
	}
	/**check if the game grid is full
	 * return a boolean */
	public boolean isFullGrille() {
		boolean full = true;
		int i = 0;
		do {
			if (plateauJetons[NB_LIGNES - 1][i] == null) {full = false;}
			i++;
		} while (i < NB_COLONNES && full);
		return full;
	}
	/** check possibility of putting a token in array at asked column
	 * si la colonne est en dehors du tableau : return IllegalArgumentException if column is out of array bounds,
	 * return Puissance4Exception if column is full
	 * or return line number where the token will be put */
	public int insererJeton(Jeton jeton, int numColonne) {
		int numLigne;
		if (numColonne >= NB_COLONNES || numColonne < 0) {throw new IllegalArgumentException(MSG_ERR_COLONNE_INVALIDE);}
		if(isFullColonne(numColonne)) {numLigne = -1;} // remplacer numLigne = -1 par throw new Puissance4Exception()
		else {numLigne = numLigne(numColonne);}
		return numLigne;
	}
	/** get token from asked position if position is valid
	 *  return a token or null */
	public Jeton getJeton(Position position) {
		if (position.getColonne() >= NB_COLONNES || position.getColonne() < 0) {throw new IllegalArgumentException(MSG_ERR_COLONNE_INVALIDE);}
		if (position.getLigne() >= NB_LIGNES || position.getLigne() < 0) {throw new IllegalArgumentException(MSG_ERR_LIGNE_INVALIDE);}
		return plateauJetons[position.getLigne()][position.getColonne()];
	}
	@Override
	public String toString() {
		Jeton jeton;
		String retour = "---------------\n";
		for (int i = 0, j = plateauJetons.length; i < j; i++) {
			retour += "|";
			for (int k = 0, l = plateauJetons[i].length; k < l; k++) {
				jeton = plateauJetons[NB_LIGNES - i - 1][k];
				if (jeton != null) {
					if (jeton.getCouleur().equals(Couleur.JAUNE)){
						retour += "J|";
					} else {
						retour += "R|";
					}
				} else {
					retour += " |";
				}
			}
			retour += "\n---------------\n";
		}
		retour += "|1|2|3|4|5|6|7|\n";
		retour += "---------------";
		return retour;
	}
	/** store token in array */
	public void setJeton(Jeton jeton, Position position) {
		plateauJetons[position.getLigne()][position.getColonne()] = jeton;
	}
}
