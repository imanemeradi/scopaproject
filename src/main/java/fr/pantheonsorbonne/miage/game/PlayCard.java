package fr.pantheonsorbonne.miage.game;
import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.LocalGame;
import fr.pantheonsorbonne.miage.game.Card;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe PlayCard qui contient les méthodes et stratégies de jeu
 * @author Imane Meradi & Sarah Guerrouj
 * @version 1.0 
 */

public class PlayCard {

//a mettre dans la classe card



/** Création d'un objet Card SEPT de DENIERS */

Card septDeDeniers = new Card(CardFigure.DENIERS,CardValue.SEPT);



/**
     * cette methode permet de faire une paire avec le 7 de deniers, qu'elle soit dans la main du joueur (premier for)
     * ou sur la table (deuxieme for), sinon return false
     * @param player applique le méthode au joueur
     * @return true si paire avec 7 de deniers sinon false
     */

public boolean havePairWithSeptDeniers(Player player){
    for( Card card1 : player.getHand()){
        if (card1.getValue()==CardValue.SEPT && card1.getFigure()==CardFigure.DENIERS){ //if (card1.toString()== "SEPT de DENIERS")
            for(Card card2: LocalGame.cardOnTheTable){
                if(card1.equals(card2)){
                    player.getStoredCard().add(card1);
                    player.getStoredCard().add(card2);
                    player.getHand().remove(card1);
                    LocalGame.cardOnTheTable.remove(card2);
                    return true; // Si pair avec sept de denier
                }
                
            }
            
        }
        
    }
     // Si pas sept de denier dans la main, on regarde si sept de denier sur la table et si oui on fait une paire avec si possible
    for (Card card1 : LocalGame.cardOnTheTable){
        if (card1.getValue()==CardValue.SEPT && card1.getFigure()==CardFigure.DENIERS){
            for(Card card2: player.getHand()){
                if (card1.equals(card2)){
                    player.getStoredCard().add(card1);
                    player.getStoredCard().add(card2);
                    LocalGame.cardOnTheTable.remove(card1);
                    player.getHand().remove(card2);

                    
                }
            }
        }

    }

    return false;

  
}
    

/**
     * cette methode permet de faire une paire avec une carte de deniers, qu'elle soit dans la main du joueur (premier for)
     * ou sur la table (deuxieme for), sinon return false
     * @param player applique le méthode au joueur
     * @return true si paire avec une carte de deniers sinon false
     */

 
public boolean havePairWithDeniers(Player player){

    for(Card card1 : player.getHand()){ // on veut faire une paire si il y'a une carte de denier dans la main du joueur
        if(card1.getFigure()==CardFigure.DENIERS){
            for (Card card2:LocalGame.cardOnTheTable){
           
                if(card1.equals(card2)){
                    player.getHand().remove(card1);
                    LocalGame.cardOnTheTable.remove(card2);
                    player.getStoredCard().add(card1);
                    player.getStoredCard().add(card2);
                    //player.getHand().remove(card1);
                    //LocalGame.cardOnTheTable.remove(card2);
                    return true;
                 }
            }
        }    
    }
    
    for(Card card1: LocalGame.cardOnTheTable){ // on veut faire une paire si il y'a une carte de denier sur la table
        if(card1.getFigure()==CardFigure.DENIERS){
            for(Card card2: player.getHand()){
                if(card1.equals(card2)){
                    LocalGame.cardOnTheTable.remove(card1);
                    player.getHand().remove(card2);
                    player.getStoredCard().add(card1);
                    player.getStoredCard().add(card2);
                    //LocalGame.cardOnTheTable.remove(card1);
                    //player.getHand().remove(card2);
                    return true;


                }
            }
        }
    }

    return false;
    
 }

 
 /**
     * cette methode permet de faire une paire (simple)
     * @param player applique le méthode au joueur
     * @return true si faire une paire simple est possible, false si non, ou false si il ne reste 
     * que deux cartes sur la table
     */


 public boolean haveClassicPair(Player player){

 if (( LocalGame.cardOnTheTable.size() ) != 2){ // On ne fait une paire que si il n'ya pas deux cartes sur la table car sinon, on laisserait qu'une seule carte ce qui permettrait au joueur suivant de faire une scopa en cas de pair
    
    for(Card card1:player.getHand()){

        for (Card card2: LocalGame.cardOnTheTable){

            if(card1.equals(card2)){
                player.getHand().remove(card1);
                LocalGame.cardOnTheTable.remove(card2);
                player.getStoredCard().add(card1);
                player.getStoredCard().add(card2);
                //player.getHand().remove(card1);
                //LocalGame.cardOnTheTable.remove(card2);
                return true;

            }
        }

    
    }

    return false; // Si pas de paire

}

return false; // Si il n'ya que deux cartes sur la table
 }
    
    /* } */

    /*else{
        return false
    } 
 }*/




   

/**
     * cette methode permet de créée une paire.
     * Soit avec le 7 de deniers si il est présent sur la table ou dans la main sinon,
     * une paire avec une carte de deniers quelconque si elle est dans la main ou sur la table sinon, 
     * une paire quelconque
     * @param player applique le méthode au joueur
     * @return true
     */

 
public boolean getPair(Player player) {
        
    boolean pairSeptDeniers=havePairWithDeniers(player);
        if(!pairSeptDeniers){
            boolean pairDeniers = havePairWithDeniers(player);
                if(!pairDeniers){
                   return haveClassicPair(player); 


                }
                return true; // le Joueur a une paire de deniers
            

        }
        return true; // le Joueur a une paire avec le sept de denier
    }
    

    /**
     * cette methode permet de poser une carte sur la table, dans un premier temps, ne pas poser de cartes
     * de deniers par strategie, sinon, si il a que des cartes de deniers, posé une carte, mais pas le 7 de deniers
     * si il est en sa possession
     * @param player applique le méthode au joueur
     */

    
    
    public void putACardOnTheTable(Player player){
        
        for(Card card : player.getHand()){ 
            if (card.getFigure()!=CardFigure.DENIERS){  // on pose une carte qui n'est pas de deniers par stratégie
                System.out.println(player.getName() + " a posé la carte " + card + " sur la table ");
                
               
                LocalGame.cardOnTheTable.add(card);
                
                player.getHand().remove(card);
                break;
                

            }
        }
       
        if (player.getHand().size()==3){ // Cas ou le joueur n'avait que des cartes de deniers, il n'a pas poser de carte
            for (Card card: player.getHand()){
                if (card.getValue()!=CardValue.SEPT){
                    System.out.println(player.getName() + " a posé la carte " + card + " sur la table");
                    LocalGame.cardOnTheTable.add(card); // il pose alors une carte de denier mais pas le sept afin de le garder pour en faire une paire ensuite
                    player.getHand().remove(card);
                    break;
                }
            }

        }
        
            
    }

}
        
        














       
