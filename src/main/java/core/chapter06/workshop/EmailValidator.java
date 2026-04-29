package core.chapter06.workshop;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9_%+-]+(\\.[A-Za-z0-9_%+-]+)*@[A-Za-z0-9]+(-[A-Za-z0-9]+)*(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$"
            // ^[A-Za-z0-9_%+-]+ -> La partie locale commence par au moins un caractère autorisé (partie utilisateur donc généralement nom+prénom)
            // (\.[A-Za-z0-9_%+-]+)* -> Autorise les points mais pas au début ni à la fin, et pas deux points d'affilée.
            // @ Séparateur entre la partie locale et la partie domaine
            // [A-Za-z0-9-]+(-[A-Za-z0-9]+)* -> Nom de domaine avec position du tiret
            // (\.[A-Za-z0-9-]+)* -> Sous-domaines éventuels
            // \.[A-Za-z]{2,}$ -> Extension finale (.fr, .com, .org, etc..)
    );

    public static ValidationResult validate(String email) {
        if (email == null) {
            return new ValidationResult(false, "L'adresse est null");
        }

        if (email.isBlank()) {
            return new ValidationResult(false, "L'adresse est vide");
        }

        if (!email.contains("@")) {
            return new ValidationResult(false, "Il manque le caractère '@'");
        }

        if (email.indexOf("@") != email.lastIndexOf("@")) {
            return new ValidationResult(false, "Il y a plusieurs caractères '@'");
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            return new ValidationResult(false, "Le format de l'adresse est invalide");
        }

        return new ValidationResult(true, "Adresse valide");
    }

    public static void main(String[] args) {

        /*
        Il existe plein d'outils présents sur Internet pour vérifier la validité d'une adresse mail, avec des niveaux de fiabilités et d'intrusion variables.
        1. Validation simple
            Vérifie le format de l'adresse mail -> ex : Apache Commons Validator
            Très rapide et facile à intégrer, pas d'appel réseau mais ne garantit pas que l'adresse existe réellement
            Utilisés dans les formulaires d'inscriptions

        2. Vérification du domaine
            Interrogiation du DNS pour voir si le domaine possède un serveur mail -> ex : dnsjava
            Rapide, détecte les faux domaine mais ne garantit pas que la boîte existe, certains domaines acceptent tous les emails (catch-all)

        3. Vérification SMTP (Simple Mail Transfer Protocol)
            Méthode la plus "poussée"
            Simulation d'une conversation SMTP sans envoyer d'email -> ex : EmailVerifier
            Peut confirmer si la boîte existe réellement mais beaucoup de serveurs bloquent cette pratique, c'est plus lent et plus complexe
            et le résultat peut parfois s'avérer faux (anti-spam, greylisting)

        4. Services en ligne (API complètes)
            Solutions les plus utilisées en production -> ex : Hunter.io, Kickbox...
            Combinaisons de plusieurs techniques :
                - Validation syntaxique
                - vérification DNS
                - test SMTP
                - détection d'emails temporaires
                - détection de catch-all
                - scoring de confiance

            Ces services sont très précis, faciles à intégrer (API REST) avec une maintenance externalisée
            MAIS ils sont payants à grande échelle et dépendent d'un service externe

         5. Vérification par confirmation
            L'utilisateur saisit son email et clique sur le lien de confirmation qui lui a été envoyé, conforme aux bonnes pratiques et souvent obligatoire
            mais nécessite une action utilisateur

         6. Cas particulier mentionnés au dessus
            Emails temporaires (Mailinator) permet de créer des adresses mails jetables (beaucoup d'API les détectent automatiquement)
            Catch-all, certains domaines acceptent toutes les adresses (impossible à valider précisément sans interaction réelle)

         7. Combinaison idéale en pratique
            1/ Validation Syntaxique
            2/ Vérification DNS
            3/ (Optionnel) API externe
            4/ Confirmation par email (indispensable)
         */

        /*
        --------------------REGEX---------------------
        Les expressions régulières REGEX sont des motifs (chaîne de caractères) qui servent à reconnaître, chercher, extraire ou remplacer du texte.
        Elles sont aujourd'hui utilisées principalement pour programmer des logiciels avec des fonctionnalités de lecture, de contrôle, de modification,
        et d'analyse de textes ainsiq ue dans la manipulation des langues formelles que sont les langages informatiques.

        Elles ont la qualité de pouvoir être décrites par des "patterns".

        Il y a 3 classes clés dans le package java.util.regex :
            - Pattern (Représente une regex compilée)
            - Matcher (Applique une regex sur un texte)
            - PatternSyntaxException (Erreur si la regex est mal écrite)

        Quelques méthodes à connaître :
            - matches() (Vérifie si toute la chaîne correspond)
            - find() (Cherche une occurrence dans la chaîne)
            - group() (Récupère ce qui a été trouvé)
            - replaceAll() (Remplace toutes les occurrences)
            - split() (Découpe une chaîne selon une regex)

        Symboles regex essentiels :
            - . (n'importe quel caractère)
            - \\d (chiffre 0 à 9)
            - \\w (caractère de mot, lettre, chiffre, _)
            - \\s (espace blanc, tabulation, retour ligne)

        Quantificateurs :
            - * (0 ou plusieurs fois)
            - + (1 ou plusieurs fois)
            - ? (0 ou 1 fois)
            - {3} (exactement 3 fois)
            - {2, 5} (2 à 5 fois)
            - {2,} (au moins 2 fois)

        Classes de caractères :
            - [abc] (a, b ou c)
            - [a-z] (lettre minuscule)
            - [A-Z] (lettre majuscule)
            - [0-9] (chiffre)
            - [^0-9] (tout sauf chiffre)

        Ancres :
            - ^ (début de chaîne)
            - $ (fin de chaîne)
            - \\b (frontière de mot)

        Cas d'usage courants :
            - Validation (email, téléphone, code postal..)
            - Extraction (récupérer un nombre, une date, un identifiant..)
            - Recherche (trouver tous les mots commençant par une majuscule etc..)
            - Nettoyage (supprimer espaces multiples..)
            - Remplacement (anonymiser des données..)
            - Découpage (séparer une ligne CSV simple..)

        Points forts :
            - Très puissantes pour traiter du texte
            - Compactes
            - Disponibles dans beaucoup de langages
            - Rapides pour des cas simples
            - Très utile pour validation, recherche, remplacement

        Limites :
            - Format complexe
            - Beaucoup de cas particuliers
            - Texte imbriqué
            - Règle métier difficile à lire
            - Regex illisibles ?

            Exemples à éviter :
                - parser du HTML/JSON complet
                - valider parfaitement une adresse e-mail selon toutes les RFC
                - vérifier qu'une adresse mail existe réellement
         */

        String[] emails = {
                "alice@example.com",
                "bob.smith+promo-2025@news.marketing.example.com",
                "\"john, q public\"@example.org",
                "charlie..brown@example.com",
                "diane@-example.net"
        };

        for (String email : emails) {
            ValidationResult result = EmailValidator.validate(email);

            System.out.println(email + " -> " + result.isValidString() + " : " + result.getMessage());
        }

        System.out.println("Veuillez entrer votre adresse mail : ");
        Scanner scanner = new Scanner(System.in);
        String userEmail = scanner.nextLine();

        ValidationResult userResult = EmailValidator.validate(userEmail);

        System.out.println(userEmail + " -> " + userResult.isValidString() + " : " + userResult.getMessage());

    }

}
