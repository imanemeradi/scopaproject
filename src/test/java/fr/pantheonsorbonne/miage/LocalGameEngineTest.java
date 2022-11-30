package fr.pantheonsorbonne.miage;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.Local;
import fr.pantheonsorbonne.miage.LocalGame;
import fr.pantheonsorbonne.miage.LocalGameEngine;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
public class LocalGameEngineTest {
    @Test
    public void havePairWithSeptDenierTest(){
        LocalGameEngine l = new LocalGameEngine();
        Player p =  new Player("ggg");
        Card card1 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        Card card2 = new Card (CardFigure.EPEE, CardValue.SEPT);
        Card card3 = new Card (CardFigure.BATON, CardValue.QUATRE);
        Card card4 = new Card (CardFigure.BATON, CardValue.TROIS);
        List<Card> hand= new ArrayList<>();
        //Collection<Card> cardOnTheTable= new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        p.setHand(hand);
        l.cardOnTheTable.add(card1);
        l.cardOnTheTable.add(card2);
        l.cardOnTheTable.add(card3);
        l.cardOnTheTable.add(card4);
        assertTrue(l.havePairWithSeptDeniers(p));
    }

    @Test
    public void putAClassicCardTest(){
       
        Player p = new Player("bdegey");
        LocalGameEngine l = new LocalGameEngine();
        Card card1 = new Card (CardFigure.BATON, CardValue.SEPT);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.TROIS);
        Card card3 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        List<Card> hand= new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        p.setHand(hand);
        assertTrue(l.putAClassicCard(p));
        assert(l.cardOnTheTable.contains(card1));
        assertFalse(p.getHand().contains(card1));
    }
    @Test
    public void putACardOfSeptDeniersTest(){
    }
    
}




