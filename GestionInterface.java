/*
 * Classe contenant des m\u00e9thodes outils pour g\u00e9rer l'interface avec l'utilisateur
 * OutilInterface.java                                               01/18
 */

package info1.gestioneven;
import java.util.Scanner;


/**
 * TODO \u00e9crire un commentaire 
 * @author INFO1
 * @version 1.0
 */
public class GestionInterface {

    /*
     * D\u00e9claration d'un objet Scanner pour les saisies
     */
    private static Scanner entree = new Scanner(System.in);
    
    
    /**
     * Liste des options possibles pour le menu
     */
    private static final char[] OPTION = { 'a', 't', 'c', 'm', 'e', 's', '?', 'q'};
    
    /**
     * Liste des options possibles pour le menu en majuscule
     */
    private static final char[] OPTION_MAJ = { 'A', 'T', 'C', 'M', 'E', 'S', '?', 'Q'};
    
    /**
     * Liste des libell\u00e9s associ\u00e9s \u00e0 chacune des options du tableau OPTION
     */
    private static final String[] LIBELLE = {
                "Ajouter un \u00e9v\u00e9nement\n",
                "voir Tous les \u00e9v\u00e9nements enregistr\u00e9s\n",
                "consulter tous les \u00e9v\u00e9nements du mois en Cours\n",
                "consulter les \u00e9v\u00e9nements d'un Mois pr\u00e9cis\n",
                "consulter les \u00e9v\u00e9nements situ\u00e9s Entre 2 dates\n",
                "Supprimer un \u00e9v\u00e9nement\n",
                "afficher l'aide\n",
                "Quitter\n\n" };
    
    /** Texte affich\u00e9 pour l'aide en ligne */
    private static final String TEXTE_AIDE_EN_LIGNE = 
            "------------------------------------------------------------------------\n"
            + "|                             AIDE EN LIGNE                            |\n"
            + "------------------------------------------------------------------------\n\n"
            + "      TODO : Texte \u00e0 compl\u00e9ter ....\n\n";
    
    /** Texte affich\u00e9 en en-t\u00eate du menu */
    private static final String TEXTE_DEBUT_MENU = 
            "------------------------------------------------------------------------\n"
            + "|                QUE SOUHAITEZ-VOUS FAIRE ?                            |\n"
            + "------------------------------------------------------------------------\n\n";
    
    
    
    
    /**
     * Affiche l'aide en ligne 
     */
    public static void afficherAide() {
        System.out.println(TEXTE_AIDE_EN_LIGNE);
    }
    
    
    /**
     * D\u00e9termine si la chaîne argument est valide, contient l'une des lettres :
     * a, t, c, m, e, s, ?, q, \u00e0 l'exclusion de tout autre caract\u00e8re.
     * La lettre peut \u00eatre en majuscule ou minuscule.
     * @param reponse  chaîne de caract\u00e8res \u00e0 tester
     * @return un bool\u00e9en \u00e9gal \u00e0 vrai ssi la chaîne arguement est valdie
     */
    public static boolean reponseValide(String reponse) {
        boolean resultat;           // r\u00e9sultat renvoy\u00e9 par la m\u00e9thode
                                    // vrai si la r\u00e9ponse argument est valide
        char reponseChar;
        
        if ( reponse.length() != 1 ) {
           //  la r\u00e9ponse ne contient pas un caract\u00e8re unique
           resultat = false;
        } else {
            // on v\u00e9rifie si la r\u00e9ponse est pr\u00e9sente dans le tableau OPTION ou OPTION_MAJ
            resultat = false;
			reponseChar = reponse.charAt(0);
			
			for ( int i = 0; i < OPTION.length ; i++) {
				if (OPTION[i] == reponseChar || OPTION_MAJ[i] == reponseChar) {
					resultat = true;
				}
			}
        }
        return resultat;
    }
    
    
    /**
     * Affiche le menu de l'application
     */
    public static void afficherMenu() {
        System.out.println(TEXTE_DEBUT_MENU);
        
        // on affiche toutes les options et les libell\u00e9s
        for(int i = 0; i < OPTION.length; i++) {
            System.out.print("  " + OPTION[i] + " - " + LIBELLE[i]);
        }
        System.out.print("       ==> ");
    }
       
    
    /**
     * Affiche le menu pour l'utilisateur et saisit son choix.
     * L'action est r\u00e9p\u00e9t\u00e9e jusqu'\u00e0 obtenir un choix valide
     * @return un caract\u00e8re contenant le choix de l'utilisateur
     *         Si l'utilisateur a entr\u00e9 une lettre minuscule, c'est la majuscule
     *         correspondante qui est renvoy\u00e9e
     */
    public static char saisirOptionMenu() {
        String reponse;       // utilis\u00e9 pour la lecture de la r\u00e9ponse de l'utilisateur
        int i;                // indice de parcours du tableau OPTION
        
        // affiche le menu et saisit le choix, r\u00e9p\u00e9t\u00e9 jusqu'\u00e0 obtenir un choix valide
        do {            
            afficherMenu();
            reponse = entree.nextLine();
            if (! reponseValide(reponse)) {
                System.out.println("\n       ==> Ce choix n'est pas valide."
                                   + " Recommencez.\n\n");
            }
        } while (! reponseValide(reponse));     
        System.out.println();
        for(i = 0; i < OPTION.length && reponse.charAt(0) != OPTION[i]; i++);
        if (i < OPTION.length) {
            
            /*
             *  l'option saisie est une lettre minuscule (ou ?)
             *  On renvoie la majuscule \u00e9quivalente
             */
            return OPTION_MAJ[i];
            
        } else {
            // l'option saisie est une majuscule
            return reponse.charAt(0);
        }
    }
    
    
   
   
}
