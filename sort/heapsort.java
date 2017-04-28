package sort;

import ds.Heap;

public class heapsort {
	public static void heapSort(Heap<Integer> array){
		
		while(array.getSize() >= 0){
			array.delete(0);
		}
		
	}
	public static void main(String[] args){
		Heap<Integer> heap = new Heap<Integer>();
		
		heap.insert(10);
		heap.insert(20);
		heap.insert(1);
		heap.insert(5);
		heap.insert(30);
		heap.insert(2);
		
		heapSort(heap);
	
	}
}
