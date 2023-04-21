package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRotationPiece {

    @Test
    public void testRotation(){
        UsineDePiece.setMode(2);
        Puits puits = new Puits();

        puits.setPieceSuivante(UsineDePiece.genererPiece());
        puits.setPieceSuivante(UsineDePiece.genererPiece());
        puits.setPieceSuivante(UsineDePiece.genererPiece());

        try {
            puits.getPieceActuelle().deplacerDe(0,1);
            puits.getPieceActuelle().deplacerDe(0,1);
            puits.getPieceActuelle().deplacerDe(0,1);
            puits.getPieceActuelle().deplacerDe(0,1);
            puits.getPieceActuelle().deplacerDe(0,1);
            puits.getPieceActuelle().deplacerDe(0,1);
            puits.getPieceActuelle().deplacerDe(0,1);
            puits.getPieceActuelle().deplacerDe(0,1);
            puits.getPieceActuelle().deplacerDe(0,1);
            puits.getPieceActuelle().deplacerDe(0,1);
        } catch (BloxException e) {
            throw new RuntimeException(e);
        }



        assertEquals(6,puits.getPieceActuelle().getElements().get(1).getCoordonnees().getAbscisse());
        assertEquals(6,puits.getPieceActuelle().getElements().get(1).getCoordonnees().getOrdonnee());

        assertEquals(4,puits.getPieceActuelle().getElements().get(2).getCoordonnees().getAbscisse());
        assertEquals(6,puits.getPieceActuelle().getElements().get(2).getCoordonnees().getOrdonnee());

        assertEquals(7,puits.getPieceActuelle().getElements().get(3).getCoordonnees().getAbscisse());
        assertEquals(6,puits.getPieceActuelle().getElements().get(3).getCoordonnees().getOrdonnee());
        //
        try {
            puits.getPieceActuelle().tourner(false);
            puits.getPieceActuelle().tourner(false);
        } catch (BloxException e) {
            throw new RuntimeException(e);
        }


        assertEquals(4,puits.getPieceActuelle().getElements().get(1).getCoordonnees().getAbscisse());
        assertEquals(6,puits.getPieceActuelle().getElements().get(1).getCoordonnees().getOrdonnee());

        assertEquals(6,puits.getPieceActuelle().getElements().get(2).getCoordonnees().getAbscisse());
        assertEquals(6,puits.getPieceActuelle().getElements().get(2).getCoordonnees().getOrdonnee());

        assertEquals(3,puits.getPieceActuelle().getElements().get(3).getCoordonnees().getAbscisse());
        assertEquals(6,puits.getPieceActuelle().getElements().get(3).getCoordonnees().getOrdonnee());
    }
}
