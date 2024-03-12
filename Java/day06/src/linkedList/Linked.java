package linkedList;

interface Linked_interface {
	// function
	void add();
	void del();
	void print();
}

public class Linked implements Linked_interface{
	// setting
	Node head, tail, tmp;
	// construct
	Linked() {
		head = new Node();
		tail = new Node();
		tmp = new Node();
		head = tail = tmp = null;
	}
		
	// function
	public void add() {
		return;
	}
	public void del() {
		return;
	};
	public void print() {
		return;
	};
}