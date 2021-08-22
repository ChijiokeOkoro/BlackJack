import javax.swing.JFrame;

public class BlackJack_Main {
	public static void main(String[] args) {
		
		// adds the game onto the screen
		JFrame blackjack = new JFrame();
		GameRunner game = new GameRunner();
		blackjack.add(game);
		
		//bounds for the screen of teh game 
		blackjack.setBounds(1,1,1200,720);
		
		
		blackjack.setTitle("Blackjack");
		
		//Makes the screen visible 
		blackjack.setResizable(false);
		blackjack.setVisible(true);
		blackjack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
