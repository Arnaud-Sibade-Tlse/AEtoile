import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sommet {
	String name;
	Map<Sommet, Integer> suiv;
	int distP;
	int heurist;;
	ArrayList<Sommet> parcouru;
	
	public Sommet(String name, int he){
		suiv = new HashMap<Sommet, Integer>();
		parcouru = new ArrayList<Sommet>();
		this.name = name;
		heurist = he;
		distP = 0;
	}
	
	public void addSuiv(Sommet s, int dist){
		suiv.put(s,dist);
		s.addParcouru(this);
		s.distP+=this.distP+dist;
	}
	
	private void addParcouru(Sommet sommet) {
		this.parcouru.add(sommet);
		
	}

	public int getHeuristique(){
		return this.heurist;
	}
	
	public int fEtoile(){
		return this.distP+this.heurist;
	}
	
	
	
}
