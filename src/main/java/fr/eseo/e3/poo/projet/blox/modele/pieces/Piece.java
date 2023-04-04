package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

     Coordonnees coordonnees;

     Couleur couleur;

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
}
