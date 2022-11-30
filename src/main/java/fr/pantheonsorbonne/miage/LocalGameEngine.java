package fr.pantheonsorbonne.miage;
import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.LocalGameEngine;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.game.Deck;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import javax.swing.event.CaretListener;


public class LocalGameEngine {
    
    protected Collection<Card> cardOnTheTable = new ArrayList<>();
    final Map <String,Integer> finalScore = new HashMap<>();
    protected final Collection <Player> players= new ArrayList<>();
    


public void play(){

    

    // Objet qui va nous servir a utiliser les methodes de la classe playCard pour les joueurs
    Deck.createDeck();
    
    System.out.println("DEBUT DE LA PARTIE");
    for(Player player : players){
        distribuateCardToPlayer(player);
        displayPlayerHand(player);
    }
    do{
    putFourCardOnTheTable();
    }
    while(haveTreeCardSameOnTheTable());
    
    

while (!Deck.deck.isEmpty()){
    
    for( Player player : players){
       
        System.out.println("Main de "+ player.getName()+ ": " +player.getHand());
        if (cardOnTheTable.isEmpty()){ // Après une scopa du joueur précédent, il faut poser une carte
            putACardOnTheTable(player);
           }
       
       
        else if(getPair(player)){
        System.out.println(player.getName() +" a fait une  paire. " );
        if (cardOnTheTable.isEmpty()){
            System.out.println(player.getName()+ " a fait une scopa!");
            player.haveNewPoint();
        }

        }

        else{
        putACardOnTheTable(player);
        }
    
      
       
        System.out.println(player.getName()+ " a stocké " +player.getStoredCard());
        System.out.println("point de scopa "+player.getFinalScore());   
        System.out.println("Voici les cartes sur la table " +cardOnTheTable);
      // On redonne une carte pour le tour d'après
      
      player.getHand().add(giveNewCard()); 
        

  
    }
    
}

// Maintenant , il y'a plus de carte dans la pioche, chaque joueur joue donc à tour de role jusqu'a qu'il n'est plus de carte
System.out.println("Plus de carte dans la pioche");


String lastPlayerWithPair="";
for(int i=0; i<Player.HAND_SIZE;i++){
    for (Player player: players){
    
    
        System.out.println("Main de "+ player.getName()+ ": " +player.getHand());
        if (cardOnTheTable.isEmpty()){ // Après une scopa du joueur précédent, il faut poser une carte
            putACardOnTheTable(player);
           }
       
       
       

       
       else if(getPair(player)){
        System.out.println(player.getName() +" a fait une  paire. " );
         lastPlayerWithPair= player.getName();
        if (cardOnTheTable.isEmpty()){
            System.out.println(player.getName()+ " a fait une scopa!");
            player.haveNewPoint();
            
           
        }

     }

       else{
        putACardOnTheTable(player);
       }
    
       System.out.println("Carte stocké de " + player.getName() +player.getStoredCard());
       System.out.println("Point de scopa " + player.getFinalScore());
       System.out.println("Voici les cartes sur la table " +cardOnTheTable);
}




}

System.out.println("Le dernier joueur a avoir fait une paire est "+ lastPlayerWithPair);


// Il va récuperer les cartes sur la table
if(!cardOnTheTable.isEmpty()){
    for(Player player : players){
        if (player.getName().equals(lastPlayerWithPair)){
            for(Card card : cardOnTheTable){
                player.getStoredCard().add(card);
            }
        System.out.println(player.getName() + player.getStoredCard());
        }
    }
}

 // Partie terminée , on procède au comptage et à la distribution des points
compareCountCard();
compareCountCardDeniers();
pointForSeptDeDeniers();
displayFinalScorel();
announceTheWinner();
    

}
    
    
   












public Card giveNewCard(){
    return Deck.deck.poll();
}

public void distribuateCardToPlayer(Player joueur ){
    for( int i=0; i<Player.HAND_SIZE; i++){
        Card c = giveNewCard();
        joueur.getHand().add(c);
     }
   }


public void displayPlayerHand(Player player){
       System.out.println(player.getName() + " a les cartes  " + player.getHand());

    }




public void putFourCardOnTheTable(){
  
    for(int i =0;i<4; i++){
        cardOnTheTable.add(Deck.deck.poll());
    }
    System.out.println( "Voici les cartes sur la table "+cardOnTheTable);
    
}

public boolean haveTreeCardSameOnTheTable(){
    for (Card card1 : cardOnTheTable){
        int count =0;
        for (Card card2: cardOnTheTable){
            if(card1.equalsValue(card2)){
                count ++;
            }
         
         }
         if(count==3){
            for(Card card : cardOnTheTable){
            Deck.deck.add(card);
            
        }
        Collections.shuffle(Deck.deck);
        cardOnTheTable.clear(); // On supprime toutes les cartes de la table
        System.out.println("Il y'a 3 cartes pareilles sur la table. On va reposer des nouvelles cartes");
        return true;
    }


}
return false;

}


public boolean havePairWithSeptDeniers(Player player){
    for( Card card1 : player.getHand()){
        if (card1.getValue()==CardValue.SEPT && card1.getFigure()==CardFigure.DENIERS){ //if (card1.toString()== "SEPT de DENIERS")
            for(Card card2: cardOnTheTable){
                if(card1.equalsValue(card2)){
                    player.getStoredCard().add(card1);
                    player.getStoredCard().add(card2);
                    player.getHand().remove(card1);
                    cardOnTheTable.remove(card2);
                    return true; // Si pair avec sept de denier
                }
                
            }
            
        }
        
    }
     // Si pas sept de denier dans la main, on regarde si sept de denier sur la table et si oui on fait une paire avec si possible
    for (Card card1 : cardOnTheTable){
        if (card1.getValue()==CardValue.SEPT && card1.getFigure()==CardFigure.DENIERS){
            for(Card card2: player.getHand()){
                if (card1.equalsValue(card2)){
                    player.getStoredCard().add(card1);
                    player.getStoredCard().add(card2);
                    cardOnTheTable.remove(card1);
                    player.getHand().remove(card2);
                    return true; // Si pair avec sept de denier

                    
                }
            }
        }

    }

    return false;

  
}
    



 
public boolean havePairWithDeniers(Player player){

    for(Card card1 : player.getHand()){ // on veut faire une paire si il y'a une carte de denier dans la main du joueur
        if(card1.getFigure()==CardFigure.DENIERS){
            for (Card card2:cardOnTheTable){
           
                if(card1.equalsValue(card2)){
                    player.getHand().remove(card1);
                    cardOnTheTable.remove(card2);
                    player.getStoredCard().add(card1);
                    player.getStoredCard().add(card2);
                    //player.getHand().remove(card1);
                    //LocalGame.cardOnTheTable.remove(card2);
                    return true;
                 }
            }
        }    
    }
    
    for(Card card1: cardOnTheTable){ // on veut faire une paire si il y'a une carte de denier sur la table
        if(card1.getFigure()==CardFigure.DENIERS){
            for(Card card2: player.getHand()){
                if(card1.equalsValue(card2)){
                    cardOnTheTable.remove(card1);
                    player.getHand().remove(card2);
                    player.getStoredCard().add(card1);
                    player.getStoredCard().add(card2);
                    //LocalGame.cardOnTheTable.remove(card1);
                    //player.getHand().remove(card2);
                    return true;


                }
            }
        }
    }

    return false;
    
 }

 
 


