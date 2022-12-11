
package fr.pantheonsorbonne.miage;

import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.model.Game;
import fr.pantheonsorbonne.miage.model.GameCommand;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


 

public class ScopaNetworkPlayer {

    static final String playerId = "Player-" + new Random().nextInt();
    static final Deque<Card> hand = new LinkedList<>();
    static final PlayerFacade playerFacade = Facade.getFacade();
    static Game scopa;

    public static void main(String[] args) {

        playerFacade.waitReady();
        playerFacade.createNewPlayer(playerId);
        scopa = playerFacade.autoJoinGame("SCOPA");
        boolean endGame=false;
        while (!endGame) {
        
    

            GameCommand command = playerFacade.receiveGameCommand(scopa);
            
                switch (command.name()) {
                    case "cardsForYou":
                      
                        break;
                    case "cardForYou":
                     
                    case "playACard":
                        
                        break;
                    case"compareCountDeniers":

                    break;

                    case"compareCountCard":

                    break;

                    case"pointForSeptDeniers":

                    break;

                    case "displayFinalScore":// donne le score à chacun

                    break;

                    case "declareWinner":
                    //handleDeclareWinnerCommand(command);
                    endGame=true;
                    break;
                
    
                }
            }
        
    
}







private static void handleDeclareWinnerCommand(GameCommand command) {
    if (command.body().equals("win")) {
        System.out.println("J'ai gagnée !!");
    } 
    else {
        System.out.println("J'ai perdu");
    }
    System.exit(0);
}
}




