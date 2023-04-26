package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Gravite implements java.awt.event.ActionListener{

    private final VuePuits vuePuits;

    private final Puits puits;


    private javax.swing.Timer timer;

    private int periodicite;

    public Gravite(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        this.periodicite=1000;
        timer = new Timer(periodicite,this);
        timer.start();
    }


    public int getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(int periodicite) {
        this.periodicite = periodicite;
        timer = new Timer(this.periodicite,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        puits.gravite();
        vuePuits.repaint();
    }

    public VuePuits getVuePuits() {
        return vuePuits;
    }
}
