package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.Random;

public class UsineDePiece {

    public static final int ALEATOIRE_COMPLET=0;

    public static final int ALEATOIRE_PIECE =1;

    public static final int CYCLIC =2;

    int mode;

    private UsineDePiece() {
        this.mode = ALEATOIRE_PIECE;
    }

    public void setMode(int m){
        if (m ==0){
            this.mode =ALEATOIRE_COMPLET ;
        }
        if (m==1){
            this.mode = ALEATOIRE_PIECE;
        }
        if (m==2){
            this.mode = CYCLIC;
        }
    }

    public Piece genererPiece(){
        int count=0;
        if(this.mode==CYCLIC){
            if (count ==0){
                return new OPiece(new Coordonnees(2,3),Couleur.ROUGE);
            }
            if(count ==1){
                count =0;
                return new IPiece(new Coordonnees(2,3),Couleur.ORANGE);
            }

        }
        if(this.mode==ALEATOIRE_PIECE){
            Random rand = new Random();
            int a =  rand.nextInt(2);
            if (a==0){
                return new OPiece(new Coordonnees(2,3),Couleur.ROUGE);
            }
            if(a==1){
                return new IPiece(new Coordonnees(2,3),Couleur.ORANGE);
            }
        }
        if(this.mode == ALEATOIRE_COMPLET){
            Random rand = new Random();
            int b =  rand.nextInt(2);
            if (b==0){
                return new OPiece(new Coordonnees(2,3),Couleur.values()[rand.nextInt(7)]);
            }
            if(b==1){
                return new IPiece(new Coordonnees(2,3),Couleur.values()[rand.nextInt(7)]);
            }
        }
        return null;
    }
}
