import java.awt.Color;
import java.awt.Graphics2D;

public class Card {
	
	public int value;
	public String symbol;
	public String name;
	public int draw = 0;
	
	public Card(int value, int symbol) {
		this.value = value + 1;
		
		
		switch(symbol + 1) {
			case 1: this.symbol = "spade";
			break;
			case 2: this.symbol = "heart";
			break;
			case 3: this.symbol = "clover";
			break;
			case 4: this.symbol = "diamond";
			break;
		}
		
		switch(this.value) {
			case 1: name = "ace";
			break;
			case 2: name = "two";
			break;
			case 3: name = "three";
			break;
			case 4: name = "four";
			break;
			case 5: name = "five";
			break;
			case 6: name = "six";
			break;
			case 7: name = "seven";
			break;
			case 8: name = "eight";
			break;
			case 9: name = "nine";
			break;
			case 10: name = "ten";
			break;
			case 11: name = "jack";
			this.value = 10;
			break;
			case 12: name = "queen";
			this.value = 10;
			break;
			case 13: name = "king";
			this.value = 10;
			break;
		}
	} 
	
	public String toString() {
		return "Card name: " + this.name + " of " + this.symbol + "     Value: " + this.value;
	}
}
