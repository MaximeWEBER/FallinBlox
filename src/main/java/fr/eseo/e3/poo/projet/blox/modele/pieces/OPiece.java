package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OPiece extends Piece{

    public OPiece(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees,couleur);
    }


    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        getElements().clear();
        this.getElements().add(new Element(coordonnees,couleur));
        this.getElements().add(new Element(new Coordonnees(coordonnees.getAbscisse(),coordonnees.getOrdonnee()-1),couleur));
        this.getElements().add(new Element(new Coordonnees(coordonnees.getAbscisse()+1,coordonnees.getOrdonnee()),couleur));
        this.getElements().add(new Element(new Coordonnees(coordonnees.getAbscisse()+1,coordonnees.getOrdonnee()-1),couleur));
    }
    @Override
    public void tourner(boolean sensHoraire){
    }

}
