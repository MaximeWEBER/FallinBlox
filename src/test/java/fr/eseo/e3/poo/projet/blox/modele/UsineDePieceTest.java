package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsineDePieceTest {

    @Test
    public void cycleTest(){
        UsineDePiece.setMode(2);
        assertEquals(OPiece.class,UsineDePiece.genererPiece().getClass());
        assertEquals(IPiece.class,UsineDePiece.genererPiece().getClass());
        assertEquals(OPiece.class,UsineDePiece.genererPiece().getClass());

        UsineDePiece.setMode(1);
        assertNotNull(UsineDePiece.genererPiece());
        assertNotNull(UsineDePiece.genererPiece());
        assertNotNull(UsineDePiece.genererPiece());
        assertNotNull(UsineDePiece.genererPiece());

        UsineDePiece.setMode(0);
        assertNotNull(UsineDePiece.genererPiece());
        assertNotNull(UsineDePiece.genererPiece());
        assertNotNull(UsineDePiece.genererPiece());
        assertNotNull(UsineDePiece.genererPiece());

        UsineDePiece.setMode(3);
        assertNotNull(UsineDePiece.genererPiece());
    }
}
