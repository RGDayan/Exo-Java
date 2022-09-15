import Bergerie.Animal;
import Magasin.Auteur;
import Magasin.Dvd;
import Magasin.Livre;
import Magasin.Realisateur;
import Mails.Complement;
import Mails.Domaine;
import Mails.Mail;
import Mails.Nom;

import java.time.Duration;
import java.time.OffsetTime;
import java.util.*;

public class Main {

    /**
     * Exécution du programme
     * @param args Parametre du lancement
     */
    public static void main(String[] args){
//        Exo_Animaux();
//
        Exo_Magasin();

        Exo_Mail_Fournisseur();

//        Exo_Pair_Impair();
//
//        Exo_justePrix();
    }

    //region EXERCICES POO

    //region EXERCICE BERGERIE
    public static void Exo_Animaux(){
        /* EXERCICE ANIMAUX*/

         List<Animal> animaux = new ArrayList<>();
         Bergerie.Maitre maitre = new Bergerie.Maitre("CLément", 28 , animaux);

         animaux.add(new Bergerie.Chat("Emile", 36));
         animaux.add(new Bergerie.Chien("Virgile", 25));
         animaux.add(new Bergerie.Chien("Dante", 25));
         animaux.add(new Bergerie.Chat("Sparda", 508));

         System.out.println(maitre);
    }
    //endregion

    //region EXERCICE MAGASIN
    public static void Exo_Magasin(){

        /* EXERCICE MAGASIN*/
         Auteur auteur1 = new Auteur("Tolkien", "John", "3 janvier 1892" ,81,"Tolkien" );

         new Livre("L001", "Le Seigneur des Anneaux - La confrérie de l'Anneau", 39,
         "LSDA001", 722, auteur1);
         new Livre("L002", "Le Seigneur des Anneaux - Les deux tours", 39 ,
         "LSDA002", 597, auteur1);
         new Livre("L003", "Le Seigneur des Anneaux - Le retour du roi", 39,
         "LSDA003", 722, auteur1);

         Realisateur realisateur1 = new Realisateur("Buck", "Chris", "24 février 1958", 76, "Disney");

         new Dvd("D001", "La Reine des Neiges", 10, 109, realisateur1);
         new Dvd("D002", "Tarzan", 9, 88, realisateur1);


         for (Livre livre: auteur1.getBibliographie()) {
         System.out.println(livre.toString());
         }


         for (Dvd dvd: realisateur1.getDiscographie()) {
         System.out.println(dvd.toString());
         }


    }
    //endregion

    //endregion

    //region EXERCICE PROGRA DURE

    //region EXERCICE MAIL FOURNISSEUR
    public static void Exo_Mail_Fournisseur(){
        Mail[] adresses = new Mail[10];

        //region CONSTRUCTION DES ADRESSE RANDOM DEPUIS LES ENUMERATIONS
        for (int i = 0; i < adresses.length; i++) {
            Nom nom = Nom.RandomNom();
            Domaine addr = Domaine.RandomDomaine();
            Complement comp = null;

            switch (addr) {
                case gmail, hotmail -> comp = Complement.com;
                case orange, outlook, wanadoo -> comp = Complement.fr;
            }

            Mail adresse = new Mail(nom, addr, comp);

            while (Arrays.stream(adresses).noneMatch(s -> s == adresse)){
                adresses[i] = adresse;
            }

            System.out.println(adresses[i]);
        }
        //endregion

        //region RECUPERATION DU NOMBRE D'ADRESSE PAR FOURNISSEUR
        int nbFournisseur = Domaine.values().length;
        Integer[] nbAdresse_par_fournisseur = new Integer[nbFournisseur];
        for (int i = 0; i < nbFournisseur; i++) {
            nbAdresse_par_fournisseur[i] = 0;
        }

        for (Mail adresse: adresses) {
            int num_domaine = adresse.getDomaine().ordinal();
            nbAdresse_par_fournisseur[num_domaine] += 1;
        }
        //endregion

        //region CALCUL DES PARTS DE MARCHES
        Integer[] part_par_fournisseur = new Integer[nbFournisseur];

        for (int i = 0; i < nbFournisseur; i++) {
            double nb_un_fournisseur = (double)nbAdresse_par_fournisseur[i];
            double part_un_fournisseur = (nb_un_fournisseur / adresses.length) * 100;
            part_par_fournisseur[i] = (int)Math.round(part_un_fournisseur);
        }
        //endregion

        // AFFICHAGE
        for (int i = 0; i < nbFournisseur; i++) {
            System.out.println("Le fournisseur " + Domaine.values()[i] + " a " + part_par_fournisseur[i].toString() + "% de part de marché.");
        }

    }
    //endregion

