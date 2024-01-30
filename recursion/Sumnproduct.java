package recursion;

public class Sumnproduct {
public static void main(String[] args)
{
	System.out.println(sum(743));
		System.out.println(product(743));
	
}
	static int sum(int n) // finding sum of a number 
	{
		if(n==0)
			{ return 0;}
		int rem=n%10;
		return rem+sum(n/10);
	}
	static int product(int n) // finding product of a number
	{
		if(n==0)
		{ return 1;}
		int rem=n%10;
		return rem*product(n/10);
	}
}
