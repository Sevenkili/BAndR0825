
/**
 * 
 * @author qichenglin
 *
 */
public class Dictionary {

	private String word;
	private String pos;
	private int freq;

	
	public Dictionary(String word, String pos, int freq) {
		super();
		this.word = word;
		this.pos = pos;
		this.freq = freq;
	}



	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}

}
