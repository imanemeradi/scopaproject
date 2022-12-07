package fr.pantheonsorbonne.miage;

import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.model.Game;
import fr.pantheonsorbonne.miage.model.GameCommand;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * this is the player part of the network version of the war game
 */

public class ScopaNetworkPlayer {

    static final String playerId = "Player-" + new Random().nextInt();
    private List<Card> hand = new ArrayList<>();
    static final PlayerFacade playerFacade = Facade.getFacade();
    static Game scopa;

    public static void main(String[] args) {

        playerFacade.waitReady();
        playerFacade.createNewPlayer(playerId);
        scopa = playerFacade.autoJoinGame("SCOPA");
        while (true) {
        }
    }
/** 
            GameCommand command = playerFacade.receiveGameCommand(scopa);
            switch (command.name()) {
                switch (command.name()) {
                    case "cardsForYou":
                        handleCardsForYou(command);
                        break;
                    case "playACard":
                        System.out.println("I have " + hand.stream().map(Card::toFancyString).collect(Collectors.joining(" ")));
                        handlePlayACard(command);
                        break;
                    case "gameOver":
                        handleGameOverCommand(command);
                        break;
    
                }
            }
        }
    
    
        }

}
*/

}
