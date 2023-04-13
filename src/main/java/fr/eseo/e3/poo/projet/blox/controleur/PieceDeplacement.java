package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseEvent;

public class PieceDeplacement implements java.awt.event.MouseMotionListener{

    private VuePuits vuePuits;

    private Puits puits;

    int ligne=0;

    int colonne=0;

    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits=this.vuePuits.getPuits();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (this.puits.getPieceActuelle() != null){
            if (ligne ==0 && colonne==0) {
                ligne = e.getY();
                colonne = e.getX();
            }
            else{

                int precColonne = Math.floorDiv(colonne ,vuePuits.getTaille());
                if (precColonne>=(e.getX()/ vuePuits.getTaille())){
                    puits.getPieceActuelle().deplacerDe(-1,0);
                }
                if (precColonne+this.vuePuits.getTaille()<=(e.getX()/ vuePuits.getTaille())){
                    puits.getPieceActuelle().deplacerDe(1,0);
                }
            }
        }
    }


}
