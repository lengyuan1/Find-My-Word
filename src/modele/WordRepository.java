package modele;

// Classe abstraite pour mettre en place le polymorphisme
public abstract class WordRepository {
    
    // Signature de la méthode (les classes filles devront l'écrire)
    public abstract Word getWord();
}