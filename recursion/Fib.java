package recursion;

public class Fib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(fib(7));
	}
	static int fib(int n)  // fibnacci series problem
	{
		if(n<2)
			{return n ;}
		
		return fib(n-1)+fib(n-2);
	}
}
