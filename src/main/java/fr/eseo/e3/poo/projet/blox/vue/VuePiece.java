package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.*;

public class VuePiece {

    public static final double MULTIPLIER_TEINTE=0.5;

    private final Piece piece;

    private final int taille;

    public VuePiece(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
    }

    public java.awt.Color teinte(java.awt.Color couleur){
        int rougeAugmentee = couleur.getRed();
        int vertAugmentee = couleur.getGreen();
        int bleuAugmentee = couleur.getBlue();
        rougeAugmentee = (int) (rougeAugmentee+(255-rougeAugmentee)*MULTIPLIER_TEINTE);
        vertAugmentee = (int) (vertAugmentee+(255-vertAugmentee)*MULTIPLIER_TEINTE);
        bleuAugmentee =(int) (bleuAugmentee+(255-bleuAugmentee)*MULTIPLIER_TEINTE);
        return new java.awt.Color(rougeAugmentee,vertAugmentee,bleuAugmentee);
    }

    public void afficherPiece(java.awt.Graphics2D g2D){

        g2D.setColor(piece.couleur.getCouleurPourAffichage());
        g2D.fill3DRect(piece.getElements().get(1).getCoordonnees().getAbscisse()*this.taille,piece.getElements().get(1).getCoordonnees().getOrdonnee()*this.taille,this.taille,this.taille,true);
        g2D.fill3DRect(piece.getElements().get(2).getCoordonnees().getAbscisse()*this.taille,piece.getElements().get(2).getCoordonnees().getOrdonnee()*this.taille,this.taille,this.taille,true);
        g2D.fill3DRect(piece.getElements().get(3).getCoordonnees().getAbscisse()*this.taille,piece.getElements().get(3).getCoordonnees().getOrdonnee()*this.taille,this.taille,this.taille,true);
        g2D.setColor(teinte(piece.couleur.getCouleurPourAffichage()));
        g2D.fill3DRect(piece.getElements().get(0).getCoordonnees().getAbscisse()*this.taille,piece.getElements().get(0).getCoordonnees().getOrdonnee()*this.taille,this.taille,this.taille,true);
    }
}
