/*
 * Application gestion des événements : programme principal               02/18
 * ApplicationGestionEvenement.java
 */

package info1.gestioneven;
import java.util.Scanner;

import info1.gestioneven.GestionUnEvenement;
import info1.gestioneven.OutilDate;
import info1.gestioneven.GestionInterface;

/**
 * Classe principale de l'application gestion des événements. Elle contient
 * la fonction main. Un menu est proposé à l'utilisateur avec toutes les opérations
 * possibles.  Au démarrage, les événements sauvergardés lors de la dernière utilisation
 * de l'application sont restaurés. Lorsque l'application s'arrête les événements sont 
 * enregistrés dans un fichier pour une restauration future.
 * @author INFO1
 * @version 1.0
 *
 */
public class ApplicationGestionEvenement {
    
    /** Message affiché si aucun événement n'est trouvé, lors d'une consultation */
    private static final String AUCUN_EVENEMENT = "Aucun événement ne corrrespond "
            + " à ce critère de recherche";
    
   
    
    /**
     * Méthode qui gère l'ajout d'un événement à l'ensemble de ceux gérés
     * Un événement est saisi au clavier et ajouté s'il est valide.
     * @param lesDates     tableau contenant les dates des événements
     * @param lesLibelles  tableau contenant les libellés des événements
     */
    private static void ajouterEven(int[][] lesDates, String[] lesLibelles) {
        String nouveauLibelle;          // libellé saisi par l'utilisateur
        int[] nouvelleDate;           // date saisie pas l'utilisateur
        nouvelleDate = new int[2];
        
        if (lesLibelles[lesLibelles.length] == null) {
            // cas particulier : le tableau est plein
            System.out.println("Impossible d'ajouter un événement. Le nombre maximum d'événements "
                               + " gérés par l'application est atteint.\n"
                               + "(suggestion : supprimer les événements qui ne sont plus utiles)\n");
        } else {
            
            // saisie du libellé et de la date de l'événement
            nouveauLibelle = GestionUnEvenement.saisirEvenement(nouvelleDate);
            if (GestionEvenement.ajouterEvenement(lesDates, lesLibelles,
                                                  nouvelleDate, nouveauLibelle)) {
                System.out.println("L'événement a bien été ajouté.\n");
            } else {
                System.out.println("L'événement n'a pas été ajouté, car il existe déjà un "
                                   + " événement avec le même libellé.\n");
            }
        }
    }
    
    
    /**
     * Méthode qui gère l'affichage de tous les évélements
     * @param lesDates     tableau contenant les dates des événements
     * @param lesLibelles  tableau contenant les libellés des événements
     */
    private static void voirTousEven(int[][] lesDates, String[] lesLibelles) {
        System.out.println("L'ensemble des événements gérés par l'application est : "
                           + "-------------------------------------------------------\n");
        if (lesLibelles[0] == null) {
            System.out.println("Aucun événement pour l'instant.");
        } else {
            System.out.println(GestionEvenement.consulterEvenement(lesDates, lesLibelles));
        }
    }
    
