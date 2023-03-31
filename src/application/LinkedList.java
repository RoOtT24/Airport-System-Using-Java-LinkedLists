package application;

public class LinkedList<T extends Comparable<T>> {
	private Node<T> head;
	
	

	public Node<T> getHead() {
		return head;
	}

	public int length() {
		Node<T> temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	public void insertion(T data) {
		Node<T> curr = head;
		Node<T> prev = null;
		Node<T> New = new Node<>(data);

		for (; (curr != null) && (curr.getData().compareTo(data) < 0); prev = curr, curr = curr.getNext())
			;
		if (head == null) {
			head = New;
		} else if (prev == null) {
			New.setNext(head);
			head = New;
		} else if (curr == null) {
			prev.setNext(New);
		} else {
			New.setNext(curr);
			prev.setNext(New);
		}
	}

	public void delete(T data) {
		Node<T> temp = head;

		if (temp.getData().equals(data)) {
			head = head.getNext();
			return;
		}

		while (temp.getNext() != null && !(temp.getNext().getData().equals(data))) {
			temp = temp.getNext();
		}
		temp.setNext(temp.getNext().getNext());
	}

	public Node<T> search(T data) {

		Node<T> temp = head;

		while (temp != null && !(temp.getData().equals(data))) {
			temp = temp.getNext();
		}
		return temp;

	}

	@Override
	public String toString() {
		Node<T> temp = head;
		String result = new String("head -> ");
		while (temp != null) {
			result = result + temp.getData() + " -> ";
			temp = temp.getNext();
		}
		return result + "null";
	}

}