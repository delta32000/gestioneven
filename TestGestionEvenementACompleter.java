/*
 * Classe de tests des méthodes de la classe GestionEvenement                      01/18
 * TestGestionEvenement.java
 */
package info1.gestioneven;

import java.util.Scanner;

/**
 * Classe de tests des méthodes de la classe GestionEvenement.
 * Les tests sont réparties en ? parties :
 * 
 *    Partie 1 : test des méthodes permettant de créer respectivement le tableau
 *               des libellés et le tableau des dates 
 *               
 *    Partie 2 : test des méthodes privées de la classe GestionEvenement
 *               indiceLibelle, libelleExiste et indicePremierEvenMois
 *               
 *    Partie 3 :  test des méthodes qui consultent des événements dans le but
 *                de les afficher
 *               
 *    Partie 4 :  tests des méthodes ajout et suppression d'un événement
 *    
 * @author INFO1
 * @version 1.0
 */
public class TestGestionEvenementACompleter {
    
   
    /**
     * Object scanner pour les opérations d'entrée
     */
    private static Scanner entree = new Scanner(System.in);
    
     
   
    /**
     *  jeu de tests  : tableau de dates triées chronologiquement    
     */
    private static final int[][] DATES = { {1, 1}, {21, 6}, {21, 6}, {15, 8}, 
                                           {16,8}, {16,8},  {20, 8}, {25, 12}};
    
    /**
     *  jeu de tests : tableau des libellés associés aux dates
     */
    private static final String[] LIBELLES = { "Jour de l'an", "Fête de la musique", 
                                               "Anniversaire Arthémis",
                                               "Jour férié, 15 Août", "Fête de Monvillage", 
                                               "Anniversaire de Marie", 
                                               "Salon du livre et des libraires", 
                                               "Jour de Noël" }; 
    
   
    /* ------------------------------------------------------------------------------- 
     * |                             PARTIE 1 
     * | test des méthodes permettant de créer respectivement 
     * |                 le tableau des libellés  et le tableau des dates 
     * -------------------------------------------------------------------------------
     */
    
    
    /**
     * Test de la méthode creerListeLibelles
     */
    public static void testCreerListeLibelles() {
        System.out.println ("TEST : méthode creerListeLibelles .\n"
                            + "---------------------------------");
        String[] libelle;           // tableau créé par la méthode
        int i;                      // indice de parcours de libelle
        
        // création du tableau des libellés 
        libelle = GestionEvenement.creerListeLibelles();
        
        // vérification de la taille du tableau
        if (libelle.length != GestionEvenement.NB_MAX_EVENEMENT) {
            
            System.out.println("Echec création liste libellés avec la taille "
                               + GestionEvenement.NB_MAX_EVENEMENT
                               + ". La taille du tableau est incorrecte.");
        } else {
            
            // vérification que toutes les cases contiennent null
            for(i = 0; i < libelle.length && libelle[i] == null; i++);
            if (i != libelle.length) {
                System.out.println("Echec création liste libellés avec la taille "
                        + GestionEvenement.NB_MAX_EVENEMENT
                        + ". \nLes cases du tableau ne sont pas égales à null.");
            } else {
                System.out.println("Test réussi avec la taille " 
                               + GestionEvenement.NB_MAX_EVENEMENT);
            }
        }        
        continuer();
    }
        
    
    /**
     * Test de la méthode creerListeDates
     */
    public static void testCreerListeDates() {        
        int[][] date;               // tableau créé par la méthode
        
        System.out.println ("TEST : méthode creerListeDates.\n"
                            + "---------------------------------");
       
        date = GestionEvenement.creerListeDates();
        
        // on vérifie le nombre de lignes du tableau des dates
        if (date.length != GestionEvenement.NB_MAX_EVENEMENT) {
            System.out.println("Echec création liste date avec la taille "
                               + GestionEvenement.NB_MAX_EVENEMENT
                               + ". Le nombre de ligne est incorrect.");
        } else {
            int i;
            
            // on vérifie le nombre de colonnes de chaque ligne
            for (i = 0 ; i < date.length && date[i].length == 2; i++);
            if (i != date.length) {
                System.out.println("Echec création liste de dates. La date située à "
                                   + " l'indice " + i + " a une taille incorrecte.");                
            } else {
                
                // on vérifie que toutes les cases sont initialisées à 0
                for (i = 0; i < date.length 
                            && date[i][0] == 0 && date[i][1] == 0; i++);
                
                if (i != date.length) {
                    System.out.println("Echec création liste de dates. La date de "
                                       + " l'indice " + i + " n'est pas égale à 0.");                
                } else {
                    
                    System.out.println("Test réussi avec la taille " 
                                       + GestionEvenement.NB_MAX_EVENEMENT);
                }
            }
        }        
        continuer();
    }
    
    
    

