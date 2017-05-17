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
			do {
				display(puissance4);
				System.out.println("Joueur " + puissance4.aQuiDeJouer() + " choisissez une colonne (1 à 7)");
				line = clavier.nextLine();
				colonne = (line != "") ? line.charAt(0) : ' ';
				while (colonne < '1' && colonne > '7') {
					System.out.println("vous devez entrer un nombre entre 1 et 7");
					colonne = clavier.nextLine().charAt(0);
				}
				puissance4.jouer((int)(colonne) - 1);
			} while (!puissance4.gameIsOver());
			
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
