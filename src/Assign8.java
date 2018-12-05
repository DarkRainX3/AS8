import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Assign8 {
	public static void main(String [] args) {
//		if (args.length!=3) {
//			System.out.println("Invalid Number of Arguments");
//			System.exit(0);
//		}
		BSTree tree = new BSTree();
		try (BufferedReader br = new BufferedReader(new FileReader("a3input1.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if(line.substring(0, 1).charAt(0) == 'I') { 
		    		tree.insertStudent(new Student(line.substring(1, 8),line.substring(8, 33),line.substring(33, 37),line.substring(37, 41),line.substring(41, 42)));
		    	}
//		    	else if(line.substring(0, 1).charAt(0) == 'D') {
//		    		tree.delete(new Student(line.substring(1, 8),line.substring(8, 33),line.substring(33, 37),line.substring(37, 41),line.substring(41, 42)));
//		    	}
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Student acb = new Student(224, "Help", "ENGG", "ENSF", 3);
//		Student bca = new Student(145, "Name", "ENGG", "ENSF", 2);
//		Student abc = new Student(123, "Noob", "ENGG", "ENSF", 4);
//		Student dsa = new Student(445, "Benn", "ENGG", "ENSF", 2);
//		Student asd = new Student(545, "Asdf", "ENGG", "ENSF", 5);
//		Student bda = new Student(945, "Zaap", "ENGG", "ENSF", 3);
//		Student adb = new Student(945, "Nbop", "ENGG", "ENSF", 3);
//		Student lst = new Student(945, "Moon", "ENGG", "ENSF", 3);
//		Student lts = new Student(945, "Mapp", "ENGG", "ENSF", 3);
//		tree.insertStudent(acb);
//		tree.insertStudent(bca);
//		tree.insertStudent(abc);
//		tree.insertStudent(dsa);
//		tree.insertStudent(asd);
//		tree.insertStudent(bda);
//		tree.insertStudent(adb);
//		tree.insertStudent(lst);
//		tree.insertStudent(lts);
		//System.out.println(tree.find("help"));
		//tree.delete("help");
		//tree.inOrder();
		//tree.preOrder();
		//tree.delete("schafer");
		tree.breadth(tree.getRoot(),0);
		try {
		tree.breadthFile("breadth.txt");
		tree.inOrderFile("depth.txt");
		} catch(IOException e) {
			System.out.println("Cannot Write to file!");
		}
	}
}
