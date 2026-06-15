package code.menufact;

import code.ingredients.*;
import code.ingredients.exceptions.IngredientException;
import code.inventaire.Inventaire;
import code.menufact.chef.Chef;
import code.menufact.facture.Facture;
import code.menufact.facture.FactureEtat;
import code.menufact.facture.exceptions.FactureException;
import code.menufact.plats.PlatAuMenu;
import code.menufact.plats.PlatChoisi;

import code.menufact.plats.Recette;
import code.menufact.plats.RecetteBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MenuObservateurTest {

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
    void ajouterChefSurFacture() {
        Facture facture = new Facture("facture");
        Chef chef01 = new Chef();
        assertDoesNotThrow(() -> facture.ajouterChef(chef01));
    }

    @Test
    void notifierChefSurFactureAvecChef() {
        ByteArrayOutputStream sortie = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sortie));

        Facture facture = new Facture("facture");
        Chef chef01 = new Chef();
        facture.ajouterChef(chef01);

        PlatAuMenu p1 = new PlatAuMenu(0, "Frite sauce", 11.50);
        p1.setRecette(friteSauce);
        PlatChoisi platChoisi1 = new PlatChoisi(p1, 2);
        try {
            facture.ajoutePlat(platChoisi1);
        } catch (FactureException e) {
            fail("Exception inattendue");
        } catch (IngredientException e) {
            throw new RuntimeException(e);
        }
        assertTrue(sortie.toString().contains("le chef a été notifié d'une nouvelle facture"));

        System.setOut(System.out);
    }

    @Test
    void notifierChefSurFactureSansChef() {
        ByteArrayOutputStream sortie = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sortie));

        Facture facture = new Facture("facture");
        PlatAuMenu p1 = new PlatAuMenu(0, "Frite sauce", 11.50);
        p1.setRecette(friteSauce);
        PlatChoisi platChoisi1 = new PlatChoisi(p1, 2);
        try {
            facture.ajoutePlat(platChoisi1);
        } catch (FactureException e) {
            fail("Exception inattendue");
        } catch (IngredientException e) {
            throw new RuntimeException(e);
        }
        assertFalse(sortie.toString().contains("le chef a été notifié d'une nouvelle facture"));

        System.setOut(System.out);
    }

    @Test
    void notifierPlusieursChefSurFacture() {
        ByteArrayOutputStream sortie = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sortie));

        Facture facture = new Facture("facture");
        Chef chef01 = new Chef();
        Chef chef02 = new Chef();
        facture.ajouterChef(chef01);
        facture.ajouterChef(chef02);
        PlatAuMenu p1 = new PlatAuMenu(0, "Frite sauce", 11.50);
        p1.setRecette(friteSauce);
        PlatChoisi platChoisi1 = new PlatChoisi(p1, 2);
        try {
            facture.ajoutePlat(platChoisi1);
        } catch (FactureException e) {
            fail("Exception inattendue ");
        } catch (IngredientException e) {
            throw new RuntimeException(e);
        }

        String messageSortie = sortie.toString();
        int nb_message = messageSortie.split("le chef a été notifié d'une nouvelle facture", -1).length - 1;
        System.setOut(System.out);
    }

    @Test
    void factureOuverteParDefaut() {
        Facture facture01 = new Facture("facture01");
        assertEquals(FactureEtat.OUVERTE, facture01.getEtat());
    }

    @Test
    void ajouterPlatFactureOuverte() {
        Facture facture01 = new Facture("facture01");
        PlatAuMenu p1 = new PlatAuMenu(0, "Frite sauce", 11.50);
        p1.setRecette(friteSauce);
        PlatChoisi platChoisi1 = new PlatChoisi(p1, 2);
        try {
            facture01.ajoutePlat(platChoisi1);
        } catch (FactureException e) {
            fail("Exception inattendue");
        } catch (IngredientException e) {
            throw new RuntimeException(e);
        }
        assertEquals(23.0, facture01.sousTotal());
    }

    @Test
    void ajouterPlatFactureFermee() {
        Facture facture01 = new Facture("facture01");
        facture01.fermer();
        PlatAuMenu p1 = new PlatAuMenu(0, "Frite sauce", 11.50);
        PlatChoisi platChoisi1 = new PlatChoisi(p1, 2);
        assertThrows(FactureException.class, () -> facture01.ajoutePlat(platChoisi1));
    }

    @Test
    void ajouterPlatFacturePayee(){
        Facture facture01 = new Facture("facture01");
        facture01.payer();
        PlatAuMenu p1 = new PlatAuMenu(0, "Frite sauce", 11.50);
        PlatChoisi platChoisi1 = new PlatChoisi(p1, 2);
        assertThrows(FactureException.class, () -> facture01.ajoutePlat(platChoisi1));
    }


}
