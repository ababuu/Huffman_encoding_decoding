import java.util.HashMap;


public class FrequencyTable {
	
	
	public HashMap<Character, Integer> charFrequencies(String data) {
		HashMap<Character, Integer> freq = new HashMap<>();
		for ( int i=0; i< data.length(); i++ ) {
			char c = data.charAt(i);
			if ( freq.containsKey(c) )
				freq.put( c, freq.get( c )+1 );
			else
				freq.put(c, 1);
		}
		
		return freq;
	}
	
	public char[] getSymbols(HashMap<Character, Integer> map) {
		char[] chars = new char[map.size()];
		int i = 0;
		for (Character c : map.keySet()) {
		    chars[i++] = c;
		}
		return chars;
	}
	
	
	
	
	

}
