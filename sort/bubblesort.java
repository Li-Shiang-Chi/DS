package sort;

import java.util.Arrays;

public class bubblesort {
	public static void bubbleSort(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			for(int j=0 ; j<array.length-1-i;j++)
			{
				if(array[j] > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] input = {1,3,4,5,2,10,9,100,7,-1};
		
		bubbleSort(input);
		
		System.out.println(Arrays.toString(input));
	}
}
