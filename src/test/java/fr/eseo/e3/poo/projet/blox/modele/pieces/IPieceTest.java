package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IPieceTest {

    @Test
    public void testConstructeur(){
        Coordonnees coo1 = new Coordonnees(3,12);
        Couleur couleur = Couleur.ROUGE;
        //Couleur couleur1 = Couleur.values()[0].
        IPiece ipiece = new IPiece(coo1,couleur);

        assertEquals(3,ipiece.getElements().get(0).getCoordonnees().getAbscisse());
        assertEquals(12, ipiece.getElements().get(0).getCoordonnees().getOrdonnee());

        assertEquals(3,ipiece.getElements().get(1).getCoordonnees().getAbscisse());
        assertEquals(11, ipiece.getElements().get(1).getCoordonnees().getOrdonnee());

        assertEquals(3,ipiece.getElements().get(2).getCoordonnees().getAbscisse());
        assertEquals(13, ipiece.getElements().get(2).getCoordonnees().getOrdonnee());

        assertEquals(3,ipiece.getElements().get(3).getCoordonnees().getAbscisse());
        assertEquals(10, ipiece.getElements().get(3).getCoordonnees().getOrdonnee());

        assertNotNull(ipiece.getElements());

    }

    @Test
    public void testToString(){
        String string = "IPiece :\n";
        Coordonnees coo1 = new Coordonnees(3,12);
        Couleur couleur = Couleur.ROUGE;
        IPiece ipiece = new IPiece(coo1,couleur);

        for (int i=0; i<4; i++) {

            string += "\t" + ipiece.getElements().get(i).toString() + "\n";
        }
        assertEquals(string, ipiece.toString());
    }
}
