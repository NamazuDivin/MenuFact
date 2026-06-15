package code.menufact;

import code.menufact.exceptions.MenuException;
import code.menufact.plats.PlatAuMenu;
import code.menufact.plats.PlatSante;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuSingletonTest {

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
