package modele;

public class Word {
    
    private String mot;

    public Word(String mot) {
        this.mot = mot.toUpperCase();
    }

    public String getValue() {
        return this.mot;
    }

    public String[] compareWith(Word motSecret) {
        String proposition = this.mot;
        String cible = motSecret.getValue();

        if (proposition.length() != 5 || cible.length() != 5) {
            System.out.println("Erreur : Les mots doivent faire exactement 5 lettres.");
            return new String[5];
        }

        String[] resultat = new String[5];
        int[] occurences = new int[26];

        // On référence les lettres du mot secret
        for (int i = 0; i < 5; i++) {
            char lettre = cible.charAt(i);
            occurences[lettre - 'A']++;
        }

        // On cherche d'abord les lettres bien placées (OK)
        for (int i = 0; i < 5; i++) {
            if (proposition.charAt(i) == cible.charAt(i)) {
                resultat[i] = "OK";
                occurences[proposition.charAt(i) - 'A']--; 
            }
        }

        // On cherche ensuite les lettres mal placées (PRESENT)
        for (int i = 0; i < 5; i++) {
            if (resultat[i] != null) {
                continue;
            }

            char lettre = proposition.charAt(i);
            int index = lettre - 'A';

            if (index >= 0 && index < 26 && occurences[index] > 0) {
                resultat[i] = "PRESENT";
                occurences[index]--;
            } else {
                resultat[i] = "ABSENT";
            }
        }
        
        return resultat;
    }
}