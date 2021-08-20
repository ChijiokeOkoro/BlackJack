import javax.swing.JFrame;

public class BlackJack_Main {
	public static void main(String[] args) {
		
		JFrame blackjack = new JFrame();
		GameRunner game = new GameRunner();
		blackjack.add(game);
		
		blackjack.setBounds(1,1,1200,720);
		
		
		blackjack.setTitle("Blackjack");
		
		
		blackjack.setResizable(false);
		blackjack.setVisible(true);
		blackjack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
