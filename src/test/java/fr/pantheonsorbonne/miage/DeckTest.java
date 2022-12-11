package fr.pantheonsorbonne.miage;
import fr.pantheonsorbonne.miage.game.Deck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckTest {
    
    @Test
    public void createDeckTest(){
        
        Deck.createDeck();
        assertEquals(40, Deck.deck.size());
    }
}
