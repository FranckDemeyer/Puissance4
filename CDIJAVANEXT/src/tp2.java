import java.util.Scanner;
public class tp2 {
	public static void main(String[] args) {
		int a, b, c, plusGrand;
		Scanner clavier = new Scanner(System.in);
		System.out.println("entrez un nombre entier quelconque :");
		a = clavier.nextInt();
		System.out.println("entrez un deuxième nombre entier quelconque :");
		b = clavier.nextInt();
		System.out.println("entrez un troisième nombre entier quelconque :");
		c = clavier.nextInt();
		clavier.close();
		plusGrand = a > b ? a > c ? a : c : b > c ? b : c;
		System.out.println(plusGrand + " est le plus grand nombre de " + a + ", " + b + " et " + c);
	}
}
