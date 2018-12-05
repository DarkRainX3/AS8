import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BSTree {
	private Student root;
	private Queue queue = new Queue();
	public BSTree() {
		root = null;
	}
	
	public void breadthFile(String filename) throws IOException{
	    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
	    if (root == null) {
	    	writer.close();
	    }
	    queue.clear();
	    queue.add(root);
	    while(!queue.isEmpty()){
	        Student node = queue.remove();
	        writer.write(node.toString());
		    writer.newLine();
	        if(node.getLeft() != null) queue.add(node.getLeft());
	        if(node.getRight() != null) queue.add(node.getRight());
	    }
	    writer.close();
	}
	
	public void breadth(Student root) {
	    if (root == null)
	        return;
	    queue.clear();
	    queue.add(root);
	    while(!queue.isEmpty()){
	        Student node = queue.remove();
	        System.out.println(node);
	        if(node.getLeft() != null) queue.add(node.getLeft());
	        if(node.getRight() != null) queue.add(node.getRight());
	    }
	}
	public void breadth(Student root, int a) {
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
	
	public void insertStudent (Student newStudent) {
		if (getRoot() == null)
			setRoot(newStudent);
		else {
			Student cursor = root;
			Student parent;
			while (true) {
				parent = cursor;
				if (newStudent.getLastName().compareToIgnoreCase(cursor.getLastName()) < 0) {
					cursor = cursor.getLeft();
					if (cursor == null) {
						newStudent.setParent(parent);
						parent.setLeft(newStudent);
						return;
					}
				}
				else if (newStudent.getLastName().compareToIgnoreCase(cursor.getLastName()) > 0) {
					cursor = cursor.getRight();
					if (cursor == null) {
						newStudent.setParent(parent);
						parent.setRight(newStudent);
						return;
					}
				}
				else {
					return;
				}
			}
		}
	}
	
	private Student find(String ln) {
		Student current = root;
		while(current!=null) {
			if (current.getLastName().replaceAll(" ","").compareToIgnoreCase(ln)==0)
				return current;
			else if (current.getLastName().replaceAll(" ","").compareToIgnoreCase(ln)<0)
				current=current.getRight();
			else
				current = current.getLeft();
		}
		return null;
	}
	
	public void delete(String name) {
		if (find(name)==null) {
			System.out.println("Student Not Found!");
			return;
		}
		root = deleteRec(root,name);
	}
	
	private Student deleteRec(Student root, String name) {// recursive method from geeks for geeks
		if (root == null) {
			return root;
		}
		if (name.compareToIgnoreCase(root.getLastName().replaceAll(" ",""))<0)
			root.setLeft(deleteRec(root.getLeft(),name));
		else if (name.compareToIgnoreCase(root.getLastName().replaceAll(" ",""))>0)
			root.setRight(deleteRec(root.getRight(),name));
		else {
			if (root.getLeft()==null)
				return root.getRight();
			else if (root.getRight()==null)
				return root.getLeft();
			copy(root,minValue(root.getRight()));
			root.setRight(deleteRec(root.getRight(),root.getLastName()));
		}
		return root;
	}
	
	private Student minValue(Student s) {
		Student min = s;
		while (s.getLeft()!=null) {
			min = s.getLeft();
			s = s.getLeft();
		}
		return min;
	}
	
	private void copy(Student a, Student b) {
		a.setDpt(b.getDpt());
		a.setLastName(b.getLastName());
		a.setNumber(b.getNumber());
		a.setProg(b.getProg());
		a.setYear(b.getYear());
	}
	
//	public void delete(String name) {
//		Student search = find(name);
//		if (search==null) {
//			System.out.println("Student Not Found!");
//		}
//		else if (search.getLeft()==null && search.getRight()==null) {
//			if (search.getLastName().compareToIgnoreCase(search.getParent().getLastName())>0)
//				search.getParent().setRight(null);
//			else
//				search.getParent().setLeft(null);
//		}
//		else if ((search.getLeft()==null && search.getRight()!=null) || (search.getLeft()!=null && search.getRight()==null))
//			return;
//		else if (search.getLeft()==null && search.getRight()!=null)
//			search.getParent().setRight(null);//not done
//		else
//			return;
//	}
	
	public void inOrder () {
		inOrderTraverse (root);
	}
	
	public void preOrder () {
		preOrderTraverse (root);
	}
	
	private void inOrderTraverse (Student cursor) {// Depth First in order will go in ascending order
		if (cursor != null) {
			inOrderTraverse (cursor.getLeft());
			System.out.println(cursor);
			inOrderTraverse (cursor.getRight());
		}
	}
	public void inOrderFile(String fn) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fn));
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
			inOrderTraverseFile (cursor.getRight(), writer);
		}
	}

	private void preOrderTraverse (Student cursor) {
		if (cursor != null) {
			System.out.println(cursor);
			preOrderTraverse (cursor.getLeft());
			preOrderTraverse (cursor.getRight());
		}
	}
	
	public Student getRoot() {
		return root;
	}

	public void setRoot(Student root) {
		this.root = root;
	}
	

}
