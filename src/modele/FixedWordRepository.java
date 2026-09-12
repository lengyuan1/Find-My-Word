package modele;

public class FixedWordRepository extends WordRepository {
    
    private Word motFixe;

    public FixedWordRepository(String mot) {
        this.motFixe = new Word(mot);
    }

    // On implémente la méthode de la classe mère
    public Word getWord() {
        return this.motFixe;
    }
}