    //region EXERCICE PAIR IMPAIR
    public static void Exo_Pair_Impair(){
        int nbCoups = 0;
        boolean combinaison = false;

        boolean[] resultats = new boolean[3];

        while (!combinaison){

            nbCoups++;
            for (int i = 0; i < resultats.length; i++) {
                int entier = new Random().nextInt(1,1000);
                resultats[i] = ((entier % 2) == 0 );

                System.out.println("L'entier " + entier + " est pair : " + resultats[i]);
            }

            System.out.println("Numéro du coup " + nbCoups);

            if (resultats[0] && resultats[1] && !resultats[2]){
                combinaison = true;
            }

        }

        System.out.println("Résultat obtenu au coups " + nbCoups);

    }
    //endregion

    //region EXERCICE JUSTE PRIX (3+4)
    public static void Exo_justePrix(){
        // INITIALISATION DE LA REPONSE
        final int reponse = new Random().nextInt(1,1000);
        int nbCoups = 0;
        boolean erreur = false;
        boolean reponse_trouve = false;

        OffsetTime temps_depart = OffsetTime.now();

        // INTRO
        System.out.println(" ============= LE JEU DU JUSTE PRIX ============= ");
        System.out.println("Le joueur propose un nombre entre 1 et 1000.");
        System.out.println("Je lui indiquerais si la réponse est plus ou moins que sa proposition.");
        System.out.println("S'il trouve, il gagne !");
        System.out.println("\nProposez votre nombre : ");

        // JEU
        while(erreur || !reponse_trouve){

            // INCREMENTATION DU NOMBRE DE COUPS JOUES
            nbCoups++;

            try {
                // RECUPERATION DE LA SAISIE
                String saisie_utilisateur = new Scanner(System.in).nextLine();
                int reponse_utilisateur = Integer.parseInt(saisie_utilisateur);

                // GESTION DE L'ERREUR : EN DEHORS DES CLOUS
                if (reponse_utilisateur > 1000 || reponse_utilisateur < 1){
                    erreur = true;
                    System.out.println("Erreur : Le chiffre doit être compris entre 1 et 1000");
                }

                // PLUS OU MOINS OU TROUVE
                if (reponse_utilisateur > reponse){
                    System.out.println("En dessous");
                } else if (reponse_utilisateur < reponse) {
                    System.out.println("Au Dessus");
                } else {
                    reponse_trouve = true;
                    System.out.println("Reponse trouvée, Le chiffre saisi est " + reponse_utilisateur + " ET le bon prix est : " + reponse + ".");
                }

            }catch (Exception exception){
                // GESTION DE L'ERREUR : SAISI N'IMPORTE QUOI
                erreur = true;
                System.out.println("Erreur : La saisie doit être un nombre compris entre 1 et 1000");
            }
        }
        OffsetTime temps_arrivee = OffsetTime.now();
        Duration duree = Duration.between(temps_depart, temps_arrivee);

        System.out.println("Vous avez mis " + duree.getSeconds() + " secondes de temps pour trouver.");
        System.out.println("Vous avez trouvé la réponse en " + nbCoups + " coups !");
        System.out.println(" ==================== FELICITATION ==================== ");
    }
    //endregion (2

    //endregion
}
