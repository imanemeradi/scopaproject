package fr.pantheonsorbonne.miage;
import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.ScopaEngine;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.game.Deck;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public abstract class ScopaEngine {
    
    protected Collection<Card> cardOnTheTable = new ArrayList<>();
    protected final Map <String,Integer> finalScore = new HashMap<>();
    protected final Collection <Player> players= new ArrayList<>();
    protected final Map<String,Integer> stockCountDeniers = new HashMap<>();
    protected final  Map<String,Integer> stockCountCard = new HashMap<>();
    protected String lastPlayerWithPair="";
    protected String winner="";
    int maxScore=0;
    


public void play(){

    
    Deck.createDeck();
    
    System.out.println("Début de la partie");
    
    for(Player player : players){
        distribuateCardToPlayer(player);
        displayPlayerHand(player);
    }
    
    do{
    putFourCardOnTheTable();
    }
    while(haveTreeCardSameOnTheTable());
    
    
    // Première phase du jeu : jouer tant qu'il y'a des cartes dans la pioche
    while (!Deck.deck.isEmpty()){
    
        for( Player player : players){
       
            displayPlayerHand(player);
            playCard(player);
            displayCardOnTheTable();
            
            // On redonne une carte pour le tour d'après
            player.getHand().add(giveNewCard(player)); 
        }
    
    }

    //  Deuxième phase: chaque joueur joue à tour de role jusqu'a qu'il n'est plus de carte
    System.out.println("Plus de carte dans la pioche");
    for(int i=0; i<Player.HAND_SIZE;i++){
        for (Player player: players){
            
            displayPlayerHand(player);
            playCard(player);
            displayCardOnTheTable();
        }

    }
     // Le dernier joueur a avoir fait une paire va récuperer les cartes sur la table
    System.out.println("Le dernier joueur a avoir fait une paire est "+ lastPlayerWithPair);
    takeCardOnTheTable();

    // Partie terminée , on procède au comptage, à la distribution des points et on annonce le gagnant
    compareCountCard();
    compareCountCardDeniers();
    pointForSeptDeDeniers();
    displayFinalScorel();
    declareWinner();
    

}
    
    
protected abstract Set<String> getInitialPlayers();

protected abstract void takeCardOnTheTable();

protected abstract void playCard(Player player);

protected abstract Card giveNewCard(Player player);

protected abstract void distribuateCardToPlayer(Player joueur );

protected abstract void declareWinner();


protected boolean makeScopa (Player player){
    if (cardOnTheTable.isEmpty()){
        System.out.println(player.getName()+ " a fait une scopa!");
        return true;

    }
return false;
}




protected void displayPlayerHand(Player player){
       System.out.println(player.getName() + " a les cartes  " + player.getHand());

    }

protected void displayCardOnTheTable(){
        System.out.println("Voici les cartes sur la table " +cardOnTheTable);
 
} 

protected void displayStorredCard(Player player){
        System.out.println("Carte stocké de " + player.getName() +" " +player.getStoredCard());
 
} 





protected void putFourCardOnTheTable(){
  
    for(int i =0;i<4; i++){
        cardOnTheTable.add(Deck.deck.poll());
    }
    System.out.println( "Voici les cartes sur la table "+cardOnTheTable);
    
}

protected boolean haveTreeCardSameOnTheTable(){
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


protected boolean havePairWithSeptDeniers(Player player){
    for( Card card1 : player.getHand()){
        if (card1.getValue()==CardValue.SEPT && card1.getFigure()==CardFigure.DENIERS){ 
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
    



 
protected boolean havePairWithDeniers(Player player){

    for(Card card1 : player.getHand()){ // on veut faire une paire si il y'a une carte de denier dans la main du joueur
        if(card1.getFigure()==CardFigure.DENIERS){
            for (Card card2:cardOnTheTable){
           
                if(card1.equalsValue(card2)){
                    player.getHand().remove(card1);
                    cardOnTheTable.remove(card2);
                    player.getStoredCard().add(card1);
                    player.getStoredCard().add(card2);
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
                    return true;


                }
            }
        }
    }

    return false;
    
 }

 
 


protected boolean haveClassicPair(Player player){
//pair is the not the only way to take cards from the table
 if (( cardOnTheTable.size() ) != 2){ // On ne fait une paire que si il n'ya pas deux cartes sur la table car sinon, on laisserait qu'une seule carte ce qui permettrait au joueur suivant de faire une scopa en cas de pair
    //fishy strategy!
    for(Card card1:player.getHand()){

        for (Card card2: cardOnTheTable){

            if(card1.equalsValue(card2)){
                player.getHand().remove(card1);
                cardOnTheTable.remove(card2);
                player.getStoredCard().add(card1);
                player.getStoredCard().add(card2);
                return true;

            }
        }

    
    }

    return false; // Si pas de paire

}

return false; // Si il n'ya que deux cartes sur la table
}
    
   




   



 
protected boolean getPair(Player player) {
        
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
    

   


protected boolean putAClassicCard(Player player){
        for(Card card : player.getHand()){ 
            if (card.getFigure()!=CardFigure.DENIERS){  // on pose une carte qui n'est pas de deniers par stratégie
                System.out.println(player.getName() + " a posé " + card + " sur la table ");
                cardOnTheTable.add(card);
                player.getHand().remove(card);
                return true;
                

            }
        }
        return false;
        

}

protected boolean putACardOfDeniers(Player player){
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

    // Cette méthode sert dans le cas ou il ne reste que le sept de deniers dans la main du joueur
protected void putACardOfSeptDeniers(Player player){
        for(Card card : player.getHand()){
            System.out.println(player.getName() + " a posé la carte " + card + " sur la table");
            cardOnTheTable.add(card); 
            player.getHand().remove(card);
            break;
        }
}
    
    
protected void putACardOnTheTable(Player player){
        boolean putACard = putAClassicCard(player);
        if(!putACard){
            putACard = putACardOfDeniers(player);
            if(!putACard){
                putACardOfSeptDeniers(player);
            }
        }
}
       

protected int countCardDeniers(Player player){
        int countCardDeniers= 0;
        
        for(Card card : player.getStoredCard()){
            if(card.getFigure()==CardFigure.DENIERS){
                countCardDeniers=countCardDeniers+1;
            }
        }
    
        return countCardDeniers;
    
    }
    
protected void compareCountCardDeniers(){
    
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
    
protected int countCard(Player player){
        return player.getStoredCard().size();
        
}
    
protected void compareCountCard(){
    
      
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
                        
                    }
                }
            }
    
        }
    
        
    
}
        
    
    
    
    
    
    
protected boolean haveSeptDeDeniers(Player player) {
        for(Card card : player.getStoredCard()){
            if (card.getFigure()==CardFigure.DENIERS && card.getValue()==CardValue.SEPT){
                return true;
            }
        }
    
        return false;
}
    
protected void pointForSeptDeDeniers(){
        for(Player player : players){
            if (haveSeptDeDeniers(player)){
                    System.out.println( player.getName() + " a le sept deniers");
                    player.haveNewPoint();
                    break;
            }
        }
}
    
        
    
    
    
    
    
    
protected void displayFinalScorel(){
        
         for(Player player: players){
            finalScore.put(player.getName(),player.getFinalScore());
         }
    
         for (Map.Entry<String, Integer> finalScoEntry :finalScore.entrySet()) { // pour récupérer les clés valeurs
            String name = finalScoEntry.getKey();
            Integer score = finalScoEntry.getValue();
            System.out.println(name + " a pour score final " + score);
    
         }
    
}
    
protected void compareFinalScore(){
        
     
        for (Map.Entry<String, Integer> finalScoEntry :finalScore.entrySet()) { // on va stocker le nom et le score du meilleur joueur
            int score = finalScoEntry.getValue();
            if (score>maxScore){
                maxScore=score;
                winner = finalScoEntry.getKey();
            }
        }
        finalScore.remove(winner);
        for (Map.Entry<String, Integer> finalScoEntry :finalScore.entrySet()) {
            if(finalScoEntry.getValue()==maxScore){ // Cas ou deux personnes sont égalités
               
                winner= "égalité";
                
                
            }
         }
        
}



}