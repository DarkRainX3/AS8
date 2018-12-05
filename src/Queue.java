
public class Queue {
	private LinkedList list;
	
	public Queue() {
		list = new LinkedList();
	}
	
	public void add(Student s) {
		list.insertToEndOfList(s);
	}
	
	public Student remove() {
		Student temp = list.getHead();
		if (temp == null) {
			System.out.println("Empty Queue");
			return null;
		}
		else {
			list.removeFirstElement();
			return temp;
		}
	}
	
	public void clear() {
		list.setHead(null);
	}
	
	public boolean isEmpty() {
		if (list.getHead()==null)
			return true;
		else
			return false;
	}
}