 public boolean haveClassicPair(Player player){

 if (( cardOnTheTable.size() ) != 2){ // On ne fait une paire que si il n'ya pas deux cartes sur la table car sinon, on laisserait qu'une seule carte ce qui permettrait au joueur suivant de faire une scopa en cas de pair
    
    for(Card card1:player.getHand()){

        for (Card card2: cardOnTheTable){

            if(card1.equalsValue(card2)){
                player.getHand().remove(card1);
                cardOnTheTable.remove(card2);
                player.getStoredCard().add(card1);
                player.getStoredCard().add(card2);
                //player.getHand().remove(card1);
                //LocalGame.cardOnTheTable.remove(card2);
                return true;

            }
        }

    
    }

    return false; // Si pas de paire

}

return false; // Si il n'ya que deux cartes sur la table
 }
    
    /* } */

    /*else{
        return false
    } 
 }*/




   



 
public boolean getPair(Player player) {
        
    boolean pairSeptDeniers=havePairWithSeptDeniers(player);
        if(!pairSeptDeniers){
            boolean pairDeniers = havePairWithDeniers(player);
                if(!pairDeniers){
                   return haveClassicPair(player); 


                }
                return true; // le Joueur a une paire de deniers
            

        }
        return true; // le Joueur a une paire avec le sept de denier
    }
    

   


    public boolean putAClassicCard(Player player){
        for(Card card : player.getHand()){ 
            if (card.getFigure()!=CardFigure.DENIERS){  // on pose une carte qui n'est pas de deniers par stratégie
                System.out.println(player.getName() + " a posé la carte " + card + " sur la table ");
                cardOnTheTable.add(card);
                player.getHand().remove(card);
                return true;
                

            }
        }
        return false;
        

    }

    public boolean putACardOfDeniers(Player player){
        for (Card card: player.getHand()){
            if (card.getValue()!=CardValue.SEPT){
                System.out.println(player.getName() + " a posé la carte " + card + " sur la table");
                cardOnTheTable.add(card); // il pose alors une carte de denier mais pas le sept afin de le garder pour en faire une paire ensuite
                player.getHand().remove(card);
                return true;
            }
        }
        return false;

    }

