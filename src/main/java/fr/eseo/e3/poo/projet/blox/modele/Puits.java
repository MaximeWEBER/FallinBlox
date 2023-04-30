package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {

    public static final int LARGEUR_PAR_DEFAUT=10;

    public static final int PROFONDEUR_PAR_DEFAUT=20;

    public static final String MODIFICATION_PIECE_ACTUELLE = "ACTUELLE";

    public static final String MODIFICATION_PIECE_SUIVANTE = "SUIVANTE";

    private java.beans.PropertyChangeSupport pcs;

    private int largeur;

    private int profondeur;
    private Piece pieceActuelle;

    private Piece pieceSuivante;

    private Tas tas;

    public Puits() {
        setProfondeur(PROFONDEUR_PAR_DEFAUT);
        setLargeur(LARGEUR_PAR_DEFAUT);
        this.pcs = new java.beans.PropertyChangeSupport(this);
        this.tas=new Tas(this);
    }

    public Puits(int largeur, int profondeur) {
        setProfondeur(profondeur);
        setLargeur(largeur);
        this.pcs = new java.beans.PropertyChangeSupport(this);
        this.tas=new Tas(this);
    }

    public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
        setProfondeur(profondeur);
        setLargeur(largeur);
        this.pcs = new java.beans.PropertyChangeSupport(this);
        this.tas= new Tas(this,nbElements, nbLignes);
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
        Piece pieceActuelleBackup = this.pieceActuelle;
        Piece pieceSuivanteBackup = this.pieceSuivante;
        if (pieceSuivante!=null){
            pieceActuelle = pieceSuivante;
            pieceActuelle.setPosition(this.largeur/2,-4);
            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE,pieceActuelleBackup,pieceActuelle);
            pieceActuelle.setPuits(this);
        }
        pieceSuivante = piece;
        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE,pieceSuivanteBackup,pieceSuivante);


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
            return "Puits : Dimension "+this.largeur+" x "+this.profondeur+"\n"+"Piece Actuelle : "
                    +"<"+c+">"+"\n" +"Piece Suivante : " +"<"+c+">"+"\n";
        }
        if(this.pieceActuelle == null){
            String a = "aucune";
            return "Puits : Dimension "+this.largeur+" x "+this.profondeur+"\n"+"Piece Actuelle : "+"<"+a+">"+"\n"
                    +"Piece Suivante : "+ pieceSuivante.toString();
        }
        return "Puits : Dimension "+this.largeur+" x "+this.profondeur+"\n"+"Piece Actuelle : "
                + pieceActuelle.toString()+"Piece Suivante : " + pieceSuivante.toString();
    }

    public Tas getTas() {
        return tas;
    }

    public void setTas(Tas tas) {
        this.tas = tas;
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(java.beans.PropertyChangeListener listener){
        pcs.removePropertyChangeListener(listener);
    }

    private void gererCollision(){
        tas.ajouterElements(getPieceActuelle());
        setPieceSuivante(UsineDePiece.genererPiece());
    }

    public void gravite(){
        try {
            pieceActuelle.deplacerDe(0,1);
        } catch (BloxException e) {
            if (e.getType() == 0)
                gererCollision();
        }
    }


}
