package ds;

public class singleLinkedList<T> {
	
	
	public node first;
	public node last;
	public int count;
	
	public void dump(){
		if(count==0){System.out.println("linked list null");}
		node<T> temp = first;
		for(int i=0;i<count;i++){
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	private node<T> getNode(int index){
		node<T> temp = first;
		for(int i=0;i<index;i++)
		{
			temp = temp.next;
		}
		return temp;
	}
	private node<T> getPreviousNode(node<T> node)
	{
		if(node == first){return first;}
		node<T> preNode = first;
		while(preNode != node){
			preNode = preNode.next;
		}
		return preNode;
	}
	public node<T> getFirst()
	{
		return first;
	}
	public node<T> getLast()
	{
		return last;
	}
	public void addFirst(T value)
	{
		node<T> node = new node<T>(value);
		if(count == 0)
			last = node;
		else
			node.next = first;
		first = node;
		count++;
	}
	public void add(T value)
	{
		node<T> node = new node<T>(value);
		if(count == 0){
			first = node;
			last = node;
		}
		else{
			last.next = node;
			last = node;
		}
		count++;
		
	}
	public void addBefore(T value , int index)
	{
		node<T> node = new node<T>(value);
		if(index < 0){return;}
		if(index > count-1){return;}
		node<T> current = getNode(index);
		node<T> preNode = getPreviousNode(current);
		if(index == 0)
		{
			first = node;
			first.next = current;
		}
		else
		{
			node.next = current;
			preNode.next = node;
			
		}
		count++;
	}
	public void addAfter(T value ,int index)
	{
		node<T> node = new node<T>(value);
		node<T> current = getNode(index);
		if(index < 0){return;}
		if(index > count-1){return;}
		
		node.next = current.next;
		current.next = node;
		count++;
			
	}
	public void removeFirst()
	{
		if(count == 0){return;}
		first = first.next;
		count--;
	}
	public void removeLast()
	{
		if(count ==0){return;}
		node<T> current = getNode(count-1);
		last = current;
		count--;
	}
	public void remove(int index)
	{
		if(index==0){removeFirst();return;}
		if(index > count-1){return;}
		if(index == count-1){removeLast();return;}
		node<T> current = getNode(index);
		node<T> preNode = getPreviousNode(current);		
		preNode.next = current.next;
		count--;
	}
	public void reverse()
	{
		if(count == 0|| count==1){return;}
		node<T> current = first;
		last = first;
		node<T> prev = null;
		while(current!=null)
		{
			node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		first = prev;

	}
	
	public int getSize(){
		return count;
	}
}
