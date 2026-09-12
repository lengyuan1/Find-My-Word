package modele;

import words.WordSet;
import words.JsonWordSet;

public class JsonWordRepository extends WordRepository {
    
    private String cheminFichier;
    private WordSet dictionnaire; 

    public JsonWordRepository(String cheminFichier) {
        this.cheminFichier = cheminFichier;
        try {
            this.dictionnaire = new JsonWordSet(this.cheminFichier);
        } catch (Exception e) {
            System.out.println("Erreur : Impossible de lire le fichier JSON.");
        }
    }

    // On implémente la méthode de la classe mère
    public Word getWord() {
        String motPioche = this.dictionnaire.random();
        return new Word(motPioche);
    }
}