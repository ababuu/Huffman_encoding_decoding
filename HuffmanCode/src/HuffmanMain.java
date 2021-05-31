
import java.util.HashMap;
import java.util.Scanner;

/**
 * Name- Ababu Alemu
 * Id_no- ATR/6421/10
 */


public class HuffmanMain {

	public static void main(String[] args) {
		
		 //once the compressed file is saved, comment the code below up to '$'
		
		acceptFileName input=new acceptFileName();
		fileManagement readFile = new fileManagement();
		String fn=input.fileName();
		String fileData =readFile.readOneFile(fn).replaceAll("\n", "");
		
		HashMap<Character, Integer> frequency=new HashMap<>();
		HashMap<Character, String> lookup=new HashMap<Character, String>();
		
		FrequencyTable ft =new FrequencyTable();
		HuffmanTree ht=new HuffmanTree();
		HuffmanEncoding he=new HuffmanEncoding();
		
		frequency=ft.charFrequencies(fileData);
		Node node=ht.buildTree(frequency);
		
		String bitString=he.getBitString(lookup,node,fileData).toString();
		char[] symbols=ft.getSymbols(frequency);
		String[] codeForSymbols=he.getCodes(lookup,node);
		
		System.out.println("Frequency of each symbol: "+ frequency);
		System.out.println("Look up Table: "+lookup);
		System.out.println("Bit String: "+ bitString);
		System.out.print("Symbols: ");
		for(int i=0;i<symbols.length;i++) {
			System.out.print(symbols[i]+ " ");
		}
		System.out.print("\n");
		System.out.print("Code for Symbols: ");
		for(int i=0;i<codeForSymbols.length;i++) {
			System.out.print(codeForSymbols[i]+ " ");
		}
		
		//file saved in the same directory as the original
		manageCompressedFile cFile= new manageCompressedFile();
	    cFile.writeACompressedFile(bitString, symbols, codeForSymbols, "Compressed-"+fn);
	    System.out.println("\nFile saved as: "+ "Compressed-"+fn);
	    
	    //'$'  
		
		//uncomment the code below after a compressed file is saved
		/**
		System.out.println("Enter file name to decode: ");
		Scanner input=new Scanner(System.in);
		String inputfile=input.nextLine();
		manageCompressedFile cFile= new manageCompressedFile();
		CompressedContent compressedContent = cFile.readCompressedFile(inputfile);
		HuffmanDecoding hDecoding=new HuffmanDecoding();
		
		char[] symbols=compressedContent.symbols;
		String[] codeForSymbols=compressedContent.codeForSymbols;
		String bitString=compressedContent.bitString;
		
		HashMap<Character, String> codeTable=hDecoding.getCodeTable(symbols, codeForSymbols);
		hDecoding.buildTree(codeTable);
		String decodedString=hDecoding.getDecodedString(bitString,codeTable);
		System.out.print(decodedString);
		fileManagement fm=new fileManagement();
		fm.writeToAFile("Decoded-"+inputfile, decodedString);
		System.out.println("File written");
		*/
		
		}

}
