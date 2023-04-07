package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuits();
        testConstructeurPuitsTaille();
    }

    private void testConstructeurPuits(){
        JFrame maFenetre = new JFrame("Puits");
        JPanel vuePuits = new VuePuits(new Puits());
        maFenetre.add(vuePuits,BorderLayout.CENTER);
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setSize(new Dimension(500,500));
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.setVisible(true);
    }

    private void testConstructeurPuitsTaille(){
        JFrame maFenetre = new JFrame("Puits et taille");
        JPanel vuePuits = new VuePuits(new Puits(), 20);
        maFenetre.add(vuePuits,BorderLayout.CENTER);
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setSize(new Dimension(500,500));
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
