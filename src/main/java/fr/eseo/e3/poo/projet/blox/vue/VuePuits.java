package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.Objects;

public class VuePuits extends JPanel implements java.beans.PropertyChangeListener  {
    public static final int TAILLE_PAR_DEFAUT =15;

    private Puits puits;

    private int taille;

    private VuePiece vuePiece;

    private PieceDeplacement pieceDeplacement;

    private PieceRotation pieceRotation;


    public VuePuits(Puits p1){
        this.puits = p1;
        this.taille=TAILLE_PAR_DEFAUT;
        this.setPreferredSize(new Dimension(puits.getLargeur()*TAILLE_PAR_DEFAUT,puits.getProfondeur()*TAILLE_PAR_DEFAUT));
        this.setBackground(Color.WHITE);
        puits.addPropertyChangeListener(this);
        this.pieceDeplacement = new PieceDeplacement(this);
        addMouseMotionListener(this.pieceDeplacement);
        addMouseListener(this.pieceDeplacement);
        addMouseWheelListener(this.pieceDeplacement);
        this.pieceRotation = new PieceRotation(this);
        addMouseListener(this.pieceRotation);
    }

    public VuePuits(Puits p1, int taille){
        this.puits=p1;
        this.taille=taille;
        this.setPreferredSize(new Dimension(puits.getLargeur()*this.taille,puits.getProfondeur()*this.taille));
        this.setBackground(Color.WHITE);
        puits.addPropertyChangeListener(this);
        this.pieceDeplacement = new PieceDeplacement(this);
        addMouseMotionListener(this.pieceDeplacement);
        addMouseListener(this.pieceDeplacement);
        addMouseWheelListener(this.pieceDeplacement);
        this.pieceRotation = new PieceRotation(this);
        addMouseListener(this.pieceRotation);

    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits p1) {
        this.puits = p1;
        this.setPreferredSize(new Dimension(puits.getLargeur()*this.taille,puits.getProfondeur()*this.taille));
        this.puits.addPropertyChangeListener(this);
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
        this.setPreferredSize(new Dimension(puits.getLargeur()*this.taille,puits.getProfondeur()*this.taille));
        this.puits.addPropertyChangeListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* appel vers super pour remplir le fond du JPanel */
        /*Le paramètre g est copie en utilisant la méthode copie()
        * puis converti en instance de Graphics2D grâce à
        * un transtypage (cast) explicite.*/
        g.setColor(Color.WHITE);
        Graphics2D g2D = (Graphics2D)g.create();
        g2D.setColor(Color.LIGHT_GRAY);
        for (int i=0; i<(getPuits().getProfondeur());i++){
            g2D.drawLine(0,i*this.taille,getPuits().getLargeur()*this.taille,i*this.taille);
        }

        for (int i=0; i<(getPuits().getLargeur());i++){
            g2D.drawLine(i*this.taille,0,i*this.taille,getPuits().getProfondeur()*this.taille);
        }

        /* Nous utiliserons l'instance de Graphics2D*/
        /*Puis nous liberons la memoire*/
        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D);
        }
        g2D.dispose();

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(Objects.equals(evt.getPropertyName(), Puits.MODIFICATION_PIECE_ACTUELLE)){
            setVuePiece(new VuePiece((Piece) evt.getNewValue(),getTaille()));
        }
    }
}
