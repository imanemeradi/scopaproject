package fr.pantheonsorbonne.miage;
import org.junit.jupiter.api.Test;
import fr.pantheonsorbonne.miage.game.Player;
import fr.pantheonsorbonne.miage.game.Card;
import fr.pantheonsorbonne.miage.game.Deck;
import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LocalGameEngineTest {


    @Test
    public void havePairWithSeptDenierTest(){
        
        Player p =  new Player("sarah");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
    public void reverseHavePairWithSeptDeniersTest(){
       
        Player p =  new Player("imane");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
        
        Card card1 = new Card (CardFigure.EPEE, CardValue.SEPT);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        Card card3 = new Card (CardFigure.BATON, CardValue.QUATRE);
        
        Card card4 = new Card (CardFigure.BATON, CardValue.TROIS);
        Card card5 = new Card (CardFigure.COUPE, CardValue.QUATRE);
        Card card6 = new Card (CardFigure.BATON, CardValue.SEPT);
        Card card7 = new Card (CardFigure.DENIERS, CardValue.DEUX);
        
        List<Card> hand= new ArrayList<>();
        //Collection<Card> cardOnTheTable= new ArrayList<>();
        hand.add(card4);
        hand.add(card1);
        hand.add(card3);
        p.setHand(hand);
        l.cardOnTheTable.add(card2);
        l.cardOnTheTable.add(card5);
        l.cardOnTheTable.add(card6);
        l.cardOnTheTable.add(card7);
        assertTrue(l.havePairWithSeptDeniers(p));
        assertFalse(p.getHand().contains(card2));
        assertTrue(l.cardOnTheTable.contains(card6));
        assert(p.getStoredCard().contains(card2));
        assertFalse(p.getStoredCard().contains(card6));

    }

    @Test
    public void falseHavePairWithSeptDenierTest(){
        
        Player p =  new Player("imane");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
        Card card1 = new Card (CardFigure.EPEE, CardValue.SEPT);
        Card card2 = new Card (CardFigure.COUPE, CardValue.SEPT);
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
        assertFalse(l.havePairWithSeptDeniers(p));

    }

    @Test
    public void havePairWithDenierTest(){
        
        Player p =  new Player("sarah");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
    public void reverseHavePairWithDenierTest(){
        
        Player p =  new Player("sarah");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
        Card card1 = new Card (CardFigure.COUPE, CardValue.SEPT);
        Card card2 = new Card (CardFigure.BATON, CardValue.QUATRE);
        Card card3 = new Card (CardFigure.BATON, CardValue.TROIS);
        
        Card card4 = new Card (CardFigure.COUPE, CardValue.QUATRE);
        Card card5 = new Card (CardFigure.DENIERS, CardValue.TROIS);
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
    public void falseHavePairWithDenierTest(){
        
        Player p =  new Player("sarah");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
        Card card1 = new Card (CardFigure.COUPE, CardValue.SEPT);
        Card card2 = new Card (CardFigure.BATON, CardValue.QUATRE);
        Card card3 = new Card (CardFigure.EPEE, CardValue.TROIS);
        
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
        assertFalse(l.havePairWithDeniers(p));
        assertTrue(p.getHand().contains(card3));
        assertTrue(l.cardOnTheTable.contains(card5));
        assertFalse(p.getStoredCard().contains(card3));
        assertFalse(p.getStoredCard().contains(card5));

    }

 @Test
    public void haveClassicPairTest(){
        
        Player p =  new Player("sarah");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
    public void falseHaveClassicPairTest(){
     
        Player p =  new Player("sarah");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
        Card card1 = new Card (CardFigure.COUPE, CardValue.SEPT);
        Card card2 = new Card (CardFigure.BATON, CardValue.CAVALIER);
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
        assertFalse(l.haveClassicPair(p));

    }

@Test

// Pour la condition cardOnthetable.size=2 
    public void haveClassicPairTest2(){
        
        Player p =  new Player("sarah");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
    public void falsePutAClassicCardTest(){
       
        Player p = new Player("imane");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
        Card card1 = new Card (CardFigure.DENIERS, CardValue.TROIS);
        Card card2 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        Card card3 = new Card (CardFigure.DENIERS, CardValue.SEPT);
    
        List<Card> hand= new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        p.setHand(hand);
        assertFalse(l.putAClassicCard(p));

    }

@Test
public void putFourCardOnTheTableTest(){
Player p =  new Player("sarah");
LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
Deck.createDeck();
l.putFourCardOnTheTable();
assertEquals(l.cardOnTheTable.size(), 4);

}


    @Test
    public void putACardOfSeptDeniersTest(){
        Player p = new Player("sarah");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
        Card card1 = new Card (CardFigure.DENIERS, CardValue.SEPT);
        List<Card> hand= new ArrayList<>();
        hand.add(card1);
        p.setHand(hand);
        l.putACardOfSeptDeniers(p);
        assert(l.cardOnTheTable.contains(card1));
        assertFalse(p.getHand().contains(card1));

    }

    @Test
    public void putACardOfDeniersTrueTest(){
        Player p = new Player("imane");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
        LocalScopaGame l = new LocalScopaGame(Set.of(p1.getName(), p2.getName()));
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
        l.players.add(p1);
        l.players.add(p2);
        l.pointForSeptDeDeniers();
        assertEquals(p1.getFinalScore(), 1);
        
    }
    

    @Test
    public void countCardTest(){
        Player p = new Player("sarah");
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
    Player p1= new Player("sarah");
    Player p2 = new Player("imane");
    LocalScopaGame l = new LocalScopaGame(Set.of(p1.getName(),p2.getName()));
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
        LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
      
        Player p1= new Player("sarah");
        Player p2 = new Player("imane");
        LocalScopaGame l = new LocalScopaGame(Set.of(p1.getName(),p2.getName()));
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
        //assertEquals(p2.getFinalScore(),1);
        
    
    }
  


@Test

public void displayFinalScoreTest(){
  
    Player p1= new Player("sarah");
    Player p2 = new Player("imane");
    LocalScopaGame l = new LocalScopaGame(Set.of(p1.getName(),p2.getName()));
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
    Player p1= new Player("sarah");
    Player p2 = new Player("imane");
    LocalScopaGame l = new LocalScopaGame(Set.of(p1.getName(),p2.getName()));
    p1.setFinalScore(3);
    p2.setFinalScore(4);
    l.players.add(p1);
    l.players.add(p2);
    l.displayFinalScorel();
    l.declareWinner();
    assertEquals(l.winner, "imane");
   
    
 }

 @Test 
 public void noWinnerTest(){
    Player p1= new Player("sarah");
    Player p2 = new Player("imane");
    LocalScopaGame l = new LocalScopaGame(Set.of(p1.getName(),p2.getName()));
    p1.setFinalScore(3);
    p2.setFinalScore(3);
 
    l.displayFinalScorel();
    l.declareWinner();;
    assertEquals(l.winner, "égalité");
   

 }

 @Test
 public void getPairSeptDeniersTest(){
    
    Player p =  new Player("sarah");
    LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
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
    assertTrue(l.getPair(p));

 }

 @Test
 public void getPairDeniersTest(){
   
    Player p =  new Player("sarah");
    LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
    Card card1 = new Card (CardFigure.EPEE, CardValue.SEPT);
    Card card2 = new Card (CardFigure.COUPE, CardValue.CINQ);
    Card card3 = new Card (CardFigure.BATON, CardValue.QUATRE);
    
    Card card4 = new Card (CardFigure.BATON, CardValue.TROIS);
    Card card5 = new Card (CardFigure.DENIERS, CardValue.QUATRE);
    Card card6 = new Card (CardFigure.BATON, CardValue.CAVALIER);
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
    assertTrue(l.getPair(p));

 }


 @Test
 public void haveTreeCardSameOnTheTableTest(){
    Player p =  new Player("sarah");
    LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
    Card card1 = new Card (CardFigure.EPEE, CardValue.SEPT);
    Card card2 = new Card (CardFigure.COUPE, CardValue.SEPT);
    Card card3 = new Card (CardFigure.BATON, CardValue.SEPT);
    Card card4 = new Card (CardFigure.BATON, CardValue.TROIS);
    l.cardOnTheTable.add(card1);
    l.cardOnTheTable.add(card2);
    l.cardOnTheTable.add(card3);
    l.cardOnTheTable.add(card4);
    assertTrue(l.haveTreeCardSameOnTheTable());
 }

 @Test
 public void falseHaveTreeCardSameOnTheTableTest(){
    Player p =  new Player("sarah");
    LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
    Card card1 = new Card (CardFigure.EPEE, CardValue.SEPT);
    Card card2 = new Card (CardFigure.COUPE, CardValue.SEPT);
    Card card3 = new Card (CardFigure.BATON, CardValue.CAVALIER);
    Card card4 = new Card (CardFigure.BATON, CardValue.TROIS);
    l.cardOnTheTable.add(card1);
    l.cardOnTheTable.add(card2);
    l.cardOnTheTable.add(card3);
    l.cardOnTheTable.add(card4);
    assertFalse(l.haveTreeCardSameOnTheTable());
 }



@Test
public void falseMakeScopaTest(){
    Player p =  new Player("sarah");
    LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
    Card card1 = new Card (CardFigure.EPEE, CardValue.SEPT);
    Card card2 = new Card (CardFigure.COUPE, CardValue.SEPT);
    Card card3 = new Card (CardFigure.BATON, CardValue.CAVALIER);
    l.cardOnTheTable.add(card1);
    l.cardOnTheTable.add(card2);
    l.cardOnTheTable.add(card3);
    assertFalse(l.makeScopa(p));

}

@Test
public void makeScopaTest(){
    Player p =  new Player("sarah");
    LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
    l.players.add(p);
    Card card1 = new Card (CardFigure.EPEE, CardValue.SEPT);
    Card card2 = new Card (CardFigure.COUPE, CardValue.SEPT);
    Card card3 = new Card (CardFigure.COUPE, CardValue.CAVALIER);
    Card card6 = new Card (CardFigure.BATON, CardValue.CAVALIER);
    List<Card> hand= new ArrayList<>();
    l.cardOnTheTable.add(card6);
    hand.add(card1);
    hand.add(card2);
    hand.add(card3);
    p.setHand(hand);
    l.playCard(p);
    assertTrue(l.makeScopa(p));

}

@Test

public void distribuateCardToPlayerTest(){
    Player p =  new Player("sarah");
    LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
    l.distribuateCardToPlayer(p);
    assertEquals(p.getHand().size(), 3);

}

@Test
public void takeCardOnTheTableTest(){
    Player p =  new Player("sarah");
    LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
    l.players.add(p);
    Card card1 = new Card (CardFigure.EPEE, CardValue.SEPT);
    Card card2 = new Card (CardFigure.COUPE, CardValue.SEPT);
    Card card3 = new Card (CardFigure.COUPE, CardValue.CAVALIER);
    Card card4 = new Card (CardFigure.EPEE, CardValue.AS);
    Card card5 = new Card (CardFigure.COUPE, CardValue.DEUX);
    Card card6 = new Card (CardFigure.BATON, CardValue.CAVALIER);
    List<Card> hand= new ArrayList<>();
    l.cardOnTheTable.add(card1);
    l.cardOnTheTable.add(card2);
    l.cardOnTheTable.add(card3);
    hand.add(card4);
    hand.add(card5);
    hand.add(card6);
    p.setHand(hand);
    l.playCard(p);
    l.takeCardOnTheTable();
    assertTrue(p.getStoredCard().contains(card1));


}

@Test
public void playCardScopaTest(){
    Player p =  new Player("sarah");
    LocalScopaGame l = new LocalScopaGame(Set.of(p.getName()));
    l.players.add(p);
    Card card1 = new Card (CardFigure.EPEE, CardValue.SEPT);
    Card card2 = new Card (CardFigure.COUPE, CardValue.SEPT);
    Card card3 = new Card (CardFigure.COUPE, CardValue.CAVALIER);
    Card card6 = new Card (CardFigure.BATON, CardValue.CAVALIER);
    List<Card> hand= new ArrayList<>();
    l.cardOnTheTable.add(card6);
    hand.add(card1);
    hand.add(card2);
    hand.add(card3);
    p.setHand(hand);
    l.playCard(p);
    assertEquals(p.getFinalScore(), 1);


}


}










