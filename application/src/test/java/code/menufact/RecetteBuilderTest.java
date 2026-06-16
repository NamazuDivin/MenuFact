package code.menufact;

import code.ingredients.*;
import code.ingredients.exceptions.IngredientException;
import code.inventaire.Inventaire;
import code.menufact.exceptions.MenuException;
import code.menufact.plats.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RecetteBuilderTest {

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
    }

    @Test
    void testQuantiteGetters() {
        Quantite qte = new Quantite(300, "g");
        assertEquals(300, qte.getQte());
        assertEquals("g", qte.getType());
    }

    @Test
    void testQuantiteZero() {
        Quantite qte = new Quantite(0, "g");
        assertEquals(0, qte.getQte());
        assertEquals("g", qte.getType());
    }

    @Test
    void testQuantiteNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Quantite(-5, "g"));
    }

    @Test
    void testQuantiteNegativeMessage() {
        assertEquals("la quantité doit être positive", assertThrows(
                IllegalArgumentException.class,
                () -> new Quantite(-5, "g")).getMessage());
    }

    @Test
    void testRecetteGetIngredients() {
        Map<Ingredient, Quantite> ingredients = new HashMap<>();
        ingredients.put(laitue, new Quantite(300, "g"));
        Recette recette = new Recette(ingredients);
        assertEquals(300, recette.getIngredients().get(laitue).getQte());
        assertEquals("g", recette.getIngredients().get(laitue).getType());
    }

    @Test
    void testRecetteVide() {
        Recette recette = new Recette(new HashMap<>());
        assertEquals(0, recette.getIngredients().size());
    }

    @Test
    void testBuilderAjouterUnIngredient() {
        salade = recettes.ajouterIngredient(laitue, 300, "g")
                .build();

        Map<Ingredient, Quantite> ingredients = salade.getIngredients();
        assertEquals(300, ingredients.get(laitue).getQte());
        assertEquals("g", ingredients.get(laitue).getType());
        assertEquals(1, ingredients.size());
    }

    @Test
    void testBuilderAjouterPlusieursIngredients() {
        salade = recettes.ajouterIngredient(laitue, 300, "g")
                .ajouterIngredient(vinaigrette, 200, "ml")
                .build();

        Map<Ingredient, Quantite> ingredients = salade.getIngredients();
        assertEquals(200, ingredients.get(vinaigrette).getQte());
        assertEquals("ml", ingredients.get(vinaigrette).getType());
        assertEquals(300, ingredients.get(laitue).getQte());
        assertEquals("g", ingredients.get(laitue).getType());
        assertEquals(2, ingredients.size());
    }

    @Test
    void testBuilderResetApresBuild() {
        salade = recettes.ajouterIngredient(laitue, 300, "g").build();
        Recette poutine = recettes.ajouterIngredient(patate, 300, "g").build();
        assertEquals(1, poutine.getIngredients().size());
    }

    @Test
    void testBuilderSansIngredient() {
        Recette poutine = recettes.build();
        assertEquals(0, poutine.getIngredients().size());
    }

    @Test
    void testBuilderCreerDeuxRecettesIndependante() {
        Recette salade = recettes.ajouterIngredient(laitue, 300, "g").build();
        Recette sauce = recettes.ajouterIngredient(vinaigrette, 200, "ml").build();
        assertFalse(salade.getIngredients().containsKey(vinaigrette));
        assertFalse(sauce.getIngredients().containsKey(laitue));
    }
}
