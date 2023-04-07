package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OPieceTest {

    @Test
    public void testConstructeur(){
        Coordonnees coo1 = new Coordonnees(3,12);
        Couleur couleur = Couleur.ROUGE;
        //Couleur couleur1 = Couleur.values()[0].
        OPiece opiece = new OPiece(coo1,couleur);

        assertEquals(3,opiece.getElements().get(0).getCoordonnees().getAbscisse());
        assertEquals(12, opiece.getElements().get(0).getCoordonnees().getOrdonnee());

        assertEquals(3,opiece.getElements().get(1).getCoordonnees().getAbscisse());
        assertEquals(11, opiece.getElements().get(1).getCoordonnees().getOrdonnee());

        assertEquals(4,opiece.getElements().get(2).getCoordonnees().getAbscisse());
        assertEquals(12, opiece.getElements().get(2).getCoordonnees().getOrdonnee());

        assertEquals(4,opiece.getElements().get(3).getCoordonnees().getAbscisse());
        assertEquals(11, opiece.getElements().get(3).getCoordonnees().getOrdonnee());

        assertNotNull(opiece.getElements());

    }

    @Test
    public void testToString(){
        String string = "OPiece :\n";
        Coordonnees coo1 = new Coordonnees(3,12);
        Couleur couleur = Couleur.ROUGE;
        OPiece opiece = new OPiece(coo1,couleur);

        for (int i=0; i<4; i++) {
            string += "\t" + opiece.getElements().get(i).toString() + "\n";
        }
        assertEquals(string, ((Piece) opiece).toString());
    }

    @Test
    public void setPositionTest(){
        Coordonnees coo1 = new Coordonnees(3,12);
        Couleur couleur = Couleur.ROUGE;
        OPiece opiece = new OPiece(coo1,couleur);
        opiece.setPosition(7,8);

        assertEquals(7,opiece.getElements().get(0).getCoordonnees().getAbscisse());
        assertEquals(8, opiece.getElements().get(0).getCoordonnees().getOrdonnee());

        assertEquals(7,opiece.getElements().get(1).getCoordonnees().getAbscisse());
        assertEquals(7, opiece.getElements().get(1).getCoordonnees().getOrdonnee());

        assertEquals(8,opiece.getElements().get(2).getCoordonnees().getAbscisse());
        assertEquals(8, opiece.getElements().get(2).getCoordonnees().getOrdonnee());

        assertEquals(8,opiece.getElements().get(3).getCoordonnees().getAbscisse());
        assertEquals(7, opiece.getElements().get(3).getCoordonnees().getOrdonnee());
    }

    @Test
    public void puitsTest(){
        Coordonnees coo1 = new Coordonnees(3,12);
        Couleur couleur = Couleur.ROUGE;
        OPiece opiece = new OPiece(coo1,couleur);

        Puits puits = new Puits();
        opiece.setPuits(puits);
        assertEquals(puits, opiece.getPuits());
    }
}
