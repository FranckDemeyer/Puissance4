import java.util.Scanner;
public class tp3 {
	public static void main(String[] args) {
		int a, b, c, temp;
		Scanner clavier = new Scanner(System.in);
		System.out.println("entrez un nombre entier quelconque :");
		a = clavier.nextInt();
		System.out.println("entrez un deuxième nombre entier quelconque :");
		b = clavier.nextInt();
		System.out.println("entrez un troisième nombre entier quelconque :");
		c = clavier.nextInt();
		clavier.close();
		/* permutation si b < c */
		if (b > c) {
			temp = b;
			b = c;
			c = temp;
		}
		if (a > b && a < c) System.out.println(a + " est compris entre " + b + " (non inclus) et " + c + " (non inclus).");
		else System.out.println(a + " n'est pas compris entre " + b + " (non inclus) et " + c + " (non inclus).");
		if (a >= b && a <= c) System.out.println(a + " est compris entre " + b + " (inclus) et " + c + " (inclus).");
		else System.out.println(a + " n'est pas compris entre " + b + " (inclus) et " + c + " (inclus).");
	}
}