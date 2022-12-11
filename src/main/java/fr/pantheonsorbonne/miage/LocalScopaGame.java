package fr.pantheonsorbonne.miage;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;

import java.util.Set;


public class LocalScopaGame extends ScopaEngine{


private final Set<String> initialPlayers;

    public LocalScopaGame( Set<String> initialPlayers){
        this.initialPlayers=initialPlayers;
         for (String namePlayer : initialPlayers) {
            players.add(new Player(namePlayer));
        }
    }


public static void main(String[] args) {
    LocalScopaGame scopa = new LocalScopaGame(Set.of("SARAH", "IMANE", "JOUEUR 3"));
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

                System.out.println(player.getName()+ " a récupéré les cartes sur la table : " + player.getStoredCard());
            
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
        System.out.println("Point de scopa pour "+ player.getName() +" : " + player.getFinalScore());       
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
protected void declareWinner(){
    compareFinalScore();
    if(winner.equals("égalité")){
       
        System.out.println("Pas de gagnant pour cette partie");
    }
    else{
       
        System.out.println(winner+ " remporte la partie avec un score de " + maxScore +" . Bravo!!");
    }
}

}