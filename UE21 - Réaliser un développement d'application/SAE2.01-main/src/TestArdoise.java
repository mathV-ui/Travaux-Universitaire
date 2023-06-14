/**
 * Comment intégrer la librairie ardoise.jar dans votre projet Eclipse
 *
 * 1/ Créer un dossier "libs" dans votre projet Eclipse
 * Clic droit sur votre projet -> New -> Folder
 *
 * 2/ Copier ardoise.jar dans le dossier "libs"
 *
 * 3/ Déclarer ardoise.jar comme librairie externe pour votre projet
 * Clic droit sur ardoise.jar (dossier "libs") -> Build Path -> Add to Build Path
 */

/**
 * Importation des classes :
 * - PointPlan
 * - Segment
 * - Ardoise
 * qui sont fournis dans la librairie ardoise.jar
 */
import java.util.ArrayList;
import ardoise.*;

/**
 * Classe TestArdoise
 * Validation de l'intégration de la librairie ardoise.jar au projet Eclipse
 */
public class TestArdoise {
    
	public static void main(String[] args) {
		ThreadA ardoise=new ThreadA();
		ardoise.start();

	}
	static class ThreadA extends Thread{
			@Override
			public void run() {
	        Ardoise ardoise = new Ardoise();

			/*tour*/
			Segment s1= new Segment(new PointPlan(9,100),new PointPlan(20,100));
			Segment s2= new Segment(new PointPlan(20,100),new PointPlan(20,198));
			Segment s3= new Segment(new PointPlan(20,198),new PointPlan(9,198));
			Segment s4= new Segment(new PointPlan(9,198),new PointPlan(9,100));
			Quadrilatere Tour=new Quadrilatere(s1,s2,s3,s4);
			Tour.setNomForme("Tour");
			/*fin tour*/
			
			/*oiseau*/
			Segment s5 = new Segment(new PointPlan(118,13),new PointPlan(123,20));
			Segment s6 =  new Segment(new PointPlan(123,20),new PointPlan(128,13));
			
			Chapeau Oiseau1=new Chapeau(s5,s6);
			Oiseau1.setNomForme("oiseau1");
			
			Segment s7= new Segment(new PointPlan(133,30),new PointPlan(136,32));
			Segment s8= new Segment(new PointPlan(136,32),new PointPlan(138,30));
	
			Chapeau Oiseau2=new Chapeau(s7,s8);
			Oiseau1.setNomForme("oiseau2");
			
			Segment s9= new Segment(new PointPlan(142,14),new PointPlan(144,17));
			Segment s10= new Segment(new PointPlan(144,17),new PointPlan(146,14));
			
			Chapeau Oiseau3=new Chapeau(s9,s10);
			Oiseau1.setNomForme("oiseau3");
			/*fin oiseau*/
			
			/*montagne*/
			Segment s11 = new Segment(new PointPlan(3,14),new PointPlan(43,3));
			Segment s12 = new Segment(new PointPlan(43,3),new PointPlan(112,14));
			Segment s13 = new Segment(new PointPlan(112,14),new PointPlan(3,14));
			Triangle montagne1=new Triangle(s11,s12,s13);
			
			montagne1.setNomForme("Montagne 1");
			
			Segment s14= new Segment(new PointPlan(152,7),new PointPlan(166,3));
			Segment s15= new Segment(new PointPlan(166,3),new PointPlan(172,7));
			Segment s16= new Segment(new PointPlan(172,7),new PointPlan(152,7));
			
			Triangle montagne2=new Triangle(s14,s15,s16);
			montagne2.setNomForme("Montagne 2");
			/*fin montange*/
			
			/*étoile */
			Segment s17= new Segment(new PointPlan(170,52),new PointPlan(173,45));
			Segment s18= new Segment(new PointPlan(173,45),new PointPlan(177,52));
	
			Chapeau branche1=new Chapeau(s17,s18);
			
			Segment s19= new Segment(new PointPlan(177,52),new PointPlan(184,57));
			Segment s20= new Segment(new PointPlan(184,57),new PointPlan(177,60));
	
			Chapeau branche2=new Chapeau(s19,s20);
			
			Segment s21= new Segment(new PointPlan(177,60),new PointPlan(174,66));
			Segment s22= new Segment(new PointPlan(174,66),new PointPlan(170,60));
			
			Chapeau branche3=new Chapeau(s21,s22);
			
			Segment s23= new Segment(new PointPlan(170,60),new PointPlan(164,57));
			Segment s24= new Segment(new PointPlan(164,57),new PointPlan(170,52));
			
			Chapeau branche4=new Chapeau(s23,s24);
			/*fin étoile */
			
			ArrayList<Forme> A=new ArrayList<Forme>();
			A.add(branche1);
			A.add(branche2);
			A.add(branche3);
			A.add(branche4);
			GF etoile=new GF(A);
			
			/* maison*/
			Segment s25= new Segment(new PointPlan(80,140),new PointPlan(180,140));
			Segment s26= new Segment(new PointPlan(180,140),new PointPlan(180,198));
			Segment s27= new Segment(new PointPlan(180,198),new PointPlan(80,198));
			Segment s28= new Segment(new PointPlan(80,198),new PointPlan(80,140));
			
			Quadrilatere Corps_maison=new Quadrilatere(s25,s26,s27,s28);
			
			Segment s29= new Segment(new PointPlan(120,170),new PointPlan(140,170));
			Segment s30= new Segment(new PointPlan(140,170),new PointPlan(140,198));
			Segment s31= new Segment(new PointPlan(140,198),new PointPlan(120,198));
			Segment s32= new Segment(new PointPlan(120,198),new PointPlan(120,170));
			
			Quadrilatere porte_maison=new Quadrilatere(s29,s30,s31,s32);
			
			Segment s33= new Segment(new PointPlan(80,140),new PointPlan(130,100));
			Segment s34= new Segment(new PointPlan(130,100),new PointPlan(180,140));
	
			Chapeau Toit_maison=new Chapeau(s33,s34);
			/*fin maison*/
			
			ArrayList<Forme> B=new ArrayList<Forme>();
			B.add(porte_maison);
			B.add(Toit_maison);
			B.add(Corps_maison);
			GF maison=new GF(B);
			
			ardoise.ajouterForme(Tour);
			ardoise.ajouterForme(Oiseau1);
			ardoise.ajouterForme(Oiseau2);
			ardoise.ajouterForme(Oiseau3);
			ardoise.ajouterForme(montagne1);
			ardoise.ajouterForme(montagne2);
			ardoise.ajouterForme(etoile);
			ardoise.ajouterForme(maison);
			
			
			assert Tour.tailleQuad(Tour) == true : "La méthode tailleQuad() ne fonctionne pas correctement.";
			
			Quadrilatere formeInvalide = new Quadrilatere(null, null, null, null);
			
			assert formeInvalide.dessiner().isEmpty() == true : "La méthode dessiner() ne gère pas correctement les formes invalides.";
			
			Tour.deplacer(10, 20);
			
			Quadrilatere formeInvalide2 = new Quadrilatere(null, null, null, null);
			
			formeInvalide2.deplacer(10, 20);
			
			
			ardoise.ajouterForme(Tour);
			
		        ardoise.dessinerGraphique();
	        
		        assert Tour.equals(Tour) : "La méthode equals() ne fonctionne pas correctement.";
	        	assert !Tour.equals(null) : "La méthode equals() ne gère pas correctement le cas de null.";
	
		        assert !Tour.equals(Oiseau1) : "La méthode equals() ne fonctionne pas correctement.";
		        assert !Oiseau1.equals(Tour) : "La méthode equals() ne fonctionne pas correctement.";

	        	assert Tour.equals(Tour) : "La méthode equals() ne fonctionne pas correctement.";
	        	assert !Tour.equals(null) : "La méthode equals() ne gère pas correctement le cas de null.";

	        	assert !Tour.equals(Oiseau1) : "La méthode equals() ne fonctionne pas correctement.";
	       		assert !Oiseau1.equals(Tour) : "La méthode equals() ne fonctionne pas correctement.";

	        	assert Tour.equals(Tour) : "La méthode equals() ne fonctionne pas correctement.";
	       		assert !Tour.equals(null) : "La méthode equals() ne gère pas correctement le cas de null.";

			assert !Tour.equals(Oiseau1) : "La méthode equals() ne fonctionne pas correctement.";
	        	assert !Oiseau1.equals(Tour) : "La méthode equals() ne fonctionne pas correctement.";

	        	assert !Tour.equals(formeInvalide) : "La méthode equals() ne fonctionne pas correctement avec une forme invalide.";
	        	assert !formeInvalide.equals(Tour) : "La méthode equals() ne fonctionne pas correctement avec une forme invalide.";

	        	assert !Tour.equals(formeInvalide2) : "La méthode equals() ne fonctionne pas correctement avec une forme invalide.";
	        	assert !formeInvalide2.equals(Tour) : "La méthode equals() ne fonctionne pas correctement avec une forme invalide.";

			assert !Tour.equals(Oiseau1) : "La méthode equals() ne fonctionne pas correctement.";
	        	assert !Oiseau1.equals(Tour) : "La méthode equals() ne fonctionne pas correctement.";

	        	assert !Tour.equals(Oiseau1) : "La méthode equals() ne fonctionne pas correctement.";
	        	assert !Oiseau1.equals(Tour) : "La méthode equals() ne fonctionne pas correctement.";

	       
	        
			try {
				
				ardoise.dessinerGraphique();
				sleep(3000);
				
				ardoise.deplacer(Oiseau1.typeForme(), 10, 20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}
}
