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
			try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
			do {
				display(puissance4);
				System.out.println("Joueur " + puissance4.aQuiDeJouer() + " choisissez une colonne (1 à 7, 0 pour abandonner)");
				line = clavier.next();
				colonne = (line != "") ? line.charAt(0) : ' ';
				while (colonne < '0' && colonne > '7') {
					System.out.println("vous devez entrer un nombre entre 1 et 7 (0 pour abandonner)");
					colonne = clavier.nextLine().charAt(0);
				}
				if(colonne != '0') {puissance4.jouer((int)(colonne) - 49);} else {puissance4.abandonner();}
			} while (!puissance4.gameIsOver());
			System.out.println(" le joueur " + puissance4.getPartie().getGagnant().getNom() + " à gagné " + (puissance4.getPartie().isParAbandon() ? "par abandon :(" : "!!! :)"));
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
		for (int i = 0; i < 50; i++) {System.out.println();}
	}
}
