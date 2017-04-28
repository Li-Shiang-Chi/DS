package sort;

import java.util.Arrays;

public class shellsort {
	public static void shellSort(int[] array){
		
		/*int gap = array.length / 2;
		int i , j;
		while(gap > 0)
		{
			for( i = gap; i < array.length; i++)
			{    //´¡¤J±Æ§Çªk 
	            int tmp = array[i];
	            for( j = i; j >= gap && tmp < array[j-gap]; j-=gap){
	                array[j] = array[j-gap];
	            }
	            array[j] = tmp;
	        }   
			gap /= 2;
		}*/
		
		int gap = array.length / 2;
		int i = 0 ;
		int j =0;
		
		while(gap > 0)
		{
			for(i = gap ; i < array.length ; i++)
			{
				for(j=i;j>=gap && array[j-gap] > array[i] ; j-=gap)
				{
					array[j] = array[j-gap];
				}
				array[j] = array[i];
			}
			
			gap /=2;
		}

	}
	public static void main(String[] args){
		int[] input = {1,3,4,5,2,10,9,100,7,-1};
		
		shellSort(input);
		
		System.out.println(Arrays.toString(input));
	}
}
