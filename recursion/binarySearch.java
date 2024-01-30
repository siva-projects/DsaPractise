package recursion;

import java.util.Arrays;

public class binarySearch {

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7};
		Arrays.sort(arr);
		System.out.println("The target is at "+binarySearch(arr,3));
	}

	public static int binarySearch(int arr[],int target)
	{
		int start=0;int end=arr.length-1;
		int ans=0;
		while(start<=end)
		{
			int mid=start+(end-start)/2;
			if(arr[mid]==target)
			{
				ans=mid;
				break;
			}
			if(arr[mid]<target)
			{
				start=mid+1;
			}
			if(arr[mid]>target)
			{
				end=mid-1;
			}
			
		}
		return ans;
	
	}
}
