import java.util.Scanner;
public class tp4bouclewhile {
	public static void main(String[] args) {
		int a, b, i = 0;
		Scanner clavier = new Scanner(System.in);
		System.out.println("entrez un nombre entier :");
		a = clavier.nextInt();
		System.out.println("entrez un deucième nombre entier :");
		b = clavier.nextInt();
		clavier.close();
		while (i <= b) {
			System.out.println(a + " * " + i + " = " + a * i);
			i++;
		}
	}
}
