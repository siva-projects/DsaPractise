package sorting;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;

public class practise{
	public static void main(String[] args) {
		
		int[] arr= {50,40,30,20,10}; // 10,20,30
//		quickSort(arr,0,arr.length-1);
//		mergeSortPractise(arr,0,arr.length-1);
//		test();
		printTriangle(5);
		
//		for(int i=0;i<5;i++) {
//			
//			for(int j=i;j<5;j++) 
//			{
//				if(i==0) {
//					break;
//				}
//			}
//			System.out.println("executing  the outer loop");
//		}
		
//		System.out.println(Arrays.toString(arr));
		
	}
	public static void mergeSort(int[] arr,int start,int end) {  //{50,40,30,20,10};
		if(start>=end) {										 //  s     m     e
			return ;
		}
		int mid = start+(end-start)/2;
		
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		
		merger(arr,start,mid,end);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void merger(int[] arr,int start,int mid,int end) {
		int i=start;int j=mid+1;int k=0;
		int[] newArr = new int[end-start+1];
		while(i<=mid && j<=end) {
			if(arr[i]<arr[j]) {
				newArr[k]=arr[i];
				k++;i++;
			}else {
				newArr[k]=arr[j];
				k++;j++;
			}
		}
		while(i<=mid) {
			newArr[k]=arr[i];
			k++;i++;
		}
		while(j<=end) {
			newArr[k]=arr[j];
			k++;j++;
		}
		for(int l=0;l<newArr.length;l++) {
			arr[start+l]=newArr[l];
		}
	}
//	public static  void quickSort(int[] arr, int l, int h) 
//	{
//		if(l>=h) {
//			return ;
//		}
//		int pivot = l+(h-l)/2;
//		int start=l;
//		int end=h;
//	
//		while(start<end)
//		{	
//			while(arr[start]<arr[pivot]) {
//				start++;
//			}
//			while(arr[end]>arr[pivot]) {
//				end--;
//			}
//			if(start<=end) {
//				int temp =arr[start];
//				arr[start]=arr[end];
//				arr[end]=temp;
//				start++;end--;
//			}
//		}
//		
//		quickSort(arr,l,end);
//		quickSort(arr,start,h);
//		
//	}
	
	public static void mergeSortPractise(int[] arr, int start, int end) {  //50,40,30,20,10
		
		if(start>=end) {
			return ;
		}
		
		int mid = start+(end-start)/2;
		mergeSortPractise(arr, start, mid);
		mergeSortPractise(arr,mid+1,end);
		
		mergerPractise(arr,start,mid,end);
		
		System.out.println(Arrays.toString(arr));
	}
	public static void mergerPractise(int[] arr, int start, int mid, int end) {
		int[] newarr=new int[end-start+1];
		int i=start;int j=mid+1;int k=0;
		while(i<=mid && j<=end) {
			if(arr[i]<arr[j]) {
				newarr[k]=arr[i];
				i++;k++;
			}else {
				newarr[k]=arr[j];
				j++;k++;
			}
		}
		while(i<=mid) {
			newarr[k]=arr[i];
			i++;k++;
		}
		while(j<=end) {
			newarr[k]=arr[j];
			j++;k++;
		}
		for(int l=0;l<newarr.length;l++) {
			arr[start+l]=newarr[l];
		}
	}
	public static void test() {
		System.out.println("Enter the number ra");
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong();
		while(n!=1) {
			if(n%2==1){
				 n = (n * 3)+1;
				System.out.println(n);
				}
			else
				{
				n = n/2;
				System.out.println(n);
				}
		}
		
	}
	
	 public static void printDiamond(int n) {
	        // Your code here
	        for(int i=1;i<=n;i++){
	            for(int j=0;j<(n-i);j++){
	                System.out.print(" ");
	            }
	            for(int j=0;j<(i+(i-1));j++){
	                if(j%2==0){
	                System.out.print("*");    
	                }else{
	                    System.out.print(" ");
	                }
	            }
	            System.out.println("");
	        }
	        System.out.println("");
	        for(int i=n;i>0;i--){
	            for(int j=0;j<(n-i);j++){
	                System.out.print(" ");
	            }
	            for(int j=0;j<(i+(i-1));j++){
	                if(j%2==0){
	                    System.out.print("*");
	                }else{
	                    System.out.print(" ");
	                }
	            }
	            System.out.println("");
	        }
	    }
	 
	public static     void printTriangle(int n) {
	        // code here
	        for(int i=1;i<=n;i++){
	            for(int j=1;j<=i;j++){
	                System.out.print(j+" ");
	            }
	            for(int j=0;j<((n-i)*4);j++){
	                System.out.print(" ");
	            }
	            
	            for(int j=n-(n-i);j>0;j--){
	                System.out.print(j+" ");
	            }
	            System.out.println("");
	        }
	    }
}
