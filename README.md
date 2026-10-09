# Find My Word 

Un jeu de devinette de mots entièrement développé en Java.

##  Description
**Find My Word** est un jeu interactif où le joueur doit deviner un mot caché. Ce projet personnel met en pratique les concepts de la programmation orientée objet (POO) en Java et utilise des fichiers JSON pour stocker et charger le dictionnaire de mots de manière dynamique.

##  Fonctionnalités
- Architecture Orientée Objet propre (séparation Modèle / Jeu).
- Chargement d'une banque de mots depuis un fichier JSON (`mots_fr_5_lettres_equilibres_1000.json`).
- Vérification des entrées utilisateur et système de tentatives.

##  Prérequis
- **Java Development Kit (JDK)** : Version 17 ou supérieure recommandée.
- **Bibliothèques externes** : Incluses dans le dossier `/lib` (pour la lecture du JSON).

##  Comment compiler et lancer le jeu

Si vous utilisez un IDE comme **Visual Studio Code**, **IntelliJ IDEA** ou **Eclipse**, vous pouvez simplement ouvrir le dossier du projet et exécuter le fichier `src/jeu/Main.java`.

Pour lancer le jeu en ligne de commande (terminal) depuis la racine du projet :

1. Compiler les fichiers Java :
javac -d bin -cp "lib/*" src/**/*.java

2. Exécuter le jeu (Sur Linux / WSL / macOS) :
java -cp "bin:lib/*" jeu.Main

3. Exécuter le jeu (Sur Windows) :
java -cp "bin;lib/*" jeu.Main

##  Auteur
- Jean-François Zhang
