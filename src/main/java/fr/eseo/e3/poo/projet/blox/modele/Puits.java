package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {

    public static final int LARGEUR_PAR_DEFAUT=10;

    public static final int PROFONDEUR_PAR_DEFAUT=20;

    private int largeur;

    private int profondeur;
    private Piece pieceActuelle;

    private Piece pieceSuivante;

    public Puits() {
        setProfondeur(PROFONDEUR_PAR_DEFAUT);
        setLargeur(LARGEUR_PAR_DEFAUT);
    }

    public Puits(int largeur, int profondeur) {
        setProfondeur(profondeur);
        setLargeur(largeur);
    }

    public int getLargeur() {
        return largeur;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public Piece getPieceActuelle() {
        return pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return pieceSuivante;
    }

    public void setPieceSuivante(Piece piece) {
        if (pieceSuivante!=null){
            pieceActuelle = pieceSuivante;
            pieceActuelle.setPosition(this.largeur/2,-4);
        }
        pieceSuivante = piece;
    }

    public void setLargeur(int largeur) throws IllegalArgumentException{
        if (largeur < 5 || largeur> 15)
            throw new IllegalArgumentException("Largeur non correcte");
        else
            this.largeur = largeur;
    }

    public void setProfondeur(int profondeur) throws IllegalArgumentException {
        if (profondeur<15 || profondeur>25 ){
            throw new IllegalArgumentException("Profondeur non correcte");
        }
        else{
            this.profondeur = profondeur;
        }
    }

    @Override
    public String toString() {
        if (this.pieceActuelle == null && this.pieceSuivante == null){
            String c = "aucune";
            return "Puits : Dimension "+this.largeur+" x "+this.profondeur+"\n"+"Piece Actuelle : "+"<"+c+">"+"\n" +"Piece Suivante : " +"<"+c+">"+"\n";
        }
        if(this.pieceActuelle == null){
            String a = "aucune";
            return "Puits : Dimension "+this.largeur+" x "+this.profondeur+"\n"+"Piece Actuelle : "+"<"+a+">"+"\n" +"Piece Suivante : "+ pieceSuivante.toString();
        }
        return "Puits : Dimension "+this.largeur+" x "+this.profondeur+"\n"+"Piece Actuelle : "+ pieceActuelle.toString()+"Piece Suivante : " + pieceSuivante.toString();
    }
}
