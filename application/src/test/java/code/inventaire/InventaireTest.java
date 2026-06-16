package code.inventaire;

import code.ingredients.*;
import code.ingredients.exceptions.IngredientException;
import code.menufact.plats.Recette;
import code.menufact.plats.RecetteBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventaireTest {

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
    RecetteBuilder recettes = new RecetteBuilder();
    Recette salade, cesar, frite, friteSauce;

    @BeforeEach
    void setup() throws Exception {

    }

    @Test
    void testInventaireSingleton() {
        Inventaire a = Inventaire.getInstance();
        Inventaire b = Inventaire.getInstance();
        assertSame(a,b);
    }

    @Test
    void testInventaireGetQuantite() throws IngredientException {
        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(laitue, 1000);
        assertEquals(1000, inventaire.getQuantite(laitue));
    }

    @Test
    void testInventaireAjouter() throws IngredientException {
        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(laitue,1000);
        assertEquals(1000,inventaire.getQuantite(laitue));
    }

    @Test
    void testInventaireAjouterPlusieurs() throws IngredientException {
        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(laitue, 1000);
        inventaire.ajouter(pomme, 100);
        assertEquals(1000, inventaire.getQuantite(laitue));
        assertEquals(100, inventaire.getQuantite(pomme));
    }

    @Test
    void testInventaireAjouterMemeIngredient() throws IngredientException {
        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(laitue, 1000);
        inventaire.ajouter(laitue, 100);
        assertEquals(1100, inventaire.getQuantite(laitue));
    }

    @Test
    void testInventaireQteZero() throws IngredientException {
        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(laitue, 0);
        assertEquals(0, inventaire.getQuantite(laitue));
    }

    @Test
    void testInventaireQteNegative() {
        Inventaire inventaire = Inventaire.getInstance();
        assertThrows(IngredientException.class, () -> inventaire.ajouter(laitue, -5));
    }

    @Test
    void testInventaireAjouteQteNegativeAIngredientExistant() throws IngredientException {
        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(laitue, 1000);
        assertThrows(IngredientException.class, () -> inventaire.ajouter(laitue, -5));
    }

    @Test
    void testInventaireSetQuantite() throws IngredientException {
        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(laitue, 1000);
        inventaire.setQuantite(laitue,1);
        assertEquals(1, inventaire.getQuantite(laitue));
    }

    @Test
    void testInventaireSetQuantiteNegative() throws IngredientException {
        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(laitue, 1000);
        assertThrows(IngredientException.class, () -> inventaire.setQuantite(laitue, -5));
    }

    @Test
    void testInventaireSetQuantiteZero() throws IngredientException {
        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(laitue, 1000);
        inventaire.setQuantite(laitue,0);
        assertEquals(0, inventaire.getQuantite(laitue));
    }

    @Test
    void testInventaireGetQuantiteIngredientNull() throws IngredientException {
        Inventaire inventaire = Inventaire.getInstance();
        assertEquals(0, inventaire.getQuantite(laitue));
    }

}
