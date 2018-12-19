/**Ce programme permet de jouer à un jeu de pion.
 * Il y a la possibilité de jouer sur un damier 2d ou 3d.
 * 
 */

import java.util.Scanner;

public class Partie {

	public static void main(String[] args) {
		int nbTours = 1, deep = 0, row = 0, column = 0, dim = 0;
		
		//Selectionne les parametres necessaires au jeu
		System.out.println("Appuyer sur entrée pour commencer la partie");
		Scanner entree = new Scanner (System.in);
		
		do {
		System.out.print("Dimension de votre jeu ( 2 ou 3) : ");
		dim = entree.nextInt();
		entree.nextLine();
		}while(dim != 2 && dim != 3 );
		
		do {
		System.out.print("Le nombre de colonnne du plateau: ");
		column = entree.nextInt();
		entree.nextLine();
		}while( column < 0 );
		
		do {
		System.out.print("Le nombre de ligne du plateau: ");
		row = entree.nextInt();
		entree.nextLine();
		}while ( row < 0 );
		
		
		if (dim == 3) {
			System.out.print("La profondeur du plateau à 3 dimensions: ");
			deep = entree.nextInt();
			entree.nextLine();	
		}
	// Fin de la selection des paramètres du jeu
		
		System.out.println();
		
		Modal dam = new Modal(dim,row,column,deep);// Creation du damier en fonction de la saisie de l'utilisateur
		
		Player player1= new Player(1);
		Player player2= new Player(2);
		
		dam.afficheTab(row,column,deep);// Affiche le damier dans son etat initial
		System.out.println();

		//Temps qu'il y a pas victoire et que le damier n'est pas rempli les joueur peuvent poser des pions
		while((dam.isColinear()==false)&&(nbTours<row*column+1))
		{
			if ( (nbTours %2 == 1)) {// défini le tour en fonction du tour pair ou impair.
				int abscissej1, ordonneej1 = 0;
				do {
				abscissej1 = player1.choixAbscisse(player1.getId());//Appel la methode permetant au joueur de choisir l'abscisse de son pion
				ordonneej1 = player1.choixOrdonnee(player1.getId());//Appel la methode permetant au joueur de choisir l'ordonnee de son pion
				
				}while( abscissej1 > column || ordonneej1 > column || abscissej1 < 0 || ordonneej1 < 0 );// Vérifie que l'utilisateur rentre une valeur comprise dans le damier
				
				dam.placePion(player1.getId(), abscissej1-1, ordonneej1-1, 0);//Place le pion dans le damier en metant l'id du joueur dans l'emplacement
				
				dam.afficheTab(row,column,deep);
				
			}else {
				int abscissej2, ordonneej2 = 0;	
				do {
					
				abscissej2 = player2.choixAbscisse(player2.getId());//Appel la methode qui permet au joueur de choisir son abscisse
				ordonneej2 = player2.choixOrdonnee(player2.getId());//Appel la methode qui permet au joueur de choisir son ordonnee
				
				}while( abscissej2 > column || ordonneej2 > column || abscissej2 < 0 || ordonneej2 < 0 );// Vérifie que l'utilisateur rentre une valeur comprise dans le damier
				
				dam.placePion(player2.getId(), abscissej2-1, ordonneej2-1, 0);//-1 pour des raisons pratiques
				dam.afficheTab(row,column,deep);
			}
			nbTours++;
		}
		System.out.println("Fin de la partie!\nVoici le damier final: ");
		dam.afficheTab(row, column, deep);
		entree.close();
	}

}
