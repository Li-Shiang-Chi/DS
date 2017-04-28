package ds;

import java.util.ArrayList;

public class stack_arraylist<T> {
	
	ArrayList<T> stack ;
	int top;
	
	public stack_arraylist()
	{
		stack = new ArrayList<T>();
		top = -1;
	}
	
	public void push(T value)
	{
		stack.add(value);
		top++;
	}
	public T peek() //return top and not remove
	{
		if(top<0){return null;}
		else{
			T result = stack.get(top);
			return result;
		}
	}
	public T pop() // return top and remove
	{
		if(top<0){return null;}
		else{
			T result = stack.get(top);
			stack.remove(top);
			top--;
			return result;
		}
	}
	public boolean isEmpty()
	{
		if(top<0){
			return true;
		}
		else{
			return false;
		}
	}
	public void dumpStack(){
		System.out.println(stack.toString());
	}
	
	
	
}
