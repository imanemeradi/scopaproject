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
        Player p =  new Player("sarah");
        
        Card card1 = new Card (CardFigure.EPEE, CardValue.SEPT);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        Card card3 = new Card (CardFigure.BATON, CardValue.QUATRE);
        
        Card card4 = new Card (CardFigure.BATON, CardValue.TROIS);
        Card card5 = new Card (CardFigure.COUPE, CardValue.QUATRE);
        Card card6 = new Card (CardFigure.BATON, CardValue.SEPT);
        Card card7 = new Card (CardFigure.DENIERS, CardValue.DEUX);
        
        List<Card> hand= new ArrayList<>();
        //Collection<Card> cardOnTheTable= new ArrayList<>();
        hand.add(card2);
        hand.add(card1);
        hand.add(card3);
        p.setHand(hand);
        l.cardOnTheTable.add(card4);
        l.cardOnTheTable.add(card5);
        l.cardOnTheTable.add(card6);
        l.cardOnTheTable.add(card7);
        assertTrue(l.havePairWithSeptDeniers(p));
        assertFalse(p.getHand().contains(card2));
        assertFalse(l.cardOnTheTable.contains(card6));
        assert(p.getStoredCard().contains(card2));
        assert(p.getStoredCard().contains(card6));

    }

    @Test
    public void havePairWithtDenierTest(){
        LocalGameEngine l = new LocalGameEngine();
        Player p =  new Player("sarah");
        Card card1 = new Card (CardFigure.COUPE, CardValue.SEPT);
        Card card2 = new Card (CardFigure.BATON, CardValue.QUATRE);
        Card card3 = new Card (CardFigure.DENIERS, CardValue.TROIS);
        
        Card card4 = new Card (CardFigure.COUPE, CardValue.QUATRE);
        Card card5 = new Card (CardFigure.BATON, CardValue.TROIS);
        Card card6 = new Card (CardFigure.BATON, CardValue.CINQ);
        Card card7 = new Card (CardFigure.DENIERS, CardValue.DEUX);
        List<Card> hand= new ArrayList<>();
        //Collection<Card> cardOnTheTable= new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        p.setHand(hand);
        l.cardOnTheTable.add(card4);
        l.cardOnTheTable.add(card5);
        l.cardOnTheTable.add(card6);
        l.cardOnTheTable.add(card7);
        assertTrue(l.havePairWithDeniers(p));
        assertFalse(p.getHand().contains(card3));
        assertFalse(l.cardOnTheTable.contains(card5));
        assert(p.getStoredCard().contains(card3));
        assert(p.getStoredCard().contains(card5));

    }
 @Test
    public void haveClassicPairTest(){
        LocalGameEngine l = new LocalGameEngine();
        Player p =  new Player("sarah");
        Card card1 = new Card (CardFigure.COUPE, CardValue.SEPT);
        Card card2 = new Card (CardFigure.BATON, CardValue.QUATRE);
        Card card3 = new Card (CardFigure.BATON, CardValue.TROIS);
        
        Card card4 = new Card (CardFigure.COUPE, CardValue.QUATRE);
        Card card5 = new Card (CardFigure.EPEE, CardValue.SIX);
        Card card6 = new Card (CardFigure.BATON, CardValue.CINQ);
        Card card7 = new Card (CardFigure.DENIERS, CardValue.DEUX);
        List<Card> hand= new ArrayList<>();
        //Collection<Card> cardOnTheTable= new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        p.setHand(hand);
        l.cardOnTheTable.add(card4);
        l.cardOnTheTable.add(card5);
        l.cardOnTheTable.add(card6);
        l.cardOnTheTable.add(card7);
        assertTrue(l.haveClassicPair(p));
        assertFalse(p.getHand().contains(card2));
        assertFalse(l.cardOnTheTable.contains(card4));
        assert(p.getStoredCard().contains(card2));
        assert(p.getStoredCard().contains(card4));

    }

@Test

// Pour la condition cardOnthetable.size=2 
    public void haveClassicPairTest2(){
        LocalGameEngine l = new LocalGameEngine();
        Player p =  new Player("sarah");
        Card card1 = new Card (CardFigure.COUPE, CardValue.SEPT);
        Card card2 = new Card (CardFigure.BATON, CardValue.QUATRE);
        Card card3 = new Card (CardFigure.BATON, CardValue.TROIS);
        Card card4 = new Card (CardFigure.COUPE, CardValue.QUATRE);
        Card card5 = new Card (CardFigure.EPEE, CardValue.SIX);
        List<Card> hand= new ArrayList<>();
        //Collection<Card> cardOnTheTable= new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        p.setHand(hand);
        l.cardOnTheTable.add(card4);
        l.cardOnTheTable.add(card5);
        assertFalse(l.haveClassicPair(p));

    }

   

   @Test
    public void putAClassicCardTest(){
       
        Player p = new Player("imane");
        LocalGameEngine l = new LocalGameEngine();
        Card card1 = new Card (CardFigure.DENIERS, CardValue.TROIS);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        Card card3 = new Card (CardFigure.BATON, CardValue.SEPT);
    
        List<Card> hand= new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        p.setHand(hand);
        assertTrue(l.putAClassicCard(p));
        assert(l.cardOnTheTable.contains(card3));
        assertFalse(p.getHand().contains(card3));
    }

    @Test
    public void putACardOfSeptDeniersTest(){
        Player p = new Player("sarah");
        LocalGameEngine l = new LocalGameEngine();
        Card card1 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        List<Card> hand= new ArrayList<>();
        hand.add(card1);
        p.setHand(hand);
        assertTrue(l.putACardOfSeptDeniers(p));
        assert(l.cardOnTheTable.contains(card1));
        assertFalse(p.getHand().contains(card1));



    }
    @Test
    public void putACardOfDeniersTest(){
        Player p = new Player("imane");
        LocalGameEngine l = new LocalGameEngine();
        Card card1 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.TROIS);
        List<Card> hand= new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        p.setHand(hand);
        assertTrue(l.putACardOfDeniers(p));
        assert(l.cardOnTheTable.contains(card2));
        assertFalse(p.getHand().contains(card2));



    }
    
    @Test
    public void haveSeptDeDeniersTest(){
        Player p = new Player("saeah");
        LocalGameEngine l = new LocalGameEngine();
        Card card1 = new Card (CardFigure.BATON, CardValue.SEPT);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.TROIS);
        List<Card> storedCard = new ArrayList<>();
        storedCard.add(card2);
        storedCard.add(card1);
        p.setStoredCard(storedCard);
        assertFalse(l.haveSeptDeDeniers(p));
        

    }
    
}









