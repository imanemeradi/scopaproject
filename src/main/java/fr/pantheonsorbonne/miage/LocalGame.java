package fr.pantheonsorbonne.miage;
import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.LocalGame;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.game.PlayCard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.event.CaretListener;


public class LocalGame  {
 
    public static Collection<Card> cardOnTheTable = new ArrayList<>();
    static Collection <Player> players= new ArrayList<>();
    static Map <String,Integer> finalScore = new HashMap<>();


public static void play(){

    Player player1 = new Player("SARAH");
    Player player2 = new Player("IMANE");
    Player player3 = new Player("JOUEUR 3");

    PlayCard p = new PlayCard(); // Objet qui va nous servir a utiliser les methodes de la classe playCard pour les joueurs
   
   
 
    Deck.createDeck();
    

   
    players.add(player1);
    players.add(player2);
    players.add(player3);

     //int nbPlayers = players.size();
    

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
            p.putACardOnTheTable(player);
           }
       
       
       

       
       else if(p.getPair(player)){
        System.out.println(player.getName() +" a fait une  paire. " );
        if (cardOnTheTable.isEmpty()){
            System.out.println(player.getName()+ " a fait une scopa!");
            player.haveNewPoint();
           
        }

     }

       else{
        p.putACardOnTheTable(player);
       }
    
      
       //System.out.println("La main mise a jour de  " +player.getName()+" est " +player.getHand());
       
      // On redonne une carte pour le tour d'après
      //Card newCard=giveNewCard();
      player.getHand().add(giveNewCard()); 
        

     System.out.println(player.getName()+ " a stocké " +player.getStoredCard());
     System.out.println("point de scopa "+player.getFinalScore());   
     System.out.println("Voici les cartes sur la table " +cardOnTheTable);
    }
    
}

// Maintenant , il y'a plus de carte dans la pioche, chaque joueur joue donc à tour de role jusqu'a qu'il n'est plus de carte
System.out.println("Plus de carte dans la pioche");


String lastPlayerWithPair="";
for(int i=0; i<Player.HAND_SIZE;i++){
    for (Player player: players){
    
    
        System.out.println("Main de "+ player.getName()+ ": " +player.getHand());
        if (cardOnTheTable.isEmpty()){ // Après une scopa du joueur précédent, il faut poser une carte
            p.putACardOnTheTable(player);
           }
       
       
       

       
       else if(p.getPair(player)){
        System.out.println(player.getName() +" a fait une  paire. " );
         lastPlayerWithPair= player.getName();
        if (cardOnTheTable.isEmpty()){
            System.out.println(player.getName()+ " a fait une scopa!");
            player.haveNewPoint();
            
           
        }

     }

       else{
        p.putACardOnTheTable(player);
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




       


        // le dernier joueur prend les cartes restantes sur la table
       /*  for(Player lastPlayer: players){
            System.out.println(lastPlayer.getName()+" est le dernier joueur a restée.");
            if(!cardOnTheTable.isEmpty()){
            for(Card lastCard: cardOnTheTable){
                System.out.println("VGFEYGFYEGFYEGFEYFG");
                lastPlayer.getStoredCard().add(lastCard);
            }
        }
            players.remove(lastPlayer);
        }

        System.out.println("La partie est donc terminée. On procède au comptage de point.");

        */

        
        
    







    // La partie est terminée, on rappelle tous les joueurs pour compter les points
 

    compareCountCard();
    compareCountCardDeniers();
    pointForSeptDeDeniers();
    displayFinalScorel();
    announceTheWinner();
    

    }
    
    
   

public static void main(String[] args) {
    play();

}










public static Card giveNewCard(){
    while (!Deck.deck.isEmpty()){
    return Deck.deck.poll();
}
throw new RuntimeException(" Il n'ya plus de carte");
}

public static void distribuateCardToPlayer(Player joueur ){
    for( int i=0; i<Player.HAND_SIZE; i++){
        Card c = giveNewCard();
        joueur.getHand().add(c);
     }
   }


public static void displayPlayerHand(Player player){
       System.out.println(player.getName() + " a les cartes  " + player.getHand());

    }


public static boolean haveTreeCardSameOnTheTable(){
    for (Card card1 : cardOnTheTable){
        int count =0;
        for (Card card2: cardOnTheTable){
            if(card1.equals(card2)){
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

public static void putFourCardOnTheTable(){
  
    for(int i =0;i<4; i++){
        cardOnTheTable.add(Deck.deck.poll());
    }
    System.out.println( "Voici les cartes sur la table "+cardOnTheTable);
    
}
           
        




public static int countCardDeniers(Player player){
    int countCardDeniers= 0;
    
    for(Card card : player.getStoredCard()){
        if(card.getFigure()==CardFigure.DENIERS){
            countCardDeniers=countCardDeniers+1;
        }
    }

    return countCardDeniers;

}

public static void compareCountCardDeniers(){

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

public static int countCard(Player player){
    return player.getStoredCard().size();
    
}

public static void compareCountCard(){

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
    






public static boolean haveSeptDeDeniers(Player player) {
    for(Card card : player.getStoredCard()){
        if (card.getFigure()==CardFigure.DENIERS && card.getValue()==CardValue.SEPT){
            return true;
        }
    }

    return false;
}

public static void pointForSeptDeDeniers(){
    for(Player player : players){
        if ( haveSeptDeDeniers(player)){
                System.out.println( player.getName() + " a le sept deniers");
                player.haveNewPoint();
                break;
                }
            }
        }

    






    public static void displayFinalScorel(){
    
     for(Player player: players){
        finalScore.put(player.getName(),player.getFinalScore());
     }

     for (Map.Entry<String, Integer> finalScoEntry :finalScore.entrySet()) { // pour récupérer les clés valeurs
        String name = finalScoEntry.getKey();
        Integer score = finalScoEntry.getValue();
        System.out.println(name + " a pour score final " + score);

     }

}


public static void announceTheWinner(){
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
