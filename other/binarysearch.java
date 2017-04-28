package other;

public class binarysearch {
	public static int binarySearch(int[] array , int find) // array should sorting first
	{
		int left = 0; int right = array.length-1;
		
		while(right > left)
		{
			int mid = (right + left) / 2;
			
			if(array[mid] == find)
				return mid;
			else if(array[mid] > find)
				right = mid-1;
			else if(array[mid] < find)
				left = mid+1;
		}
		return left;
	}
	
	public static void main(String[] args){
		
		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		System.out.println(binarySearch(array , 15));
		
		
	}
}
