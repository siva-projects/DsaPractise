package recursion;

public class Sortchecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,5,1,2,3};
		System.out.println(sortchecker(arr,0));
	}
	static boolean sortchecker(int arr[],int index) //checking whether the array is sorted or not 
	{
		if(index==arr.length-1)
		{return true;}
		return (arr[index]<arr[index+1]) && sortchecker(arr,index+1);
	}
}
