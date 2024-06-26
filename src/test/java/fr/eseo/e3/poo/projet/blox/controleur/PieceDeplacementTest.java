package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class PieceDeplacementTest {

    public PieceDeplacementTest() {
        testPieceDeplacement();
    }

    private void testPieceDeplacement(){
        JFrame maFenetre = new JFrame("Puits");
        Puits p1 = new Puits();
        JPanel vuePuits = new VuePuits(p1,20);
        UsineDePiece.setMode(2);
        p1.setPieceSuivante(UsineDePiece.genererPiece());
        p1.setPieceSuivante(UsineDePiece.genererPiece());
        p1.setPieceSuivante(UsineDePiece.genererPiece());

        try {
            p1.getPieceActuelle().deplacerDe(0,1);
            p1.getPieceActuelle().deplacerDe(0,1);
            p1.getPieceActuelle().deplacerDe(0,1);
            p1.getPieceActuelle().deplacerDe(0,1);
            p1.getPieceActuelle().deplacerDe(0,1);
            p1.getPieceActuelle().deplacerDe(0,1);
            p1.getPieceActuelle().deplacerDe(0,1);
            p1.getPieceActuelle().deplacerDe(0,1);
        } catch (BloxException e) {
            throw new RuntimeException(e);
        }



        maFenetre.add(vuePuits, BorderLayout.CENTER);
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setSize(new Dimension(500,500));
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.pack();
        maFenetre.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new PieceDeplacementTest();
            }
        });
    }
}
