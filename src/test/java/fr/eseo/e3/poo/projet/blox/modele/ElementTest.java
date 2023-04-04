package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {

    @Test
    public void testConstructeur(){
        Coordonnees coo1 = new Coordonnees(3,10);
        Couleur couleur = Couleur.ROUGE;

        Element el1 = new Element(coo1);
        assertEquals(coo1,el1.getCoordonnees());
        assertEquals(couleur, el1.getCouleur());

        Element el2 = new Element(3,12);
        assertEquals(3,el2.getCoordonnees().getAbscisse());
        assertEquals(12,el2.getCoordonnees().getOrdonnee());

        Element el3 = new Element(coo1, couleur);
        assertEquals(coo1,el3.getCoordonnees());
        assertEquals(couleur, el3.getCouleur());

        Element el4 = new Element(3,12,couleur);
        assertEquals(3,el4.getCoordonnees().getAbscisse());
        assertEquals(12,el4.getCoordonnees().getOrdonnee());
        assertEquals(couleur, el4.getCouleur());
    }

    @Test
    public void testToString(){
        Coordonnees coo1 = new Coordonnees(3,10);
        Couleur couleur = Couleur.ROUGE;
        Element el1 = new Element(coo1);
        assertEquals("("+3+", "+10+")"+" - "+couleur,el1.toString());
    }

    @Test
    public void testEquals(){
        Coordonnees coordonnees = new Coordonnees(15,2);
        Element el1 = new Element(coordonnees);
        assertTrue(el1.equals(el1),"Test objet");

        assertFalse(el1.equals(new Element(13, 2)));

    }

    @Test
    public void testHashcode(){
        Coordonnees coordonnees = new Coordonnees(15,2);
        Element el1 = new Element(coordonnees);
        Coordonnees coordonnees1 = new Coordonnees(15,2);
        assertTrue(coordonnees1.equals(coordonnees1) && coordonnees.equals(coordonnees));
        assertNotEquals(el1.hashCode(), coordonnees1.hashCode());
    }

    @Test
    public void setterTest(){
        Coordonnees coordonnees = new Coordonnees(15,2);
        Element el1 = new Element(new Coordonnees(10,3));
        el1.setCoordonnees(coordonnees);
        assertEquals(15, el1.getCoordonnees().getAbscisse());
        assertEquals(2, el1.getCoordonnees().getOrdonnee());
        el1.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU,el1.getCouleur());
    }

}
