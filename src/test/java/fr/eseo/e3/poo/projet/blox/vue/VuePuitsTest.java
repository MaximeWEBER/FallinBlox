package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VuePuitsTest {

    @Test
    public void constructeurTest(){
        Puits puits = new Puits();
        VuePuits vuePuits1 = new VuePuits(puits);
        VuePuits vuePuits2 = new VuePuits(puits,5);

        assertEquals(10, vuePuits1.getTaille());
        assertEquals(puits,vuePuits1.getPuits());

        assertEquals(5,vuePuits2.getTaille());
        assertEquals(puits,vuePuits2.getPuits());
    }

    @Test
    public void setterTest(){
        Puits puits = new Puits();
        VuePuits vuePuits1 = new VuePuits(puits);

        Puits puits1 = new Puits(10,20);
        vuePuits1.setPuits(puits1);
        vuePuits1.setTaille(17);
        assertEquals(puits1.getLargeur(),vuePuits1.getPuits().getLargeur());
        assertEquals(puits1.getProfondeur(),vuePuits1.getPuits().getProfondeur());
        assertEquals(17,vuePuits1.getTaille());
    }


}
