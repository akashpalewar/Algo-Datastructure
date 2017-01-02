package linkedlist;

@SuppressWarnings("unused")
public class CircularLinkedList<E> {
	public Node<E> tail;
	public int size;
	
	private static class Node<E>{
		private E element;
		private Node<E> next;
		
		
		public Node(E e, Node<E> n){
			next = n;
			element = e;
		}
		
		public E getElement(){
			return element;
		}
		public void setElement(E e){
			element =e;
		}
		public void setNext(Node<E> n){
			next = n;
		}
		public Node<E> getNext(){
			return next;
		}
	}
	
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	
	public E first(){
		return tail.getNext().getElement();
	}
	
	public E last(){
		if(isEmpty()) return null;
		return tail.getElement();
	}
	public void rotate(){
		if(tail!=null)
			tail=tail.getNext();
	}

	
	public void addFirst(E e){
		if(size ==0){
			tail = new Node<>(e, null);
			tail.setNext(tail);
		}else{
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
	}
	
	public void addLast(E e){
		addFirst(e);
		tail = tail.getNext();
	}
	
	public E removeFirst(){
		if(isEmpty()) return null;
		Node<E> head = tail.getNext();
		if(head == tail) tail =null;
		else tail.setNext(head.getNext());
		size--;
		return head.getElement();
	}
}
 