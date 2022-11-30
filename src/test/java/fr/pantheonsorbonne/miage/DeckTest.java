package fr.pantheonsorbonne.miage;
import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.LocalGameEngine;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.game.Deck;
import java.util.Collection;
import java.util.Set;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import fr.pantheonsorbonne.miage.game.Deck;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckTest {
    @Test
    public void createDeckTest(){
        
        Deck.createDeck();
        assertEquals(Deck.deck.size(), 40);
    }
}
