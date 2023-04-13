package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

     Coordonnees coordonnees;

     public Couleur couleur;

     private List<Element> elements;

     Puits puits;

     public Piece(Coordonnees coordonnees, Couleur couleur) {
          this.coordonnees = coordonnees;
          this.couleur=couleur;
          this.elements = new ArrayList<Element>();
          this.setElements(coordonnees,couleur);
     }

     public List<Element> getElements(){
          return elements;
     }
     protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

     public void setPosition(int abscisse, int ordonnee){
          elements.clear();
          setElements(new Coordonnees(abscisse,ordonnee),couleur);
     }
     @Override
     public String toString() {
          String string = this.getClass().getSimpleName()+" :\n";
          for (Element element : elements) {
               string += "\t" + element.toString() + "\n";
          }
          return string;
     }

     public Puits getPuits() {
          return puits;
     }

     public void setPuits(Puits puits) {
          this.puits = puits;
     }

     public void deplacerDe(int deltaX, int deltaY) throws IllegalArgumentException{
          if(Math.abs(deltaX)>1 || deltaY <0 || deltaY>1){
               throw new IllegalArgumentException("Non valide");
          }
          else{
               for(int i=0;i<getElements().size();i++){
                    elements.get(i).deplacerDe(deltaX,deltaY);
               }
          }
     }

     public void tourner(boolean sensHoraire){
          /*
          if(this.getClass().getSimpleName().equalsIgnoreCase("IPiece")){
               if(sensHoraire && getElements().get(1).getCoordonnees().getOrdonnee() == getElements().get(0).getCoordonnees().getOrdonnee()-1){
                    getElements().get(1).setCoordonnees(new Coordonnees(getElements().get(0).getCoordonnees().getAbscisse()+1,getElements().get(0).getCoordonnees().getOrdonnee()));
                    getElements().get(2).setCoordonnees(new Coordonnees(getElements().get(0).getCoordonnees().getAbscisse()+2,getElements().get(0).getCoordonnees().getOrdonnee()));
                    getElements().get(3).setCoordonnees(new Coordonnees(getElements().get(0).getCoordonnees().getAbscisse()-1,getElements().get(0).getCoordonnees().getOrdonnee()));
               }
               else if (getElements().get(1).getCoordonnees().getOrdonnee() == getElements().get(0).getCoordonnees().getOrdonnee()){
                    getElements().get(1).setCoordonnees(new Coordonnees(getElements().get(0).getCoordonnees().getAbscisse(),getElements().get(0).getCoordonnees().getOrdonnee()-1));
                    getElements().get(2).setCoordonnees(new Coordonnees(getElements().get(0).getCoordonnees().getAbscisse(),getElements().get(0).getCoordonnees().getOrdonnee()-2));
                    getElements().get(3).setCoordonnees(new Coordonnees(getElements().get(0).getCoordonnees().getAbscisse(),getElements().get(0).getCoordonnees().getOrdonnee()+1));

               }
               else{
                    getElements().get(1).setCoordonnees(new Coordonnees(getElements().get(0).getCoordonnees().getAbscisse()-1,getElements().get(0).getCoordonnees().getOrdonnee()));
                    getElements().get(2).setCoordonnees(new Coordonnees(getElements().get(0).getCoordonnees().getAbscisse()-2,getElements().get(0).getCoordonnees().getOrdonnee()));
                    getElements().get(3).setCoordonnees(new Coordonnees(getElements().get(0).getCoordonnees().getAbscisse()+1,getElements().get(0).getCoordonnees().getOrdonnee()));
               }

          }
          */
          if(sensHoraire){
               double angle = -Math.PI/2;

               for(int i=1; i<this.getElements().size();i++){
                    int xM1 = getElements().get(i).getCoordonnees().getAbscisse()-getElements().get(0).getCoordonnees().getAbscisse();
                    int yM1 = getElements().get(i).getCoordonnees().getOrdonnee()-getElements().get(0).getCoordonnees().getOrdonnee();;
                    int x1 = (int) (xM1 * Math.cos(angle) + yM1 * Math.sin(angle) + getElements().get(0).getCoordonnees().getAbscisse());
                    int y1 = (int) (-xM1 * Math.sin(angle) + yM1 * Math.cos(angle) + getElements().get(0).getCoordonnees().getOrdonnee());
                    getElements().get(i).setCoordonnees(new Coordonnees(Math.round(x1),Math.round(y1)));
               }
          }
          else {
               double angle = Math.PI/2;
               for (int i = 1; i < this.getElements().size(); i++) {
                    int xM1 = getElements().get(i).getCoordonnees().getAbscisse() - getElements().get(0).getCoordonnees().getAbscisse();
                    int yM1 = getElements().get(i).getCoordonnees().getOrdonnee() - getElements().get(0).getCoordonnees().getOrdonnee();
                    int x1 = (int) (xM1 * Math.cos(angle) + yM1 * Math.sin(angle) + getElements().get(0).getCoordonnees().getAbscisse());
                    int y1 = (int) (-xM1 * Math.sin(angle) + yM1 * Math.cos(angle) + getElements().get(0).getCoordonnees().getOrdonnee());
                    getElements().get(i).setCoordonnees(new Coordonnees(x1, y1));
               }
          }
     }
}
