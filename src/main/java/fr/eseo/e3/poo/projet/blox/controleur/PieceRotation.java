package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PieceRotation extends MouseAdapter {

    private VuePuits vuePuits;

    private Puits puits;

    public PieceRotation(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = this.vuePuits.getPuits();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)){
            try {
                vuePuits.getPuits().getPieceActuelle().tourner(true);
            } catch (BloxException ex) {
                throw new RuntimeException(ex);
            }
            vuePuits.repaint();
        }
        if(SwingUtilities.isLeftMouseButton(e)){
            try {
                vuePuits.getPuits().getPieceActuelle().tourner(false);
            } catch (BloxException ex) {
                throw new RuntimeException(ex);
            }
            vuePuits.repaint();
        }
    }
}
