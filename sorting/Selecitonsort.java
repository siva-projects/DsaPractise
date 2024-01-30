package sorting;

import java.util.Arrays;

public class Selecitonsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {9,10,1,2};
		selectionsort(arr);
	}

	public static void selectionsort(int[] arr)
	{
		for(int i=0;i<arr.length-i;i++)
		{
			int max=findmax(arr,0,arr.length-i-1);
			int temp=arr[arr.length-i-1];
			arr[arr.length-i-1]=arr[max];
			arr[max]=temp;
		}
		System.out.println(Arrays.toString(arr));
		
	}
	public static int findmax(int[] arr,int start,int end)
	{
		int maxi=0;
		for(int i=start;i<=end;i++)
		{
			if(arr[i]>arr[maxi])
				maxi=i;
		}
		return maxi;
	}
}
