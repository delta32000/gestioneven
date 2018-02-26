
/*
 * Classe avec diff\u00e9rentes op\u00e9rations permettant de g\u00e9rer une date          01/18
 * OutilDate.java
 */
package info1.gestioneven;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Classe contenant des op\u00e9rations permettant de g\u00e9rer une date d\u00e9crite par un num\u00e9ro
 * de jour et un num\u00e9ro de mois :
 *    - saisir un mois en recommençant en cas d'erreur
 *    - saisir un jour en recommençant en cas d'erreur
 *    - saisir un jour et un mois valide (saisie recommenc\u00e9e si erreur)
 *    - transforme un num\u00e9ro de mois en la chaîne associ\u00e9e (janvier, f\u00e9vrier, ...)
 *    - transforme une date en chaîne de caract\u00e8res
 *    - d\u00e9termine si une date est valide
 *    - d\u00e9termine le jour et le mois de la date courante
 *    - d\u00e9termine si une date est ant\u00e9rieure \u00e0 une autre date
 * Une date est stock\u00e9e dans un tableau de 2 cases : \u00e0 l'indice 0, on place le jour et
 * \u00e0 l'indice 1, on place le mois.
 * @author INFO1
 * @version 1.0
 */
public class OutilDate {

    /** Objet pour effectuer les saisies sur l'entr\u00e9e standard, le clavier */
    private static Scanner entree = new Scanner(System.in);
    
    
    /**
     * Effectue la saisie d'un mois, un entier entre 1 et 12.
     * La saisie est recommenc\u00e9e en cas d'erreur.
     * Si l'utilisateur commet une erreur, un message pr\u00e9cis lui indique
     * la cause de l'erreur.
     * @return mois un entier compris entre 1 et 12
     */
    public static int saisirMois() {
        int mois = -1;      // initialis\u00e9 avec une valeur incorrecte
        
        // recommence la saisie du mois jusqu'\u00e0 obtenir une valeur correcte
        do {
            System.out.print("Entrez un mois : ");
            if (entree.hasNextInt()) {
                
                // l'utilisateur a saisi un entier
                mois = entree.nextInt();
                if (mois < 1 || mois > 12) {
                    System.out.println("Nombre incorrect. " 
                                       + "Un mois est compris entre 1 et 12");
                }
            } else {
                System.out.println("Erreur. Vous devez saisir un entier.");
            }
            entree.nextLine();            
        } while (mois < 1 || mois > 12);
        return mois;
    }
    
    
    /**
     * Effectue la saisie d'un jour dans un mois, un entier entre 1 et 31.
     * La saisie est recommenc\u00e9e en cas d'erreur.
     * Si l'utilisateur commet une erreur, un message pr\u00e9cis lui indique
     * la cause de l'erreur.
     * @return jour un entier compris entre 1 et 31
     */
    public static int saisirJour() {
        int jour = -1;      // initialis\u00e9 avec une valeur incorrecte
        
		do {
			System.out.print("Entrez un jour : ");
			if (entree.hasNextInt()) {
				
				// l'utilisateur a saisi un entier
				jour = entree.nextInt();
				if (1 > jour || jour > 31) {
					System.out.println("Nombre incorect." 
										+ "un jour doit \u00eatre compris entre 1 et 31");
				}
			} else {
				System.out.println("Erreur. Vous devez saisir un entier.");
			}
			entree.nextLine();
		} while (1 > jour || jour > 31);
        return jour;
    }
    
    
    /**
     * Saisit un jour et un mois. La saisie est recommenc\u00e9e en cas d'erreur.
     * Le jour doit \u00eatre valide par rapport au mois.
     * Si l'utilisateur commet une erreur, un message lui indique que cette
     * date n'est pas valide.
     * @return un tableau de 2 entiers : le premier est le jour saisi, le deuxi\u00e8me
     *         est le mois saisi
     */
    public static int[] saisirJourMois() {
        int[] date = new int[2];        // contiendra le jour et le mois saisis
        
		date[0] = saisirJour();
		date[1] = saisirMois();
        return date;
    }
     
    
    /**
     * D\u00e9termine si la date argument est valide, c'est-\u00e0-dire si
     * le tableau contient bien 2 \u00e9l\u00e9ments et si 
     * le jour est bien inf\u00e9rieur ou \u00e9gal au nombre de jours dans le mois. 
     * On consid\u00e8re que le mois de f\u00e9vrier a  29 jours
     * @param date  un tableau de 2 entiers suppos\u00e9 contenir une date
     *              \u00e0 l'indice 0 : le jour 
     *              \u00e0 l'indice 1 : le mois 
     * @return  un bool\u00e9en \u00e9gal \u00e0 vrai ssi le jour est valide pour le mois argument
     */
    public static boolean estValide(int[] date) {
        
        final int [] NB_JOUR_PAR_MOIS = {31,29,31,30,31,30,31,31,30,31,30,31};
		
		boolean valide = false;
		if (date[0] <= NB_JOUR_PAR_MOIS[date[1]-1] && date[0] > 0) {
			valide = true;
		}
        return valide;  
    }

    
    /**
     * Renvoie le jour et le mois courants (de la date du jour)
     * @return un tableau de 2 \u00e9l\u00e9ments contenant le jour et le mois courant
     *         ²
     */
    public static int[] jourMoisCourant() {
        
        /*
         * tableau qui contiendra le r\u00e9sultat :
         *    \u00e0 l'indice 0 le jour courant
         *    \u00e0 l'indice 1 le mois courant
         */
        int[] dateCourante = new int[2];
        Calendar calendrier = Calendar.getInstance();
		
        dateCourante[0] = calendrier.get(Calendar.DAY_OF_MONTH);  
		dateCourante[1] = calendrier.get(Calendar.MONTH) + 1;
        return dateCourante;        
    }
    
    
    /**
     * D\u00e9termine si les 2 dates arguments sont ordonn\u00e9es.
     * Si l'un des arguments est invalide, la m\u00e9thode affiche un message d'avertissement
     * et renvoie la valeur faux.
     * @param date1   tableau contenant le jour et le mois de la date 1
     * @param date2   tableau contenant le jour et le mois de la date 2   
     * @return un bool\u00e9en \u00e9gal \u00e0 vrai ssi la premi\u00e8re date est situ\u00e9e avant
     *         (strictement) la deuxi\u00e8me
     */
    public static boolean sontOrdonnes(int[] date1, int[] date2) {

        boolean valide = false;		// initialis\u00e9 a false et devient true si la date est bonne
		
		if (date1[1] < date2[1] || date1 [1] == date2[1] && date1 [0] < date2[0]){
			valide = true;
		} else {
			System.out.println("La date1 est plus grande que la date2");
		}
        return valide;
    }
    
