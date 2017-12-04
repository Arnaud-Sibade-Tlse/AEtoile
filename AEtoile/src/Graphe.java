import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graphe {
	ArrayList<Sommet> sommets;
	Map<Sommet, Integer> avantLast;
	Sommet first;
	Sommet last;
	
	public Graphe(Sommet f, Sommet l){
		sommets = new ArrayList<Sommet>();
		avantLast = new HashMap<Sommet, Integer>();
		first = f;
		last = l;

	}
	
	public void addSommet(Sommet s){
		this.sommets.add(s);
	}
	
	public void moveSommet(Sommet s){
		this.sommets.remove(s);
	}
	
	public int plusCourt(){
		for(Sommet current : sommets){
			if(current.suiv.containsKey(last)){
				avantLast.put(current,current.distP+current.suiv.get(last));
			}
		}
		int min = 99999;
		for(int i : avantLast.values()){
			if(i <= min){
				min = i;
			}
		}
		return min;
	}
}
