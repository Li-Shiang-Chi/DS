package other;

public class linearsearch {
	public static int linearSearch(int[] array , int find)
	{
		int result = -1;
		for(int i=0;i<array.length;i++)
		{
			if(array[i] == find)
			{
				result = i;
				break;
			}	
		}
		return result;
	}
}
