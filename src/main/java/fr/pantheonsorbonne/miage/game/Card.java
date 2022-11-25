package fr.pantheonsorbonne.miage.game;

import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;

public class Card{


private final CardFigure figure;
private final CardValue  value;


public Card(CardFigure figure, CardValue value) {
    this.figure = figure;
    this.value = value;
    }



    public CardFigure getFigure(){
        return figure;
    }

    public CardValue getValue(){
        return value;
    }


    @Override
	public String toString() {
		return this.getValue() + " de " + this.getFigure();
     



    }
    
  

    public boolean equalsValue(Card card) {
        
        return card.getValue()==this.getValue();
		
	}

    



    
















} 