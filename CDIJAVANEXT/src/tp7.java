import java.util.Scanner;
public class tp7 {
	public static void main(String[] args) {
		int a, b, c, d;
		Scanner clavier = new Scanner(System.in);
		System.out.println("entrez un nombre entier quelconque :");
		a = clavier.nextInt();
		System.out.println("entrez un deuxième nombre entier quelconque :");
		b = clavier.nextInt();
		System.out.println("entrez un troisième nombre entier quelconque :");
		c = clavier.nextInt();
		System.out.println("entrez un quatrième nombre entier quelconque :");
		d = clavier.nextInt();
		clavier.close();
		System.out.println("(max2) le plus grand nombre de " + a + ", " + b + ", " + c + " et " + d + " est : " + max2(max2(a, b), max2(c, d)));
		System.out.println("(max3) le plus grand nombre de " + a + ", " + b + ", " + c + " et " + d + " est : " + max2(a, max3(b, c, d)));
	}
	static int max2(int a, int b) {
		return a > b ? a : b;
	}
	static int max3(int a, int b, int c) {
		return a > b ? a > c ? a : c : b > c ? b : c;
	}
}
