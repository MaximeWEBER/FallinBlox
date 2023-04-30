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
            throw new IllegalArgumentException("Le nombre d'élements est trop grand");
        }
        else{
            //int nbElementsAPlacer = 0;
            System.out.println(nbElements);
            while (nbElements!=0){
                int prof = puits.getProfondeur() - (rand.nextInt(nbLignes)+1);
                int larg = rand.nextInt(puits.getLargeur());

                if(elements[prof][larg]==null){
                    int indiceCouleur = rand.nextInt(7);
                    elements[prof][larg] = new Element(larg,prof, Couleur.values()[indiceCouleur]);
                    nbElements -=1;
                }
            }
        }
    }
    public void ajouterElements(Piece piece) {
        elements[piece.getElements().get(0).getCoordonnees().getOrdonnee()]
                [piece.getElements().get(0).getCoordonnees().getAbscisse()]
                = new Element(new Coordonnees(piece.getElements().get(0).getCoordonnees().getAbscisse()
                , piece.getElements().get(0).getCoordonnees().getOrdonnee()),piece.getElements().get(0).getCouleur());
        elements[piece.getElements().get(1).getCoordonnees().getOrdonnee()]
                [piece.getElements().get(1).getCoordonnees().getAbscisse()]
                = new Element(new Coordonnees(piece.getElements().get(1).getCoordonnees().getAbscisse()
                , piece.getElements().get(1).getCoordonnees().getOrdonnee()),piece.getElements().get(0).getCouleur());
        elements[piece.getElements().get(2).getCoordonnees().getOrdonnee()]
                [piece.getElements().get(2).getCoordonnees().getAbscisse()]
                = new Element(new Coordonnees(piece.getElements().get(2).getCoordonnees().getAbscisse()
                , piece.getElements().get(2).getCoordonnees().getOrdonnee()),piece.getElements().get(0).getCouleur());
        elements[piece.getElements().get(3).getCoordonnees().getOrdonnee()]
                [piece.getElements().get(3).getCoordonnees().getAbscisse()]
                = new Element(new Coordonnees(piece.getElements().get(3).getCoordonnees().getAbscisse()
                , piece.getElements().get(3).getCoordonnees().getOrdonnee()),piece.getElements().get(0).getCouleur());
        verificationDeTas();
    }

    private static boolean containsClassAtPosition(Object[][] array, int row, int col, Class<?> clazz) {
        if (row >= 0 && row < array.length && col >= 0 && col < array[0].length) {
            Object obj = array[row][col];
            return clazz.isInstance(obj);
        }
        return false;
    }
    int nbLigneSup=0;
    public void verificationDeTas(){
        nbLigneSup=0;
        for(int i=0;i<getElements().length;i++){
            int compteurLigneJ =0;
            for(int j=0; j<getElements()[0].length;j++){
                if(containsClassAtPosition(getElements(), i, j, Element.class)){
                    compteurLigneJ+=1;
                    if(compteurLigneJ==puits.getLargeur()){
                        nbLigneSup+=1;
                        compteurLigneJ-=1;
                        while(compteurLigneJ!=-1){
                            elements[i][compteurLigneJ]=null;
                            compteurLigneJ--;
                        }
                        for(int k=i;k>1;k--) {
                            for (int h = 0; h < getElements()[0].length; h++) {
                                System.out.println("HELLP");
                                if (elements[k-1][h] != null && elements[k][h] == null) {
                                    Element ele = elements[k-1][h];
                                    elements[k-1][h] = null;
                                    elements[k][h] = new Element(h, k, ele.getCouleur());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
