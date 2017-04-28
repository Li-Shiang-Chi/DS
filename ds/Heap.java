package ds;

import java.util.*;

public class Heap<T extends Comparable<T>>
{
	ArrayList<T> heap ;

	public Heap(){
		heap = new ArrayList<T>();
	}
	public void insert(T value)
	{
		heap.add(value);
		shiftUp();
	}
	public void delete(int index)
	{
		System.out.print(heap.get(0)+" ");
		if(heap.size() == 0){throw new NoSuchElementException(); }
		if(heap.size() == 1){heap.remove(0);}
		
		T last = heap.get(heap.size()-1);
		for(int i=0;i<heap.size();i++) // replace the remove node to last node
		{
			if(heap.get(i).equals(heap.get(index)))
			{
				heap.set(i , last);
			}
		}
		heap.remove(heap.size()-1);
		shiftDown();
	}
	public void shiftUp() // 往上取代
	
	{
		int k= heap.size() - 1;
		
		while(k > 0)
		{
			int p = (k-1)/2;
			T item = heap.get(k);
			T parent = heap.get(p);
			
			if(item.compareTo(parent) > 0)
			{
				//swap
				heap.set((k-1)/2, item);
				heap.set(k, parent);
				k = p; // 往上找
			}
			else{
				break;
			}
		}
	}
	public void shiftDown()
	{
		int k = 0; // first node
		int l = (2*k+1); // left leaf node
		while( l < heap.size())
		{
			int max = l; // greatest leaf node
			int r = l+1; // right leaf node
			if( r < heap.size())  // check right leaf not out of bounds
			{
				if( heap.get(r).compareTo(heap.get(l)) > 0)// find the greatest leaf
					max++;
			}
			
			T item = heap.get(k);
			T children = heap.get(max);
			if(children.compareTo(item) > 0)
			{	
				//swap
				heap.set(k, children);
				heap.set(max, item);
				k = max;
				l = (2*k)+1;
			}
			else// out of bounds
			{
				break;
			} 
		}
	}
	public int getSize(){
		return heap.size();
	}
	public void dumpHeap(){
		System.out.println(heap.toString());
	}
	public boolean isEmpty(){
		return heap.size() == 0;
	}
}

