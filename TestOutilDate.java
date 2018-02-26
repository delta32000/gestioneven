/*
 * Tests de la classe OutilDate                           01/18
 * TestOutilDate.java
 */

package info1.gestioneven;
import java.util.Scanner;
import info1.gestioneven.OutilDate;

/**
 * Classe contenant diverses m\u00e9thodes permettant de tester les m\u00e9thodes
 * de la classe OutilDate. Certains tests sont enti\u00e8rement automatis\u00e9s,
 * d'autres n\u00e9cessitent une interaction avec l'utilisateur. Enfin, pour 
 * d'autres tests, le testeur doit v\u00e9rifier visuellement l'exactitude
 * du r\u00e9sultat de la m\u00e9thode.
 * Il s'agit d'une classe de tests unitaires.
 * @author INFO1
 * @version 1.0
 *
 */
public class TestOutilDate {

    /**
     * Nombre de r\u00e9p\u00e9titions des tests qui doivent \u00eatre recommenc\u00e9s plusieurs fois
     */
    private static final int NB_REPETITION_TEST = 2;
    
    /**
     * Object scanner pour les op\u00e9rations d'entr\u00e9e
     */
    private static Scanner entree = new Scanner(System.in);
    
    /**
     * Test de la m\u00e9thode moisCourant, suppos\u00e9e renvoyer le mois courant
     * Le testeur doit v\u00e9rifier de mani\u00e8re visuelle que le r\u00e9sultat de la m\u00e9thode
     * est correct.
     */
    public static void testJourMoisCourant() {
        
        // on consulte la date courante
        int[] dateDuJour = OutilDate.jourMoisCourant(); 
        System.out.println ("TEST : m\u00e9thode jourMoisCourant (test visuel)\n"
                            + "--------------------------------------------");
        
        // on l'affiche \u00e0 l'\u00e9cran pour que l'utilisateur v\u00e9rifie qu'elle est correcte
        System.out.println("La date courante est " + dateDuJour[0] 
                           + "/" + dateDuJour[1] 
                           + "\nAppuyer sur entr\u00e9e pour continuer les tests.") ;
        entree.nextLine();
    }
    
    
    
    /**
     * Test de la m\u00e9thode saisirMois 
     * Le testeur doit interagir avec la m\u00e9thode de test pour v\u00e9rifier
     * que la m\u00e9thode saisirMois est correctement programm\u00e9e.
     */
    public static void testSaisirMois() {
        int moisSaisi;              // mois saisi par l'utilisateur
        System.out.println ("\nTEST : m\u00e9thode saisirMois (test interactif)\n"
                            + NB_REPETITION_TEST + " tests seront effectu\u00e9s \n"
                            + "----------------------------------------------");
        for(int i = 1; i <= NB_REPETITION_TEST; i++) {
            moisSaisi = OutilDate.saisirMois();
            System.out.println("Le mois saisi est " + moisSaisi);
        }       
        System.out.println("\nAppuyer sur entr\u00e9e pour continuer les tests.") ;
        entree.nextLine();
    }
    
    
    /**
     * Test de la m\u00e9thode saisirJour
     * Le testeur doit interagir avec la m\u00e9thode de test pour v\u00e9rifier
     * que la m\u00e9thode saisirJour est correctement programm\u00e9e.
     */
    public static void testSaisirJour() {
        int jourSaisi;              // jour saisi par l'utilsateur
        System.out.println ("\nTEST : m\u00e9thode saisirJour (test interactif)\n"
                            + NB_REPETITION_TEST + " tests seront effectu\u00e9s\n"
                            + "---------------------------------------------");        
        for(int i = 1; i <= NB_REPETITION_TEST; i++) {
            jourSaisi = OutilDate.saisirJour();
            System.out.println("Le jour saisi est " + jourSaisi);
        }
        System.out.println("\nAppuyer sur entr\u00e9e pour continuer les tests.") ;
        entree.nextLine();
    }
    
    
    /**
     * Test de la m\u00e9thode saisirJourMois
     * Le testeur doit interagir avec la m\u00e9thode de test pour v\u00e9rifier
     * que la m\u00e9thode saisirJourMois est correctement programm\u00e9e.
     */
    public static void testSaisirJourMois() {
        int[] dateSaisie;              // date saisie par l'utilisteur        
        System.out.println ("\nTEST : m\u00e9thode saisirJourMois (test interactif)\n"
                            + NB_REPETITION_TEST + " tests seront effectu\u00e9s pour cette m\u00e9thode\n"
                            + "-------------------------------------------------");
        for(int i = 1; i <= NB_REPETITION_TEST; i++) {
            dateSaisie = OutilDate.saisirJourMois();
            System.out.println("La date saisie est " 
                               + OutilDate.jourMoisEnChaine(dateSaisie) ); 
        }       
        System.out.println("\nAppuyer sur entr\u00e9e pour continuer les tests.") ;
        entree.nextLine();
    }
    