    /* ------------------------------------------------------------------------------- 
     * |                             PARTIE 2
     * | test des méthodes privées de la classe GestionEvenement :
     * |             indiceLibelle, libelleExiste et indicePremierEvenMois 
     * -------------------------------------------------------------------------------
     */
    
     
    /**
     * Test de la méthode indiceLibelle
     */
    public static void testIndiceLibelle() {        
        int compteurOK = 0;         // nombre de tests corrects
        int indiceTrouve;           // indice sur lequel le libellé est trouvé 

        System.out.println ("TEST : méthode indiceLibelle.\n"
                             + "---------------------------------");
        
        // recherche de l'indice de libellés qui existent dans le tableau
        for (int i = 0 ; i < LIBELLES.length; i++) {
            indiceTrouve = GestionEvenement.indiceLibelle(LIBELLES, LIBELLES[i]);
            if (i == indiceTrouve) {
                compteurOK++;
            } else {
                System.out.println("Echec : indice " + indiceTrouve + " incorrect "
                                   + " pour le résultat de la recherche du  libelle " 
                                   + LIBELLES[i]);
            }
        }
        
        // test pour un libellé inexistant
        indiceTrouve = GestionEvenement.indiceLibelle(LIBELLES, "inexistant");
        if (indiceTrouve == -1) {
            compteurOK++;
        } else {
            System.out.println("Echec : indice " + indiceTrouve + " incorrect pour le " 
                               + "résultat de la recherche d'un libellé inexistant");
        }
        
        // résultat global du test
        afficherResultatTest(LIBELLES.length + 1, compteurOK);        
        continuer();      
    }
    
    
    /**
     * Test de la méthode libelleExiste
     */
    public static void testLibelleExiste() {
        int compteurOK = 0;         // nombre de tests corrects

        System.out.println ("TEST : méthode libelleExiste.\n"
                + "---------------------------------");
       
        // recherche des libellés existants dans le tableau
        for (int i = 0 ; i < LIBELLES.length; i++) {            
            if (GestionEvenement.libelleExiste(LIBELLES, LIBELLES[i])) {
                compteurOK++;
            } else {
                System.out.println("Echec : le libellé (présent) " + LIBELLES[i] 
                                   + " n'a pas été trouvé " );
            }
        }
        
        // test pour un libellé inexistant       
        if (! GestionEvenement.libelleExiste(LIBELLES, "inexistant")) {
            compteurOK++;
        } else {
            System.out.println("Echec : un libellé inexistant a été trouvé." );
        }
        
        // résultat global du test
        afficherResultatTest(LIBELLES.length + 1, compteurOK);   
        continuer();       
    }
    
    
    /**
     * Test de la méthode indicePremierEvenMois
     */
    public static void testIndicePremierEvenMois() {
        
        // liste des mois qui seront recherchés dans le tableau DATES
        final int[] MOIS_A_CHERCHER = { 1, 6, 8, 10, 12};
        
        // réponse attendue pour chaque mois recherché (un indice du tableau DATES)
        final int[] REPONSE_ATTENDUE = { 0, 1, 3, -1, 7};
        
        int compteurOK = 0;     // nombre de tests corrects
        int indiceTrouve;       // indice trouvé pour le 1er événement du mois 
        
        System.out.println("TEST : méthode indicePremierEvenMois.\n "               
                           + "------------------------------------\n"); 
      
        // tests à partir du tableau moisAChercher
        for (int i = 0; i < MOIS_A_CHERCHER.length; i++) {
            indiceTrouve = 
                    GestionEvenement.indicePremierEvenMois(DATES, MOIS_A_CHERCHER[i]);
            if (indiceTrouve == REPONSE_ATTENDUE[i]) {
                compteurOK++;
            } else {
                System.out.println("Erreur : le premier événement du mois " 
                                   + MOIS_A_CHERCHER[i] + " a été trouvé à l'indice "
                                   + indiceTrouve + " au lieu de l'indice " 
                                   + REPONSE_ATTENDUE[i]);
            }            
        }        
        
        // résultat global du test
        afficherResultatTest(MOIS_A_CHERCHER.length, compteurOK);   
        continuer(); 
    }
    
    
    
