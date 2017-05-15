import java.util.Scanner;
public class tp1 {
	public static void main(String[] args) {
		int nombre;
		Scanner clavier = new Scanner(System.in);
		System.out.println("Entrez un nombre entier positif, négatif ou nul :");
		nombre = clavier.nextInt();
		clavier.close();
		if (nombre > 0) System.out.println(nombre + " est positif.");
		else if (nombre < 0) System.out.println(nombre + " est négatif.");
		else System.out.println(nombre + " est nul.");
	}
}
