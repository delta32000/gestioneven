/*
 * Tests des m\u00e9thodes de la classe OutilInterface
 * TestOutilInterface.java                                      21/01/14
 */
package info1.gestioneven;

import java.util.Scanner;
import info1.gestioneven.GestionInterface;

/**
 * Cette classe permet de tester les m\u00e9thodes de la classe OutilInterface
 * @author INFO1
 * @version 1.0
 */
public class TestGestionInterface {

   
    /**
     * Object scanner pour les op\u00e9rations d'entr\u00e9e
     */
    private static Scanner entree = new Scanner(System.in);
    
    /**
     * Nombre de r\u00e9p\u00e9tition de chacun des tests
     */
    private static int NB_TEST = 3;
    
    
    
    /********************   2 m\u00e9thodes outils pour g\u00e9rer les tests   ******************/
    
    
    /**
     * Demande \u00e0 l'utilisateur d'appuyer sur entr\u00e9e pour continuer
     */
    private static void continuer() {
        System.out.println("\n\n\nAppuyer sur entr\u00e9e pour continuer les tests.") ;
        entree.nextLine();
        System.out.println("\n\n");
    }
    
    
    /**
     * Affiche le r\u00e9sultat d'un test : le nombre de tests r\u00e9ussis et le 
     * nombre de tests total
     * @param nbTestTotal       nombre total de tests effectu\u00e9s
     * @param nbTestOk          nombre de tests r\u00e9ussis
     */
    private static void afficherResultatTest(int nbTestTotal, int nbTestOk) {
        System.out.println(nbTestOk + " test(s) ont r\u00e9ussi sur un total de "
                + nbTestTotal + " tests r\u00e9alis\u00e9s.\n   ==>  "
                + ((nbTestOk == nbTestTotal) ?
                        "Tous les tests sont OK" 
                        : "Au moins un test a \u00e9chou\u00e9.") + "\n");
    }
    

    /*****************************  m\u00e9thodes de test   *******************************/
    
    
    
    /** 
     * Test de la m\u00e9thode afficherAide qui affiche l'aide en ligne (test visuel)
     */
    public static void testAfficherAide() {
        System.out.println ("TEST : m\u00e9thode afficherAide (test visuel)\n"
                + "-----------------------------------------\n");
        GestionInterface.afficherAide();
        continuer();
    }
    

    /** 
     * Test de la m\u00e9thode afficherMenu qui affiche le menu (test visuel)
     */
    public static void testAfficherMenu() {
        System.out.println ("TEST : m\u00e9thode afficherMenu (test visuel)\n"
                + "------------------------------------------\n");
        GestionInterface.afficherMenu();
        continuer();
    }
    
    
    /** 
     * Test de la m\u00e9thode reponseValide  (test automatique)
     */
    public static void testReponseValide() {
        System.out.println ("TEST : m\u00e9thode reponseValide (test automatique)\n"
                            + "-----------------------------------------------");
        
        // listes des options valides
        final char[] OPTION = { 'a', 't', 'c', 'm', 'e', 's', '?', 'q'};
        final char[] OPTION_MAJ = { 'A', 'T', 'C', 'M', 'E', 'S', '?', 'Q'};
        final String[] OPTION_INCORRECT = {"b",  "B", "h",  "H", "", "Ajouter", "A A",
                                           " a", "help", "t+"};
        int nbTestCorrect;
        
        // Etape 1 : test avec des valeurs correctes
        System.out.println("========> Etape 1/2 - Tests avec des valeurs correctes \n");
        nbTestCorrect = 0;
        for(int i = 0; i < OPTION.length; i++) {
            if (! GestionInterface.reponseValide(OPTION[i] + "")) {
                System.out.println("Erreur - L'option " + OPTION[i] 
                                   + " a \u00e9t\u00e9 consid\u00e9r\u00e9e comme invalide.");
            } else {
                nbTestCorrect++;
            }
            if (! GestionInterface.reponseValide(OPTION_MAJ[i] + "")) {
                System.out.println("Erreur - L'option " + OPTION_MAJ[i] 
                                   + " a \u00e9t\u00e9 consid\u00e9r\u00e9e comme invalide.");
            } else {
                nbTestCorrect++;
            }
        }
        afficherResultatTest(OPTION.length * 2, nbTestCorrect);
        
            
        // Etape 2 : test avec des valeurs incorrectes
        System.out.println("\n========> Etape 2/2 - Tests avec des valeurs incorrectes \n");
        nbTestCorrect = 0;
        for(int i = 0; i < OPTION_INCORRECT.length; i++) {
            if ( GestionInterface.reponseValide(OPTION_INCORRECT[i])) {
                System.out.println("Erreur - L'option " + OPTION_INCORRECT[i] 
                                   + " a \u00e9t\u00e9 consid\u00e9r\u00e9e comme valide.");
            } else {
                nbTestCorrect++;
            }            
        }
        afficherResultatTest( OPTION_INCORRECT.length, nbTestCorrect);        
        continuer();    
    }
    
    
    /**
     * Test de la m\u00e9thode saisirOptionMenu (test interactif)
     */
    public static void testSaisirOptionMenu() {
        char option;        // option saisie pour le menu
        
        System.out.println ("TEST : m\u00e9thode saisirOptionMenu (test interactif "
                            + "recommenc\u00e9 " + NB_TEST + " fois)\n----------------"
                            + "---------------------------------------------------");
        for (int i = 1; i <= NB_TEST; i++) {
            System.out.println("TEST NUMERO " + i + "\n");
            option = GestionInterface.saisirOptionMenu();  
            System.out.println("\n\nPOUR LE TEST NUMERO " + i 
                               + " C'EST L'OPTION " + option
                               + " QUI A ETE CHOISIE.\n\n");
        }
    }
    
    
    
    
    /**
     * Programme principal. Point d'entr\u00e9e pour lancer les tests
     * @param args  argument non utilis\u00e9
     */
    public static void main(String[] args) {
        System.out.println("TESTS UNITAIRES DE LA CLASSE GestionInterface\n\n");
        
        // test de la m\u00e9thode afficherAide
        testAfficherAide();
       
        // test de la m\u00e9thode afficherMenu
        testAfficherMenu();
        
        // test de la m\u00e9thode reponseValide
        testReponseValide();
               
        // test de la m\u00e9thode saisirOptionMenu
        testSaisirOptionMenu();
        
        System.out.println("FIN DES TESTS DE LA CLASSE GestionInterface");
    }
}
