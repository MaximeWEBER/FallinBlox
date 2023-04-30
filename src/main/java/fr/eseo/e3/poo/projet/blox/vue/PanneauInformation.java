package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class PanneauInformation extends JPanel implements PropertyChangeListener {

    private VuePiece vuePiece;

    public PanneauInformation(Puits puits){
        puits.addPropertyChangeListener(this);
        this.setPreferredSize(new Dimension(70,70));

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(Objects.equals(evt.getPropertyName(), Puits.MODIFICATION_PIECE_SUIVANTE)){
            vuePiece = new VuePiece((Piece) evt.getNewValue(),10);
            this.repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g.create();

        if(vuePiece!=null){
            vuePiece.afficherPiece(g2D);
        }
        g2D.dispose();
    }
}
