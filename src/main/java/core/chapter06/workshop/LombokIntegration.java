package core.chapter06.workshop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LombokIntegration {

    private String name;
    private int age;

    public String getName() {
        System.out.println("this is my getter, not lombok's");
        return name;
    }
    // Le print est bien affiché dans la console avant le print de la méthode main

    public static void main(String[] args) {

        // Que permet Lombok ?
        /*
        Automatiser la création de méthodes telles que les getters, les setters, les constructeurs,
        // les méthodes equals, hashCode et toString grâce aux annotations. Il réduit la quantité de code boilerplate
         */

        // Comment l'utiliser ?
        /*
        Après avoir ajouter la dépendance lombok via Maven (pom.xml) il faut activer les "annotations processors" dans les paramètres de intelliJ dans le compiler
        et installer le plugin lombok dans intelliJ, un reload Maven project et c'est parti
         */

        // Infos clés à retenir le concernant ?
        /*
        1. Il élimine le code répétitif
        2. Il fonctionne avec des annotations (@)
        3. @Data et @Builder sont les plus utilisés
        3.1 @Data regroupe les getter setter toString equals hashCode et requiredArgsConstructor (principalement utilisés pour les DTO (Data Transfer Object)
        3.2 @Builder permet une plus grande flexibilité et lisibilité lors d'une instanciation d'objet avec beaucoup de champs
        4. Configuration nécessaire de l'IDE
        5. Il fonctionne à la compilation, pas à l'exécution
        6. Il ne remplace pas la compréhension de Java (il automatise seulement)
         */

        LombokIntegration lombok = new LombokIntegration();
        lombok.setName("lombokk");
        lombok.setAge(16);

        System.out.println("Le projet " + lombok.getName() + " a maintenant " + lombok.getAge() + " ans !");

        /*
        Recherche sur Defensive et Deep copy
        Prompt : J'aimerai en savoir plus sur les notions "defensive copy" et "deep copy" qui sont en lien avec les Getters et les Setters en Java

        Defensive Copy : Consiste à copier un objet avant de le stocker ou de le retourner, pour éviter qu'il soit modifié de l'extérieur
        Elle protège des effets de bord, très important avec les List, Map et objets mutables
        Par exemple sans la defensive copy on peut modifier un objet sans passer par lui directement.

        Deep Copy : Consiste à copier tout l'objet ainsi que ce qu'il contient, récursivement
        Liste, sous liste tout est copié, aucune référence n'est partagée

        En résumé :
        - Defensive = protéger
        - Deep = copier toute la structure
         */

    }

}
