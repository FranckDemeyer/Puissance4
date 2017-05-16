
public class tp9 {

	public static void main(String[] args) {
		int [] tabEntier = {1,3,8,2,5};
		System.out.println("la somme des éléments " + visu(tabEntier) + " est égale à " + somme(tabEntier));
		System.out.println("le minimum des éléments " + visu(tabEntier) + " est " + min(tabEntier));
		System.out.println("le maximum des éléments " + visu(tabEntier) + " est " + max(tabEntier));
		if (ordonne(tabEntier)) {
			System.out.println("le tableau est ordonné");
		} else {
			System.out.println("le tableau n'est pas ordonné");
		}
		System.out.print("l'inversion de " + visu(tabEntier) + "est ");
		renverser(tabEntier);
		System.out.println(visu(tabEntier));
		System.out.print(visu(tabEntier) + " trié donne ");
		trier(tabEntier);
		System.out.println(visu(tabEntier));
	}
	public static void afficher(int [] tabEntier){
		System.out.print("[");
		for (int i = 0, j = tabEntier.length; i < j; i++){
			System.out.print(tabEntier[i]);
			if (i < j - 1) System.out.print(", ");
		}
		System.out.println("]");
	}
	public static String visu(int [] tabEntier) {
		String retour = "[";
		for (int i = 0, j = tabEntier.length; i < j; i++){
			retour += tabEntier[i];
			if (i < j - 1) retour += ", ";
		}
		retour += "]";
		return retour;
	}
	public static int max(int [] tabEntier) {
		int max = tabEntier[0];
		for (int i = 1, j = tabEntier.length; i < j; i++){
			if (tabEntier[i] > max) {
				max = tabEntier[i];
			}
		}
		return max;
	}
	public static int min(int [] tabEntier) {
		int min = tabEntier[0];
		for (int i = 1, j = tabEntier.length; i < j; i++){
			if (tabEntier[i] < min) {
				min = tabEntier[i];
			}
		}
		return min;
	}
	public static boolean ordonne(int [] tabEntier){
		boolean isOrdered = true;
		int i = 1;
		do {
			if (tabEntier[i - 1] > tabEntier[i]) isOrdered = false;
			i++;
		} while ((i < tabEntier.length) && isOrdered);
		return isOrdered;
	}
	public static void renverser(int [] tabEntier){
		int l = tabEntier.length;
		int [] tabTemp = new int[l];
		for (int i = 0; i < l; i++){
			tabTemp[i] = tabEntier[l - (i + 1)];
		}
		for (int i = 0; i < l; i++){
			tabEntier[i] = tabTemp[i];
		}
	}
	public static int somme(int [] tabEntier){
		int somme = 0;
		for (int i = 0, j = tabEntier.length; i < j; i++){
			somme += tabEntier[i];
		}
		return somme;
	}
	/* tri par peigne */
	public static void trier(int [] tabEntier){
		int intervalle = tabEntier.length, temp, i;
		boolean echange;
		do {
			intervalle = (int)(intervalle / 1.3);
			if (intervalle < 1) intervalle = 1;
			i = 0;
			echange = false;
			do {
				if (tabEntier[i] > tabEntier[i + intervalle]){
					temp = tabEntier[i];
					tabEntier[i] = tabEntier[i + intervalle];
					tabEntier[i + intervalle] = temp;
				}
				i++;
			} while (i < tabEntier.length - intervalle);
		} while (intervalle > 1 || echange);
	}
}