    /**
     * Test de la m\u00e9thode estValide
     * Ce test est enti\u00e8rement automatis\u00e9
     */
    public static void testEstValide() {
        /*
         * deux tableaux contenant des dates : le premier contient des dates valides
         * le deuxi\u00e8me des dates invalides
         */
        int[][] dateValide = { {31, 1}, {30, 3}, {31, 7}, {31,8}, {29, 2}, 
                               {3, 6}, {31, 12} };
        int[][] dateInvalide = { {32, 1}, {30, 2}, {31, 2},  {0, 4}, {31, 4}, {31, 9},
                                 {31, 6}, {31,11} };
        int nbTestCorrect = 0;    // nombre de tests corrects
        System.out.println ("\nTEST : m\u00e9thode estValide\n"
                            + "--------------------------\n"
                            + "\n      Etape 1/2  :  Tests avec des dates valides\n");
        
        // premi\u00e8re \u00e9tape : tests avec des  dates valides
        for (int i = 0; i < dateValide.length; i++) {
            if (OutilDate.estValide(dateValide[i])) {
                nbTestCorrect++;
            } else {
                System.out.println("ERREUR la date valide " 
                                   + OutilDate.jourMoisEnChaine(dateValide[i])
                                   + " a \u00e9t\u00e9 d\u00e9tect\u00e9e invalide.");
            }
        }
        
        // affichage r\u00e9sultat global du test        
        System.out.println(nbTestCorrect + " test(s) OK sur un total de " 
                           + dateValide.length + " tests\n\n" 
                           + (nbTestCorrect == dateValide.length ?
                            "Tous les tests avec une date valide sont OK." :
                            "Au moins un test avec une date valide a \u00e9chou\u00e9"));
                 
        
        // deuxi\u00e8me \u00e9tape : tests avec des dates invalides
        System.out.println ("\n      Etape 2/2  :  Tests avec des dates invalides\n");
        nbTestCorrect = 0;
        for (int i = 0; i < dateInvalide.length; i++) {
            if (! OutilDate.estValide(dateInvalide[i])) {
                nbTestCorrect++;
            } else {
                System.out.println("ERREUR la date invalide " 
                                   + OutilDate.jourMoisEnChaine(dateInvalide[i])
                                   + " a \u00e9t\u00e9 d\u00e9tect\u00e9e valide.");
            }
        }
        
        // affichage r\u00e9sultat global du test
        System.out.println(nbTestCorrect + " test(s) OK sur un total de " 
                          + dateInvalide.length + " tests\n\n"
                          + (nbTestCorrect == dateInvalide.length ?
                            "Tous les tests avec une date invalide sont OK." :
                            "Au moins un test avec une date invalide a \u00e9chou\u00e9"));                         
        System.out.println("\nAppuyer sur entr\u00e9e pour continuer les tests.") ;
        entree.nextLine();
    }
    
    
    /**
     *  Test de la m\u00e9thode enLettre
     *  Ce test est enti\u00e8rement automatis\u00e9
     */  
    public static void testEnLettre() {
        final String[] MOIS_EN_LETTRE = { "Janvier", "F\u00e9vrier", "Mars", "Avril", 
                                          "Mai", "Juin", "Juillet", "Ao\u00fbt", 
                                          "Septembre", "Octobre", "Novembre",
                                          "D\u00e9cembre", "erreur"  }; 
        int nbTestCorrect = 0;    // nombre de valeurs correctes
        System.out.println ("\nTEST : m\u00e9thode enLettre\n"
                            + "-------------------------");
        for (int i = 1; i < MOIS_EN_LETTRE.length+1; i++) {
            if (OutilDate.enLettre(i).equals(MOIS_EN_LETTRE[i-1])) {
                nbTestCorrect++;
            } else {
                System.out.println("ERREUR pour le mois " + i + " = " 
                                   + OutilDate.enLettre(i));
            }
        }
        
        // affichage r\u00e9sultat global du test
        System.out.println(nbTestCorrect + " test(s) OK sur un total de " 
                           + MOIS_EN_LETTRE.length + " tests\n");
        if (nbTestCorrect == MOIS_EN_LETTRE.length) {
            System.out.println("Tous les tests de la m\u00e9thode enLettre sont OK");
        } else {
            System.out.println("Au moins un test de la m\u00e9thode enLettre"
                               + " a \u00e9chou\u00e9");
        }
        System.out.println("\nAppuyer sur entr\u00e9e pour continuer les tests.") ;
        entree.nextLine();
    }
    
    
    /**
     *  Test de la m\u00e9thode jourMoisEnChaine
     *  Ce test est enti\u00e8rement automatis\u00e9
     */  
    public static void testJourMoisEnChaine() {
        /* tableau contenant les dates qui serviront de jeu de test */
        int[][] dateValide = { {31, 1}, {30, 3}, {31, 7}, {31,8}, {29, 2}, 
                               {3, 6}, {31, 12} };
        
        /* tableau contenant les r\u00e9sultats attendus */
        String[] resultat = { "31/1", "30/3", "31/7", "31/8", "29/2", "3/6",
                              "31/12" };
              
        int nbTestCorrect = 0;    // nombre de valeurs correctes
        System.out.println ("\nTEST : m\u00e9thode jourMoisEnChaine\n"
                            + "---------------------------------");
        for (int i = 0; i < dateValide.length; i++) {
            if (OutilDate.jourMoisEnChaine(dateValide[i]).equals(resultat[i])) {
                nbTestCorrect++;
            } else {
                System.out.println("ERREUR la date num\u00e9ro " + i 
                                   + " n'est pas correctement affich\u00e9e : "
                                   + OutilDate.jourMoisEnChaine(dateValide[i]));
            }
        }
        
        // affichage r\u00e9sultat global du test
        System.out.println(nbTestCorrect + " test(s) OK sur un total de " 
                           + dateValide.length + " tests\n\n"
                           + (nbTestCorrect == dateValide.length ?
                                   "Tous les tests de la m\u00e9thode jourMoisEnChaine sont OK" 
                                   : "Au moins un test de la m\u00e9thode jourMoisEnChaine"
                                     + " a \u00e9chou\u00e9"));        
        System.out.println("\nAppuyer sur entr\u00e9e pour continuer les tests.") ;
        entree.nextLine();
    }
    
    
    /**
     * Test de la m\u00e9thode sontOrdonnees
     * Ce test est enti\u00e8rement automatis\u00e9
     */
    public static void testSontOrdonnees() {
        /*
         * deux tableaux contenant des dates : la date d'indice i du premier tableau
         * est ant\u00e9rieure \u00e0 celle d'indice i du deuxi\u00e8me tableau
         */
        int[][] dateAvant = { {15, 1}, {30, 3}, {30, 3}, {30, 3}, {14, 6}, {14, 12} };
        int[][] dateApres = { {16, 1}, {31, 3}, {1, 4},  {15, 4}, {17, 9}, {14, 12} };
        int nbTestCorrect;     // nombre de tests corrects
        
        System.out.println ("\nTEST : m\u00e9thode sontOrdonnes\n"
                            + "-----------------------------n" 
                            + "\n      Etape 1/2  :  Tests avec des dates ordonn\u00e9es\n");

        // on v\u00e9rifie l'ordre des dates des 2 tableaux
        nbTestCorrect = 0;
        for (int i = 0; i < dateAvant.length-1; i++) {
            if (OutilDate.sontOrdonnes(dateAvant[i], dateApres[i])) {
                nbTestCorrect++;
            } else {
                System.out.println("Erreur comparaison. La date " 
                                   + OutilDate.jourMoisEnChaine(dateAvant[i]) 
                                   + " a \u00e9t\u00e9 trouv\u00e9e post\u00e9rieure \u00e0 "
                                   + OutilDate.jourMoisEnChaine(dateApres[i]));
            }           
        }
        
        // on affiche le r\u00e9sultat du test de la premi\u00e8re \u00e9tape
        System.out.println(nbTestCorrect + " test(s) OK sur un total de " 
                + (dateAvant.length - 1) + " tests\n\n" 
                + (nbTestCorrect == dateAvant.length - 1 ?
                 "Tous les tests avec des dates ordonn\u00e9es sont OK." :
                 "Au moins un test avec 2 dates ordonn\u00e9es a \u00e9chou\u00e9"));
      
        
        // deuxi\u00e8me \u00e9tape : test avant des dates non ordonn\u00e9es
        System.out.println("\n\n      Etape 2/2  :  Tests avec des dates non ordonn\u00e9es\n");
        nbTestCorrect = 0;     // nombre de tests corrects
        
        /*
         * on v\u00e9rifie en inversant l'ordre des deux dates, et en prenant la
         * n\u00e9gation de la condition
         */
        nbTestCorrect = 0;     // nombre de tests corrects
        for (int i = 0; i < dateAvant.length; i++) {
            if (! OutilDate.sontOrdonnes(dateApres[i], dateAvant[i])) {
                nbTestCorrect++;
            } else {
                System.out.println("Erreur comparaison. La date " 
                                   + OutilDate.jourMoisEnChaine(dateAvant[i]) 
                                   + " a \u00e9t\u00e9 trouv\u00e9e post\u00e9rieure \u00e0 "
                                   + OutilDate.jourMoisEnChaine(dateApres[i]));
            }           
        }
        
        // on affiche le r\u00e9sultat du test de la deuxi\u00e8me \u00e9tape
        System.out.println(nbTestCorrect + " test(s) OK sur un total de " 
                + dateAvant.length + " tests\n\n" 
                + (nbTestCorrect == dateAvant.length ?
                 "Tous les tests avec des dates d\u00e9sordonn\u00e9es sont OK." :
                 "Au moins un test avec 2 dates non ordonn\u00e9es a \u00e9chou\u00e9"));       
        System.out.println("\nAppuyer sur entr\u00e9e pour continuer les tests.") ;
        entree.nextLine();
    }
    
    
    /**
     * Programme principal. Point d'entr\u00e9e pour lancer les tests
     * @param args  argument non utilis\u00e9
     */
    public static void main(String[] args) {
        
        System.out.println("Lancement des tests pour les m\u00e9thodes de la classe"
                           + " OutilDate\n\n");
        // test de la m\u00e9thode moisCourant 
		testJourMoisCourant();
        
        // test des deux m\u00e9thodes saisirJour et saisirMois
		testSaisirJour();
		testSaisirMois();
        
        // test de la m\u00e9thode estValide (validit\u00e9 d'une date)
        testEstValide();
		
        // test de la m\u00e9thode saisirJourMois
        testSaisirJourMois();
        
        // test de la m\u00e9thode enLettre (transforme un mois en chaîne)
        testEnLettre();
        
        // test de la m\u00e9thode jourMoisEnChaine (transforme une date en chaîne)
        testJourMoisEnChaine();
        
        // test de la m\u00e9thode sontOrdonn\u00e9es (ordre de 2 dates)
        testSontOrdonnees();
        
        System.out.println("Fin du programme de tests");
    }
}
