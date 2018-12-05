
public class Student {
	private String number;
	private String lastName;
	private String dpt;
	private String prog;
	private String year;
	private Student left, right, parent, next;
	
	public Student(String id, String ln, String department, String program, String year) {
		number = id;
		lastName=ln;
		dpt = department;
		prog = program;
		this.year = year;
		left = right = parent = next = null;
	}
	public Student() {
		number = year = null;
		lastName = dpt = prog = null;
		left = right = parent = next = null;
	}
	@Override
	public String toString() {
		return number+" "+lastName+" "+dpt+" "+prog+" "+ year;// + "\n Parent is : "+parent;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDpt() {
		return dpt;
	}
	public void setDpt(String dpt) {
		this.dpt = dpt;
	}
	public String getProg() {
		return prog;
	}
	public void setProg(String prog) {
		this.prog = prog;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public Student getLeft() {
		return left;
	}

	public void setLeft(Student left) {
		this.left = left;
	}

	public Student getRight() {
		return right;
	}

	public void setRight(Student right) {
		this.right = right;
	}
	public Student getParent() {
		return parent;
	}
	public void setParent(Student parent) {
		this.parent = parent;
	}
	public Student getNext() {
		return next;
	}
	public void setNext(Student next) {
		this.next = next;
	}

}
