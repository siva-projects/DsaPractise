package recursion;

public class Linearsearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,5,1,2,3};
		System.out.println(linearsearch(arr,10,0));
	}
	static int linearsearch(int[] arr,int target,int index) //linear searching an element via recursion
	{
		if(index==arr.length)
		{return -1;}
	
	if(target==arr[index])
		return index;
	else
		return linearsearch(arr,target,index+1);
	}
}
