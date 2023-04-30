package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {

    public static final double MULTIPLIER_NUANCE = 0.4;

    private final VuePuits vuePuits;

    private final Tas tas;



    public VueTas(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        tas = vuePuits.getPuits().getTas();
    }

    public VuePuits getVuePuits() {
        return vuePuits;
    }

    public java.awt.Color nuance(java.awt.Color couleur){
        int rougeAugmentee = couleur.getRed();
        int vertAugmentee = couleur.getGreen();
        int bleuAugmentee = couleur.getBlue();
        rougeAugmentee = (int) (rougeAugmentee*(1-MULTIPLIER_NUANCE));
        vertAugmentee = (int) (vertAugmentee*(1-MULTIPLIER_NUANCE));
        bleuAugmentee =(int) (bleuAugmentee*(1-MULTIPLIER_NUANCE));
        return new java.awt.Color(rougeAugmentee,vertAugmentee,bleuAugmentee);
    }

    public void afficher(java.awt.Graphics2D g2D){

        for(int i=0;i<tas.getElements().length;i++){
            for(int j=0;j<tas.getElements()[0].length;j++){
                if(tas.getElements()[i][j]!=null){
                    g2D.setColor(nuance(tas.getElements()[i][j].getCouleur().getCouleurPourAffichage()));
                    g2D.fill3DRect(tas.getElements()[i][j].getCoordonnees().getAbscisse()* vuePuits.getTaille(),tas.getElements()[i][j].getCoordonnees().getOrdonnee()* vuePuits.getTaille(),vuePuits.getTaille(),vuePuits.getTaille(),true);

                }
            }
        }

    }
}
