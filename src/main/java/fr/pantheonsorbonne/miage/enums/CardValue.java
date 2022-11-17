package fr.pantheonsorbonne.miage.enums;

/**
 * An enum that represend the possible cards value from a deck
 */
public enum CardValue{
	
    AS(1), 
	DEUX(2),
	TROIS(3),
	QUATRE(4),
	CINQ(5),
	SIX(6),
	SEPT(7),
	VALET(8),
	CAVALIER(9),
	ROI(10);

    final int value;
	
	private CardValue(int value) {
		this.value = value;
	}


}
