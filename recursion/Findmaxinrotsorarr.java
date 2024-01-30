package recursion;

public class Findmaxinrotsorarr {

	public static void main(String[] args) {
		int[] arr= {4,5,1,2,3};
		System.out.println(findmaxinrotsorarr(arr,0,arr.length-1));
	}
	static int findmaxinrotsorarr(int[] arr,int start,int end) //find the max element in rotated sorted array
	{
		int mid=start+(end-start)/2;
		if(start>=end)
			return arr[start];
		if( (mid<arr.length-1) && arr[mid]>arr[mid+1] )
			return arr[mid];
		if(  (mid>0) && arr[mid]<arr[mid-1])
			return arr[mid-1];
		if(arr[start]>arr[end])
			return findmaxinrotsorarr(arr,start,mid+1);
		else
			return findmaxinrotsorarr(arr,mid+1,end);
	}
	 
}
