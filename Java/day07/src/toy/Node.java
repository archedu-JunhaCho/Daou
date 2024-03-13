package toy;

public class Node<T> {
	// setting
	private T data;
	Node<T> before;
	Node<T> after;
	Node<T> tmp;
	// construct
	Node(){
		data = null;
		before = null;
		after = null;
		tmp = null;
	}
	// function
	public void setData(T data) {
		this.data = data;
	}
	public T getData() {
		return this.data;
	}
}
