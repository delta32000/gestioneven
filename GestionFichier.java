/*
 * Classe outil pour enregistrer et restaurer des événements            02/18
 * GestionFichier.java
 */
package exerciceconception.gestionevenement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Classe contenant les méthodes permettant de sauvegarder des événements en mémoire
 * permanente (dans un fichier). Ces méthodes se nomment enregistreFichier. L'une 
 * permet d'enregistrer les dates, l'autre les libellés des événements.
 * La classe contient également une méthode permettant de restaurer les événements
 * préalablement enregistrés.
 * @author INFO1
 * @version 1.0
 */
public class GestionFichier {
    /**
     * 
     * Nom du fichier dans lequel sont enregistrés les libellés des événements
     */
    private static final String FICHIER_LIBELLE = "libelle.dat";
    
    
    /**
     * Nom du fichier dans lequel sont enregistrés les dates des événements
     */
    private static final String FICHIER_DATE = "dateevenement.dat";
    
    
    /**
     * Sauvegarde des dates des événements et des libellés  dans 2 fichiers binaires
     * @param date  tableau contenant les dates des événements
     *              Ce tableau est sauvergardé dans un fichier binaire nommé
     *              FICHIER_DATE
     * @param libelle tableau contenant les libellés des événements 
     *                Ce tableau est sauvegardé dans un fichier binaire nommé
     *                FICHIER_LIBELLE
     */
    public static void enregistrerFichier(int[][] date, String[] libelle) {
        enregistrerFichier(date);
        enregistrerFichier(libelle);
    }
    
 
    /**
     * Sauvegarde des libellés dans un fichier binaire
     * @param libelle  tableau contenant les libellés des événements que l'on
     *                 souhaite enregistrer. Les libellés sont sauvegardés dans
     *                 le fichier FICHIER_LIBELLE
     */
    private static void enregistrerFichier(String[] libelle) {
        try {
            
            // déclaration et création d'un fichier binaire (mode écriture)
            ObjectOutputStream fluxEcriture = new ObjectOutputStream(
                                  new FileOutputStream(FICHIER_LIBELLE));
            
            // écriture de l'objet tableau de libellés dans le fichier
            fluxEcriture.writeObject(libelle);
            fluxEcriture.close() ;          // fermeture du fichier
        } catch (IOException e) {
            
            // exception levée si un problème survient lors de l'accès au fichier
            System.out.println ( "ERREUR écriture dans le fichier "
                                 + FICHIER_LIBELLE + ". Echec sauvegarde des"
                                 + " libellés des événements.");
        }
    }
    
    
    /**
     * Sauvegarde des dates des événements  dans un fichier binaire
     * @param date  tableau contenant les dates des événements
     *              Ce tableau est sauvergardé dans un fichier binaire nommé
     *              FICHIER_DATE
     */
    private static void enregistrerFichier(int[][] date) {
        try {
            
            // déclaration et création d'un fichier binaire (mode écriture)
            ObjectOutputStream fluxEcriture = new ObjectOutputStream(
                                  new FileOutputStream(FICHIER_DATE));
            
            // écriture de l'objet tableau de libellés dans le fichier
            fluxEcriture.writeObject(date);
            fluxEcriture.close() ;         // fermeture du fichier
        } catch (IOException e) {
            
            // exception levée si un problème survient lors de l'accès au fichier            
            System.out.println ( "ERREUR écriture dans le fichier "
                                 + FICHIER_LIBELLE + ". Echec sauvegarde des"
                                 + " dates des événements.");
        }
    }
    
    
   
    
    /**
     * Méthode permettant de restaurer les dates préalablement enregistrées 
     * dans le fichier FICHIER_DATE, et les libellés situés dans le fichier
     * FICHIER_LIBELLE
     * @param date    tableau dans lequel la méthode recopie les dates
     *                trouvées dans le fichier. Le tableau doit être créé par
     *                l'appelant de la méthode.
     * @param libelle  tableau dans lequel la méthode recopie les libellés
     *                 trouvés dans le fichier. Le tableau doit être créé par
     *                 l'appelant de la méthode.
     */
    public static void restaurerContexte(int[][] date, String[] libelle) {
        restaurerContexte(date);
        restaurerContexte(libelle);
    }
    
    
    
