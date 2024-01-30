package recursion;
import java.util.*;
public class Characterremoval {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter two  numbers please");
		int a = sc.nextInt();
		if(a%11 ==0 && a%17==0)
		{
			System.out.println("foo boo");
		}
		else if(a%11 ==0)
		{
			System.out.println("foo");
		}
		else if(a%17 == 0)
		{
			System.out.println("bar");
		}
		
		
	}
	
		
}


