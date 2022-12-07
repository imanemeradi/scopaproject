package fr.pantheonsorbonne.miage;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;

import java.util.Set;


public class LocalGame extends LocalGameEngine{


private final Set<String> initialPlayers;

    public LocalGame( Set<String> initialPlayers){
        this.initialPlayers=initialPlayers;
         for (String namePlayer : initialPlayers) {
            players.add(new Player(namePlayer));
        }
    }


public static void main(String[] args) {
    LocalGame scopa = new LocalGame(Set.of("SARAH", "IMANE", "JOUEUR 3"));
    scopa.play();
    
}

@Override
protected Set<String> getInitialPlayers() {
        return this.initialPlayers;
    }


@Override
protected void takeCardOnTheTable(){
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
}

@Override
protected void playCard(Player player){
    
    if (cardOnTheTable.isEmpty()){ // Après une scopa du joueur précédent, il faut poser une carte
        putACardOnTheTable(player);
       }
   
   
   else if(getPair(player)){
    System.out.println(player.getName() +" a fait une  paire. " );
    displayStorredCard(player);
    lastPlayerWithPair= player.getName();
    if (makeScopa(player)){
        player.haveNewPoint();
        System.out.println("Point de scopa " + player.getFinalScore());       
    }

 }

   else{
    putACardOnTheTable(player);
   }

}

@Override
protected Card giveNewCard(Player player){
    return Deck.deck.poll();
}

@Override
protected void distribuateCardToPlayer(Player joueur ){
    for( int i=0; i<Player.HAND_SIZE; i++){
        Card c = giveNewCard(joueur);
        joueur.getHand().add(c);
     }
}

@Override
protected void putFourCardOnTheTable(){
  
    for(int i =0;i<4; i++){
        cardOnTheTable.add(Deck.deck.poll());
    }
    System.out.println( "Voici les cartes sur la table "+cardOnTheTable);
    
}

@Override
protected void declareWinner(){
    System.out.println(winner + "has win !");
}





}