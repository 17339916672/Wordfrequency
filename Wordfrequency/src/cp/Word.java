package cp;


public class Word {
	String word;
	int number=1;
	public Word(String word)
	{
		this.word=word;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber() {
		this.number = number+1;
	}
	
}
