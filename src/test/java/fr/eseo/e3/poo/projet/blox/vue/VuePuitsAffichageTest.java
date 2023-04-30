package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuits();
        testConstructeurPuitsTaille();
        //testVueTas();
    }

    private void testConstructeurPuits(){
        JFrame maFenetre = new JFrame("Puits");
        Puits p1 = new Puits();
        JPanel vuePuits = new VuePuits(p1);
        UsineDePiece.setMode(2);
        p1.setPieceSuivante(UsineDePiece.genererPiece());
        p1.setPieceSuivante(UsineDePiece.genererPiece());
        maFenetre.add(vuePuits,BorderLayout.CENTER);
        Piece piece = UsineDePiece.genererPiece();
        VuePiece vuePiece = new VuePiece(piece,10);
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setSize(new Dimension(500,500));
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.pack();
        maFenetre.setVisible(true);
    }

    private void testConstructeurPuitsTaille(){
        JFrame maFenetre = new JFrame("Puits et taille");
        Puits p1 = new Puits();
        JPanel vuePuits = new VuePuits(p1, 20);
        maFenetre.add(vuePuits,BorderLayout.CENTER);
        maFenetre.setLocationRelativeTo(null);
        UsineDePiece.setMode(2);
        p1.setPieceSuivante(UsineDePiece.genererPiece());
        p1.setPieceSuivante(UsineDePiece.genererPiece());
        maFenetre.setSize(new Dimension(500,500));
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.pack();
        maFenetre.setVisible(true);
    }

    private void testVueTas(){
        JFrame maFenetre = new JFrame("Tas");
        Puits p1 = new Puits();
        JPanel vuePuits = new VuePuits(p1, 20);
        maFenetre.add(vuePuits,BorderLayout.CENTER);
        maFenetre.setLocationRelativeTo(null);
        UsineDePiece.setMode(2);
        p1.setPieceSuivante(UsineDePiece.genererPiece());
        p1.setPieceSuivante(UsineDePiece.genererPiece());
        p1.setPieceSuivante(UsineDePiece.genererPiece());
        maFenetre.setSize(new Dimension(500,500));
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.pack();
        maFenetre.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new VuePuitsAffichageTest ();
            }
        });
    }
}
