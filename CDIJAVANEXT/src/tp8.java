import java.util.Scanner;
public class tp8 {
	public static void main(String[] args) {
		int a;
		Scanner clavier = new Scanner(System.in);
		System.out.println("Entrez un nombre entier quelconque :");
		a = clavier.nextInt();
		clavier.close();
		System.out.println("la valeur absolue de " + a + " est " + abs(a));
	}
	static int abs (int a) {
		if (a < 0) a = -a;
		return a;
	}
}
