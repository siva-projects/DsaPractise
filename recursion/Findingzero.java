package recursion;

public class Findingzero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findingzero(500040,0));
	}
	static int findingzero(int n,int count)  //finding no.of zeros in a number
	{
		if(n==0)
		{return count;}
		int rem=n%10;
		if(rem==0)
		{count++;};
		return findingzero(n/10,count);
	}
}
