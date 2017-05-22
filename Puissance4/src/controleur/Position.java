package controleur;
/** defines the position. */
public class Position {
	/* déclaration des variables */
	private int colonne;
	private int ligne;
	/* déclaration des Constructeurs */
	/** initializes position with the line number and the column number.
	* @param ligne the row of the position.
	* @param colonne the column of the position.
	*/
	public Position(int ligne, int colonne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}
	/* déclaration des Méthodes et Fonctions */
		/* publiques */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (colonne != other.colonne)
			return false;
		if (ligne != other.ligne)
			return false;
		return true;
	}
	/** @return the column number of the position. */
	public int getColonne() {
		return colonne;
	}
	/** @return the line number of the position. */
	public int getLigne() {
		return ligne;
	}
	@Override
	public String toString() {
		return "Position > [ligne=" + ligne + ", colonne=" + colonne + "]";
	}
}
