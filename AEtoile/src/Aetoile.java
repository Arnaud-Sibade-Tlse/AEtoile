import java.util.ArrayList;

public class Aetoile {

	public static void main(String[] args) {
		Sommet t = new Sommet("t", 0);
		Sommet s = new Sommet("s", 0);
		Sommet a = new Sommet("a", 5);
		Sommet b = new Sommet("b", 4);
		Sommet c = new Sommet("c", 4);
		Sommet d = new Sommet("d", 3);
		Sommet e = new Sommet("e", 7);
		Sommet f = new Sommet("f", 4);
		Sommet g = new Sommet("g", 2);

		s.addSuiv(a, 2);
		a.addSuiv(b, 2);
		b.addSuiv(c, 2);
		c.addSuiv(d, 3);
		d.addSuiv(t, 3);

		s.addSuiv(e, 2);
		e.addSuiv(f, 5);
		f.addSuiv(g, 2);
		g.addSuiv(t, 2);

		Graphe leGraphe = new Graphe(s, t);
		leGraphe.addSommet(s);
		leGraphe.addSommet(a);
		leGraphe.addSommet(b);
		leGraphe.addSommet(c);
		leGraphe.addSommet(d);
		leGraphe.addSommet(e);
		leGraphe.addSommet(f);
		leGraphe.addSommet(g);
		leGraphe.addSommet(t);

		Aetoiles(leGraphe);
	}

	public static void Aetoiles(Graphe g) {
		Sommet ref = g.first;
		Sommet newRef = g.first;
		int min = 999999;
		ArrayList<Sommet> sommetSuiv = g.sommets;

		//while (ref != g.last) {
		while (sommetSuiv.size() > 0) {

			System.out.println("___" + ref.name + "___");


			for (Sommet currents : sommetSuiv) {
				if (currents.fEtoile() <= min) {
					if (currents != ref) {
						min = currents.fEtoile();
						newRef = currents;
					}
				}
			}

			min = 99999;
			sommetSuiv.remove(ref);

			if (ref == g.last) {
				System.out.println(ref.fEtoile());
				System.exit(0);
			}

			ref = newRef;
			for (Sommet currentS : ref.suiv.keySet()) {
				if (!sommetSuiv.contains(currentS)) {
					sommetSuiv.add(currentS);
				}
			}

		}
	}
}
