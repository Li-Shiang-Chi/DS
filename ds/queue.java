package ds;
import java.util.*;
public class queue<T> {
	LinkedList<node<T>> queue;
	
	public queue(){
		queue = new LinkedList<node<T>>();
	}
	
	public boolean add(T value){
		node<T> temp = new node(value);
		return queue.add(temp);
	}
	public node<T> element() //Retrieves, but does not remove, the head of this queue.
	{
		return queue.getFirst();
	}
	public boolean offer(T value) //Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
	{
		node<T> temp = new node(value);
		return queue.add(temp);
	}
	public node<T> peek() //Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	{
		return queue.peek();
	}
	public node<T> poll()//Retrieves and removes the head of this queue, or returns null if this queue is empty.
	{
		return queue.poll();
	}
	public node<T> remove() //Retrieves and removes the head of this queue.
	{
		return queue.remove();
	}
}
