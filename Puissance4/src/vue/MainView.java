package vue;
import controleur.*;
import java.util.Scanner;
public class MainView {
	public static void main(String[] args) {
		char colonne;
		Scanner clavier = new Scanner(System.in);
		String continuer, line;
		do {
			System.out.println("bienvenue dans Puissance 4");
			Puissance4 puissance4 = new Puissance4();
			System.out.println("Le joueur " + puissance4.aQuiDeJouer() + " commence");
			try {Thread.sleep(2000);} catch (InterruptedException e) {e.getMessage();}
			do {
				display(puissance4);
				System.out.println("Joueur " + puissance4.aQuiDeJouer() + " choisissez une colonne (1 à 7, 0 pour abandonner)");
				line = clavier.next();
				colonne = (line != "") ? line.charAt(0) : ' ';
				while (colonne < '0' && colonne > '7') {
					System.out.println("vous devez entrer un nombre entre 1 et 7 (0 pour abandonner)");
					colonne = clavier.nextLine().charAt(0);
				}
				if(colonne != '0') {
						try {
							puissance4.jouer((int)(colonne) - 49);
						} catch (Exception e) {
							System.out.println(e.getMessage());
							try {Thread.sleep(2000);} catch (InterruptedException ex) {ex.getMessage();}
						}
				} else {puissance4.abandonner();}
			} while (!puissance4.gameIsOver());
			if (puissance4.getPartie().getGagnant() != null) {
				System.out.println(" le joueur " + puissance4.getPartie().getGagnant().getNom() + " à gagné " + (puissance4.getPartie().isParAbandon() ? "par abandon :(" : "!!! :)"));
			} else {
				System.out.println("Match nul !!!");
			}
			System.out.println("voulez vous jouer une nouvelle partie ? (oui pour continuer)");
			continuer = clavier.next().toLowerCase();
		} while (continuer.charAt(0) == 'o' || continuer.charAt(0) == 'y');
		clavier.close();
	}
	private static void display(Puissance4 puissance4) {
		clear();
		System.out.println(puissance4.getPartie().getGrille().toString());
	}
	private static void clear() {
		for (int i = 0; i < 100; i++) {System.out.println();}
	}
}
