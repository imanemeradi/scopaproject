package fr.pantheonsorbonne.miage;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.Local;
import fr.pantheonsorbonne.miage.LocalGame;
import fr.pantheonsorbonne.miage.LocalGameEngine;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;
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
    public void havePairWithDenierTest(){
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
    public void putACardOfDeniersTrueTest(){
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
    public void putACardOfDeniersFalseTest(){
        Player p = new Player("imane");
        LocalGameEngine l = new LocalGameEngine();
        Card card1 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        List<Card> hand= new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        p.setHand(hand);
        assertFalse(l.putACardOfDeniers(p));

        assertTrue(p.getHand().contains(card2));

    }


    @Test
    public void haveSeptDeDeniersFalseTest(){
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

    @Test
    public void haveSeptDeDeniersTrueTest(){
        Player p = new Player("imane");
        LocalGameEngine l = new LocalGameEngine();
        Card card1 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.TROIS);
        List<Card> storedCard = new ArrayList<>();
        storedCard.add(card2);
        storedCard.add(card1);
        p.setStoredCard(storedCard);
        assertTrue(l.haveSeptDeDeniers(p));
        

    }

    
    @Test
    public void pointForSeptDeDeniersTest(){
        Player p1 = new Player("imane");
        Player p2= new Player("sarah");
        LocalGameEngine l = new LocalGameEngine();
        l.players.add(p1);
        l.players.add(p2);
        Card card1 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.TROIS);
        Card card3 = new Card (CardFigure.DENIERS, CardValue.QUATRE);
        Card card4 = new Card (CardFigure.EPEE, CardValue.TROIS);
        List<Card> storedCardP1 = new ArrayList<>();
        List<Card> storedCardP2 = new ArrayList<>();
        storedCardP1.add(card2);
        storedCardP1.add(card1);
        storedCardP2.add(card3);
        storedCardP2.add(card4);
        p1.setStoredCard(storedCardP1);
        p2.setStoredCard(storedCardP2);
        l.pointForSeptDeDeniers();
        assertEquals(p1.getFinalScore(), 1);
        
    }
    

    @Test
    public void countCardTest(){
        Player p = new Player("sarah");
        LocalGameEngine l = new LocalGameEngine();
        Card card1 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.TROIS);
        List<Card> storedCard = new ArrayList<>();
        storedCard.add(card2);
        storedCard.add(card1);
        p.setStoredCard(storedCard);
        assertEquals(l.countCard(p), 2);

    }

    @Test

public void compareCountCardTest(){
    LocalGameEngine l = new LocalGameEngine();
    Player p1= new Player("sarah");
    Player p2 = new Player("imane");
    List<Card> storedCardP1 = new ArrayList<>();
    List<Card> storedCardP2 = new ArrayList<>();
    Card card1 = new Card (CardFigure.DENIERS, CardValue.SEPT);
    Card card2 = new Card (CardFigure.EPEE, CardValue.TROIS);
    Card card3 = new Card (CardFigure.BATON, CardValue.TROIS);
    Card card4 = new Card (CardFigure.DENIERS, CardValue.SEPT);
    Card card5 = new Card (CardFigure.DENIERS, CardValue.TROIS);
    Card card6 = new Card (CardFigure.DENIERS, CardValue.QUATRE);
    Card card7 = new Card (CardFigure.EPEE, CardValue.CINQ);
    storedCardP1.add(card2);
    storedCardP1.add(card1);
    storedCardP1.add(card3);
    storedCardP2.add(card4);
    storedCardP2.add(card5);
    storedCardP2.add(card6);
    storedCardP2.add(card7);
    p1.setStoredCard(storedCardP1);
    p2.setStoredCard(storedCardP2);
    l.players.add(p1);
    l.players.add(p2);
    l.compareCountCard();
    assertEquals(l.stockCountCard.get(p1.getName()),3);
    assertEquals(l.stockCountCard.get(p2.getName()),4);
    assertEquals(p2.getFinalScore(),1);
    

}



    @Test
    public void countCardDeniersTest(){
        Player p = new Player("imane");
        LocalGameEngine l = new LocalGameEngine();
        Card card1 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.TROIS);
        Card card3 = new Card (CardFigure.BATON, CardValue.TROIS);
        List<Card> storedCard = new ArrayList<>();
        storedCard.add(card2);
        storedCard.add(card1);
        storedCard.add(card3);
        p.setStoredCard(storedCard);
        assertEquals(l.countCardDeniers(p), 2);

    }

    
    



@Test

public void compareCountCardDeniersTest(){
    LocalGameEngine l = new LocalGameEngine();
    Player p1= new Player("sarah");
    Player p2 = new Player("imane");
    List<Card> storedCardP1 = new ArrayList<>();
    List<Card> storedCardP2 = new ArrayList<>();
    Card card1 = new Card (CardFigure.DENIERS, CardValue.SEPT);
    Card card2 = new Card (CardFigure.EPEE, CardValue.TROIS);
    Card card3 = new Card (CardFigure.BATON, CardValue.TROIS);
    Card card4 = new Card (CardFigure.DENIERS, CardValue.SEPT);
    Card card5 = new Card (CardFigure.DENIERS, CardValue.TROIS);
    Card card6 = new Card (CardFigure.DENIERS, CardValue.QUATRE);
    Card card7 = new Card (CardFigure.EPEE, CardValue.CINQ);
    storedCardP1.add(card2);
    storedCardP1.add(card1);
    storedCardP1.add(card3);
    storedCardP2.add(card4);
    storedCardP2.add(card5);
    storedCardP2.add(card6);
    storedCardP2.add(card7);
    p1.setStoredCard(storedCardP1);
    p2.setStoredCard(storedCardP2);
    l.players.add(p1);
    l.players.add(p2);
    l.compareCountCardDeniers();
    assertEquals(l.stockCountDeniers.get(p1.getName()),1);
    assertEquals(l.stockCountDeniers.get(p2.getName()),3);
    assertEquals(p2.getFinalScore(),1);
    

}
  


@Test

public void displayFinalScoreTest(){
    LocalGameEngine l = new LocalGameEngine();
    Player p1= new Player("sarah");
    Player p2 = new Player("imane");
    p1.setFinalScore(3);
    p2.setFinalScore(4);
    l.players.add(p1);
    l.players.add(p2);
    l.displayFinalScorel();
    assertEquals(l.finalScore.get(p2.getName()),4);
    assertEquals(l.finalScore.get(p1.getName()),3);

}

@Test
 public void announceTheWinnerTest(){
    LocalGameEngine l = new LocalGameEngine();
    Player p1= new Player("sarah");
    Player p2 = new Player("imane");
    p1.setFinalScore(3);
    p2.setFinalScore(4);
    l.players.add(p1);
    l.players.add(p2);
    l.displayFinalScorel();
    assertEquals(l.announceTheWinner(), "imane");
   
    
 }

 @Test 
 public void noWinnerTest(){
    LocalGameEngine l = new LocalGameEngine();
    Player p1= new Player("sarah");
    Player p2 = new Player("imane");
    p1.setFinalScore(3);
    p2.setFinalScore(3);
    l.players.add(p1);
    l.players.add(p2);
    l.displayFinalScorel();
    assertEquals(l.announceTheWinner(), "egalité");
   

 }





}









