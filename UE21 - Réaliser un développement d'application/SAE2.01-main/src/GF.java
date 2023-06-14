import java.util.ArrayList;

import ardoise.*;

public class GF extends Forme {
	
	private ArrayList<Forme> formes;
	
	public GF(ArrayList<Forme> formes) {
		this.formes = formes;
	}
	
	@Override
	public void deplacer(int deplacementX, int deplacementY) {
		for (Forme forme : formes) {
			try {
				forme.deplacer(deplacementX, deplacementY);
			} catch (Exception e) {
				System.out.println("Une erreur s'est produite lors du déplacement d'une forme : " + e.getMessage());
			}
		}
	}

	@Override
	public ArrayList<Segment> dessiner() {
		ArrayList<Segment> segments = new ArrayList<>();
		for (Forme forme : formes) {
			try {
				segments.addAll(forme.dessiner());
			} catch (Exception e) {
				System.out.println("Une erreur s'est produite lors du dessin d'une forme : " + e.getMessage());
			}
		}
		return segments;
	}

	@Override
	public String typeForme() {
		return "GF";
	}

}