package classes;
import java.util.Scanner;
public class testEtudiant {
	public static void main(String[] args) {
		Etudiant carl = new Etudiant("Karl Lagarfeld");
		Etudiant john = new Etudiant("John Wick");
		Scanner clavier = new Scanner(System.in);
		String reponse;
		System.out.println(carl.getNom() + " a-t-il réussi son examen ? (o/n)");
		reponse = clavier.next();
		if (reponse.charAt(0) == 'o' || reponse.charAt(0) == 'O') {carl.aReussi(); } else {carl.aRate(); }
		System.out.println(carl.toString());
		System.out.println(john.getNom() + " a-t-il réussi son examen ? (o/n)");
		reponse = clavier.next();
		if (reponse.charAt(0) == 'o' || reponse.charAt(0) == 'O') {john.aReussi(); } else {john.aRate(); }
		System.out.println(john.toString());		
		clavier.close();
	}
}
