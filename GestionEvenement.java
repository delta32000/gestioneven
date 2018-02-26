/*
 * Classe contenant les méthodes permettant de gérer les événements
 * fichier GestionEvenement.java                                 01/18
 */
package info1.gestioneven;

import info1.gestioneven.GestionUnEvenement;


/**
 * Classe contenant toutes les méthodes permettant de gérer les événements.
 * Un événement est représenté par une date et un libellé. Une date est un
 * tableau de 2 entiers, le jour et le mois. Le libellé est une chaîne de
 * caractères.
 * Principales méthodes :
 *    - TODO : compléter le commentaire
 *    
 * @author INFO1
 * @version 1.0
 */
public class GestionEvenement {

    /**
     * Nombre d'événements maximum que l'application pourra gérer
     * Eventuellement la valeur 10 pour faciliter les tests
     * Normalement la valeur 300
     */
    public static final int NB_MAX_EVENEMENT = 10;
    
    /**  Message d'erreur pour une erreur qui ne doit pas se produire */
    private static final String ERREUR_INATTENDUE = "Erreur inattendue. ";
    
    
    /**************************  CREATION DES TABLEAUX VIDES  *****************
     *     - un tableau vide de 10 éléments pour les libellés (tableau de String)
     *     - un tableau vide de 2 colonnes et de 10 lignes pour les dates. Les 
     *        éléments de ce tableau sont de type int. 
     **************************************************************************        
     */
  
    
    /**
     * Création du tableau qui contiendra les libellés
     * Les cases du tableau sont initialisées à null, automatiquement. 
     * Le nombre de cases sera égal à  NB_MAX_EVENEMENT      
     * @return un tableau de chaînes de caractères initialisé à null
     */
    public static String[] creerListeLibelles() {   
			String[] listeLibelles = new String[NB_MAX_EVENEMENT];
        return listeLibelles;
    }
    
    
    /**
     * Création du tableau qui contiendra les dates des événements
     * Chaque ligne du tableau contiendra 2 entiers (un pour le jour,
     * l'autre pour le mois), donc 2 colonnes
     * Les cases du tableau sont initialisées avec 0, automatiquement    
     * Le nombre de cases sera égal à  NB_MAX_EVENEMENT 
     * @return un tableau à 2 dimensions initialisé avec la valeur 0
     */
    public static int[][] creerListeDates() {
        int[][] listeDate = new int[NB_MAX_EVENEMENT][2];
        return listeDate;
    }
   
        
    /****************************  AFFICHAGE DES EVENEMENTS ********************/
    
    /**
     * Renvoie tous les événements décrits par les tableaux date et libelle
     * @param date      tableau d'entiers à 2 dimensions contenant les dates des
     *                  événements (chaque ligne contient 2 valeurs : jour et mois)
     * @param libelle   tableau de chaînes contenant les intitulés des événements
     * @return une chaîne de caractères contenant tous les événements, séparés
     *         par un retour à la ligne
     */
    public static String consulterEvenement(int[][] date, String[] libelle) {
        /*
         * Remarque : on construit la chaîne à renvoyer dans une instance de
         *            type StringBuilder. En effet, dans la boucle "for" on 
         *            modifie à plusieurs reprises la chaîne résultat qui
         *            contiendra les événements à renvoyer. Il est plus efficace
         *            de modifier un StringBuilder plutôt qu'un objet de type
         *            String.
         */
        StringBuilder resultat = new StringBuilder();        // chaîne à renvoyer

        /*
         *  insertion de chacun des événements des tableaux date et libelle
         *  dans l'objet resultat.
         *  Un retour à la ligne est inséré entre chaque événement.
         *  Remarque : si aucun événement n'est présent dans les tableaux
         *  libellé ou date, la chaîne renvoyée sera vide.
         */
        for (int i = 0; i < libelle.length && libelle[i] != null; i++){            
            resultat.append(GestionUnEvenement.evenementEnLettres(date[i], libelle[i])).append("\n");          
        }
        return resultat.toString();   // le StringBuiler est transformé en String
    }
        
