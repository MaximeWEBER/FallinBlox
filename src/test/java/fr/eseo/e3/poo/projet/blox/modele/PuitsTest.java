package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuitsTest {

    @Test
    public void testConstructeur(){
        //Couleur couleur1 = Couleur.values()[0].
        Puits puits = new Puits();

        assertEquals(10,puits.getLargeur());
        assertEquals(20,puits.getProfondeur());
        assertNull(puits.getPieceActuelle());
        assertNull(puits.getPieceSuivante());

    }

    @Test
    public void testConstructeur2(){
        //Couleur couleur1 = Couleur.values()[0].
        Puits puits = new Puits(10,20);

        assertEquals(10,puits.getLargeur());
        assertEquals(20,puits.getProfondeur());
        assertNull(puits.getPieceActuelle());
        assertNull(puits.getPieceSuivante());

        assertThrows(IllegalArgumentException.class,()->new Puits(4,16),"Largeur et Profondeur changée");

        assertThrows(IllegalArgumentException.class,()->new Puits(14,26),"Profondeur et Largeur changée");
    }

    @Test
    public void testAjout(){
        Puits puits = new Puits();
        Piece opiece = new OPiece(new Coordonnees(puits.getLargeur()/2,3),Couleur.ROUGE);
        Piece ipiece = new IPiece(new Coordonnees(puits.getLargeur()/2,3),Couleur.ROUGE);
        puits.setPieceSuivante(opiece);
        puits.setPieceSuivante(ipiece);
        assertEquals(opiece,puits.getPieceActuelle());
        assertEquals(ipiece,puits.getPieceSuivante());
    }

    @Test
    public void testSetter(){
        Puits puits = new Puits();
        puits.setLargeur(12);
        puits.setProfondeur(17);
        assertEquals(12,puits.getLargeur());
        assertEquals(17,puits.getProfondeur());
    }

    @Test
    public void testToString(){
        Puits puits = new Puits();

        Piece opiece = new OPiece(new Coordonnees(puits.getLargeur()/2,3),Couleur.ROUGE);
        Piece ipiece = new IPiece(new Coordonnees(puits.getLargeur()/2,3),Couleur.ROUGE);
        puits.setPieceSuivante(opiece);
        puits.setPieceSuivante(ipiece);

        String string = "Puits : Dimension "+puits.getLargeur()+" x "+puits.getProfondeur()+"\n"+"Piece Actuelle : "+puits.getPieceActuelle().getClass().getSimpleName()+" :\n";

        for (int i=0; i<4; i++) {
            string += "\t" + puits.getPieceActuelle().getElements().get(i).toString() + "\n";
        }
        string+="Piece Suivante : "+puits.getPieceSuivante().getClass().getSimpleName()+" :\n";
        for (int i=0; i<4; i++) {
            string += "\t" + puits.getPieceSuivante().getElements().get(i).toString() + "\n";
        }
        assertEquals(string, puits.toString());

        Puits puits1 = new Puits();
        String string1 = "Puits : Dimension "+10+" x "+20+"\n"+"Piece Actuelle : "+"<aucune>"+"\n"+"Piece Suivante : <aucune>\n";
        assertEquals(string1, puits1.toString());

        Puits puits2 = new Puits();
        puits2.setPieceSuivante(opiece);
        String string2 = "Puits : Dimension "+10+" x "+20+"\n"+"Piece Actuelle : <aucune>\n"+"Piece Suivante : " +opiece.toString();
        assertEquals(string2, puits2.toString());
    }
}
