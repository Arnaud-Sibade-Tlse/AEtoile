import java.util.HashMap;
import java.util.Map;

public class Sommet {
	String name;
	Map<Sommet, Integer> suiv;
	int distP;
	int heurist;

	public Sommet(String name, int he) {
		suiv = new HashMap<Sommet, Integer>();
		this.name = name;
		heurist = he;
		distP = 0;
	}

	public void addSuiv(Sommet s, int dist) {
		suiv.put(s, dist);
		if (s.distP == 0) {
			s.distP += this.distP + dist;
		} else {
			if (this.distP + dist < s.distP) {
				s.distP = this.distP + dist;
			}
		}

	}

	public int getHeuristique() {
		return this.heurist;
	}

	public int fEtoile() {
		return this.distP + this.heurist;
	}

}
