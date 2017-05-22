package controleur;
/** game grid.
* @author Fr@nck D.
*/
public class Grille {
	/* déclaration des constantes */
		/* publiques */
	/** set number of columns from Config. */
	public static final int NB_COLONNES = Config.NB_COLONNES;
	/** set number of line from Config. */
	public static final int NB_LIGNES = Config.NB_LIGNES;
		/* privées */
	private static final String MSG_ERR_COLONNE_FULL = "la colonne est pleine, choisissez une autre colonne.";
	/* déclaration des variables */
		/* privées */
	private Jeton[][] plateauJetons;
	/* déclaration des Constructeurs */
	/** initializes the game by creating an array of NB_LIGNES * NB_COLONNES. */
	public Grille() {
		this.plateauJetons = new Jeton[NB_LIGNES][NB_COLONNES];
	}
	/** get array from previous saved game to continue.
	* @param plateauJetons the game board.
	*/
	public Grille(Jeton[][] plateauJetons) {
		this.plateauJetons = plateauJetons;
	}
	/* déclaration des Méthodes et Fonctions */
		/* privées */
	private boolean alignementDiagonalDG(Position position) throws Exception {
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
	private boolean alignementDiagonalGD(Position position) throws Exception {
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
	private boolean alignementHorizontal(Position position) throws Exception {
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
	private boolean alignementVertical(Position position) throws Exception  {
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
	/** checks if 4 tokens are aligned.
	* @param position the position of the token to control.
	* @return alignment.
	* @throws ArrayIndexOutOfBoundsExceptions if numColonne is out of the array bounds.
	*/
	public boolean alignementRealise(Position position) throws Exception {
		boolean alignement = false;
		alignement = alignementDiagonalDG(position);
		if(!alignement) {alignement = alignementDiagonalGD(position);}
		if(!alignement) {alignement = alignementHorizontal(position);}
		if(!alignement) {alignement = alignementVertical(position);}
		return alignement;
	}
	/** checks if column passed in parameters is full.
	* @param numColonne the number of the column to be checked.
	* @return status of a column whose number has been passed in parameters. true if full otherwise false.
	*/
	public boolean isFullColonne(int numColonne) {
		boolean full = false;
		if (plateauJetons[NB_LIGNES - 1][numColonne] != null) {full = true;}
		return full;
	}
	/**checks if the game grid is full.
	* @return state of the grid. true if full, false otherwise.
	*/
	public boolean isFullGrille() {
		boolean full = true;
		int i = 0;
		do {
			if (plateauJetons[NB_LIGNES - 1][i] == null) {full = false;}
			i++;
		} while (i < NB_COLONNES && full);
		return full;
	}
	/** checks possibility of putting a token in the array at the requested column.
	* @param jeton the token to insert.
	* @param numColonne the number of the column where to insert the token.
	* @return line number where the token will be placed.
	* @throws Puissance4Exception if column is full.
	*/
	public int insererJeton(Jeton jeton, int numColonne) throws Exception {
		int numLigne = -1;
		if(isFullColonne(numColonne)) {throw new Puissance4Exception(MSG_ERR_COLONNE_FULL);}
		else {numLigne = numLigne(numColonne);}
		return numLigne;
	}
	/** get the token at the requested position if it's valid.
	* @param position the position of the token to get.
	* @return a token if no exception is thrown, null otherwise.
	* @throws ArrayIndexOutOfBoundsException if position row or position column is out of the array bounds.
	*/
	public Jeton getJeton(Position position) throws Exception {
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
	/** store the token in the array.
	* @param jeton the token to set.
	* @param position the position where to set the token.
	*/
	public void setJeton(Jeton jeton, Position position) {
		plateauJetons[position.getLigne()][position.getColonne()] = jeton;
	}
}
