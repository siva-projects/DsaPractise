package sorting;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Quicksort {
//
//	public static void main(String[] args) {
//		int arr[]= {2,1,3,4,5};
////		quicksort(arr,0,arr.length-1);
////		System.out.println(Arrays.toString(arr));
//	}
//	
//	public static  void quicksort(int arr[],int start, int end) 
//	{
//		if(start>=end)
//		{
//			return ;
//		}
//		int pivot = start+(end-start)/2;
//		int i=start,j=end;
//	
//		while(i<=j)
//		{
//			while(arr[i]<arr[pivot])
//			{
//				i++;
//			}
//			while(arr[j]>arr[pivot])
//			{
//				j--;
//			}
//			if(i<=j)
//			{
//				int temp=arr[i];
//				arr[i]=arr[j];
//				arr[j]=temp;
//				i++;j--;
//			}
//		}
//		quicksort(arr,start,j);
//		quicksort(arr,i,end);
//		}
//
//
//}

import java.util.*;
public class Quicksort
{
	public static void main (String[] args) 
	{
		int arr[] = {60,30,34,56,12,76,89,99,23,10};
		quickSortPractise(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static void quickSort(int[] arr,int l,int h) {
		if(l>=h) {
			return ;
		}
		int pivot = l + (h-l)/2;
		int start = l;int end = h;
		while(start<end) {
			while(arr[start]<arr[pivot]) {
				start++;
			}
			while(arr[end]>arr[pivot]) {
				end--;
			}
			if(start<=end) {
				int temp = arr[start];
				arr[start]=arr[end];
				arr[end]=temp;
				start++;
				end--;
			}
		}
		quickSort(arr,l,end);
		quickSort(arr,start,h);
	}
	
	public static void quickSortPractise(int[] arr, int l, int h) {
		if(l>=h) {
			return ;
		}
		int pivot = l + (h-l)/2;
		
		int start=l,end=h;
		
		while(start<end) {
			while(arr[start]<arr[pivot]) {
				start++;
			}
			while(arr[end]>arr[pivot]) {
				end--;
			}
			if(start<=end) {
				int temp = arr[start];
				arr[start]=arr[end];
				arr[end]=temp;
				start++;
				end--;
			}
		}
		
		quickSortPractise(arr,l,end);
		quickSortPractise(arr,start,h);
	}
}