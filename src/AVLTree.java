import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AVLTree {
	private Student root;
	private Queue queue = new Queue();
	
	public AVLTree() {
		setRoot(null);
	}
	
	int max(int a, int b) {
        return (a > b) ? a : b;
    }
	
	int height(Student N) {
        if (N == null)
            return 0;
        return N.getHeight();
    }
	
	public void breadth() {
		Student root = this.getRoot();
	    if (root == null)
	        return;
	    queue.clear();
	    queue.add(root);
	    queue.add(new Student());
	    while(!queue.isEmpty()){
	        Student node = queue.remove();
	        if(node.getLastName()==null) {
		        if (!queue.isEmpty()) {
		        	queue.add(new Student());
		        	System.out.println();
		        }
	        }else {
	        	if (node.getLeft()!=null)
	        		queue.add(node.getLeft());
	        	if (node.getRight()!=null)
	        		queue.add(node.getRight());
	        	System.out.print(node+ ", ");
	        }
	    }
	}
	
	public void breadthFile(String filename) throws IOException{
	    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
	    if (root == null) {
	    	writer.close();
	    }
	    queue.clear();
	    queue.add(root);
	    writer.write("Number  Last Name                 Dept Prog Year");
	    writer.newLine();
	    System.out.println("Number  Last Name                 Dept Prog Year");
	    while(!queue.isEmpty()){
	        Student node = queue.remove();
	        writer.write(node.toString());
		    writer.newLine();
		    System.out.println(node);
	        if(node.getLeft() != null) queue.add(node.getLeft());
	        if(node.getRight() != null) queue.add(node.getRight());
	    }
	    writer.close();
	}
	
	public void inOrderFile(String fn) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fn));
		writer.write("Number  Last Name                 Dept Prog Year");
		System.out.println("Number  Last Name                 Dept Prog Year");
		writer.newLine();
		inOrderTraverseFile (root, writer);
		writer.close();
	}
	
	private void inOrderTraverseFile (Student cursor, BufferedWriter writer) throws IOException {// Depth First in order will go in ascending order
	    if (root == null) {
	    	writer.close();
	    }
		if (cursor != null) {
			inOrderTraverseFile (cursor.getLeft(), writer);
			writer.write(cursor.toString());
			writer.newLine();
			System.out.println(cursor);
			inOrderTraverseFile (cursor.getRight(), writer);
		}
	}
	
	private Student rRotate(Student s) {
		Student x = s.getLeft();
		Student y = x.getRight();
		x.setRight(s);
		s.setLeft(y);
		
		s.setHeight(max(height(s.getLeft()),height(s.getRight()))+1);
		x.setHeight(max(height(x.getLeft()),height(x.getRight()))+1);
		return x;
	}
	
	private Student lRotate(Student s) {
		Student y = s.getRight();
		Student x = y.getLeft();
		y.setLeft(s);
		s.setRight(x);
		
		s.setHeight(max(height(s.getLeft()),height(s.getRight()))+1);
		y.setHeight(max(height(y.getLeft()),height(y.getRight()))+1);
		return y;
	}
	
	int getBalance(Student N) {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }
	
	public Student insert(Student root, Student s) { //Methods taken from geeksforgeeks but adapted for student object
		if (root==null) {
			return s;
		}
		if (s.getLastName().compareToIgnoreCase(root.getLastName())<0)
			root.setLeft(insert(root.getLeft(), s));
		else if (s.getLastName().compareToIgnoreCase(root.getLastName())>0)
			root.setRight(insert(root.getRight(), s));
		else
			return root;
		root.setHeight(1+max(height(root.getLeft()),height(root.getRight())));
		int bal = getBalance(root);
		if (bal > 1 && s.getLastName().compareToIgnoreCase(root.getLeft().getLastName()) < 0)
            return rRotate(root);
		if (bal < -1 && s.getLastName().compareToIgnoreCase(root.getRight().getLastName()) > 0)
            return lRotate(root);
		if (bal > 1 && s.getLastName().compareToIgnoreCase(root.getLeft().getLastName()) > 0) {
			root.setLeft(lRotate(root.getLeft()));
            return rRotate(root);
		}
		if (bal < -1 && s.getLastName().compareToIgnoreCase(root.getRight().getLastName()) < 0) {
			root.setRight(rRotate(root.getRight()));
            return lRotate(root);
		}
		return root;
	}
	
	public void insertStudent(Student s) {
		root = insert(getRoot(),s);
	}

	public Student getRoot() {
		return root;
	}

	public void setRoot(Student root) {
		this.root = root;
	}
}
