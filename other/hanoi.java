package other;

public class hanoi {
	public static void hanoi(int count , String from , String temp , String to){
		if(count==1){
			 System.out.println("Disk 1 from " + from + " to " + to);
		}
		else{
			
			hanoi(count-1 , from , to, temp);
			System.out.println("Disk " + count + " from " + from + " to " + to);
			hanoi(count-1 , temp , from ,to);
		}
	}
	
	public static void main(String[] args){
		hanoi(3,"A","B","C");
	}
}
