import java.util.Scanner;


//file have to be stored in the project folder

public class acceptFileName {
	String fileName() {
		Scanner sc=new Scanner(System.in);
	    System.out.print("Enter file name: ");
	    String name=sc.next();
	    sc.close();
	    return name;
	

}}
