import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Deck {

	public Card deck[] = new Card[52];
	int topDeck = 0;
	
	// creates a deck of 52 cards and shuffles the deck using the shuffle method
	public Deck() {
		for (int i = 0; i < deck.length; i++) {
			deck[i] = new Card(i % 13, i / 13);
		}
		
		// "shuffles" 10 times
		for (int i = 0; i < 10; i++) {
			shuffle();
		}
		
		
		
	}
	
	// method "shuffles" by swapping the location of each card in the deck with a random value
	public void shuffle() {
		for (int i = 0; i < deck.length; i++){
			int j = new Random().nextInt(52);
			Card temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		}
	}
	
	// creates a visual of the deck on the screen
	public void draw(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect(550, 295, 100, 150);
		g.setColor(Color.yellow);
		g.drawRect(550, 295, 100, 150);
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 15; j++) {
				g.setColor(Color.white);
				g.fillOval( 552 + i*10, 297 + j*10, 5, 5);
			}
		}
	}
	
	// shows each card in a players hand 
	public void drawCard(Player player) {
		if(player.totalCards < 5) {
			player.hand[player.totalCards] = deck[topDeck];
			player.totalCards++;
			topDeck++;
		}
	} 
	
}
