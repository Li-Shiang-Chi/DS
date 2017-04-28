package ds;

import java.util.*;
public class stack<T> {
	LinkedList<node<T>> link;
	
	public stack(){
		link = new LinkedList<node<T>>();
	}
	public boolean empty(){
		if(link.size() == 0)
			return true;
		else
			return false;
	}
	public node<T> peek() //Looks at the object at the top of this stack without removing it from the stack.
	{
		node<T> result = null;
		if(!empty()){
			result = link.peekFirst();
			return result;
		}
		else{
			return null;
		}
	}
	public node<T> pop() // Removes the object at the top of this stack and returns that object as the value of this function.
	{
		node<T> result = null;
		if(!empty())
		{
			result = link.pop();
			return result;
		}
		else
			return null;
	}
	public void push(T value)
	{
		node<T> temp = new node<T>(value);
		link.addFirst(temp);
	}
	public int search(T value){
		for(int i=0;i<link.size();i++)
		{
			System.out.println(link.get(i).value);
			if(link.get(i).value.equals(value)){
				return i;
			}
		}
		return -1;
	}
	
}
