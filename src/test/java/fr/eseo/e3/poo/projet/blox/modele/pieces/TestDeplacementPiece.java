package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDeplacementPiece {

    @Test
    public void testDeplacement(){
        UsineDePiece.setMode(2);
        Puits puits = new Puits();

        puits.setPieceSuivante(UsineDePiece.genererPiece());
        puits.setPieceSuivante(UsineDePiece.genererPiece());
        puits.setPieceSuivante(UsineDePiece.genererPiece());
        Piece pieceBackup = puits.getPieceActuelle();
        puits.getPieceActuelle().setPuits(puits);
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
            puits.getPieceActuelle().deplacerDe(-1,0);
            puits.getPieceActuelle().deplacerDe(-1,0);
            puits.getPieceActuelle().deplacerDe(-1,0);
            puits.getPieceActuelle().deplacerDe(-1,0);
            puits.getPieceActuelle().deplacerDe(-1,0);
            puits.getPieceActuelle().deplacerDe(-1,0);


        } catch (BloxException e) {
            throw new RuntimeException(e);
        }
        assertEquals(0,puits.getPieceActuelle().getElements().get(0).getCoordonnees().getAbscisse());
    }

    public static void main(String[] args) {
        //testDeplacement();
    }

}
