import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Player {

	public Card hand[] = new Card[5];
	public int totalCards = 0;
	public int sum1;
	public int sum2;
	public boolean ace = false;
	
	public Player() {
		
	}
	
	// shows each card that is in a player's hand
	public void drawHand(Graphics2D g, int locX, int locY) {
		
		for(int i = 0; i < 5; i++) {
			if (hand[i] != null) {
				g.setColor(Color.white);
				g.fillRect(locX + i*110, locY, 100, 150);		
				displayHand(g, hand[i], locX + i*110, locY);
			}
			else {
				g.setColor(Color.gray);
				g.drawRect(locX + i*110, locY, 100, 150);				
			}
		}
	}
	
	// draws the image on each card in a players hand
	public void displayHand(Graphics2D g, Card card, int x, int y) {
		
		if(card.symbol.equals("spade") || card.symbol.equals("clover") )
			g.setColor(Color.black);
		else
			g.setColor(Color.red);
		
		g.setFont(new Font("arial", Font.BOLD, 15));
		
		switch(card.name) {
			case "ace": g.drawString("A", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("A", x+85, y+145);
			break;
			case "two": g.drawString("2", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("2", x+85, y+145);
			break;
			case "three": g.drawString("3", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("3", x+85, y+145);
			break;
			case "four": g.drawString("4", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("4", x+85, y+145);
			break;
			case "five": g.drawString("5", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("5", x+85, y+145);
			break;
			case "six": g.drawString("6", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("6", x+85, y+145);
			break;
			case "seven": g.drawString("7", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("7", x+85, y+145);
			break;
			case "eight": g.drawString("8", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("8", x+85, y+145);
			break;
			case "nine": g.drawString("9", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("9", x+85, y+145);
			break;
			case "ten": g.drawString("10", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("10", x+80, y+145);
			break;
			case "jack": g.drawString("J", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("J", x+85, y+145);
			break;
			case "queen": g.drawString("Q", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("Q", x+85, y+145);
			break;
			case "king": g.drawString("K", x+3, y+15);
			g.drawString(card.symbol, x+20, y+75);
			g.drawString("K", x+85, y+145);
			break;
		}
		summer();
	}
	
	// calculates the score of each player's hand
	private void summer() {
		int i = 0;
		sum1 = 0; sum2 = 0;
		while(i < 5 && hand[i] != null ) {
			sum1 += hand[i].value;
			sum2 += hand[i].value;
			
			if(hand[i].value == 1)	ace = true;
			i++;
		}
		if(ace)	sum2 += 10;
	}
}
