import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
public class tp6 {
	public static void main(String[] args) {
		AtomicInteger a, b;
		int [] tabInt;
		tabInt = new int[2];
		Scanner clavier = new Scanner(System.in);
		System.out.println("entrez un nombre entier quelconque :");
		a = new AtomicInteger(clavier.nextInt());
		tabInt[0] = a.get();
		System.out.println("entrez un deuxième nombre entier quelconque :");
		b = new AtomicInteger(clavier.nextInt());
		tabInt[1] = b.get();
		clavier.close();
		System.out.println("en mode Atomic Integer :");
		System.out.println("a : " + a + ", b : " + b);
		swap(a, b);
		System.out.println("a : " + a + ", b : " + b);
		System.out.println("en mode tableau :");
		System.out.println("a : " + tabInt[0] + ", b : " + tabInt[1]);
		swapTab(tabInt);
		System.out.println("a : " + tabInt[0] + ", b : " + tabInt[1]);
	}
	public static void swap(AtomicInteger a,AtomicInteger b) {
		a.set(b.getAndSet(a.get()));;
	}
	public static void swapTab(int [] tabInt){
		int temp;
		temp = tabInt[0];
		tabInt[0] = tabInt[1];
		tabInt[1] = temp;
	}
}
