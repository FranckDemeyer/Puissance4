import java.util.Scanner;
public class tp5 {
	public static void main(String[] args) {
		int entree, max = 0;
		Scanner clavier = new Scanner(System.in);
		do {
			System.out.println("entrez un nombre entier positif quelconque entre 0 et 20 (-1 pour sortir) :");
			entree = clavier.nextInt();
			if (entree > 20) System.out.println("vous devez entrer un nombre entre 0 et 20.");
			if (entree >= 0 && entree <= 20 && entree > max){
				max = entree;
			}
		} while (entree >= 0);
		clavier.close();
		System.out.println("la plus grande note est " + max);
	}
}
