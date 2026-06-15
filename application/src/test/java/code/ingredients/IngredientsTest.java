package code.ingredients;

import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IngredientsTest {

    /**
     * Tester la classe de l objet
     */
    @Test
    void factoryFruitCreerFruit(){
        FactoryFruit factoryFruit = new FactoryFruit();
        Ingredient ingredient = factoryFruit.creerIngredient();
        assertInstanceOf(Fruit.class, ingredient);
    }

    @Test
    void factoryLegumeCreerLegume(){
        FactoryLegume factoryLegume = new FactoryLegume();
        Ingredient ingredient = factoryLegume.creerIngredient();
        assertInstanceOf(Legume.class, ingredient);
    }

    @Test
    void factoryLaitierCreerLaitier(){
        FactoryLaitier factoryLaitier = new FactoryLaitier();
        Ingredient ingredient = factoryLaitier.creerIngredient();
        assertInstanceOf(Laitier.class, ingredient);
    }

    @Test
    void factoryViandeCreerViande(){
        FactoryViande factoryViande = new FactoryViande();
        Ingredient ingredient = factoryViande.creerIngredient();
        assertInstanceOf(Viande.class, ingredient);
    }

    @Test
    void factoryEpiceCreerEpice(){
        FactoryEpice factoryEpice = new FactoryEpice();
        Ingredient ingredient = factoryEpice.creerIngredient();
        assertInstanceOf(Epice.class, ingredient);
    }

    /**
     * Tester la valeur de l objet
     */
    @Test
    void testTypeFruit() {
        FactoryFruit factory = new FactoryFruit();
        Ingredient ingredient = factory.creerIngredient();
        assertEquals(TypeIngredient.FRUIT, ingredient.getTypeIngredient());
    }

    @Test
    void testTypeLegume() {
        FactoryLegume factory = new FactoryLegume();
        Ingredient ingredient = factory.creerIngredient();
        assertEquals(TypeIngredient.LEGUME, ingredient.getTypeIngredient());
    }

    @Test
    void testTypeViande() {
        FactoryViande factory = new FactoryViande();
        Ingredient ingredient = factory.creerIngredient();
        assertEquals(TypeIngredient.VIANDE, ingredient.getTypeIngredient());
    }

    @Test
    void testTypeLaitier() {
        FactoryLaitier factory = new FactoryLaitier();
        Ingredient ingredient = factory.creerIngredient();
        assertEquals(TypeIngredient.LAITIER, ingredient.getTypeIngredient());
    }

    @Test
    void testTypeEpice() {
        FactoryEpice factory = new FactoryEpice();
        Ingredient ingredient = factory.creerIngredient();
        assertEquals(TypeIngredient.EPICE, ingredient.getTypeIngredient());
    }

    /**
     * Caracteristiques d un ingredient
     */
    @Test
    void SetNom() {
        FactoryFruit factory = new FactoryFruit();
        Ingredient ingredient = factory.creerIngredient();
        ingredient.setNom("Pomme");
        assertEquals("Pomme", ingredient.getNom());
    }

    @Test
    void SetDescription() {
        FactoryFruit factory = new FactoryFruit();
        Ingredient ingredient = factory.creerIngredient();
        ingredient.setDescription("Mega grosse pomme rouge");
        assertEquals("Mega grosse pomme rouge", ingredient.getDescription());
    }

    @Test
    void ComparaisonObjetsdifferents() {
        FactoryFruit factoryFruit = new FactoryFruit();
        Ingredient ingredient01 = factoryFruit.creerIngredient();
        Ingredient ingredient02 = factoryFruit.creerIngredient();
        assertNotSame(ingredient01, ingredient02);
    }
}
