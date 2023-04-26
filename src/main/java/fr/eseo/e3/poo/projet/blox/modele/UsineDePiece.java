package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.Random;

public class UsineDePiece {

    public static final int ALEATOIRE_COMPLET=0;

    public static final int ALEATOIRE_PIECE =1;

    public static final int CYCLIC =2;

    static int mode;

    static int count=0;

    private UsineDePiece() {
        mode = ALEATOIRE_PIECE;
    }

    public static void setMode(int m){
        mode = m;
    }

    public static Piece genererPiece(){

        if(mode==CYCLIC){
            if (count ==0){
                count=1;
                return new OPiece(new Coordonnees(2,3),Couleur.ROUGE);
            }
            else if(count ==1){
                count =0;
                return new IPiece(new Coordonnees(2,3),Couleur.ORANGE);
            }
        }


        else if(mode == ALEATOIRE_COMPLET){
            Random rand = new Random();
            int b =  rand.nextInt(2);
            if (b==0){
                return new OPiece(new Coordonnees(2,3),Couleur.values()[rand.nextInt(7)]);
            }
            else if(b==1){
                return new IPiece(new Coordonnees(2,3),Couleur.values()[rand.nextInt(7)]);
            }
        }

        else{
            Random rand = new Random();
            int a =  rand.nextInt(2);
            if (a==0){
                return new OPiece(new Coordonnees(2,3),Couleur.ROUGE);
            }
            else if(a==1){
                return new IPiece(new Coordonnees(2,3),Couleur.ORANGE);
            }
        }
        return null;
    }
}
