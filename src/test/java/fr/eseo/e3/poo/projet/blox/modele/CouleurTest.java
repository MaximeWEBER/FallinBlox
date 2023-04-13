package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CouleurTest {

    @Test
    public void testConstructeur(){

        Couleur c1 = Couleur.ROUGE;
        assertEquals(java.awt.Color.RED,c1.getCouleurPourAffichage());
    }
}
