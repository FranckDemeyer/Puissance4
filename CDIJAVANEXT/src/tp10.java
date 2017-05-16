public class tp10 {
	public static void main(String[] args) {
		int [][] tab = {{3, 4, 6, 11}, {2, -21, 7, 9}, {1, 5, 12, 3}};
		System.out.println("affichage par ligne :");
		afficherParLigne(tab);
		System.out.println("affichage par colonne :");
		afficherParColonne(tab);
		if(hasOnlyPositivesWhile(tab)) {
			System.out.println("le tableau n'est constitué que de nombres positifs");
		} else {
			System.out.println("le taleau contient au moins un nombre négatif");
		}
		System.out.println("la somme des nombres impairs sur les bords du tableau est " + sommeDesBords(tab));
		System.out.println("la somme des nombres pairs sur les bords du tableau est " + sommeDesBords(tab, true));
	}
	public static void afficherParColonne(int [][] tab) {
		for (int i = 0, j = tab[0].length; i < j; i++) {
			for (int k = 0, l = tab.length; k < l; k++) {
				System.out.print(tab[k][i]);
				if (k < l - 1) System.out.print(", ");
			}
			System.out.println();
		}
	}
	public static void afficherParLigne(int [][] tab) {
		for (int i = 0, j = tab.length; i < j; i++) {
			for (int k = 0, l = tab[i].length; k < l; k++) {
				System.out.print(tab[i][k]);
				if (k < l - 1) System.out.print(", ");
			}
			System.out.println();
		}
	}
	public static boolean hasOnlyPositivesFor(int [][] tab){
		boolean hasNegative = false;
		for (int i = 0, j = tab.length; i < j; i++){
			for (int k = 0, l = tab[i].length; k < l; k++){
				if(tab[i][k] < 0) {
					hasNegative = true;
					break;
				}
				if (hasNegative) break;
			}
		}
		return !hasNegative;
	}
	public static boolean hasOnlyPositivesWhile(int [][] tab) {
		boolean hasNegative = false;
		int i = 0, j = tab.length;
		while (i < j && !hasNegative) {
			int k = 0, l = tab[i].length;
			while (k < l && !hasNegative) {
				if (tab[i][k] < 0) hasNegative = true;
				k++;
			}
			i++;
		}
		return !hasNegative;
	}
	public static int sommeDesBords(int [][] tab) {
		return sommeDesBords(tab, false);
	}
	public static int sommeDesBords(int [][] tab, boolean pair) {
		int somme = 0, l = tab.length - 1, l2 = tab[0].length - 1, valMod;
		if (pair) valMod = 0;
		else valMod = 1;
		for (int i = 0, j = tab[0].length; i < j; i++){
			if (tab[0][i] % 2 == valMod) somme += tab[0][i];
			if (tab[l][i] % 2 == valMod) somme += tab[l][i];
		}
		for (int i = 1; i < l; i++) {
			if (tab[i][0] % 2 == valMod) somme += tab[i][0];
			if (tab[i][l2] % 2 == valMod) somme += tab[i][l2];
		}
		return somme;
	}
}
