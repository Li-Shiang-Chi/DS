package sort;

import java.util.Arrays;

public class mergesort {
	
	public static void mergeSort(int[] array){
		if(array.length <=1){return;}
		
		int rightLength = array.length / 2;
		int leftLength = array.length - (array.length / 2);
		
		int[] right = new int[rightLength];
		int[] left = new int[leftLength];
		
		for(int i=0;i<leftLength;i++)
			left[i] = array[i];
		for(int i=0;i<rightLength;i++)
			right[i] = array[leftLength+i];
		
		
		mergeSort(right);
		mergeSort(left);
		merge(array,right , left);
	}
	public static void merge(int[] data , int[] right , int[] left)
	{
		int[] workArray = new int[right.length + left.length];
		int r = 0;
		int l = 0;
		int index = 0;
		
		while(r <= right.length-1 && l <= left.length-1)
		{
			
			if(right[r] > left[l]){
				workArray[index] = left[l];
				l++;
			}
			else{
				workArray[index] = right[r];
				r++;
			}
			index++;
		}
		while(r <= right.length-1){
			workArray[index] = right[r];
			r++;
			index++;
		}
		while(l <= left.length-1){
			workArray[index] = left[l];
			l++;
			index++;
		}
		for(int i=0;i<data.length;i++)
			data[i] = workArray[i];
	}
	
	
	
	public static void main(String[] args){
		int[] input = {1,3,4,5,2,10,9,100,7};
		mergeSort(input);
		
		for(int i=0;i<input.length;i++){
			System.out.print(input[i] + " ");
		}
	}
}
