package fr.eseo.e3.poo.projet.blox.controleur;

public class Controle {

    public static void main(String[] args) {
        Music m = new Music();
        m.start();
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {}
        m.end();
    }
}
