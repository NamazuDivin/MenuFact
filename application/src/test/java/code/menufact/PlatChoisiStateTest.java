package code.menufact;

import code.ingredients.*;
import code.inventaire.Inventaire;
import code.menufact.plats.*;
import code.menufact.plats.etat.Impossible;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlatChoisiStateTest {

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
    PlatAuMenu FS = new PlatAuMenu(0, "Frite sauce", 20.00);
    PlatAuMenu S = new PlatAuMenu(0, "Salade", 10.00);
    PlatAuMenu F = new PlatAuMenu(0, "Frite", 15.00);
    PlatAuMenu SC = new PlatAuMenu(0, "Salade césar", 20.00);

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
        FS.setRecette(friteSauce);
        S.setRecette(salade);
        SC.setRecette(cesar);
    }

    @Test
    void testPlatEtatInitial() {
        PlatChoisi plat = new PlatChoisi(S, 2);
        assertEquals("Commande", plat.getEtat());
    }

    @Test
    void testPlatChangerEtat() {
        PlatChoisi plat = new PlatChoisi(S, 2);
        plat.changeEtat();
        assertEquals("Preparation", plat.getEtat());
    }

    @Test
    void testPlatPlusieursChangerEtat() {
        PlatChoisi plat = new PlatChoisi(S, 2);
        plat.changeEtat();
        assertEquals("Preparation", plat.getEtat());
        plat.changeEtat();
        assertEquals("Termine", plat.getEtat());
        plat.changeEtat();
        assertEquals("Servie", plat.getEtat());
    }

    @Test
    void testPlatChangerEtatApresServi() {
        PlatChoisi plat = new PlatChoisi(S, 2);
        plat.changeEtat();
        assertEquals("Preparation", plat.getEtat());
        plat.changeEtat();
        assertEquals("Termine", plat.getEtat());
        plat.changeEtat();
        assertEquals("Servie", plat.getEtat());
        plat.changeEtat();
        assertEquals("Servie", plat.getEtat());
    }

    @Test
    void testPlatChangerEtatImpossible() {
        PlatChoisi plat = new PlatChoisi(S, 2);
        plat.setEtat(new Impossible());
        assertEquals("Impossible", plat.getEtat());
    }

    @Test
    void testPlatDonnees() {
        PlatChoisi plat = new PlatChoisi(SC, 3);
        assertEquals(3, plat.getQuantite());
        assertEquals(SC, plat.getPlat());
    }

    @Test
    void testPlatGetRecette() {
        PlatChoisi plat = new PlatChoisi(F, 1);
        F.setRecette(frite);
        assertEquals(frite, plat.getPlat().getRecette());
    }
}
