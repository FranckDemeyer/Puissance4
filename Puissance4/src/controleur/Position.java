package controleur;
public class Position {
	/* d�claration des variables */
	private int colonne;
	private int ligne;
	/* d�claration des Constructeurs */
	public Position(int ligne, int colonne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}
	/* d�claration des M�thodes et Fonctions */
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
	public int getColonne() {
		return colonne;
	}
	public int getLigne() {
		return ligne;
	}
	@Override
	public String toString() {
		return "Position > [ligne=" + ligne + ", colonne=" + colonne + "]";
	}
}
