/**
 * This class contains the methods for creating a student linked list
 * @author Waley
 *
 */
public class LinkedList {
	
	private Student head;
	/**
	 * The default constructor for a student linked list. Creates an empty liked list
	 */
	public LinkedList (){
		head = null;
	}
	/**
	 * This method inserts a student into the front of the linked list
	 * @param s student to insert
	 */
	public void insertToFrontOfList (Student s){
		s.setNext(head);
		head = s;
	}
	/**
	 * This method inserts a student into the end of the linked list
	 * @param s student to insert
	 */
	public void insertToEndOfList (Student s){
		Student cursor = head; 
		if (head==null) {
			head=s;
			return;
		}
		while (cursor.getNext() != null)
			cursor = cursor.getNext();
		cursor.setNext(s);
	}
	/**
	 * This method inserts a student into the linked list in ascending order of student id
	 * @param s student to insert 
	 */
//	public void insertInOrder (Student s){
//		if (head==null) {
//			head = s;
//			return;
//		}
//		if (search(s.getId())!=null)
//			return;
//		Student current = head, prev = head;
//		while (current!=null) {
//			if (current.getId()<s.getId()) {
//				prev=current;
//				current=current.getNext();
//				if(current==null) {
//					prev.setNext(s);// not using insertToEndOfList method here since it would be simpler to just do prev.setnext
//					return;
//				}
//			}
//			else if(current == head) {
//				insertToFrontOfList(s);
//				return;
//				}
//			else {
//				s.setNext(current);
//				prev.setNext(s);
//				return;
//			}
//		}
//	}
	/**
	 * This method searches a linked list for a student matching a student ID
	 * @param id the student id to search for
	 * @return the student matching the id or null
	 */
//	public Student search(int id) {
//		Student cursor = head;
//		while (cursor!= null) {
//			if (cursor.getId()==id)
//				return cursor;
//			cursor = cursor.getNext();
//		}
//		return null;
//	}
	/**
	 * This method removes the last element in the linked list
	 */
//	public void removeEndElement() {
//		Student cursor = head;
//		if (head ==null)
//			return;
//		if (head.getNext()==null) {
//			head=null;
//			return;
//		}
//		while (true) {
//			if (cursor.getNext().getNext()==null) {
//				cursor.setNext(null);
//				return;
//			}
//			cursor=cursor.getNext();
//		}
//	}
	/**
	 * This method removes the first element in the linked list
	 */
	public void removeFirstElement() {
		if (head==null)
			return;
		if (head.getNext()==null)
			head=null;
		else
			head=head.getNext();
	}
	/**
	 * This method removes a student matching a certain student ID from the linked list
	 * @param id the id of student to remove
	 */
//	public void removeElement(int id) {
//		if (head==null)
//			return;
//		Student temp = head;
//		if (temp.getId()==id)
//			removeFirstElement();
//		while(temp.getNext()!=null) {
//			if (temp.getNext().getId()==id) {
//				if (temp.getNext().getNext()==null) {
//					temp.setNext(null);// not using removeEndElement since that would require more complexity.
//					return;
//				}
//				else {
//					temp.setNext(temp.getNext().getNext());
//					return;
//				}
//			}
//			temp=temp.getNext();
//		}
//	}
	/**
	 * This method prints the contents of the linked list
	 */
	public void printLinkedList (){
		Student cursor = head;
		if (head==null)
			return;
		while (cursor!=null) {
			System.out.println(cursor.toString());
			cursor=cursor.getNext();
		}
	}
	public Student getHead() {
		return head;
	}
	public void setHead(Student s) {
		head=s;
	}
	
	
//	public static void main (String [] args){
//		StudentLinkedList myHead = new StudentLinkedList ();
//
//		myHead.insertInOrder(new Student ("Sammmm", 6));
//		myHead.insertInOrder(new Student ("Joeey", 5));
//		myHead.insertInOrder(new Student ("Sarah", 3));
//		myHead.insertInOrder(new Student("Sam",1));
//		myHead.insertInOrder(new Student("AKJFGKLASF",1));
//		myHead.insertInOrder(new Student("Joe",9));
//		myHead.insertInOrder(new Student("Bob",40));
//		myHead.insertInOrder(new Student("ABC", 2));
//		myHead.insertInOrder(new Student("Student",9));
//		myHead.insertInOrder(new Student("Samuel",20));
//		myHead.removeEndElement();
//		myHead.removeEndElement();
//		myHead.removeFirstElement();
//		myHead.removeFirstElement();
//		myHead.removeElement(5);
//		System.out.println("Search Results= "+ myHead.search(9));
//		myHead.printLinkedList();
//	}
}
