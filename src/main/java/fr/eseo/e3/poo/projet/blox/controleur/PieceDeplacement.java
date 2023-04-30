package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class PieceDeplacement extends MouseAdapter implements java.awt.event.MouseMotionListener, java.awt.event.MouseWheelListener, java.awt.event.MouseListener{

    private VuePuits vuePuits;

    private Puits puits;

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
        /*
        if (this.puits.getPieceActuelle() != null){
            int precColonne = e.getX()/vuePuits.getTaille();
            if (colonne!=-1) {
                if (precColonne<(colonne)){
                    try {
                        puits.getPieceActuelle().deplacerDe(-1,0);
                        vuePuits.repaint();
                    } catch (BloxException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if (precColonne>(colonne)){

                    try {
                        puits.getPieceActuelle().deplacerDe(1,0);

                        vuePuits.repaint();
                    } catch (BloxException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                //this.puits.getPieceActuelle().setPosition(Math.floorDiv(colonne ,vuePuits.getTaille()),this.puits.getPieceActuelle().getElements().get(0).getCoordonnees().getOrdonnee());
            }
            colonne=precColonne;
        }
*/

        if (this.puits.getPieceActuelle() != null){
            // - 1 Changer en 0
            if (colonne==0) {
                colonne = e.getX();
                // ajout d'un set position si sortie d'écran
                //this.puits.getPieceActuelle().setPosition(Math.floorDiv(colonne ,vuePuits.getTaille()),this.puits.getPieceActuelle().getElements().get(0).getCoordonnees().getOrdonnee());
            }
            else{
                // Suppression Math.floorDiv
                int precColonne = Math.floorDiv(colonne,vuePuits.getTaille());
                // Les >= et <= ne sont pas logique
                if (precColonne>(e.getX()/ vuePuits.getTaille())){
                    colonne=e.getX();
                    try {
                        puits.getPieceActuelle().deplacerDe(-1,0);
                    } catch (BloxException ex) {
                        System.out.println("Impossible d'aller à gauche");
                    }

                    vuePuits.repaint();
                }
                if (precColonne<(e.getX()/ vuePuits.getTaille())){
                    colonne=e.getX();

                    try {
                        puits.getPieceActuelle().deplacerDe(1,0);
                    } catch (BloxException ex) {
                        System.out.println("Impossible d'aller à droite");
                    }

                    vuePuits.repaint();
                }
            }
        }


    }



    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        colonne =-1;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (puits.getPieceActuelle() !=null){
            if (e.getWheelRotation()>0){

                try {
                    puits.getPieceActuelle().deplacerDe(0,1);
                } catch (BloxException ex) {
                    System.out.println("Collision bas puits / Collision tas");;
                }

                vuePuits.repaint();
            }
        }
    }
}
