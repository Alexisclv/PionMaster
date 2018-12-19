/**
 * classe qui permet de définir le joueur
 */
import java.util.Scanner;

public class Player {
	Scanner ordonnee = new Scanner(System.in);
	Scanner abscisse = new Scanner(System.in);
	
	private int id;
	
	public Player(int id) {
		
		this.id=id;
	}
	
	public int getId() {
		
		return this.id;
	}
	
	//
	public int choixAbscisse(int id) {
		System.out.println("Joueur "+id+", rentrer les coordonnées de votre pion : ");
		System.out.print("Abscisse : ");
		int x = abscisse.nextInt();
		abscisse.nextLine();

		return x;
	}
	
	public int choixOrdonnee(int id) {
		System.out.print("Ordonnée : ");
		int y = ordonnee.nextInt();
		ordonnee.nextLine();
	
		return y;
	}

}
