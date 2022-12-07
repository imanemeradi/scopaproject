package fr.pantheonsorbonne.miage;

import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.model.Game;
import fr.pantheonsorbonne.miage.model.GameCommand;

import java.util.*;

/**
 * This class implements the war game with the network engine
 */

public class ScopaGameNetworkEngine extends LocalGameEngine {

    private static final int PLAYER_COUNT = 3;

    private final HostFacade hostFacade;
    private final Set<String> players;
    private final Game scopa;

    public ScopaGameNetworkEngine(HostFacade hostFacade, Set<String> players, fr.pantheonsorbonne.miage.model.Game scopa) {
        this.hostFacade = hostFacade;
        this.players = players;
        this.scopa = scopa;
    }

    public static void main(String[] args) {
        //create the host facade
        HostFacade hostFacade = Facade.getFacade();
        hostFacade.waitReady();

        //set the name of the player
        hostFacade.createNewPlayer("Host");

        //create a new game of war
        fr.pantheonsorbonne.miage.model.Game scopa = hostFacade.createNewGame("SCOPA");

        //wait for enough players to join
        hostFacade.waitForExtraPlayerCount(PLAYER_COUNT);

        LocalGameEngine host = new ScopaGameNetworkEngine(hostFacade, scopa.getPlayers(), scopa);
        host.play();


    }

@Override
protected Set<String> getInitialPlayers() {
    return this.scopa.getPlayers();

    }

@Override
public void distribuateCardToPlayer(Player p) {
    hostFacade.sendGameCommandToPlayer(scopa, p.getName(), new GameCommand("cardsForYou"));
    }

@Override
public Card giveNewCard(Player player){
    hostFacade.sendGameCommandToPlayer(scopa, player.getName(), new GameCommand("cardForYou"));
    return null;
    
}

@Override
public void declareWinner() {
        hostFacade.sendGameCommandToPlayer(scopa, winner, new GameCommand("win"));
    }

@Override
public void playCard(Player player){
    hostFacade.sendGameCommandToPlayer(scopa, player.getName(), new GameCommand("playCard"));
}

@Override
public void takeCardOnTheTable() {

    // TODO Auto-generated method stub
    
}

@Override
public void putFourCardOnTheTable() {

    
}




}

