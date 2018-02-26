/*
 * Classe de tests des m\u00e9thodes de la classe GestionEvenement
 * TestGestionUnEvenement.java                                                  01/18
 */
package info1.gestioneven;

import java.util.Scanner;
import info1.gestioneven.GestionUnEvenement;

public class TestGestionUnEvenement {
    
    /**  Object scanner pour les op\u00e9rations d'entr\u00e9e */
    private static Scanner entree = new Scanner(System.in);
    
    /**
     * Nombre de r\u00e9p\u00e9titions des tests qui doivent \u00eatre recommenc\u00e9s plusieurs fois
     */
    private static final int NB_TEST = 3;
    
    /**  jeu de tests  : tableau de dates    */
    private static final int[][] DATES = { {1, 1}, {21, 6}, {21, 6}, {15, 8}, 
                                           {16,8}, {16,8},  {20, 8}, {25, 12}};
    
    /** jeu de tests : tableau des libell\u00e9s associ\u00e9s aux dates */
    private static final String[] LIBELLES = { "Jour de l'an", "F\u00eate de la musique", 
                                               "Anniversaire Arth\u00e9mis",
                                               "Jour f\u00e9ri\u00e9, 15 Ao\u00fbt", "F\u00eate de Monvillage", 
                                               "Anniversaire de Marie", 
                                               "Salon du livre et des libraires", 
                                               "Jour de No\u00ebl" }; 
    
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
    

    
    /****************   m\u00e9thodes de test de la classe GestionUnEvenement   ***************/
    
    
    /**
     * Test de la m\u00e9thode evenementEnLettres
     */
    public static void testEvenementEnLettres() {       
        System.out.println("TEST : m\u00e9thode evenementEnLettres "
                + " (affichage de quelques exemples, test visuel)\n--------------"
                + "-----------------------------------------------------------\n"); 
        
        // les \u00e9v\u00e9nements du jeu de test sont affich\u00e9s un \u00e0 un
        for (int i = 0; i < DATES.length; i++) {
            System.out.println(GestionUnEvenement.evenementEnLettres(DATES[i], LIBELLES[i]));
        }        
        continuer();
    }
    
    
    /**
     * Test de la m\u00e9thode afficherEvenement
     */
    public static void testAfficherEvenement() {       
        System.out.println("TEST : m\u00e9thode afficherEvenement "
                + " (affichage de quelques exemples, test visuel)\n-----------"
                + "------------------------------------------------------------\n"); 
        
        // les \u00e9v\u00e9nements du jeu de test sont affich\u00e9s un \u00e0 un
        for (int i = 0; i < DATES.length; i++) {
            GestionUnEvenement.afficherEvenement(DATES[i], LIBELLES[i]);
        }        
        continuer();
    }
    
    
    /**
     * Test de la m\u00e9thode saisirLibelle
     */
    public static void testSaisirLibelleValide() {
        String libelle;             // libell\u00e9 saisi
        System.out.println("TEST : m\u00e9thode saisirLibelleValide (test interactif et "
                           + "recommenc\u00e9 " + NB_TEST + " fois).\n-------------------"
                           + "-----------------------------------------------------\n"
                           + "\nPour bien tester, il faut penser \u00e0 saisir des libell\u00e9s" 
                           + " vides ou trop longs\n");
        
        /*
         * on appelle plusieurs fois la m\u00e9thode saisirLibelleValide et on affiche
         * le libell\u00e9 saisi pour v\u00e9rification
         */        
        for(int i = 1; i <= NB_TEST; i++) {
            libelle = GestionUnEvenement.saisirLibelleValide();
            System.out.println("\n\n     ==> Vous avez saisi : " + libelle + "\n\n");
        }        
        continuer();
    } 
    
    
    /**
     * Test de la m\u00e9thode saisirEvenement
     */
    public static void testSaisirEvenement() {
        String libelle;                 // libelle d'un \u00e9v\u00e9nement saisi
        int[] date = new int[2];        // date d'un \u00e9v\u00e9nement saisi
               
        System.out.println ("TEST : m\u00e9thode saisirEvenement (test interactif "
                            + "recommenc\u00e9 " + NB_TEST + " fois).\n------------------"
                            + "---------------------------------");
        
        /*
         * On recommence plusieurs fois : saisie d'un \u00e9v\u00e9nement complet (sa 
         * date et son libell\u00e9), puis affichage pour v\u00e9rification 
         */
        for (int i = 1; i <= NB_TEST; i++) {
            libelle = GestionUnEvenement.saisirEvenement(date);
            System.out.println("\nEvenement saisi = " 
                               + GestionUnEvenement.evenementEnLettres(date, libelle)
                               +"\n");
        }
        continuer();
    }
    
    
    
    /**
     * Programme principal : point d'entr\u00e9e du programme de test
     * @param args argument non utilis\u00e9
     */
    public static void main(String[] args) {
               
        System.out.println("TESTS UNITAIRES DE LA CLASSE GestionUnEvenement\n\n");
        
        
        // test de la m\u00e9thode evenementEnLettres
        testEvenementEnLettres();
        
        // test de la m\u00e9thode afficherEvenement
        testAfficherEvenement();
                
        // test de la m\u00e9thode saisirLibelleValide
        testSaisirLibelleValide();
        
        // test de la m\u00e9thode saisirEvenement
        testSaisirEvenement();
        
        System.out.println("FIN DES TESTS DE LA CLASSE GestionUnEvenement");
                      
    }
        

}
