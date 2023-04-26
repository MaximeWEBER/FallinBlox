package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public abstract class Piece {

     private Coordonnees coordonnees;

     public Couleur couleur;

     private List<Element> elements;

     private Puits puits;

     public Piece(Coordonnees coordonnees, Couleur couleur) {
          this.coordonnees = coordonnees;
          this.couleur = couleur;
          this.elements = new ArrayList<Element>();
          this.setElements(coordonnees, couleur);
          this.setPuits(puits);
     }

     public List<Element> getElements() {
          return elements;
     }

     protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

     public void setPosition(int abscisse, int ordonnee) {
          elements.clear();
          setElements(new Coordonnees(abscisse, ordonnee), couleur);
     }

     @Override
     public String toString() {
          String string = this.getClass().getSimpleName() + " :\n";
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

     private static boolean containsClassAtPosition(Object[][] array, int row, int col, Class<?> clazz) {
          if (row >= 0 && row < array.length && col >= 0 && col < array[0].length) {
               Object obj = array[row][col];
               return clazz.isInstance(obj);
          }
          return false;
     }

     public void deplacerDe(int deltaX, int deltaY) throws IllegalArgumentException, BloxException {
          if (Math.abs(deltaX) > 1 || deltaY < 0 || deltaY > 1) {
               throw new IllegalArgumentException("Non valide");
          }
          else {
               if (getPuits() != null) {
                    int count = 0;
                    for (int i = 0; i < getElements().size(); i++) {
                         if (getElements().get(i).getCoordonnees().getAbscisse() + deltaX < 0 || getPuits().getLargeur()-1 < getElements().get(i).getCoordonnees().getAbscisse() + deltaX) {
                              for (int j = 0; j < count; j++) {
                                   this.elements.get(j).getCoordonnees().setAbscisse(elements.get(j).getCoordonnees().getAbscisse() - deltaX);
                                   this.elements.get(j).getCoordonnees().setOrdonnee(elements.get(j).getCoordonnees().getOrdonnee() - deltaY);
                              }

                              throw new BloxException("Sortie de Puits", BloxException.BLOX_SORTIE_PUITS);
                              // NON LOGIQUE CAR SI PROFONDEUR 24 ALORS EXECUTION D'UNE ERREUR, C'EST SI ET SSI 25
                              // A CHANGER CAR NON CONFORME AU CAHIER DES CHARGES
                         } else if (getPuits().getProfondeur() <= getElements().get(i).getCoordonnees().getOrdonnee() + deltaY) {
                              for (int j = 0; j < count; j++) {
                                   this.elements.get(j).getCoordonnees().setAbscisse(elements.get(j).getCoordonnees().getAbscisse() - deltaX);
                                   this.elements.get(j).getCoordonnees().setOrdonnee(elements.get(j).getCoordonnees().getOrdonnee() - deltaY);
                              }
                              throw new BloxException("Collision avec le bas du Puits", BloxException.BLOX_COLLISION);
                         } else if (containsClassAtPosition(puits.getTas().getElements(), elements.get(i).getCoordonnees().getOrdonnee() + deltaY, elements.get(i).getCoordonnees().getAbscisse() + deltaX, Element.class)) {
                              for (int j = 0; j < count; j++) {
                                   this.elements.get(j).getCoordonnees().setAbscisse(elements.get(j).getCoordonnees().getAbscisse() - deltaX);
                                   this.elements.get(j).getCoordonnees().setOrdonnee(elements.get(j).getCoordonnees().getOrdonnee() - deltaY);
                              }

                              throw new BloxException("Collision avec le bas du Puits", BloxException.BLOX_COLLISION);
                         } else {
                              count += 1;
                              elements.get(i).deplacerDe(deltaX, deltaY);
                         }

                    }
               }
               else {
                    System.out.println("HELLO");
                    for (int i = 0; i < getElements().size(); i++) {
                         elements.get(i).deplacerDe(deltaX, deltaY);
                    }
               }


          }
     }

     public void tourner(boolean sensHoraire) throws BloxException {
          int tab[]={getElements().get(1).getCoordonnees().getAbscisse(),getElements().get(1).getCoordonnees().getOrdonnee(),getElements().get(2).getCoordonnees().getAbscisse(),getElements().get(2).getCoordonnees().getOrdonnee(),getElements().get(3).getCoordonnees().getAbscisse(),getElements().get(3).getCoordonnees().getOrdonnee()};
          if (sensHoraire) {
               int count1 = 1;
               double angle = -Math.PI / 2;
               if (getPuits() != null) {
                    for (int i = 1; i < this.getElements().size(); i++) {
                         int xM1 = getElements().get(i).getCoordonnees().getAbscisse() - getElements().get(0).getCoordonnees().getAbscisse();
                         int yM1 = getElements().get(i).getCoordonnees().getOrdonnee() - getElements().get(0).getCoordonnees().getOrdonnee();
                         int x1 = (int) (round(xM1 * Math.cos(angle) + yM1 * Math.sin(angle) + getElements().get(0).getCoordonnees().getAbscisse()));
                         int y1 = (int) (-xM1 * Math.sin(angle) + yM1 * Math.cos(angle) + getElements().get(0).getCoordonnees().getOrdonnee());

                         if (x1 <0 || getPuits().getLargeur()-1 < x1) {
                              for (int j = 1; j < count1; j++) {
                                   this.elements.get(j).getCoordonnees().setAbscisse(tab[2*(j-1)]);
                                   this.elements.get(j).getCoordonnees().setOrdonnee(tab[2*j-1]);
                              }
                              throw new BloxException("Sortie de Puits", BloxException.BLOX_SORTIE_PUITS);
                         }
                         else if (getPuits().getProfondeur()-1 < y1) {
                              for (int j = 1; j < count1; j++) {
                                   this.elements.get(j).getCoordonnees().setAbscisse(tab[2*(j-1)]);
                                   this.elements.get(j).getCoordonnees().setOrdonnee(tab[2*j-1]);
                              }
                              throw new BloxException("Collision avec le bas du Puits", BloxException.BLOX_COLLISION);
                         } else if (containsClassAtPosition(puits.getTas().getElements(), y1, x1, Element.class)) {
                              for (int j = 1; j < count1; j++) {
                                   this.elements.get(j).getCoordonnees().setAbscisse(tab[2*(j-1)]);
                                   this.elements.get(j).getCoordonnees().setOrdonnee(tab[2*j-1]);
                              }
                              throw new BloxException("Impossible de tourner dans le sens horaire", BloxException.BLOX_COLLISION);
                         }
                         else {
                              count1 += 1;
                              getElements().get(i).setCoordonnees(new Coordonnees(x1, y1));
                         }


                         }
                    }

               else {
                    for (int i = 1; i < this.getElements().size(); i++) {
                         int xM1 = getElements().get(i).getCoordonnees().getAbscisse() - getElements().get(0).getCoordonnees().getAbscisse();
                         int yM1 = getElements().get(i).getCoordonnees().getOrdonnee() - getElements().get(0).getCoordonnees().getOrdonnee();
                         int x1 = (int) (xM1 * Math.cos(angle) + yM1 * Math.sin(angle) + getElements().get(0).getCoordonnees().getAbscisse());
                         int y1 = (int) (-xM1 * Math.sin(angle) + yM1 * Math.cos(angle) + getElements().get(0).getCoordonnees().getOrdonnee());
                         getElements().get(i).setCoordonnees(new Coordonnees(x1, y1));
                    }
               }
          }
          else{
               int count2 = 1;
               double angle2 = Math.PI / 2;
               if (getPuits() != null) {
                    for (int i = 1; i < this.getElements().size(); i++) {
                         int xM1 = getElements().get(i).getCoordonnees().getAbscisse() - getElements().get(0).getCoordonnees().getAbscisse();
                         int yM1 = getElements().get(i).getCoordonnees().getOrdonnee() - getElements().get(0).getCoordonnees().getOrdonnee();
                         int x1 = (int) (round(xM1 * Math.cos(angle2) + yM1 * Math.sin(angle2) + getElements().get(0).getCoordonnees().getAbscisse()));
                         int y1 = (int) (-xM1 * Math.sin(angle2) + yM1 * Math.cos(angle2) + getElements().get(0).getCoordonnees().getOrdonnee());
                         System.out.println(x1);
                         System.out.println(y1);
                         if (x1 <0 || getPuits().getLargeur()-1 < x1) {
                              for (int j = 1; j < count2; j++) {
                                   this.elements.get(j).getCoordonnees().setAbscisse(tab[2*(j-1)]);
                                   this.elements.get(j).getCoordonnees().setOrdonnee(tab[2*j-1]);
                              }
                              throw new BloxException("Sortie de Puits", BloxException.BLOX_SORTIE_PUITS);
                         }
                         else if (getPuits().getProfondeur()-1 < y1) {
                              for (int j = 1; j < count2; j++) {
                                   this.elements.get(j).getCoordonnees().setAbscisse(tab[2*(j-1)]);
                                   this.elements.get(j).getCoordonnees().setOrdonnee(tab[2*j-1]);
                              }
                              throw new BloxException("Collision avec le bas du Puits", BloxException.BLOX_COLLISION);
                         } else if (containsClassAtPosition(puits.getTas().getElements(), y1, x1, Element.class)) {
                              for (int j = 1; j < count2; j++) {
                                   this.elements.get(j).getCoordonnees().setAbscisse(tab[2*(j-1)]);
                                   this.elements.get(j).getCoordonnees().setOrdonnee(tab[2*j-1]);
                              }
                              throw new BloxException("Impossible de tourner dans le sens horaire", BloxException.BLOX_COLLISION);
                         }
                         else {
                              count2 += 1;
                              getElements().get(i).setCoordonnees(new Coordonnees(x1, y1));
                         }

                    }
               }
               else {
                    for (int i = 1; i < this.getElements().size(); i++) {
                         int xM1 = getElements().get(i).getCoordonnees().getAbscisse() - getElements().get(0).getCoordonnees().getAbscisse();
                         int yM1 = getElements().get(i).getCoordonnees().getOrdonnee() - getElements().get(0).getCoordonnees().getOrdonnee();
                         int x1 = (int) (xM1 * Math.cos(angle2) + yM1 * Math.sin(angle2) + getElements().get(0).getCoordonnees().getAbscisse());
                         int y1 = (int) (-xM1 * Math.sin(angle2) + yM1 * Math.cos(angle2) + getElements().get(0).getCoordonnees().getOrdonnee());
                         count2 += 1;
                         getElements().get(i).setCoordonnees(new Coordonnees(x1, y1));
                    }
               }
          }
     }
}

