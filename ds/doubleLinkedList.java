package ds;

public class doubleLinkedList<T> {
	private node<T> first;
	private node<T> last;
	private int count;
	
	public int getSize(){
		return count;
	}
	public void getFirst(){
		System.out.println(first.value);
	}
	public void getLast(){
		System.out.println(last.value);
	}
	
	public void dump(){
		node<T> temp = first;
		
		while(temp != null){
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println();
		
	}
	public node<T> getCurrent(int index){
		node<T> temp = first;
		for(int i=0;i<index;i++)
		{
			temp = temp.next;
		}
		return temp;
	}
	public void remove(int index){
		if(count==0){return;}
		if(count==1){removeFirst();return;}
		if(index == count-1){removeLast();return;}
		node<T> temp = getCurrent(index);
		
		node<T> preNode = temp.previous;
		node<T> nextNode = temp.next;
		
		preNode.next = nextNode;
		nextNode.previous = preNode;
		
		count--;
		
	}
	public void removeFirst(){
		if(count <=0){return;}
		if(count==1){first=null;last=null;}
		node<T> nextNode = first.next;
		nextNode.previous = null;
		first = nextNode;
		count--;
	}
	public void removeLast(){
		if(count==0){return;}
		if(count==1){removeFirst();return;}
		
		node<T> preNode = last.previous;
		preNode.next = null;
		last = preNode;
		
		count--;
	}
	public void add(T value){
		node<T> node = new node<T>(value);
		if(count == 0)
		{
			first = node;
			last = node;
		}
		else
		{
			last.next = node;
			node.previous = last;
			last = node;
		}
		count++;
			
	}
	public void addFirst(T value){
		node<T> temp = new node<T>(value);
		if(count==0){first = temp;last=temp;}
	
		temp.next = first;
		first = temp;
		
		count++;
	}
	public void addLast(T value){
		node<T> temp = new node<T>(value);
		if(count==0){first = temp ; last=temp;}
		
		last.next = temp;
		temp.previous = last;
		last = temp;
		
		count--;
	}
	public void addBefore(T value , int index){
		node<T> temp = new node<T>(value);
		if(index > count-1){return;}
		if(index==0){addFirst(value);return;}
		
		node<T> current = getCurrent(index);
		temp.next = current;
		temp.previous = current.previous;
		current.previous.next = temp;
		current.previous = temp;
		count++;
	}
	public void addAfter(T value , int index){
		node<T> temp = new node<T>(value);
		if(index > count-1){return;}
		if(index == count-1){addLast(value);return;}
		
		node<T> current = getCurrent(index);
		temp.next = current.next;
		temp.previous = current;
		current.next.previous = temp;
		current.next = temp;
		
		count++;
		
	}
}
