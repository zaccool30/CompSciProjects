import java.util.ArrayList;
import java.util.Scanner;

public class Uno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//fill deck
				ArrayList<Card> deck = new ArrayList<Card>();
				String Suit = null;
				String Rank = null;
				int Value = 0;
				for (int i = 0; i < 4; i++){
					for (int j =1; j <= 12; j++){
						switch(i){
							case 0:
								Suit = "Red";
							break;
							case 1:
								Suit = "Blue";
							break;
							case 2:
								Suit = "Yellow";
							break;
							case 3:
								Suit = "Green";
							break;
						}
						switch(j){
							case 1:
								Rank = "1";
								Value = 1;
							break;
							case 2:
								Rank = "2";
								Value = 2;
								break;
							case 3:
								Rank = "3";
								Value = 3;
							break;
							case 4:
								Rank = "2";
								Value = 4;
							break;
							case 5:
								Rank = "5";
								Value = 5;
							break;
							case 6:
								Rank = "6";
								Value = 6;
							break;
							case 7:
								Rank = "7";
								Value = 7;
							break;
							case 8:
								Rank = "8";
								Value = 8;
							break;
							case 9:
								Rank = "9";
								Value = 9;
							break;
							case 10:
								Rank = "Skip";
								Value = 10;
							break;
							case 11:
								Rank = "Reverse";
								Value = 11;
							break;
							case 12:
								Rank = "Draw Two";
								Value = 12;
							break;
							
					}
						deck.add(new Card(Suit, Rank, Value));
					}
				}
				
				
				for (int i = 0; i < 4; i++){
					for (int j =0; j <= 12; j++){
						switch(i){
							case 0:
								Suit = "Red";
							break;
							case 1:
								Suit = "Blue";
							break;
							case 2:
								Suit = "Yellow";
							break;
							case 3:
								Suit = "Green";
							break;
						}
						switch(j){
							case 0:
							Rank = "0";
								Value = 0;
							break;
							case 1:
								Rank = "1";
								Value = 1;
							break;
							case 2:
								Rank = "2";
								Value = 2;
								break;
							case 3:
								Rank = "3";
								Value = 3;
							break;
							case 4:
								Rank = "2";
								Value = 4;
							break;
							case 5:
								Rank = "5";
								Value = 5;
							break;
							case 6:
								Rank = "6";
								Value = 6;
							break;
							case 7:
								Rank = "7";
								Value = 7;
							break;
							case 8:
								Rank = "8";
								Value = 8;
							break;
							case 9:
								Rank = "9";
								Value = 9;
							break;
							case 10:
								Rank = "Skip";
								Value = 10;
							break;
							case 11:
								Rank = "Reverse";
								Value = 11;
							break;
							case 12:
								Rank = "Draw Two";
								Value = 12;
							break;
							
					}
						deck.add(new Card(Suit, Rank, Value));
					}
				}
				for (int i = 0; i < 1; i++){
					for (int j =1; j <= 8; j++){
						switch(i){
							case 0:
								Suit = "Wild";
							break;
							
						}
						switch(j){
							
							case 1:
								Rank = "Color";
								Value = 13;
							break;
							case 2:
								Rank = "Color";
								Value = 13;
							break;
							case 3:
								Rank = "Color";
								Value = 13;
							break;
							case 4:
								Rank = "Color";
								Value = 13;
							break;
							case 5:
								Rank = "Draw Four";
								Value = 14;
								break;
							case 6:
								Rank = "DrawFour";
								Value = 14;
							break;
							case 7:
								Rank = "DrawFour";
								Value = 13;
							break;
							case 8:
								Rank = "DrawFour";
								Value = 13;
							break;
							
					}
						deck.add(new Card(Suit, Rank, Value));
					}
				}
				
				
				
				
				
				Deck Deck1 = new Deck(deck);
				//Deck1.saying();
				Deck1.Shuffle();
				//Deck1.saying();
				//System.out.println(Deck1.size());
				Scanner input = new Scanner(System.in);
				System.out.println("How many players are there?");
				int numplayers = input.nextInt();
				Deck1.deal(numplayers, 7);
				
				ArrayList<ArrayList<Card>> Cards = Deck1.deal(numplayers, 7);
				ArrayList<Player> Players= new ArrayList<Player>();
				for (int i = 0; i < Cards.size(); i++){
					Players.add(new Player(Cards.get(i)));
					System.out.println();
				}
																								
				//main loop
				Boolean end = false;
				int turns = 0;
				String Operation;
				int CardIndex =0;
				Card LastPlayed = Deck1.getCard(Deck1.size()-1);
				Deck1.useCard(LastPlayed);
				Deck1.delCard(LastPlayed);
				while (LastPlayed.getSuit().equalsIgnoreCase("wild") || LastPlayed.getRank().equalsIgnoreCase("reverse") || LastPlayed.getRank().equalsIgnoreCase("draw two") || LastPlayed.getRank().equalsIgnoreCase("skip")){
					
					LastPlayed = Deck1.getCard(Deck1.size()-1);
					Deck1.useCard(LastPlayed);
					Deck1.delCard(LastPlayed);
				}
				while(end == false){
					System.out.println(LastPlayed.getSuit() + ", " + LastPlayed.getRank() + " was played last.");
					Players.get(turns % numplayers).Saying();
					System.out.println();
					System.out.println("Player " + turns % numplayers + " it is your turn!");
					System.out.println("What do you want to do? Draw or Play?");
					Operation = input.next();
					if (Operation.equalsIgnoreCase("Draw")){
						Players.get(turns % numplayers).Draw(Deck1);
						Players.get(turns % numplayers).getCard(Players.get(turns % numplayers).size()-1).saying();
					}
					else if (Operation.equalsIgnoreCase("Play")){
						/*Players.get(turns % numplayers).indexSaying();
						System.out.println("What card do u want to play?");
						CardIndex = input.nextInt();
						LastPlayed = Players.get(turns % numplayers).Play(Deck1, CardIndex);*/
						//need to see if the card they placed is good with the rules
						LastPlayed = Play(Players, turns, numplayers, CardIndex, input, LastPlayed, Deck1);
						
					}
					
					
					
					
					if(Players.get(turns % numplayers).size() == 0){
						end = true;
						System.out.println("Player " + turns % numplayers + " Wins!");
					}
					
					turns++;
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
				}		
				
	}
		
	
	public static Card Play(ArrayList<Player> Players, int turns, int numplayers, int CardIndex, Scanner input, Card LastPlayed, Deck Deck1){
		Players.get(turns % numplayers).indexSaying();
		System.out.println("What card do u want to play?");
		CardIndex = input.nextInt();
		//need to see if the card they placed is good with the rules
		if(Players.get(turns % numplayers).getCard(CardIndex).getRank() == LastPlayed.getRank() || Players.get(turns % numplayers).getCard(CardIndex).getSuit() == LastPlayed.getSuit() || Players.get(turns % numplayers).getCard(CardIndex).getSuit().equals("Wild") || LastPlayed.getSuit().equals("Wild")){
			
		}
		else{
			System.out.println("That card does not work becasue the color or number does not match and it is not wild.");
			System.out.println("Play a card that matches: " + LastPlayed.getSuit() + " " + LastPlayed.getRank() + "!");
			Play(Players, turns, numplayers, CardIndex, input, LastPlayed, Deck1);
		}
		
			
			
			
		LastPlayed = Players.get(turns % numplayers).Play(Deck1, CardIndex);
		return LastPlayed;
	}
	

}
