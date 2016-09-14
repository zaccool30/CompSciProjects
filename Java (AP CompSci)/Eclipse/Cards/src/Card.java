
public class Card {
	
	private String Suit;
	private String Rank;
	private int Value;
	
	public Card(String suit, String rank, int value){
		Suit = suit;
		Rank = rank;
		Value = value;	
	}
	
	public String getSuit(){
		return Suit;
	}
	
	public String getRank(){
		return Rank;
	}
	
	public int getValue(){
		return Value;
	}
	public void saying(){
		System.out.println(Suit + ", " + Rank + ", " + Value);
	}
	public void indexSaying(int index){
		System.out.println("Card " + index + "; " + Suit + ", " + Rank);
	}
}