    /**
     * Méthode permettant de restaurer les dates préalablement enregistrées 
     * dans le fichier FICHIER_DATE
     * @param date    tableau dans lequel la méthode recopie les dates
     *                trouvées dans le fichier. Le tableau doit être créé par
     *                l'appelant de la méthode.
     */
    private static void restaurerContexte(int[][] date) {
        int[][] dateLue = null;    
        
        date[0][0] = -1;          // aucune date restaurée pour l'instant
        date[0][1] = -1;
        
        try {
            
            // déclaration et création d'un fichier binaire (mode lecture)
            ObjectInputStream fluxLecture = new ObjectInputStream(
                                  new FileInputStream(FICHIER_DATE));
            dateLue= (int[][]) fluxLecture.readObject();
            fluxLecture.close() ;
        } catch (IOException e) {
           
            // exception levée si un problème survient lors de l'accès au fichier     
            System.out.println ( "ERREUR lecture dans le fichier "
                                 + FICHIER_DATE + ". Echec restauration des"
                                 + " dates.");
        } catch (ClassCastException err) {
            
            // le fichier ne contient pas un tableau de chaînes de caractères
            System.out.println("ERREUR lecture dans le fichier "
                               + FICHIER_LIBELLE + ".Le contenu du fichier " 
                               + "n'est pas du type attendu.");
        } catch (ClassNotFoundException err) {
            
            // le fichier ne contient pas un objet
            System.out.println("ERREUR lecture dans le fichier "
                               + FICHIER_DATE + ".Le contenu du fichier " 
                               + "n'est pas du type attendu.");
        }
        
        // initialisation du tableau libellé
        if (dateLue != null) {
            
            // on recopie chaque libellé lu dans le tableau paramètre libellé
            for (int i = 0;  i < dateLue.length && i < date.length; i++ ) {   
                if (dateLue[i].length == 2) {
                    date[i][0] = dateLue[i][0];
                    date[i][1] = dateLue[i][1];
                } else {
                    System.out.println("ATTENTION une information contenue dans le "
                            + "fichier " + FICHIER_DATE + " n'est pas une date. "
                            + "Elle ne sera pas prise en compte.");
                }
         }
            
            // vérification du nombre de libellés
            if (dateLue.length > date.length && dateLue[date.length][0] != -1) {
                
                // le fichier contient plus de dates que le tableau date
                System.out.println("ATTENTION les dates contenues dans le fichier "
                                   + FICHIER_DATE + " sont trop nombreuses. Les dernières" 
                                   + " ne sont pas restaurées.");
            }
        }
    }
    
    /**
     * Méthode permettant de restaurer les libellés préalablement enregistrés 
     * dans le fichier FICHIER_LIBELLE
     * @param libelle  tableau dans lequel la méthode recopie les libellés
     *                 trouvés dans le fichier. Le tableau doit être créé par
     *                 l'appelant de la méthode.
     */
    private static void restaurerContexte(String[] libelle) {
        String[] objetLu = null;    
        
        libelle[0] = null;          // aucun libellé restauré pour l'instant
        try {
            
            // déclaration et création d'un fichier binaire (mode lecture)
            ObjectInputStream fluxLecture = new ObjectInputStream(
                                  new FileInputStream(FICHIER_LIBELLE));
            objetLu = (String[]) fluxLecture.readObject();
            fluxLecture.close() ;
        } catch (IOException e) {
           
            // exception levée si un problème survient lors de l'accès au fichier     
            System.out.println ( "ERREUR lecture dans le fichier "
                                 + FICHIER_LIBELLE + ". Echec restauration des"
                                 + " libellés.");
        } catch (ClassCastException err) {
            
            // le fichier ne contient pas un tableau de chaînes de caractères
            System.out.println("ERREUR lecture dans le fichier "
                               + FICHIER_LIBELLE + ".Le contenu du fichier " 
                               + "n'est pas du type attendu.");
        } catch (ClassNotFoundException err) {
            
            // le fichier ne contient pas un objet
            System.out.println("ERREUR lecture dans le fichier "
                               + FICHIER_LIBELLE + ".Le contenu du fichier " 
                               + "n'est pas du type attendu.");
        }
        
        // initialisation du tableau libellé
        if (objetLu != null) {
            
            // on recopie chaque libellé lu dans le tableau paramètre libellé
            for (int i = 0;  i < objetLu.length && i < libelle.length; i++ ) {     
                   libelle[i] = objetLu[i];
            }
            
            // vérification du nombre de libellés
            if (objetLu.length > libelle.length && objetLu[libelle.length] != null) {
                
                // le fichier contient plus de libellés que le tableau libelle
                System.out.println("ATTENTION les libellés contenus dans le fichier "
                                   + FICHIER_LIBELLE + " sont trop nombreux. Les derniers" 
                                   + " ne sont pas restaurés.");
            }
        }
    }
    
    
    
    /**
     * Programme principal. Permet de tester la sauvegarde et la restauration
     * dans le cas normal
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {
        
        // constantes contenant les événements standard qui seront enregistrés
        final int[][] DATE_STANDARD = { {1, 1}, {14,2}, {21, 6}, {15, 8}, {25, 12}, {31, 12}};
        final String[] LIBELLE_STANDARD = { "Jour de l'an", "Saint Valentin", 
                                            "Fête de la musique", "Jour férié, 15 août",
                                            "Jour de Noël", "Réveillon"};
        
        // tableaux qui recevront les événements préalablement restaurés
        int[][] dateAGerer = new int[5][2];
        String[] libelleEven = new String[5];  
        
        // sauvegarde des tableaus standards
        enregistrerFichier(DATE_STANDARD, LIBELLE_STANDARD);
        
        // restauration dans les deux autres tableaux
        restaurerContexte(dateAGerer,libelleEven);
        
        // affichage pour vérification
        System.out.println("Après restauration :");
        for (int i = 0;  i < libelleEven.length; i++ ) {
            if (libelleEven[i] != null) {
                System.out.println(libelleEven[i] + "  "
                                   + OutilDate.jourMoisEnChaine(dateAGerer[i]));
            }
        }        
        System.out.println("Fin test fichier.");
    }
}
