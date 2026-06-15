package code.menufact;

import code.menufact.chef.Chef;
import code.menufact.facture.Facture;
import code.menufact.facture.FactureEtat;
import code.menufact.facture.exceptions.FactureException;
import code.menufact.plats.PlatAuMenu;
import code.menufact.plats.PlatChoisi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MenuObservateurTest {

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
        PlatChoisi platChoisi1 = new PlatChoisi(p1, 2);
        try {
            facture.ajoutePlat(platChoisi1);
        } catch (FactureException e) {
            fail("Exception inattendue");
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
        PlatChoisi platChoisi1 = new PlatChoisi(p1, 2);
        try {
            facture.ajoutePlat(platChoisi1);
        } catch (FactureException e) {
            fail("Exception inattendue");
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
        PlatChoisi platChoisi1 = new PlatChoisi(p1, 2);
        try {
            facture.ajoutePlat(platChoisi1);
        } catch (FactureException e) {
            fail("Exception inattendue ");
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
        PlatChoisi platChoisi1 = new PlatChoisi(p1, 2);
        try {
            facture01.ajoutePlat(platChoisi1);
        } catch (FactureException e) {
            fail("Exception inattendue");
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