    /**
     * Renvoie tous les événements décrits par les tableaux date et libelle,
     * et situés dans le mois argument
     * @param date      tableau d'entiers à 2 dimensions contenant les dates des
     *                  événements (chaque ligne contient 2 valeurs : jour et mois)
     *                  Ce tableau est trié chronologiquement.
     * @param libelle   tableau de chaînes contenant les intitulés des événements  
     * @param mois      entier compris entre 1 et 12 correspondant au mois à afficher
     * @return une chaîne de caractères contenant tous les événements correspondant
     *         au critère de recherche, séparés par un retour à la ligne
     */
    public static String consulterEvenement(int[][] date, String[] libelle, int mois) {
       
        StringBuilder resultat = new StringBuilder();        // chaîne à renvoyer
		int i;
        if (mois < 1 || mois > 12) {
            
            // cette erreur ne doit pas se produire
            resultat.append(ERREUR_INATTENDUE + " (mois invalide)"); 
        } else {
            // indice du premier événement situé dans le mois argument
			for (i = 0 ; date[i][1] < mois ; i++) {};
            // remplissage du StringBuilder
            for (;i < date.length && date[i][1] == mois ; i++) {
                resultat.append(GestionUnEvenement.evenementEnLettres(date[i], libelle[i])).append("\n");   
			}
        }
        return resultat.toString();    // le StringBuiler est transformé en String
    }
        
    /**
     * Renvoie tous les événements décrits par les tableaux date et libelle,
     * et à partir de la date limite, et jusqu'à la fin du mois de celle-ci
     * @param date      tableau d'entiers à 2 dimensions contenant les dates des
     *                  événements (chaque ligne contient 2 valeurs : jour et mois)
     *                  Ce tableau est trié chronologiquement.
     * @param libelle   tableau de chaînes contenant les intitulés des événements  
     * @param limite    tableau contenant la date limite à partir de laquelle 
     *                  l'affichage est effectué
     * @return une chaîne de caractères contenant tous les événements correspondant
     *         au critère de recherche, séparés par un retour à la ligne
     */
    public static String consulterEvenement(int[][] date, String[] libelle, int[] limite) {
        StringBuilder resultat = new StringBuilder();        // chaîne à renvoyer
		int i;
		
        if (!OutilDate.estValide(limite)) {
            // cette erreur ne doit pas se produire
            resultat.append(ERREUR_INATTENDUE + " (limite invalide)"); 
        } else {
            // indice du premier événement situé avant le mois argument
			for (i = 0 ; date[i][1] < limite[1] ; i++) {}
			for (;i < date.length && date[i][0] < limite[0] ; i++) {}
			
            // remplissage du StringBuilder
			for (; i < date.length && date[i][1] <= limite[1] && date[i][0] >= limite[0] ; i++) {
                resultat.append(GestionUnEvenement.evenementEnLettres(date[i], libelle[i])).append("\n");   
			}
		}
        
        return resultat.toString();
    }
    
    
    /* TODO : écrire ici la méthode qui consulte les événements situés entre
     *        2 dates précises
     */
    /**
     * Renvoie tous les événements décrits par les tableaux date et libelle,
     * et à partir de la date limite de Début, et jusqu'à la limite de Fin
     * @param date      tableau d'entiers à 2 dimensions contenant les dates des
     *                  événements (chaque ligne contient 2 valeurs : jour et mois)
     *                  Ce tableau est trié chronologiquement. 
     * @param libelle   tableau de chaînes contenant les intitulés des événements  
     * @param limiteDeb tableau contenant la date limite à partir de laquelle 
     *                  l'affichage est effectué
     * @param limiteFin tableau contenant la date limite à partir de laquelle 
     *                  l'affichage est effectué
     * @return une chaîne de caractères contenant tous les événements correspondant
     *         au critère de recherche, séparés par un retour à la ligne
     */
    public static String consulterEvenement(int[][] date, String[] libelle, int[] limiteDeb, int[] limiteFin) {
        StringBuilder resultat = new StringBuilder();        // chaîne à renvoyer
		int i;
		
        if (!OutilDate.estValide(limiteDeb) || !OutilDate.estValide(limiteFin) || !OutilDate.sontOrdonnes(limiteDeb,limiteFin)) {
            // cette erreur ne doit pas se produire
            resultat.append(ERREUR_INATTENDUE + " (limite invalide)"); 
        } else {
            // indice du premier événement situé dans le mois argument
			for (i = 0 ; date[i][1] < limiteDeb[1] && date[i][0] < limiteDeb[0] ; i++) {};
            // remplissage du StringBuilder
			for (; date[i][1] <= limiteFin[1] && date[i][0] <= limiteFin[0] ; i++) {
				resultat.append(GestionUnEvenement.evenementEnLettres(date[i], libelle[i])).append("\n");
			}
		}
        
        return resultat.toString();
    }
    
    
    /************************   AJOUT ET SUPPRESSION D'UN EVENEMENT ***********/
    
    
    /**
     * Ajoute si c'est possible l'évenement argument aux tableaux des événements gérés.
     * L'événement à ajouter est décrit par sa date et son intitulé.
     * @param date    tableau contenant toutes les dates des événements gérés
     *                Il s'agit d'un tableau d'entiers à 2 dimensions.
     *                Chaque ligne contient une date (2 entiers, le jour et le mois).
     *                Le tableau est trié chronologiquement.
     * @param libelle  tableau contenant tous les libellés des événements gérés
     * @param quand     date de l'événement à ajouter (un tableau de 2 entiers)
     * @param intitule  intitulé de l'événement à ajouter
     * @return un booléen égal à vrai ssi l'ajout est possible
     */
    public static boolean ajouterEvenement(int[][] date, String[] libelle, 
                                           int[] quand, String intitule) {
        
        // si le libellé existe déjà ou si les tableaux sont pleins : ajout impossible
        if (date[date.length-1][0] != 0 || libelle[libelle.length-1] != null || libelleExiste(libelle, intitule)) {  
		System.out.println("au revoir");  
            return false;
        }
		System.out.println("bonjour");

        // on recherche la dernière case occupéee dans le tableau
        int i;      // indice de parcours
        System.out.println("DEBUG1 " + date.length);
        for (i = date.length ; i > 0 && date[i] == null ; i--);
        System.out.println("DEBUG2 " + i);

        /* décaler la fin du tableau vers la droite, de manière à libérer
         * une case pour réaliser l'insertion
         */
        for (; i > 0 && date[i][1] >= quand[1] && date[i][0] > quand[0] ; i--) {
			date[i+1][1] = date[i][1];
			date[i+1][0] = date[i][0];
		}
        
        date[i][1] = quand[1];
		date[i][0] = quand[0];
		libelle[i] = intitule;
        
        return true;
   }
           
