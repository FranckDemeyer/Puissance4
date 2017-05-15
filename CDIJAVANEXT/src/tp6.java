import java.util.Scanner;
public class tp6 {
	public static void main(String[] args) {
		Integer a, b;
		Scanner clavier = new Scanner(System.in);
		System.out.println("entrez un nombre entier quelconque :");
		a = new Integer(clavier.nextInt());
		System.out.println("entrez un deuxième nombre entier quelconque :");
		b = new Integer(clavier.nextInt());
		clavier.close();
		System.out.println("a : " + a + ", b : " + b);
		swap(a, b);
		System.out.println("a : " + a + ", b : " + b);
	}
	static void swap(Integer a, Integer b) {
		System.out.println("swap a before > " + a + ", b before > " + b);
		Integer temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println("swap a after > " + a + ", b after > " + b);
	}
}
