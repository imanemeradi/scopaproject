package fr.pantheonsorbonne.miage;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;

import java.util.Set;

/**
 * Classe LocalScopaGame
 * @author Imane Meradi & Sarah Guerrouj
 */

public class LocalScopaGame extends ScopaEngine{



private final Set<String> initialPlayers;

/**
  * Le constructeur qui ajoute des joueurs à la collection players
  * @param initialPlayers
  */

public LocalScopaGame( Set<String> initialPlayers){
        this.initialPlayers=initialPlayers;
         for (String namePlayer : initialPlayers) {
            players.add(new Player(namePlayer));
        }
    }

/**
  * La méthode main depuis laquelle on lance le jeu
  * @param args
  */

public static void main(String[] args) {
    LocalScopaGame scopa = new LocalScopaGame(Set.of("SARAH", "IMANE", "JOUEUR 3"));
    scopa.play();
    
}

/**
     * retourne l'ensemble initialPlayers
     * @return initialPlayers
     */

@Override
protected Set<String> getInitialPlayers() {
        return this.initialPlayers;
}

/**
     * cette méthode fait récuperer les cartes sur la table au dernier joueur ayant fais une scopa
     * (donc ayant fais la derniere pair en ne laissant aucune carte sur la table)
     * 
     */

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

/**
     * cette méthode fait jouer une carte au joueur, si il n'y a plus de carte sur la table, après une scopa du
     * joueur précédent, il faut poser une carte sur la table
     * sinon, si le joueur fais une paire, l'affiche et affiche ses cartes stockées
     * si le joueur fais une scopa, on lui ajoute un point, sinon il pause une carte sur la table
     * @param player
     * 
     */

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

/**
     * cette méthode distribue une carte et l'enleve donc de la pioche
     * @param player
     * @return la pioche avec la premiere carte en moins
     */

@Override
protected Card giveNewCard(Player player){
    return Deck.deck.poll();
}

/**
     * cette méthode crée une main au joueur en lui distribuant 3 cartes
     * @param player
     */

@Override
protected void distribuateCardToPlayer(Player joueur ){
    for( int i=0; i<Player.HAND_SIZE; i++){
        Card c = giveNewCard(joueur);
        joueur.getHand().add(c);
     }
}

/**
     * cette méthode compare les scores des joueurs, si des joueurs sont égaux, il n'y a 
     * pas de gagnant pour cette partie
     * sinon, affiche le nom du gagnant et son score
     * @param player
     */

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