    /**
     * D\u00e9termine si les 2 dates arguments sont egales.
     * Si l'un des arguments est invalide, la m\u00e9thode affiche un message d'avertissement
     * et renvoie la valeur faux.
     * @param date1   tableau contenant le jour et le mois de la date 1
     * @param date2   tableau contenant le jour et le mois de la date 2   
     * @return un bool\u00e9en \u00e9gal \u00e0 vrai ssi les deux dates sont \u00e9gales
     */
    public static boolean sontEgales(int[] date1, int[] date2) {
        
        boolean valide = false;		// initialis\u00e9 a false et devient true si la date est bonne
		
		if (date1 [1] == date2[1] && date1[0] == date2[0]){
			valide = true;
		} else {
			System.out.println("La date1 est plus grande que la date2");
		}
        return valide;
    }
    
    
    /**
     * Renvoie l'\u00e9quivalent en toutes lettres du mois argument.
     * Le nom du mois comporte des accents, et d\u00e9bute par une lettre majuscule.
     * Les autres lettres sont en minuscule.
     * @param mois  un entier contenant un mois (entier entre 1 et 12)
     * @return une chaîne contenant le mois en toutes lettres
     *         ou bien la chaîne "erreur" si le mois argument n'est pas valide
     */
    public static String enLettre(int mois) {
        final String[] LES_MOIS = { "Janvier", "F\u00e9vrier", "Mars", "Avril", "Mai", "Juin",
                                    "Juillet", "Ao\u00fbt", "Septembre", "Octobre", "Novembre",
                                    "D\u00e9cembre" }; 
									
        if (mois >= 1 && 12 >= mois) {
			return LES_MOIS[mois-1];
		}
        return "erreur";
    }
    
    
    /**
     * Renvoie la date courante sous la forme d'une chaîne de caract\u00e8res.
     * Dans cette chaîne, le mois est \u00e9crit en toutes lettres (conform\u00e9ment
     * \u00e0 la m\u00e9thode enLettre.
     * @param date tableau contenant 2 entiers : le jour et le mois 
     * @return une chaîne contenant la date argument avec le mois en toutes lettres
     *         ou bien la chaîne "erreur" si l'argument est une date invalide.
     *         
     */
    public static String jourMoisEnLettre(int[] date) {
        if (date[1] >= 1 && 12 >= date[1] && estValide(date)) {
		    return date[0] + " " + enLettre(date[1]);
	    }
		return "erreur"; 
    }
    
    
    
    
    /**
     * Renvoie une chaîne contenant la date argument.
     * Si l'un des arguments est invalide, la m\u00e9thode renvoie un message d'avertissement.
     * @param date tableau contenant 2 entiers : le jour et le mois \u00e0 renvoyer
     * @return une chaîne contenant la date argument sous la forme jour/mois
     *         (ou "Erreur inattendue m\u00e9thode jourMoisEnChaine de la classe 
                    OutilDate. La date argument est incorrecte.")
     */
    public static String jourMoisEnChaine(int[] date) {
        final String MESSAGE_ERR = "Erreur inattendue m\u00e9thode jourMoisEnChaine de la classe" 
                   + "OutilDate. La date argument est incorrecte";
		
		if (date[1] >= 1 && 12 >= date[1] && estValide(date)) {
			return date[0] + "/" + date[1];
		} 
        return MESSAGE_ERR;      
    }
    
}
