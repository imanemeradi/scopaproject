package fr.pantheonsorbonne.miage.game;
import java.util.ArrayList;
import java.util.List;

public class Player{
    private String name;
    private List<Card> storedCard = new ArrayList<>();
    private List<Card> hand= new ArrayList<>();
    private  int finalScore;
    public static final int  HAND_SIZE = 3;

    public Player (String name){
        this.name=name;
    }


    public String getName(){
        return this.name;
    }

    public List<Card> getHand(){
        return this.hand;
    }

    public void setHand(List<Card> cardHand){
        this.hand=cardHand;
    }
    
    public List<Card> getStoredCard(){
        return this.storedCard;
    }

    public void setStoredCard(List<Card> cardStored){
        this.storedCard=cardStored;
    }
    
  

    public int haveNewPoint(){
        this.finalScore = this.finalScore+1;
        return this.finalScore;
    }

    public int getFinalScore(){
        return this.finalScore;
    }


    
    }
    
  




