package fr.pantheonsorbonne.miage;
import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.LocalGameEngine;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.game.Deck;
import java.util.Collection;
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

}