
public class SpaceChar {
	private int input;
	private int length;
	private char[] charList = {' '};
	
	//constructor allows you the initialize variables as soon as a object is created
	public SpaceChar(){
		input = 0;
	}
	
	
	public char getChar(int theInput){
		input = theInput;
		char Letter = charList[input];
		return Letter;
	}
	public int getNum(){
		length = charList.length;
		return length;
	}
}
