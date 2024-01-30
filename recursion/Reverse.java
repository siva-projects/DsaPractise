package recursion;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(743,0));
	}
	static int reverse(int n,int ans) //finding reverse of a number
	{
		if(n==0)
		{return ans;}
		int rem=n%10;
		ans=(ans*10)+rem;
		return reverse(n/10,ans);
	}
	
}
