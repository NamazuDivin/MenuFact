package code.menufact;

import code.ingredients.*;
import code.inventaire.Inventaire;
import code.menufact.facture.Facture;
import code.menufact.plats.*;

public class TestMenuFact01 {
    public static void main(String[] args) {

        try {
            System.out.println("===factory Laitier");
            FactoryLaitier laitier = new FactoryLaitier();
            System.out.println(laitier);

            System.out.println("===factory Legume");
            FactoryLegume legume = new FactoryLegume();
            System.out.println(legume);

            System.out.println("===factory Epice");
            FactoryEpice epice = new FactoryEpice();
            System.out.println(epice);

            System.out.println("===factory viande");
            FactoryViande viande = new FactoryViande();
            System.out.println(viande);

            System.out.println("===factory Fruit");
            FactoryFruit fruit = new FactoryFruit();
            System.out.println(fruit);

            System.out.println("===fruit pomme");
            Ingredient pomme = fruit.creerIngredient();
            System.out.println(pomme);

            System.out.println("===legume patate");
            Ingredient patate = legume.creerIngredient();
            System.out.println(patate);

            System.out.println("===legume laitue");
            Ingredient laitue = legume.creerIngredient();
            System.out.println(laitue);

            System.out.println("===laitier fromage");
            Ingredient fromage = laitier.creerIngredient();
            System.out.println(fromage);

            System.out.println("===epice vinaigrette");
            Ingredient vinaigrette = epice.creerIngredient();
            System.out.println(vinaigrette);

            System.out.println("===epice sauce");
            Ingredient sauce = epice.creerIngredient();
            System.out.println(sauce);

            System.out.println("===viande bacon");
            Ingredient bacon = fruit.creerIngredient();
            System.out.println(bacon);

            System.out.println("===Inventaire");
            Inventaire inventaire = Inventaire.getInstance();
            inventaire.ajouter(pomme, 300);
            inventaire.ajouter(laitue, 300);
            inventaire.ajouter(fromage, 300);
            inventaire.ajouter(vinaigrette, 500);
            inventaire.ajouter(sauce, 2000);
            inventaire.ajouter(bacon, 300);
            inventaire.ajouter(patate, 5000);
            System.out.println(inventaire);

            System.out.println("===recette builder");
            RecetteBuilder recettes = new RecetteBuilder();
            System.out.println(bacon);

            System.out.println("===recette salade");
            Recette salade = recettes.ajouterIngredient(laitue,300,"g")
                    .ajouterIngredient(vinaigrette, 200, "ml")
                    .build();
            System.out.println(salade);

            System.out.println("===recette cesar");
            Recette cesar = recettes.ajouterIngredient(laitue,300,"g")
                    .ajouterIngredient(vinaigrette, 200, "ml")
                    .ajouterIngredient(fromage, 10, "g")
                    .ajouterIngredient(bacon, 10, "g")
                    .build();
            System.out.println(cesar);

            System.out.println("===recette frite");
            Recette frite = recettes.ajouterIngredient(patate,1,"lb")
                    .build();
            System.out.println(frite);

            System.out.println("===recette friteSauce");
            Recette friteSauce = recettes.ajouterIngredient(sauce,15,"ml")
                    .ajouterIngredient(patate,1,"lb")
                    .build();
            System.out.println(friteSauce);

            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
            PlatAuMenu p1 = new PlatAuMenu(0, "Frites sauce", 11.50);
            p1.setRecette(friteSauce);
            System.out.println(p1);

            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
            PlatAuMenu p2 = new PlatAuMenu(1, "Frites", 10.25);
            p2.setRecette(frite);
            System.out.println(p2);

            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
            PlatSante ps1 = new PlatSante(2, "Salade", 5.25, 100, 10, 1);
            ps1.setRecette(salade);
            System.out.println(ps1);

            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
            PlatSante ps2 = new PlatSante(3, "Salade Cesar", 8.25, 100, 10, 1);
            ps2.setRecette(cesar);
            System.out.println(ps2);

            System.out.println("===menufact.Menu ajout avec 4 plats");
            Menu menu = Menu.getInstance("Menu1");
            menu.ajoute(p1);
            menu.ajoute(p2);
            menu.ajoute(ps1);
            menu.ajoute(ps2);
            System.out.println(menu);

            System.out.println("===menufact.Menu position 1, plat à la position 0");
            menu.position(0);
            System.out.println(menu.platCourant());

            System.out.println("===menufact.Menu position 1, plat à la position suivante 1");
            menu.positionSuivante();
            System.out.println(menu.platCourant());

            System.out.println("== Plat choisi");
            PlatChoisi pch1 = new PlatChoisi(p1, 1);
            System.out.println(pch1);

            System.out.println("== New menufact.facture.Facture");
            Facture facture = new Facture("Ma facture");
            System.out.println(facture);

            System.out.println("== Ajout d'un plat choisie à la facture");
            facture.ajoutePlat(pch1);
            System.out.println(pch1.getEtat());
            System.out.println(inventaire.getQuantite(patate));
            System.out.println(facture);
            System.out.println(facture.sousTotal());

            System.out.println("== Ajout d'un plat choisie à la facture");
            PlatChoisi pch2 = new PlatChoisi(p2, 10);
            facture.ajoutePlat(pch2);
            System.out.println(pch2.getEtat());
            System.out.println(facture);
            System.out.println(facture.sousTotal());

            System.out.println(facture.total());
            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.fermer();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.payer();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());
        }catch (Exception fe)
        {
            System.out.println(fe.getMessage());
        }

    }
}