    /* ------------------------------------------------------------------------------
     * |                         PARTIE 3
     * | test des méthodes qui consultent les tableaux des événemnts
     * |              (dans le but d'afficher les événemnents selon une période)
     * -------------------------------------------------------------------------------
     */
    
    
    /**
     * Tests de la méthode consulterEvenement
     */
    public static void testConsulterEvenement() {              
        System.out.println("TEST : méthode consulterEvenement (test visuel) \n "               
                           + "---------------------------------------\n"
                           + "(Bien vérifier que " + DATES.length 
                           + " événements sont affichés)\n"); 
        System.out.println(GestionEvenement.consulterEvenement(DATES, LIBELLES));
        continuer();       
    }
    
    
    /**
     * Tests de la méthode consulterEvenement pour les événements situés dans un mois
     * précis
     */
    public static void testConsulterEvenementDansUnMois() {      
        // tableau contenant les mois qui seront recherchés dans le tableau DATES
        int[] moisAChercher = { 1, 4, 6, 8, 10, 12};
        
        // nombre d'événements situés dans chacun des mois recherchés
        int[] quantiteAttendue = { 1, 0, 2, 4, 0, 1};
        
        System.out.println("TEST : méthode consulterEvenement (test visuel)\n "               
                           + "------------------------------------------\n"); 
        
        // on affiche les événements de chacun des mois à rechercher
        for (int i = 0; i < moisAChercher.length; i++) {
            System.out.println("\nEvenements du mois " + moisAChercher[i] 
                               + " (" + quantiteAttendue[i] 
                               + " événement(s) doi(ven)t s'afficher) : ");
            System.out.println(
                    GestionEvenement.consulterEvenement(DATES, 
                                                        LIBELLES, 
                                                        moisAChercher[i]));            
        }       
       continuer();
    }
    
    /**
     * Tests de la méthode consulterEvenement pour les événements situés à partir
     * d'une date précise
     */
    public static void testConsulterEvenementAPartirDe() {
        // tableau contenant les dates qui seront recherchées dans le tableau date
        int[][] dateAChercher = { {1, 1}, {10, 1}, {2, 4}, {15, 6}, {5, 8}, {16, 8}, 
                                  {20, 8}, {25, 8}, {10, 10}, {26, 12} };
        
        /*
         * nombre d'événements situés à partir des dates recherchées dans le mois de cette
         * même date
         */
        int[] quantiteAttendue = { 1, 0, 0, 2, 4, 3, 1, 0, 0, 0};     
        
        System.out.println("TEST : méthode consulterEvenement à partir d'une date, "
                           + " dans le mois courant (test visuel)\n"               
                           + "---------------------------------------------\n"); 
        
        // on affiche les événements situés à partir de chacune des dates
        for (int i = 0; i < dateAChercher.length; i++) {
            System.out.println("\nEvenements à partir de la date " 
                               + OutilDate.jourMoisEnChaine(dateAChercher[i])
                               + " (" + quantiteAttendue[i] 
                               + " événement(s) doi(ven)t s'afficher) : ");
            System.out.println(
                    GestionEvenement.consulterEvenement(DATES, 
                                                        LIBELLES, 
                                                        dateAChercher[i]));            
        }       
        continuer();
    }
    
    
    
