package sort;

public class insertionsort {
	public static void sort(int[] array)
	{
		int i = 0; int j = 0;
		for(i=1;i<array.length;i++)
		{
			int temp = array[i];
			for(j = i-1; j >= 0; j--)
			{
				if(array[j] > temp)
				{
					array[j+1] = array[j]; // ©¹«á²¾
				}
				else{
					break;
				}
			}
			array[j+1] = temp;
		}
	}
	
	
	public static void main(String[] args){
		int[] n = {1,2,5,0,6,100,50,25};
		
		sort(n);
		
		for(int i=0;i<n.length;i++)
			System.out.print(n[i]+" ");
}
}