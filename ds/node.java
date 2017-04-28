package ds;

public class node<T> {
	node<T> next;
	node<T> previous;
	public T value; 
	
	public node(T value){
		this.value = value;
	}
	public T getValue(){
		return this.value;
	}
	public T getNext(){
		return this.next.value;
	}
	public T getPrevious(){
		return this.previous.value;
	}
}
