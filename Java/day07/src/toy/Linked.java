package toy;

import java.util.ArrayList;

public class Linked {
	// setting
	String name;
	Node<Integer> head;
	Node<Integer> tail;
	Node<Integer> tmp;
	// construct
	Linked(){
		head = new Node<Integer>();
		tail = head;
		tmp = null;
	}
	// function
	public void add(Integer data) {
		System.out.println(" -> Add Try");
		tail.after = new Node<Integer>();
		tail.after.before = tail;
		tail = tail.after;
		tail.setData(data);
	}
	public boolean delete(Integer idx) {
		System.out.println(" -> Delete Try");
		int i = 0;
		boolean result = false;
		for (tmp = head.after; tmp != null; tmp = tmp.after) {
			if(i == idx) {
				// logic
				result = true;
				if (tmp.after == null) {
					tmp.before.after = null;
					tail = tmp.before;
					break;
				}
				if (tmp.before == null) {
					head.after = tmp.after;
					head.before = null;
					break;
				}
				tmp.before.after = tmp.after;
				tmp.after.before = tmp.before;
				break;
			}
			i++;
		}
		return result;
	}
	public ArrayList<Integer> print() {
		System.out.println(" -> Print Try");
		ArrayList<Integer> result = new ArrayList<>();
		for (tmp = head.after; tmp != null; tmp = tmp.after) {
			System.out.println(tmp.getData());
			result.add(tmp.getData());
		}
		return result;
	}
	public void rank() {
		System.out.println(" -> Rank Try");
	}
}
