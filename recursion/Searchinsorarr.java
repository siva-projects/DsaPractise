package recursion;

public class Searchinsorarr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,5,1,2,3};
		System.out.println(searchinsorarr(arr,0,arr.length-1,4));
	}
	static int searchinsorarr(int[] arr,int start,int end,int target)
	{ // searching for an element in rotated sorted array using recursion
		
		int mid=start+(end-start)/2;
		if(start>=end)
			return start;
		if(arr[mid]==target)
			return  mid;
		if(arr[mid]<arr[end] )
		{
			if(target>arr[mid] && target<=arr[end])
				return searchinsorarr(arr,mid+1,end,target);
			else
			return 	searchinsorarr(arr,start,mid-1,target);
		}
		else
		{
			if(target>=arr[start] && target<arr[mid])
				return searchinsorarr(arr,start,mid-1,target);
			else
				return searchinsorarr(arr,mid+1,end,target);
		}
	}
}
