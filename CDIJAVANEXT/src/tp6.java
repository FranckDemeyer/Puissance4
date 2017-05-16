import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
public class tp6 {
	public static void main(String[] args) {
		AtomicInteger a, b;
		Scanner clavier = new Scanner(System.in);
		System.out.println("entrez un nombre entier quelconque :");
		a = new AtomicInteger(clavier.nextInt());
		System.out.println("entrez un deuxième nombre entier quelconque :");
		b = new AtomicInteger(clavier.nextInt());
		clavier.close();
		System.out.println("a : " + a + ", b : " + b);
		swap(a, b);
		System.out.println("a : " + a + ", b : " + b);
	}
	public static void swap(AtomicInteger a,AtomicInteger b) {
		a.set(b.getAndSet(a.get()));;
	}
}
