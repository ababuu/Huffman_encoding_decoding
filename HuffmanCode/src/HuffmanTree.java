import java.util.HashMap;
import java.util.PriorityQueue;


public class HuffmanTree {
	Node rootNode=new Node();
	
	public Node buildTree(HashMap<Character, Integer> frequencies) {
		final PriorityQueue<Node> pq=new PriorityQueue<>();
		for(char ch: frequencies.keySet()) {
			pq.add(new Node(ch,frequencies.get(ch),null,null));
		}
		
		while(pq.size()>1) {
			 Node left= pq.poll();
			 Node right= pq.poll();
			 Node parent= new Node('\0',left.freq+right.freq, left, right);
		     pq.add(parent);
		} 
		return pq.poll();
	}
	
    
	
}
