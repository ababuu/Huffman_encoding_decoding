
import java.util.HashMap;
import java.util.Map.Entry;




public class HuffmanEncoding {
	

	public void buildLookupTable(Node node, String string,HashMap<Character, String> map) {
		if(!node.isLeaf()) {
			buildLookupTable(node.left,string+'0', map);
			buildLookupTable(node.right,string+'1', map);
			}
		else {
			map.put(node.ch, string);
		}
		
	}
	
	
	
    public HashMap<Character, String> getCodeForSymbols(Node node){
		
		HashMap<Character, String> map=new HashMap<>();
		buildLookupTable(node,"",map);
		return map;
		}
    
    public String[] getCodes(HashMap<Character, String> map,Node node) {
    	buildLookupTable(node,"",map);
		String[] codes = new String[map.size()];
		int i = 0;
		for (String s : map.values()) {
		    codes[i++] = s;
		}
		return codes;
	}
	
	public StringBuilder getBitString(HashMap<Character,String> map,Node node,String data) {
		buildLookupTable(node,"",map);
		StringBuilder bitString=new StringBuilder();
		for(int i=0; i<data.length();i++){  
			  bitString.append(map.get(data.charAt(i))) ;  
			  } 
		return bitString;
	}
	
	

}
