package myAndroid.baseball;
import java.util.Comparator;


class CompareJoueurs implements Comparator{


	public int compare(Object j1, Object j2){
		if((j1 instanceof Joueur)&&(j2 instanceof Joueur)){

			return ((Joueur)j1).name.compareTo(((Joueur)j2).name);
			
		}
		else{

			return 1;
		}
	}
}
