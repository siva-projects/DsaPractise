package sorting;

import java.util.Arrays;

public class Mergesort {

	public static void main(String[] args) {
		int arr[]= {5,4,3,1,2};
		//mergesort5(arr,0,arr.length-1);
System.out.println(Arrays.toString(mergesort(arr)));
	}
	public static void mergesort5(int[] arr,int start,int end)
	{
                                                 //	 only taking indexes for start and end 
       if(end-start<=0) {                        //	 for ex for 5,4,3,2,1 ; start = 0 and end = 4;
		return ;}
    	int mid=start+(end-start)/2;
		mergesort5(arr,start,mid);
		mergesort5(arr,mid+1,end);				     
		
		merger5(arr,start,mid,end);         
		
	}
	public static void merger5(int[] arr,int start,int mid,int end) 
	{  
		int[] mergedarr=new int[end-start+1];
		int i=start,j=mid+1,k=0;
		while(i<=mid && j<=end)
		{ 
			if(arr[i]<arr[j])
			{
				mergedarr[k]=arr[i];
				i++;k++;
			}
			else
			{
				mergedarr[k]=arr[j];
				j++;k++;
			}
		}
			while(i<=mid)
			{
				mergedarr[k]=arr[i];
				i++;k++;
			}
			while(j<=end)
			{
				mergedarr[k]=arr[j];
				k++;j++;
			}
	
		for(int l=0;l<mergedarr.length;l++)
		{
			arr[start+l]=mergedarr[l];
		}

		
	}
	
//	public static void mergesort1(int[] arr,int start,int end)
//	{
//                                                 //		if(end-start==1)
//       if(end-start==1) {                        //		{return ;}
//		return ;}
//    	int mid=start+(end-start)/2;
//		mergesort1(arr,start,mid);
//		mergesort1(arr,mid,end);				//      mergesort1(arr,mid,end);
//		
//		merger1(arr,start,mid,end);
//		
//	}
//	public static void merger1(int[] arr,int start,int mid,int end) 
//	{  
//		
//		int[] mergedarr=new int[end-start];
//		int i=start,j=mid,k=0;
//		while(i<mid && j<end)
//		{ 
//			if(arr[i]<arr[j])
//			{
//				mergedarr[k]=arr[i];
//				i++;k++;
//			}
//			else
//			{
//				mergedarr[k]=arr[j];
//				j++;k++;
//			}
//		}
//			while(i<mid)
//			{
//				mergedarr[k]=arr[i];
//				i++;k++;
//			}
//			while(j<end)
//			{
//				mergedarr[k]=arr[j];
//				k++;j++;
//			}
//		
//		for(int l=0;l<mergedarr.length;l++)
//		{
//			arr[start+l]=mergedarr[l];
//		}
//	}

	public static int[] mergesort(int[] arr)
	{ // DOING MERGE SORT WITHOUT MODIFICATION OF ORIGINAL ARRAY 
		if(arr.length==1)
		{return arr;}
		int mid=arr.length/2;
		int[] left=mergesort(Arrays.copyOfRange(arr, 0, mid));
		int[] right=mergesort(Arrays.copyOfRange(arr, mid, arr.length));
		
		return merger(left,right);
	}

	public static int[] merger(int[] first, int[] second) 
	{  
		int[] mergedarr=new int[first.length+second.length];
		int i=0,j=0,k=0;
		while(i<first.length && j<second.length)
		{
			if(first[i]<second[j])
			{
				mergedarr[k]=first[i];
				i++;k++;
			}
			else
			{
				mergedarr[k]=second[j];
				j++;k++;
			}
		}
			while(i<first.length)
			{
				mergedarr[k]=first[i];
				k++;i++;
			}
			while(j<second.length)
			{
				mergedarr[k]=second[j];
				k++;j++;
			}
		return mergedarr;
	}
}
