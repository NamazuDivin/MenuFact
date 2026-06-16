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
import code.menufact.facture.FactureIterator;
import code.ingredients.exceptions.IngredientException;
import code.menufact.plats.Recette;
import code.menufact.plats.RecetteBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FactureTest {

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
        inventaire.ajouter(fromage, 1000);
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
        assertEquals(2, nb_message);
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

    @Test
    void payerFacture(){
        Facture facture01 = new Facture("facture01");
        facture01.payer();
        assertEquals(FactureEtat.PAYEE, facture01.getEtat());
    }

    @Test
    void fermerFacture(){
        Facture facture01 = new Facture("facture01");
        facture01.fermer();
        assertEquals(FactureEtat.FERMEE, facture01.getEtat());
    }

    @Test
    void ouvrirFactureFermee() throws FactureException {
        Facture facture01 = new Facture("facture01");
        facture01.fermer();
        facture01.ouvrir();
        assertEquals(FactureEtat.OUVERTE, facture01.getEtat());
    }

    @Test
    void ouvrirFacturePayee(){
        Facture facture01 = new Facture("facture01");
        facture01.payer();
        assertThrows(FactureException.class, () -> facture01.ouvrir());
    }

    @Test
    void factureIteratorVide(){
        Facture facture01 = new Facture("facture01");
        FactureIterator iterator = facture01.createIterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    void iteratorNextSansPlat() throws IngredientException, FactureException {
        Facture facture01 = new Facture("facture");
        PlatAuMenu p1 = new PlatAuMenu(0, "Frites", 10.0);
        p1.setRecette(frite);
        facture01.ajoutePlat(new PlatChoisi(p1, 2));
        FactureIterator iterator = facture01.createIterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    void iteratorNextUnPlat()throws IngredientException, FactureException {
        Facture facture = new Facture("facture");
        PlatAuMenu p1 = new PlatAuMenu(0, "Frites", 10.0);
        p1.setRecette(frite);
        facture.ajoutePlat(new PlatChoisi(p1, 2));
        FactureIterator iterator = facture.createIterator();
        assertEquals("Frites", iterator.next().getPlat().getDescription());
    }

    @Test
    void iteratorNextPlusieursPlats() throws IngredientException, FactureException {
        Facture facture01 = new Facture("facture");
        PlatAuMenu p1 = new PlatAuMenu(0, "Frites", 10.0);
        PlatAuMenu p2 = new PlatAuMenu(1, "Frite sauce", 11.50);
        PlatAuMenu p3 = new PlatAuMenu(2, "Salade", 5.25);
        p1.setRecette(frite);
        p2.setRecette(friteSauce);
        p3.setRecette(salade);
        facture01.ajoutePlat(new PlatChoisi(p1, 1));
        facture01.ajoutePlat(new PlatChoisi(p2, 1));
        facture01.ajoutePlat(new PlatChoisi(p3, 1));
        FactureIterator iterator = facture01.createIterator();
        int nb_facture = 0;
        while (iterator.hasNext()) {
            iterator.next();
            nb_facture++;
        }
        assertEquals(3, nb_facture);
    }

    @Test
    void testChefCuisiner() {
        Chef chef1 = new Chef();
        PlatAuMenu p1 = new PlatAuMenu(0, "Frites", 10.0);
        p1.setRecette(frite);
        PlatChoisi plat = new PlatChoisi(p1, 2);
        chef1.cuisiner(plat);
        assertEquals("Preparation", plat.getEtat());
    }

    @Test
    void testFacturePeutCuisiner() throws IngredientException {
        Chef chef1 = new Chef();
        Facture facture01 = new Facture("facture");
        Recette collation = recettes.ajouterIngredient(fromage, 100, "g").build();
        PlatAuMenu p1 = new PlatAuMenu(0, "Collation", 10.0);
        p1.setRecette(collation);
        PlatChoisi plat = new PlatChoisi(p1, 2);
        facture01.peutCommander(plat);
        assertEquals("Commande", plat.getEtat());
        assertEquals(800, inventaire.getQuantite(fromage));
    }

    @Test
    void testFacturePeutCuisinerImpossible() throws IngredientException {
        Chef chef1 = new Chef();
        Facture facture01 = new Facture("facture");
        Recette collation = recettes.ajouterIngredient(fromage, 1000, "g").build();
        PlatAuMenu p1 = new PlatAuMenu(0, "Collation", 10.0);
        p1.setRecette(collation);
        PlatChoisi plat = new PlatChoisi(p1, 2);
        facture01.peutCommander(plat);
        assertEquals("Impossible", plat.getEtat());
    }

    @Test
    void testFactureAjoutePlatEtCuisine() throws IngredientException, FactureException {
        Chef chef1 = new Chef();
        Facture facture01 = new Facture("facture");
        facture01.ajouterChef(chef1);
        Recette collation = recettes.ajouterIngredient(fromage, 10, "g").build();
        PlatAuMenu p1 = new PlatAuMenu(0, "Collation", 10.0);
        p1.setRecette(collation);
        PlatChoisi plat = new PlatChoisi(p1, 2);
        assertEquals("Commande", plat.getEtat());
        facture01.ajoutePlat(plat);
        assertEquals("Preparation", plat.getEtat());
        chef1.cuisiner(plat);
        assertEquals("Termine", plat.getEtat());
    }
}
