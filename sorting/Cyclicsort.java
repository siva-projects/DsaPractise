package sorting;

import java.util.Arrays;

public class Cyclicsort {

	public static void main(String[] args) {
	
		int arr[]= {5,4,3,2,1};
		//cyclicsort(arr1);
	}

	public static void cyclicsort(int[] arr)
	{
		
		for(int i=0;i<arr.length;i++)
		{
//			if(arr[i]!=i+1)    		if the limit is from 1 to n then this will work
//			{
//				int temp=arr[i];
//				arr[i]=arr[temp-1];
//				arr[temp-1]=temp;
//			}
			if(arr[i]!=i)
			{
				int temp=arr[i];    //if the limit is from 0 to n then this will work
				arr[i]=arr[temp];
				arr[temp]=temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
