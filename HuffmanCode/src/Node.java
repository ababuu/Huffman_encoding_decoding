

public class Node implements Comparable<Node> {
	
	char ch;
	int freq;
	Node left;
	Node right;
	Character key;
	String code="";
	
	
	public Node() {
		
	}
	
	public Node(char data){
        this.ch = data;
    }

	
	public Node(char ch, int freq, Node left, Node right) {
		this.ch=ch;
		this.freq=freq;
		this.left=left;
		this.right=right;
	}
	
	public boolean isLeaf() {
		return left==null && right==null;
	}
	
	public char getData(){
        return this.ch;
    }
	
	
	@Override
	public int compareTo(Node that) {
		
		return this.freq-that.freq;
	}
	
	

}