    /**
     * Méthode qui gère l'affichage de tous les évélements situés dans un mois précis.
     * Le mois de la recherche est demandé à l'utilisateur et saisi dans la méthode.
     * @param lesDates     tableau contenant les dates des événements
     * @param lesLibelles  tableau contenant les libellés des événements
     */
    private static void voirEvenMoisPrecis(int[][] lesDates, String[] lesLibelles) {
		Scanner clavier = new Scanner(System.in);
		
		int mois;
		
		boolean trouve;
		
		trouve = false;
		mois = -1;
		
		/* On demande à l'utilisateur de rentrer le mois qu'il veut*/ 
		while (mois < 1 || 12 < mois) {
			System.out.print("Entrez un mois entre 1 et 12 : ");
			if (!clavier.hasNextInt()) {
				System.out.println("Vous devez entrée un entier positif entre 1 et 12");
			} else {
				mois = clavier.nextInt();
			}
			clavier.nextLine();
		}
		
		/* parcourir le tableau et recherche le mois */
		for(int i = 0 ; i < lesDates.length; i++){
		/* affiche tous les évènements du mois choisi */
			if ( lesDates[i][1] == mois ){
				GestionUnEvenement.afficherEvenement(lesDates[i], lesLibelles[i]);
				trouve = true;
			}
		}
		if ( trouve == false ){
			System.out.println("Aucune correspondance trouvé");
		}
	}
    
    
    /**
     * Méthode qui gère l'affichage de tous les évélements situés à partir de la 
     * date courante
     * @param lesDates     tableau contenant les dates des événements
     * @param lesLibelles  tableau contenant les libellés des événements
     */
    private static void voirEvenAPartirDateCourant(int[][] lesDates, String[] lesLibelles) {
        
		int[] jourMoisDep = new int[2];
		jourMoisDep = OutilDate.jourMoisCourant();
		System.out.printf("Nous sommes le %d/%d\n", jourMoisDep[0], jourMoisDep[1]);
    
		for (int i = 0 ; i < lesDates.length ; i++) {
			if (lesDates[i][1] > jourMoisDep[1] ) {
				GestionUnEvenement.afficherEvenement(lesDates[i], lesLibelles[i]);
			} else if (lesDates[i][1] > jourMoisDep[1] && jourMoisDep[0] >= lesDates[i][0]){
				GestionUnEvenement.afficherEvenement(lesDates[i], lesLibelles[i]);
			}
		}
    }
    
    /*
     * TODO : écrire d'autres méthodes sur le modèle des précédentes.
     * Il s'agit d'écrire une méthode pour chacune des options du menu.
     */
	 
	/**
	 * réaliser les opérations a partir de l'entrer par l'utilisateur.
	 * @param 
	 *
	 */
	 
    private static void operationARealiser(int[][] lesDates, String[] lesLibelles) {
		/*  l'option choisie par l'utilisateur */
		final char OPERATION_USER = GestionInterface.saisirOptionMenu();
		
		switch (OPERATION_USER) {
			case 'A': 
				System.out.println(OPERATION_USER);
				break;
			case 'T': 
				System.out.println(OPERATION_USER);
				break;
			case 'C': 
				voirEvenAPartirDateCourant(lesDates, lesLibelles);
				break;
			case 'M': 
				voirEvenMoisPrecis(lesDates, lesLibelles);
				break;
			case 'E': 
				System.out.println(OPERATION_USER);
				break;
			case 'S': 
				System.out.println(OPERATION_USER);
				break;
			case '?': 
				System.out.println(OPERATION_USER);
				break;
			case 'Q': 
				System.out.println(OPERATION_USER);
				break;
			default: 
				System.out.println("ERREUR");
		}
	}
    
    
    /**
     * Point d'entrée de l'application principale.
     * Un menu est proposé à l'utilisateur et l'opération qu'il demande est ensuite
     * réalisée. Le menu est proposé jusqu'à ce que l'utilisateur choisisse de quitter
     * l'application.
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {
		
		
        int[][] toutesLesDates = { {1,2},{11,5},{22,5},{1,2} };     // tableau contenant les dates des événements gérés
        String[] tousLesLibelles = {"Le test de la vie" , "Ta palourde", "Ton huite", "test"};   // tableau contenant les libellés des événements gérés
		
		
//		voirEvenMoisPrecis( toutesLesDates, tousLesLibelles );
		
//		voirEvenAPartirDateCourant(toutesLesDates, tousLesLibelles);
		
		operationARealiser(toutesLesDates, tousLesLibelles);
		
		
        /* TODO : réaliser ici
         *   - la restauration des événements précédemment sauvegardés
         *   - d'autres opérations
         *   - une boucle contenant un switch pour réaliser les opérations
         *      demandées par l'utilisateur. Dans chacune des branches du switch,
         *      on appelera l'une des méthodes définies dans cette classe
         *      (voir avant la fonction main)
         *   - sauvegarde des événements en mémoire permanente
         */
         
		
    }

}