    /* ------------------------------------------------------------------------------
     * |                         PARTIE 4
     * | test des méthodes  d'ajout et de suppression d'un événement
     * -------------------------------------------------------------------------------
     */
    
    
    /**
     * Tests de la méthode ajouterEvenement 
     */
    public static void testAjouterEvenement() {
        // tableau des libellés tel qu'il devra être obtenu
        String[] libelleAObtenir = { "Jour de l'an", "Anniversaire Arthémis", "Fête de la musique", 
                                     "Jour férié, 15 Août", "Anniversaire de Marie",
                                     "Fête de Monvillage", 
                                     "Salon du livre et des libraires", 
                                     "Jour de Noël" }; 
        
        // tableau déterminant dans quel ordre seront ajoutés les événements
        int[] ordreAjout = { 2, 5, 7, 6, 1, 0, 3, 4 };    // contient des indices        
        int[][] dateObtenu;         // contiendra les dates ajoutées
        String[] libelleObtenu;     // contiendra les libellés ajoutés
        int compteurOK;             // nombre de tests corrects
                
        System.out.println("TEST : méthode ajoutEvenement\n"               
                           + "-----------------------------\n");
        
        // création des listes de dates et de libellés
        libelleObtenu = GestionEvenement.creerListeLibelles();
        dateObtenu = GestionEvenement.creerListeDates();
        
        /*
         *  ajout des dates et des libellés des tableaux date et libelle
         *  l'ordre de l'ajout est déterminé par le tableau d'indice ordreAjout
         */
        for (int i = 0; i < ordreAjout.length; i++) {
            GestionEvenement.ajouterEvenement(dateObtenu, libelleObtenu, 
                    DATES[ordreAjout[i]], LIBELLES[ordreAjout[i]]);
        }
        
       
        // on vérifie si le tableaux des libellés obtenus est bien celui attendu         
        compteurOK = 0;
        for (int i = 0; i < LIBELLES.length; i++) {
            if (libelleAObtenir[i].equals(libelleObtenu[i])) {
                compteurOK++;
            } else {
                System.out.println("Erreur : le libellé " + libelleObtenu[i] 
                                   + " a été trouvé à l'indice " + i + " alors que c'est "
                                   + " le libellé " + libelleAObtenir[i] + " qui est attendu.");
            }
        }
        System.out.println("\nRésutat pour les libellés : ");
        afficherResultatTest(LIBELLES.length, compteurOK );
        
        // on vérifie si le tableaux des dates obtenues est bien celui attendu         
        compteurOK = 0;
        for (int i = 0; i < DATES.length; i++) {
            if (DATES[i][0] == dateObtenu[i][0] && DATES[i][1] == dateObtenu[i][1]) {
                compteurOK++;
            } else {
                System.out.println("Erreur : date" 
                                   + OutilDate.jourMoisEnChaine(dateObtenu[i])
                                   + " a été trouvée à l'indice " + i + " alors que c'est "
                                   + " la date " 
                                   + OutilDate.jourMoisEnChaine(DATES[i]) 
                                   + " qui est attendue.");
            }
        }
        System.out.println("\nRésutat pour les dates : ");
        afficherResultatTest(DATES.length, compteurOK );
        continuer();
    }
    
    /*
     * TODO : écrire ici le code de la méthode qui teste la consultation des
     *        événements situés entre 2 dates
     */
    
    
    /*
     * TODO : écrire ici le code de la méthode qui teste la suppression d'un 
     *        événement
     */
    
    
    
    /*   ---------------------------   Méthodes outils ----------------------------------- */
    
    /**
     * Demande à l'utilisateur d'appuyer sur entrée pour continuer
     */
    private static void continuer() {
        System.out.println("\nAppuyer sur entrée pour continuer les tests.") ;
        entree.nextLine();
    }
    
    
    /**
     * Affiche le résultat global d'un test
     * @param nbTestTotal       nombre total de tests effectués
     * @param nbTestOk          nombre de tests réussis
     */
    private static void afficherResultatTest(int nbTestTotal, int nbTestOk) {
        System.out.println(nbTestOk + " test(s) ont réussi sur un total de "
                + nbTestTotal + " tests réalisés.\n   ==>  "
                + ((nbTestOk == nbTestTotal) ?
                        "Tous les tests sont OK" 
                        : "Au moins un test a échoué.") + "\n");
    }
    
    
    
    /**
     * Programme principal permettant de lancer les tests
     * @param args
     */
    public static void main(String[] args) {
        
        // tests de la PARTIE 1 : création des tableaux de libellés et de dates
//OK        // testCreerListeLibelles();
//OK        // testCreerListeDates();
        
        
        // tests de la PARTIE 2 : test des méthodes privées de la classe GestionEvenement
//OK        // testIndiceLibelle();
//OK        // testLibelleExiste();
//OK        // testIndicePremierEvenMois();
        
        
        // tests de la PARTIE 3 : test des méthodes qui consultent les événements
//OK        // testConsulterEvenement();
//OK        // testConsulterEvenementDansUnMois();
//OK        // testConsulterEvenementAPartirDe();
     
        
        // tests de la PARTIE 4 : test des méthodes ajout et suppression
         testAjouterEvenement();
        
    }

}
