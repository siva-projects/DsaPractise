package sorting;

import java.util.Arrays;

public class Bubblesort {

	public static void main(String[] args) {
		
		int arr[]= {5,4,3,2,1};
		bubblesort(arr);
	}

	public static void bubblesort(int[] arr) {
		// this is bubble sorting
		for(int i=0;i<arr.length;i++)
		{	
			for(int j=i;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		
	}
}
