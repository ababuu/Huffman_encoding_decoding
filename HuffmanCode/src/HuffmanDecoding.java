import java.util.HashMap;

public class HuffmanDecoding {
	
	

	public HashMap<Character,String> getCodeTable(char[] symbols, String[] codeForSymbols){
		HashMap<Character,String> code_table = new HashMap<>();
		for (int i = 0; i < codeForSymbols.length; i++) {
			code_table.put(symbols[i], codeForSymbols[i]);
		}
		return code_table;
	}
	
	String Decomp;
    public HuffmanTree buildTree(HashMap<Character, String> codeTable) {
        HuffmanTree tree = new HuffmanTree();
      
        for (HashMap.Entry<Character, String> entry : codeTable.entrySet()) {            
            char key = entry.getKey();            
            String code = entry.getValue();                    
            Node node = tree.rootNode;
            
            for (int i = 0; i < code.length(); i++) {
       
                if (code.charAt(i) == '1') {
                    if (node.right == null) {
                        node.right = new Node();
                        node = node.right;
                    } else {
                        node = node.right;
                    }
                } else if(code.charAt(i) == '0') {
                    if (node.left == null) {
                        node.left = new Node();
                        node = node.left;
                    } else {
                        node = node.left;
                    }
                }
                if (i == code.length()-1) {
                    node.key = key;
                    node.code = code;
                    node = tree.rootNode;
                }
            }           
        }      
        return tree;
    }

    
    public String getDecodedString(String bitString, HashMap<Character, String> codeTable) {
        
        HuffmanTree charTree = buildTree(codeTable);  
        Decomp = "";       
        Node node = charTree.rootNode;

        for (int i = 0; i < bitString.length(); i++) {
            if (bitString.charAt(i) == '0') {
                node = node.left;
            } else {
                node = node.right;
            }          
            if (node.isLeaf()) {
                Decomp += Character.toString(node.key);                      
                node = charTree.rootNode;
            }
        }      
        return Decomp;
        
    }
		
}

    





