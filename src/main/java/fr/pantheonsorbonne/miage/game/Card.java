package fr.pantheonsorbonne.miage.game;

import fr.pantheonsorbonne.miage.enums.CardFigure;
import fr.pantheonsorbonne.miage.enums.CardValue;

import java.util.Arrays;
import java.util.stream.Collectors;


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
    
    @Override

    public boolean equals(Object o ) {
        Card card= (Card)o;
        return card.getValue()==this.getValue();
		
	}
} 
