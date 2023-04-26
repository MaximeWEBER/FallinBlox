package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.Random;

public class Tas {

    private Puits puits;

    private Element[][] elements;

    public Tas(Puits puits) {
        this.puits = puits;
        this.elements= new Element[puits.getProfondeur()][puits.getLargeur()];
    }

    public Tas(Puits puits, int nbElements, int nbRows) {
        this.puits = puits;
        this.elements= new Element[puits.getProfondeur()][puits.getLargeur()];
        construireTas(nbElements,nbRows,new Random());
    }

    public Tas(Puits puits, int nbElements) {
        this.puits = puits;
        this.elements= new Element[puits.getProfondeur()][puits.getLargeur()];
        int n = nbElements/puits.getLargeur()+1;
        construireTas(nbElements,n,new Random());
    }



    public Puits getPuits() {
        return puits;
    }

    public Element[][] getElements() {
        return elements;
    }

    private void construireTas(int nbElements, int nbLignes, java.util.Random rand){
        System.out.println(nbLignes*puits.getLargeur());
        if (nbElements!=0 && nbElements>=nbLignes*puits.getLargeur()+1){
            System.out.println("Yo");
            throw new IllegalArgumentException("Le nombre d'élements est trop grand");
        }
        else{
            //int nbElementsAPlacer = 0;
            System.out.println(nbElements);
            while (nbElements!=0){
                int ordon = puits.getProfondeur() - (rand.nextInt(nbLignes)+1);
                int absci = rand.nextInt(puits.getLargeur());
                System.out.println(ordon);
                System.out.println(absci);
                if(elements[ordon][absci]==null){
                    int indiceCouleur = rand.nextInt(7);
                    elements[ordon][absci] = new Element(absci,ordon, Couleur.values()[indiceCouleur]);
                    nbElements -=1;
                }
            }
        }
    }

    public void ajouterElements(Piece piece) {
        elements[piece.getElements().get(0).getCoordonnees().getOrdonnee()][piece.getElements().get(0).getCoordonnees().getAbscisse()] = new Element(new Coordonnees(piece.getElements().get(0).getCoordonnees().getAbscisse(), piece.getElements().get(0).getCoordonnees().getOrdonnee()),piece.getElements().get(0).getCouleur());
        elements[piece.getElements().get(1).getCoordonnees().getOrdonnee()][piece.getElements().get(1).getCoordonnees().getAbscisse()] = new Element(new Coordonnees(piece.getElements().get(1).getCoordonnees().getAbscisse(), piece.getElements().get(1).getCoordonnees().getOrdonnee()),piece.getElements().get(0).getCouleur());
        elements[piece.getElements().get(2).getCoordonnees().getOrdonnee()][piece.getElements().get(2).getCoordonnees().getAbscisse()] = new Element(new Coordonnees(piece.getElements().get(2).getCoordonnees().getAbscisse(), piece.getElements().get(2).getCoordonnees().getOrdonnee()),piece.getElements().get(0).getCouleur());
        elements[piece.getElements().get(3).getCoordonnees().getOrdonnee()][piece.getElements().get(3).getCoordonnees().getAbscisse()] = new Element(new Coordonnees(piece.getElements().get(3).getCoordonnees().getAbscisse(), piece.getElements().get(3).getCoordonnees().getOrdonnee()),piece.getElements().get(0).getCouleur());
    }
}
