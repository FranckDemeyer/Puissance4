import java.util.Scanner;
public class tp4bouclefor {
	public static void main(String[] args) {
		int a, b;
		Scanner clavier = new Scanner(System.in);
		System.out.println("entrez un nombre entier :");
		a = clavier.nextInt();
		System.out.println("entrez un deucième nombre entier :");
		b = clavier.nextInt();
		clavier.close();
		for (int i = 0; i <= b; i++) {
			System.out.println(a + " * " + i + " = " + a * i);
		}
	}
}
