package code.menufact;

import code.ingredients.*;
import code.inventaire.Inventaire;
import code.menufact.exceptions.MenuException;
import code.menufact.plats.PlatAuMenu;
import code.menufact.plats.PlatSante;
import code.menufact.facture.Facture;

import code.menufact.plats.Recette;
import code.menufact.plats.RecetteBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuSingletonTest {

    FactoryLaitier laitier = new FactoryLaitier();
    FactoryLegume legume = new FactoryLegume();
    FactoryEpice epice = new FactoryEpice();
    FactoryViande viande = new FactoryViande();
    FactoryFruit fruit = new FactoryFruit();
    Ingredient pomme = fruit.creerIngredient();
    Ingredient patate = legume.creerIngredient();
    Ingredient laitue = legume.creerIngredient();
    Ingredient fromage = laitier.creerIngredient();
    Ingredient vinaigrette = epice.creerIngredient();
    Ingredient sauce = epice.creerIngredient();
    Ingredient bacon = fruit.creerIngredient();
    Inventaire inventaire = Inventaire.getInstance();
    RecetteBuilder recettes = new RecetteBuilder();
    Recette salade, cesar, frite, friteSauce;
    @BeforeEach
    void setup() throws Exception {
        inventaire.ajouter(pomme, 300);
        inventaire.ajouter(laitue, 300);
        inventaire.ajouter(fromage, 300);
        inventaire.ajouter(vinaigrette, 500);
        inventaire.ajouter(sauce, 2000);
        inventaire.ajouter(bacon, 300);
        inventaire.ajouter(patate, 5000);

        salade = recettes.ajouterIngredient(laitue, 300, "g")
                .ajouterIngredient(vinaigrette, 200, "ml")
                .build();
        cesar = recettes.ajouterIngredient(laitue, 300, "g")
                .ajouterIngredient(vinaigrette, 200, "ml")
                .ajouterIngredient(fromage, 10, "g")
                .ajouterIngredient(bacon, 10, "g")
                .build();
        frite = recettes.ajouterIngredient(patate, 1, "lb")
                .build();
        friteSauce = recettes.ajouterIngredient(sauce, 15, "ml")
                .ajouterIngredient(patate, 1, "lb")
                .build();
    }
    @Test
    void testMenuInstanceSingleton() {
        Menu menu01 = Menu.getInstance("menu01");
        Menu menu02 = Menu.getInstance("menu02");
        assertSame(menu01, menu02);
    }

    @Test
    void testMenuInstanceDescriptionSingleton() {
        Menu menu01 = Menu.getInstance("menu01");
        Menu menu02 = Menu.getInstance("menu02");
        assertEquals(menu01.toString(), menu02.toString());
    }

    @Test
    void testMenuExceptionMaximum(){
        Menu menu01 = Menu.getInstance("menu01");
        PlatAuMenu p1 = new PlatAuMenu(0, "Frites sauce", 11.50);
        menu01.ajoute(p1);
        menu01.position(0);
        assertThrows(MenuException.class, () -> {
            for (int i=0; i<5; i++){
                menu01.positionSuivante();
            }
        });
    }

    @Test
    void testMenuExceptionMinimum(){
        Menu menu01 = Menu.getInstance("menu01");
        menu01.position(0);
        assertThrows(MenuException.class, () -> {
            menu01.positionPrecedente();
        });
    }

    @Test
    void testMenuGetPlat(){
        Menu menu01 = Menu.getInstance("menu01");
        PlatAuMenu p1 = new PlatAuMenu(0, "Frite sauce", 11.50);
        PlatAuMenu p2 = new PlatAuMenu(1, "Frites", 10.25);
        PlatSante ps1 = new PlatSante(2, "Salade", 5.25, 100, 10, 1);
        menu01.ajoute(p1);
        menu01.ajoute(p2);
        menu01.ajoute(ps1);

        menu01.position(0);
        assertEquals(menu01.platCourant(), p1);

        menu01.position(1);
        assertEquals(menu01.platCourant(), p2);

        menu01.position(2);
        assertEquals(menu01.platCourant(), ps1);
    }
}
