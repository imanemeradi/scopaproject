package fr.pantheonsorbonne.miage.game;

import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;

import java.util.Collections;
import java.util.LinkedList;




public class Deck {
    
    private Deck() {
    }

    
    public static LinkedList<Card> deck = new LinkedList();
    
   
   
    // Création de la pioche avec toutes les cartes
    public static void createDeck() {

        for (CardFigure figure : CardFigure.values()) {
            for (CardValue value : CardValue.values()) {
                deck.add(new Card(figure,value));

            
        }

     }
     // Une fois la pioche créer, on mélange les cartes
     
     Collections.shuffle(deck);
     
     


 }

 


 

 
 

} 













