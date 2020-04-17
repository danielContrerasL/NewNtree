package structure;

import java.util.ArrayList;

public class Node<T> {

	private T info;
	private ArrayList<Node<T>> list;

	public Node(T info) {
		this.info = info;
		list = new ArrayList<>();
	}

	public T getInfo() {
		return info;
	}
	
	public void add(Node<T> info) {
		list.add(info);
	}
	
	
	public ArrayList<Node<T>> getList() {
		return list;
	}

}
