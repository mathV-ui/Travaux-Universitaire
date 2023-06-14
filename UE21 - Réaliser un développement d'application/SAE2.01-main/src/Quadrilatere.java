import java.util.ArrayList;
import ardoise.*;

public class Quadrilatere extends Forme {
    private Segment segment1;
    private Segment segment2;
    private Segment segment3;
    private Segment segment4;

    public Quadrilatere(Segment segment1, Segment segment2, Segment segment3, Segment segment4) {
        this.segment1 = segment1;
        this.segment2 = segment2;
        this.segment3 = segment3;
        this.segment4 = segment4;
    }

        
    @Override
    public void deplacer(int deplacementX, int deplacementY) {
        try {
            segment1.getPointDepart().deplacer(deplacementX, deplacementY);
            segment1.getPointArrivee().deplacer(deplacementX, deplacementY);
            segment2.getPointDepart().deplacer(deplacementX, deplacementY);
            segment2.getPointArrivee().deplacer(deplacementX, deplacementY);
            segment3.getPointDepart().deplacer(deplacementX, deplacementY);
            segment3.getPointArrivee().deplacer(deplacementX, deplacementY);
            segment4.getPointDepart().deplacer(deplacementX, deplacementY);
            segment4.getPointArrivee().deplacer(deplacementX, deplacementY);
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors du déplacement du quadrilatère.");
        }
    }

    @Override
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segments = new ArrayList<>();
        try {
            segments.add(segment1);
            segments.add(segment2);
            segments.add(segment3);
            segments.add(segment4);
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création des segments du quadrilatère.");
        }
        return segments;
	}

	@Override
    public String typeForme() {
        return "Q";
    }

	public boolean tailleQuad(Object v) {
		 try {
	            Segment s1 = ((Quadrilatere) v).getSegment1();
	            Segment s2 = ((Quadrilatere) v).getSegment2();
	            Segment s3 = ((Quadrilatere) v).getSegment3();
	            Segment s4 = ((Quadrilatere) v).getSegment4();

	            if (s1 != s2 && s1 != s3 && s1 != s4)
	                return false;
	            if (s2 != s1 && s2 != s3 && s2 != s4)
	                return false;
	            if (s3 != s2 && s3 != s1 && s3 != s4)
	                return false;
	            return true;
	        } catch (Exception e) {
	            System.out.println("Une erreur s'est produite lors de la vérification de la taille du quadrilatère.");
	            return false;
	        }
	}
	
    public Segment getSegment1() {
        return this.segment1;
    }

    public void setSegment1(Segment segment1) {
        this.segment1 = segment1;
    }

    public Segment getSegment2() {
        return this.segment2;
    }

    public void setSegment2(Segment segment2) {
        this.segment2 = segment2;
    }

    public Segment getSegment3() {
        return this.segment3;
    }

    public void setSegment3(Segment segment3) {
        this.segment3 = segment3;
    }

    public Segment getSegment4() {
        return this.segment4;
    }

    public void setSegment4(Segment segment4) {
        this.segment4 = segment4;
    }
	
}