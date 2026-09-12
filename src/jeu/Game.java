package jeu;

import modele.Word;
import modele.WordRepository;
import modele.JsonWordRepository;
import java.util.Scanner;

public class Game {
    
    private Word motSecret;
    private int essaisRestants;

    public Game() {
        // Le constructeur est vide maintenant.
        // On initialise tout dans start() pour pouvoir recommencer à l'infini.
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean veutRejouer = true;

        // GRANDE BOUCLE : Gère le fait d'enchaîner plusieurs parties
        while (veutRejouer == true) {
            
            // 1. Préparation de la nouvelle manche
            this.essaisRestants = 6;
            WordRepository repo = new JsonWordRepository("mots_fr_5_lettres_equilibres_1000.json");
            this.motSecret = repo.getWord();

            System.out.println("JEU FIND MY WORD");

            boolean gagne = false;
            long tempsDebut = System.currentTimeMillis();

            // 2. PETITE BOUCLE : Gère les 6 essais de la manche en cours
            while (this.essaisRestants > 0) {
                System.out.println("\nEssais restants : " + this.essaisRestants);
                System.out.print("Propose un mot de 5 lettres : ");
                
                String saisie = scanner.nextLine();

                //  Bloque les lettres en double 
                while (contientLettresEnDouble(saisie)) {
                    System.out.println("Erreur : Vous ne pouvez pas proposer plusieurs fois la même lettre.");
                    System.out.print("Propose un autre mot : ");
                    saisie = scanner.nextLine();
                }


                Word proposition = new Word(saisie);

                if (proposition.getValue().length() != 5) {
                    System.out.println("Erreur : Le mot doit contenir 5 lettres.");
                    continue; 
                }

                String[] resultat = proposition.compareWith(this.motSecret);
                
                System.out.print("Résultat : ");
                for (int i = 0; i < resultat.length; i++) {
                    System.out.print(resultat[i] + " ");
                }
                System.out.println();

                if (proposition.getValue().equals(this.motSecret.getValue())) {
                    long tempsFin = System.currentTimeMillis();
                    long tempsSecondes = (tempsFin - tempsDebut) / 1000;

                    System.out.println("\nBRAVO ! Tu as trouve le mot secret.");
                    System.out.println("Temps : " + tempsSecondes + " secondes.");
                    gagne = true;
                    break; 
                }
                
                this.essaisRestants--;
            }

            if (gagne == false) {
                System.out.println("\nPERDU !");
                System.out.println("Le mot secret etait : " + this.motSecret.getValue());
            }

            // 3. Fin de la manche : on demande au joueur s'il veut continuer
            System.out.print("\nVoulez-vous rejouer une partie ? (O/N) : ");
            String reponse = scanner.nextLine();

            // Si le joueur tape 'N' ou 'n', on casse la grande boucle
            if (reponse.equals("N") || reponse.equals("n")) {
                veutRejouer = false;
                System.out.println("Merci d'avoir joue ! A bientot.");
            }
        }

        // On ferme le scanner tout à la fin, quand on quitte vraiment l'application
        scanner.close();
    }

    //  Vérifie si le mot contient des doublons 
    private boolean contientLettresEnDouble(String saisie) {
        // On compare chaque lettre avec toutes les lettres suivantes
        for (int i = 0; i < saisie.length(); i++) {
            for (int j = i + 1; j < saisie.length(); j++) {
                if (saisie.charAt(i) == saisie.charAt(j)) {
                    return true; 
                }
            }
        }
        return false; 
    }
}