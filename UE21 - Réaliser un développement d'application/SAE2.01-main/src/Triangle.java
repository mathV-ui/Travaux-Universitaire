import java.util.ArrayList;
import ardoise.*;

public class Triangle extends Forme {

	 private Segment segment1;
	    private Segment segment2;
	    private Segment segment3;

	    public Triangle( Segment segment1, Segment segment2, Segment segment3) {
	        this.segment1 = segment1;
	        this.segment2 = segment2;
	        this.segment3 = segment3;
	    }

    @Override
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segments = new ArrayList<>();
        try {
            segments.add(segment1);
            segments.add(segment2);
            segments.add(segment3);
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création de la liste de segments du triangle.");
        }
        return segments;
    }

    @Override
    public String typeForme() {
        return "T";
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
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors du déplacement du triangle.");
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
}