     /*
      * TODO : écrire ici la méthode qui suppprime un événement
      */
    
        
    
    
    /********************************  RECHERCHE EVENEMENT ********************/
        
    /**
     * Renvoie l'indice du libellé argument dans le tableau des intitulés
     * si il est présent, sinon -1
     * @param intitule  tableau de chaînes contenant tous les intitulés existants
     * @param aChercher   chaîne contenant le libellé à rechercher    
     * @return un entier égal à l'indice du libellé argument dans le tableau
     *         intitulé, ou bien -1 si le libellé n'existe pas dan le tableau
     */
    public static int indiceLibelle(String[] intitule, String aChercher) {
        for (int i = 0 ; i < intitule.length ; i++) {
			if (intitule[i].equals(aChercher)) {
				return i;
			}
		}
        return -1;
    }
      
    /**
     * Détermine si le libellé argument existe déjà dans le tableau des intitulés
     * @param intitule  tableau de chaînes contenant tous les intitulés existants
     * @param libelle   chaîne contenant le libellé à rechercher
     * @return un booléen égal à vrai ssi le libellé arguement est présent 
     *         parmi les intitulés
     */
    public static boolean libelleExiste(String[] intitule, String libelle) {
        for (int i = 0 ; i < intitule.length ; i++) {
			if (intitule[i].equals(libelle)) {
				return true;
			}
		}
        return false;
        
    }
    
    /**
     * Renvoie l'indice de la première date située dans le mois argument
     * Le tableau de date est supposé trié dans l'odre croissant
     * @param date      tableau d'entiers à 2 dimensions contenant les dates des
     *                  événements (chaque ligne contient 2 valeurs : jour et mois)
     *                  Ce tableau est trié chronologiquement.
     * @param mois      entier compris entre 1 et 12 correspondant au mois à rechercher    
     * @return un entier égal à l'indice de la première date située dans le mois argument
     *         ou -1 si le mois est invalide ou si aucun événement n'est situé 
     *         dans ce mois
     */
    public static int indicePremierEvenMois(int[][] date, int mois) {      
		for (int i = 0 ; date[i][1] <= mois ; i++) {
			if (date[i][1] == mois) {
				return i;
			}
		};
        return -1;
    }
  
       
}