    public boolean putACardOfSeptDeniers(Player player){
        for(Card card : player.getHand()){
            System.out.println(player.getName() + " a posé la carte " + card + " sur la table");
            cardOnTheTable.add(card); 
            player.getHand().remove(card);
            return true;
            

        }
       return false

    }
    
    
    public void putACardOnTheTable(Player player){
        boolean putACard = putAClassicCard(player);
        if(!putACard){
            putACard = putACardOfDeniers(player);
            if(!putACard){
                putACardOfSeptDeniers(player);
            }
        }
    }
       

    public int countCardDeniers(Player player){
        int countCardDeniers= 0;
        
        for(Card card : player.getStoredCard()){
            if(card.getFigure()==CardFigure.DENIERS){
                countCardDeniers=countCardDeniers+1;
            }
        }
    
        return countCardDeniers;
    
    }
    
    public void compareCountCardDeniers(){
    
        // Construction d'une map avec tous les nb de cartes de deniers des joueurs
        Map<String,Integer> stockCountDeniers = new HashMap<>();
        for ( Player player : players){
           stockCountDeniers.put(player.getName(),countCardDeniers(player));
        }
        
        int maxCardDeniers=0;
        for( int countCardDeniers : stockCountDeniers.values()){
            if ( countCardDeniers>maxCardDeniers){
                maxCardDeniers=countCardDeniers; 
            }
        }
    
        for (Map.Entry<String, Integer> entry : stockCountDeniers.entrySet()){
            if(entry.getValue()==maxCardDeniers){
                String name= entry.getKey(); // on stock le nom du joueur qui a la + de carte de denier
                System.out.println( name + " a le max de deniers " + maxCardDeniers);
                for ( Player player : players){
                    if (player.getName().equals(name)){
                        player.haveNewPoint();
                        break;
                    }
                }
    
        
    
            }
        }
    
    
    
    }
    
    public int countCard(Player player){
        return player.getStoredCard().size();
        
    }
    
    public void compareCountCard(){
    
        // Construction d'une map avec tous les nb de cartess des joueurs
        Map<String,Integer> stockCountCard = new HashMap<>();
        for ( Player player : players){
           stockCountCard.put(player.getName(),countCard(player));
        }
        
        int maxCard=0;
        for( int countCard : stockCountCard.values()){
            if ( countCard>maxCard){
                maxCard=countCard; 
            }
        }
    
        for (Map.Entry<String, Integer> entry : stockCountCard.entrySet()){
            if(entry.getValue()==maxCard){
                String name= entry.getKey(); // on stock le nom du joueur qui a la + de carte 
                for ( Player player : players){
                    if (player.getName().equals(name)){
                        player.haveNewPoint();
                        System.out.println( name + " a le max de carte " + maxCard);
                        break;
                    }
                }
            }
    
        }
    
        
    
            }
        
    
    
    
    
    
    
    public boolean haveSeptDeDeniers(Player player) {
        for(Card card : player.getStoredCard()){
            if (card.getFigure()==CardFigure.DENIERS && card.getValue()==CardValue.SEPT){
                return true;
            }
        }
    
        return false;
    }
    
    public void pointForSeptDeDeniers(){
        for(Player player : players){
            if ( haveSeptDeDeniers(player)){
                    System.out.println( player.getName() + " a le sept deniers");
                    player.haveNewPoint();
                    break;
                    }
                }
            }
    
        
    
    
    
    
    
    
        public void displayFinalScorel(){
        
         for(Player player: players){
            finalScore.put(player.getName(),player.getFinalScore());
         }
    
         for (Map.Entry<String, Integer> finalScoEntry :finalScore.entrySet()) { // pour récupérer les clés valeurs
            String name = finalScoEntry.getKey();
            Integer score = finalScoEntry.getValue();
            System.out.println(name + " a pour score final " + score);
    
         }
    
    }
    
    
    public  void announceTheWinner(){
        int maxScore=0;
        String name="";
        for (Map.Entry<String, Integer> finalScoEntry :finalScore.entrySet()) { // on va stocker le nom et le score du meilleur joueur
            int score = finalScoEntry.getValue();
            if (score>maxScore){
                maxScore=score;
                name = finalScoEntry.getKey();
            }
        }
        finalScore.remove(name);
        boolean gagnant = true;
        for (Map.Entry<String, Integer> finalScoEntry :finalScore.entrySet()) {
            if(finalScoEntry.getValue()==maxScore){ // Cas ou deux personnes sont égalités
                System.out.println("Il n'y a pas de gagnant pour cette partie");
                gagnant = false;
                break;
            }
         }
        if(gagnant){
            System.out.println (name+ " remporte la partie avec un score de "+ maxScore +" . " + "Bravo!");
        }
    
    
    
    
    }
       
       
       
       
       
       
}
