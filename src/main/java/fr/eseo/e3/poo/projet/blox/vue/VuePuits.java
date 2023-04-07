package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;
import java.awt.*;

public class VuePuits extends JPanel {
    public static final int TAILLE_PAR_DEFAUT =10;

    private Puits puits;

    private int taille;

    public VuePuits(Puits p1){
        this.puits = p1;
        this.taille=TAILLE_PAR_DEFAUT;
        this.setPreferredSize(new Dimension(puits.getLargeur()*TAILLE_PAR_DEFAUT,puits.getProfondeur()*TAILLE_PAR_DEFAUT));
        this.setBackground(Color.WHITE);
    }

    public VuePuits(Puits p1, int taille){
        this.puits=p1;
        this.taille=taille;
        this.setPreferredSize(new Dimension(puits.getLargeur()*this.taille,puits.getProfondeur()*this.taille));
        this.setBackground(Color.WHITE);
    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits p1) {
        this.puits = p1;
        this.setPreferredSize(new Dimension(puits.getLargeur()*this.taille,puits.getProfondeur()*this.taille));
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
        this.setPreferredSize(new Dimension(puits.getLargeur()*this.taille,puits.getProfondeur()*this.taille));
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

        g2D.dispose();
    }
}
