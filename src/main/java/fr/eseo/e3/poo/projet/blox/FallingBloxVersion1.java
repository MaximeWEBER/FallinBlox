package fr.eseo.e3.poo.projet.blox;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.controleur.Music;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class FallingBloxVersion1 {

    public static void main(String[] args) {
        if(args.length==0){
            JFrame maFenetre = new JFrame("Falling Blox");
            Puits p1 = new Puits();

            VuePuits vuePuits = new VuePuits(p1,20);
            UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
            p1.setPieceSuivante(UsineDePiece.genererPiece());
            p1.setPieceSuivante(UsineDePiece.genererPiece());
            PanneauInformation vuePanneau = new PanneauInformation(p1);
            Gravite gravite = new Gravite(vuePuits);

            maFenetre.add(vuePuits, BorderLayout.CENTER);
            maFenetre.add(vuePanneau,BorderLayout.EAST);
            maFenetre.setLocationRelativeTo(null);
            maFenetre.setSize(new Dimension(1000,1000));
            maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            maFenetre.pack();
            maFenetre.setVisible(true);
            Music m = new Music();
            m.start();

        } else if (args.length==1) {
            JFrame maFenetre = new JFrame("Falling Blox");
            Puits p1 = new Puits();
            p1.setTas(new Tas(p1,Integer.parseInt(args[0])));
            UsineDePiece.setMode(2);
            p1.setPieceSuivante(UsineDePiece.genererPiece());
            p1.setPieceSuivante(UsineDePiece.genererPiece());
            VuePuits vuePuits = new VuePuits(p1,20);

            PanneauInformation vuePanneau = new PanneauInformation(p1);
            Gravite gravite = new Gravite(vuePuits);

            maFenetre.add(vuePuits, BorderLayout.CENTER);
            maFenetre.add(vuePanneau,BorderLayout.EAST);
            maFenetre.setLocationRelativeTo(null);
            maFenetre.setSize(new Dimension(1000,1000));
            maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            maFenetre.pack();
            maFenetre.setVisible(true);
            UsineDePiece.setMode(2);
        } else if (args.length==2) {
            JFrame maFenetre = new JFrame("Falling Blox");
            Puits p1 = new Puits();
            p1.setTas(new Tas(p1,Integer.parseInt(args[0]),Integer.parseInt(args[1])));
            UsineDePiece.setMode(2);
            p1.setPieceSuivante(UsineDePiece.genererPiece());
            p1.setPieceSuivante(UsineDePiece.genererPiece());
            VuePuits vuePuits = new VuePuits(p1,20);

            PanneauInformation vuePanneau = new PanneauInformation(p1);
            Gravite gravite = new Gravite(vuePuits);

            maFenetre.add(vuePuits, BorderLayout.CENTER);
            maFenetre.add(vuePanneau,BorderLayout.EAST);
            maFenetre.setLocationRelativeTo(null);
            maFenetre.setSize(new Dimension(1000,1000));
            maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            maFenetre.pack();
            maFenetre.setVisible(true);

        }
        else{

        }
    }
}
