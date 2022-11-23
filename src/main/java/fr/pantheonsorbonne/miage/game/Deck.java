package fr.pantheonsorbonne.miage.game;

import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class Deck {
    
    private Deck() {
    }

    

    public static LinkedList<Card> deck = new LinkedList();
    public static List<Card> cardOnTheTable = new ArrayList<>();
   
   
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


 

 
 


 /*  Prendre 4 cartes de la pioche pour les mettre sur la table au début du jeu
 public void createTable(){
  
    for(int i=deckSize-1 ; i>(deckSize)-5; i--){
        cardOnTheTable.add(deck.get(i)); 
        deck.remove(i);
        //deck.remove(deck.get(i)); // On supprime ces cartes de la pioche: mise à jour de,la pioche
    }

}
*/


  

/*  Donner une carte à un joueur

  
public Card giveNewCard(){
    
    if(deck.isEmpty()){
        throw new RuntimeException("Il n'y a plus de carte , la partie est donc terminée!");
    }

    else{
  
    Card cardToPlayer = deck.get((deck.size())-1);
    deck.remove(cardToPlayer); // On supprime de la pioche la carte une fois qu'elle est donnée à un joueur: mise à jour
    return cardToPlayer;
    
}




}

*/

} 













