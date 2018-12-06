import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Assign8b {
	public static void main(String [] args) {
//		if (args.length!=1) {
//			System.out.println("Invalid Number of Arguments");
//			System.exit(0);
//		}
//		String fileName = args[0];
		AVLTree tree = new AVLTree();
		try (BufferedReader br = new BufferedReader(new FileReader("a3input1.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if(line.substring(0, 1).charAt(0) == 'I') {
		    		Student temp = new Student(line.substring(1, 8),line.substring(8, 33),line.substring(33, 37),line.substring(37, 41),line.substring(41, 42));
		    		tree.insertStudent(temp);
		    	}
		    	else
		    		System.out.println("Cannot Delete in AVL Tree, or invalid operation code");
		    }
		} catch (IOException e) {
			System.out.println("Error, unable to read file or file not found!");
			return;
		}
		tree.breadth();
	}
}
