package controleur;
public class Puissance4Exception extends RuntimeException {
	/* d�claration des constantes */
		/* priv�es */
	private static final long serialVersionUID = -1544923152475792920L;
	/* d�claration des constructeurs */
	public Puissance4Exception() {
		super();
	}
	public Puissance4Exception(String message) {
		super(message);
	}
	public Puissance4Exception(Throwable cause) {
		super(cause);
	}
	public Puissance4Exception(String message, Throwable cause) {
		super(message, cause);
	}
}
