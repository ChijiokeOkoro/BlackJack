import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameRunner extends JPanel implements KeyListener, ActionListener{

	private Deck deck;
	private Player one, dealer;
	
	private boolean done = false;
	
	private Timer timer;          
	private int delay = 100;
	
	//generates the objects needed for the game
	public GameRunner() {

		
		deck = new Deck();
		one = new Player();
		dealer = new Player();
		
		// allows user to interact in the game
		addKeyListener(this);
		setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		
		
		timer = new Timer(delay, this);
		timer.start();
	}
	
	
	// decides what actions occur whenever there is a change to the objects
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		// conditions on which a winner is determined
		if( (one.sum1 >= 21 && one.sum2 >= 21) || ((dealer.sum1 >= 21 && dealer.sum2 >= 21)))
			done = true;
		else if(one.sum1 == 21 || one.sum2 == 21 || dealer.sum1 >= 21 || dealer.sum2 >= 21)
			done = true;
		

		repaint();
	}

	//empty
	public void keyTyped(KeyEvent e) {
	}

	// decides what actions occur when a button is pressed
	public void keyReleased(KeyEvent e) {
		// Press hit
		if (e.getKeyCode() == KeyEvent.VK_1 && done == false) {
			deck.drawCard(one);
			
			if(dealer.sum1 < 17 && dealer.sum2 > 21 || dealer.sum2 < 17) {
				deck.drawCard(dealer);
			}
		}
		
		// Press hold
		if(e.getKeyCode() == KeyEvent.VK_2 && done == false) {
			done = true;
			
			if(dealer.sum2 < 17 || (dealer.sum2 > 21 && dealer.sum1 < 17) ) {
				deck.drawCard(dealer);			
			}
		}
		
		//restart the game
		if (e.getKeyCode() == KeyEvent.VK_ENTER && done == true) {
			done = false;
			one.ace = false;
			dealer.ace = false;
			for (int i = 0; i < 5; i++) {
				one.hand[i] = null;
				dealer.hand[i] = null;
				deck.shuffle();
			}
			deck.topDeck = 0;
			one.totalCards = 0;
			dealer.totalCards = 0;
			one.sum1 = 0;
			one.sum2 = 0;
			dealer.sum1 = 0;
			dealer.sum2 = 0;
		}
		
	}

	//empty
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// decides how a winner is determined
	private void determineWinner(Graphics g) {
		if(one.sum2 <= 21) {
			if (one.sum2 == 21 && one.totalCards == 2)
				g.drawString("BLACKJACK! You Win", 20, 360);
			else if(dealer.sum2 <= 21) {
				if(dealer.sum2 > one.sum2)
					g.drawString("You Lose", 20, 360);
				else if(dealer.sum2 < one.sum2)
					g.drawString("You Win", 20, 360);
				else
					g.drawString("Tie", 20, 360);
			}
			else if(dealer.sum1 <= 21) {
				if(dealer.sum1 > one.sum2)
					g.drawString("You Lose", 20, 360);
				else if(dealer.sum1 < one.sum2)
					g.drawString("You Win", 20, 360);
				else
					g.drawString("Tie", 20, 360);
			}
			else {
				g.drawString("Bust Hand. You Win", 20, 360);
			}
		}
		else if(one.sum1 <= 21) {
			if(dealer.sum2 <= 21) {
				if(dealer.sum2 > one.sum1)
					g.drawString("You Lose", 20, 360);
				else if(dealer.sum2 < one.sum1)
					g.drawString("You Win", 20, 360);
				else
					g.drawString("Tie", 20, 360);
			}
			else if(dealer.sum1 <= 21) {
				if(dealer.sum1 > one.sum1)
					g.drawString("You Lose", 20, 360);
				else if(dealer.sum1 < one.sum1)
					g.drawString("You Win", 20, 360);
				else
					g.drawString("Tie", 20, 360);
			}
			else {
				g.drawString("Bust Hand. You Win", 20, 360);
			}
		}
		else {
			g.drawString("Bust Hand. You Lose", 20, 360);
		}
	}

	//updates the images on the screen 
	public void paint(Graphics g) {
		
		
		// background 
		g.setColor(Color.green);
		g.fillRect(1, 1, 1200, 720);
		
		// adding deck
		deck.draw((Graphics2D)g);
		
		// starting hands
		dealer.drawHand((Graphics2D) g, 320, 25);
		one.drawHand((Graphics2D) g, 320, 495);
		
		// draw cards
		while(one.totalCards < 2 && dealer.totalCards < 2) {
			deck.drawCard(one);
			deck.drawCard(dealer);
		}
		
		// instructions
		g.setColor(Color.black);
		g.setFont(new Font("arial", Font.PLAIN, 20));
		g.drawString("Hit - Press 1", 0, 20);
		g.drawString("Hold - Press 2 ", 0, 50);
		
		// Player assignment
		g.setFont(new Font("arial", Font.BOLD, 50));
		g.drawString(" Player", 900, 575);
		g.drawString(" Dealer ", 900, 125);
		
		// Deciding winner
		if(done ) {
			determineWinner(g);
		}

		
		g.dispose();
	}

}
