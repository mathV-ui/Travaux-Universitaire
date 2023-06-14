import java.util.ArrayList;
import ardoise.*;

public class Chapeau extends Forme {
    private PointPlan point1;
    private PointPlan point2;
    private PointPlan point3;
	
    public Chapeau(Segment segment1, Segment segment2) {
        super("Chapeau");
        this.point1 = segment1.getPointDepart();
        this.point2 = segment1.getPointArrivee();
        this.point3 = segment2.getPointArrivee();
    }

    @Override
    public void deplacer(int deplacementX, int deplacementY) {
        try {
            point1.deplacer(deplacementX, deplacementY);
            point2.deplacer(deplacementX, deplacementY);
            point3.deplacer(deplacementX, deplacementY);
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors du déplacement du chapeau.");
        }
    }

    @Override
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segments = new ArrayList<>();
        try {
            segments.add(new Segment(point1, point2));
            segments.add(new Segment(point2, point3));
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création des segments du chapeau.");
        }
        return segments;
    }

    @Override
    public String typeForme() {
        return "C";
    }
    public PointPlan getPoint1() {
        return this.point1;
    }

    public void setPoint1(PointPlan point1) {
        this.point1 = point1;
    }

    public PointPlan getPoint2() {
        return this.point2;
    }

    public void setPoint2(PointPlan point2) {
        this.point2 = point2;
    }

    public PointPlan getPoint3() {
        return this.point3;
    }

    public void setPoint3(PointPlan point3) {
        this.point3 = point3;
    }
}