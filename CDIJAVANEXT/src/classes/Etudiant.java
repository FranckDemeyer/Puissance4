package classes;
public class Etudiant {
	private static int nbEtudiant = 0;
	private int numero;
	private String nom;
	private int anneeEtude;
	private boolean doubleur;
	private boolean ancien;
	public Etudiant(String nom) {
		nbEtudiant++;
		this.numero = nbEtudiant;
		this.nom = nom;
		this.anneeEtude = 1;
		this.doubleur = this.ancien = false;
	}
	public Etudiant(String nom, int anneeEtude) {
		nbEtudiant++;
		this.numero = nbEtudiant;
		this.nom = nom;
		this.anneeEtude = anneeEtude;
		if (anneeEtude >= 4) {ancien = true; }
	}
	public Etudiant(String nom, boolean doubleur) {
		nbEtudiant++;
		this.numero = nbEtudiant;
		this.nom = nom;
		this.anneeEtude = 1;
		this.doubleur = doubleur;
	}
	public Etudiant(String nom, int anneeEtude, boolean doubleur) {
		nbEtudiant++;
		this.numero = nbEtudiant;
		this.nom = nom;
		this.anneeEtude = anneeEtude;
		this.doubleur = doubleur;
		if (anneeEtude >= 4) {ancien = true; }
	}
	public int getNumero() {
		return numero;
	}
	public String getNom() {
		return nom;
	}
	public int getAnneeEtude() {
		return anneeEtude;
	}
	public boolean isDoubleur() {
		return doubleur;
	}
	public boolean isAncien() {
		return ancien;
	}
	public void aRate() {
		doubleur = true;
	}
	public void aReussi() {
		doubleur = false;
		anneeEtude++;
		if(anneeEtude ==4) ancien = true;
	}
	@Override
	public String toString() {
		return "Etudiant : " + nom + " numéro d'etudiant : " + numero + ", anneeEtude : " + anneeEtude + ", redoublant :" + (doubleur ? "oui" : "non")
				+ ", ancien :" + (ancien ? "oui" : "non");
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ancien ? 1231 : 1237);
		result = prime * result + anneeEtude;
		result = prime * result + (doubleur ? 1231 : 1237);
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + numero;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (ancien != other.ancien)
			return false;
		if (anneeEtude != other.anneeEtude)
			return false;
		if (doubleur != other.doubleur)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}
}
