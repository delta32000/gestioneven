/*
 * Classe contenant les m\u00e9thodes permettant de g\u00e9rer un unique \u00e9v\u00e9nement
 * ind\u00e9pendamment des autres \u00e9v\u00e9nements
 * fichier GestionUnEvenement.java                                 01/18
 */
package info1.gestioneven;

import java.util.Scanner;

import info1.gestioneven.OutilDate;

public class GestionUnEvenement {

    
    /** Nombre maximum de caract\u00e8res pour un libell\u00e9 */
    public static final int LONGUEUR_MAX_LIBELLE = 60;
    
    /** Nombre de positions sur lesquelles la date doit \u00eatre affich\u00e9e */
    private static final int POSITON = 12;
    
    
    
    
    /**
     * Renvoie une chaîne de caract\u00e8res contenant la date d'un \u00e9v\u00e9nement, suivie 
     * de son libell\u00e9. Le mois de l'\u00e9v\u00e9nement est \u00e9crit en toutes lettres
     * La date est \u00e9crite sur 12 positions. Donc des espaces sont ajout\u00e9es avant
     * que le libell\u00e9 ne soit concat\u00e9n\u00e9 \u00e0 la chaîne.
     * @param date     date de l'\u00e9v\u00e9nement (tableau de 2 entiers)
     * @param libelle  libell\u00e9 associ\u00e9 \u00e0 l'\u00e9v\u00e9nement
     * @return une chaîne contenant la description compl\u00e8te de l'\u00e9v\u00e9n\u00e9ment,
     *         le mois est \u00e9crit en toutes lettres
     */
     public static String evenementEnLettres(int[] date, String libelle) {
       
		final int NB_CARAC = 15;

        int nbEspace;       // nombre d'espaces \u00e0 ajouter apr\u00e8s la date
                            // pour que les libell\u00e9s soient bien align\u00e9s
        StringBuilder resultat;  // contiendra l'\u00e9v\u00e9nement avec le mois en lettres
		
        // on place dans r\u00e9sultat le date avec le mois en lettres
		resultat = new StringBuilder("");
        
		resultat.append(date[0]).append(" ");
		if ( date[0] < 10 ){
			resultat.append(" ");
		}
		resultat.append(OutilDate.enLettre(date[1]));
        // on calcule combien d'espaces devront \u00eatre ajout\u00e9s \u00e0 la suite de la date
		
		nbEspace = NB_CARAC - resultat.length();

        // ajout des espaces \u00e0 la suite de la date 
		for (int i = 0; i < nbEspace ; i++) {
			resultat.append(" ");
		}
        
		
        // ajout du libell\u00e9  de l'\u00e9v\u00e9nement, apr\u00e8s la date
		
        resultat.append("-  ").append(libelle);
        return resultat.toString();
    }
    
     
     /**
      * Affiche un \u00e9v\u00e9nement. Le mois est \u00e9crit en toutes lettresultat
      * @param date         date de l'\u00e9v\u00e9nement (tableau de 2 cases)
      * @param libelle      libell\u00e9 de l'\u00e9v\u00e9nement
      */
     public static void afficherEvenement(int[] date, String libelle) {
         System.out.println(evenementEnLettres(date, libelle));
     }
    
  
     /** 
      * Effectue la saisie d'un libell\u00e9 valide ind\u00e9pendemment des libell\u00e9s existants.
      * Si le libell\u00e9 saisi est vide, la saisie est recommenc\u00e9e.
      * Si le libell\u00e9 d\u00e9passe la longueur maximum, il est tronqu\u00e9 et l'utilisateur
      * en est inform\u00e9.
      * @return une chaîne contenant le texte saisi par l'utilisateur (\u00e9ventuellement
      *         tronqu\u00e9)
      */
     public static String saisirLibelleValide() {
         Scanner entree = new Scanner(System.in);
         String chaineLue;           // chaîne saisie par l'utilisateur
         
         // La saisie du libell\u00e9 est recommenc\u00e9e jusqu'\u00e0 obtenir une chaîne non vide
         do {
             System.out.print("Entrez le libell\u00e9 de l'\u00e9v\u00e9nement : ");
             chaineLue = entree.nextLine();
             if ( chaineLue.length() <= 0) {
                 
                 // le libell\u00e9 est vide
                 System.out.println("Erreur. Vous devez saisir un texte non vide.\n");
             } else if ( chaineLue.length() > LONGUEUR_MAX_LIBELLE ) {
                 
                 // libell\u00e9 trop long : il faut le tronquer et pr\u00e9venir l'utilisateur
                 chaineLue = chaineLue.substring(0,LONGUEUR_MAX_LIBELLE) ; 
                 System.out.println("Ce libell\u00e9 est trop long. Il sera tronqu\u00e9 en "
                                    + chaineLue);
             }
         } while (chaineLue.length() == 0);
         return chaineLue;
     }
     
    
    /**
     * Saisit la description compl\u00e8te d'un \u00e9v\u00e9nement : date et libell\u00e9
     * La saisie est recommenc\u00e9e en cas d'erreur
     * @param date tableau de 2 entiers qui recevra la date de l'\u00e9v\u00e9nement
     *             (jour pour la premi\u00e8re case, mois pour la deuxi\u00e8me)
     *             Ce tableau de 2 cases doit avoir \u00e9t\u00e9 cr\u00e9\u00e9 par l'appelant
     *             de la m\u00e9thode.
     * @return une chaîne contenant le libell\u00e9 de l'\u00e9v\u00e9nement
     */
    public static String saisirEvenement(int[] date) {
        String libelle;     // libell\u00e9 de l'\u00e9v\u00e9nement saisi
        int[] dateSaisie;   // date de l'\u00e9v\u00e9nement saisi
        
        // saisie du libell\u00e9        
        libelle = saisirLibelleValide();
        
        // saisie de la date
        System.out.println("Date de l'\u00e9v\u00e9nement ?");
        dateSaisie = OutilDate.saisirJourMois();
        date[0] = dateSaisie[0];
        date[1] = dateSaisie[1];
        
        // le libell\u00e9 est renvoy\u00e9, la date argument a \u00e9t\u00e9 mise \u00e0 jour
        return libelle;
    }
    
}
