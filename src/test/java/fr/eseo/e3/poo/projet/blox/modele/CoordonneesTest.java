package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordonneesTest {

    @Test
    public void testConstructeur(){
        Coordonnees coordonnees = new Coordonnees(15,2);
        assertEquals(15,coordonnees.getAbscisse(),"Test Abscisse");
        assertEquals(2,coordonnees.getOrdonnee(),"Test Ordonnee");
    }

    @Test
    public void testSetter(){
        Coordonnees coordonnees = new Coordonnees(15,2);
        coordonnees.setAbscisse(12);
        coordonnees.setOrdonnee(15);
        assertEquals(12,coordonnees.getAbscisse(),"Test Abscisse");
        assertEquals(15,coordonnees.getOrdonnee(),"Test Ordonnee");
    }

    @Test
    public void testToString(){
        Coordonnees coordonnees = new Coordonnees(13,2);
        assertEquals("("+13+", "+2+")",coordonnees.toString(),"Test Abscisse");
    }

    @Test
    public void testEquals(){
        Coordonnees coordonnees = new Coordonnees(15,2);
        assertTrue(coordonnees.equals(coordonnees),"Test objet");
    }

}
