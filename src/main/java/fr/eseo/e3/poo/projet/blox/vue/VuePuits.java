package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;

public class VuePuits extends JPanel {
    public static final int TAILLE_PAR_DEFAUT =0;

    private Puits puits;

    private int taille;

    public VuePuits(Puits p1){
        this.puits = p1;
        this.taille=TAILLE_PAR_DEFAUT;
    }

    public VuePuits(Puits p1, int taille){
        this.puits=p1;
        this.taille=taille;
    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
}
