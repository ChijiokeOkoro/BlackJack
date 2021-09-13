# BlackJack
Simulates the game of blackjack. Contains 5 classes: BlackJack_Main, GameRunner, Deck, Card, Player

Blackjack_Main: The tester class that displays the game on a JFrame, creates the bounds for the game, and creates a GameRunner object.

GameRunner: Handles the main bulk of the code. Utilizes the helper classes in order to frame the interactions with the player and the game. Registers the inputs that the user enters using the actionListener in order to progress the game.  

Card: This helper class creates a "card" which contains all the properties of one. This includes the value of a card and image using the Graphics class

Deck: This helper class contains a collection of 52 cards from the Card class. With this it includes a method to shuffle the order of the cards, a method to draw a card to a "player", and a method to display a card shown. 

Player: This helper class is used to represent the "player" and the "dealer". Each player contains a score with depends on the value and number of cards in a player's hand. The hand is an array of cards from the card class which is passed to a player from the deck.
