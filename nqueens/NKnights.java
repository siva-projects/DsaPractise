package nqueens;

import java.util.*;

public class NKnights
{
	public static void main(String[] args)
	{ 
		boolean[][]arr = new boolean[4][4];
		int count = knights(arr,0,0,4);
	System.out.println("final ans: "+count);
	}
	public static int knights(boolean[][] arr,int row,int col,int k)
	{
		int count=0;
		if(k==0)
		{
			display(arr);
			return 1;
		}
		if(row==arr.length-1 && col==arr[row].length)
		{
			return count;
		}
		if(col==arr.length)
		{
			return count+=knights(arr,row+1,0,k);
		}
			if(isValid(arr,row,col)==true)
			{
				arr[row][col]=true;
				count+= knights(arr,row,col+1,k-1);
				arr[row][col]=false;
			}
			count+=knights(arr,row,col+1,k);
				
		
		return count;
		
	}
	public static boolean isValid(boolean[][] arr,int row,int col)
	{ 
		if(isSafe(arr,row-2,col-1))
		{
			if(arr[row-2][col-1]==true)
				return false;
		}
		if(isSafe(arr,row-2,col+1))
		{
			if(arr[row-2][col+1]==true)
				return false;
		}
		if(isSafe(arr,row-1,col-2))
		{
			if(arr[row-1][col-2]==true)
				return false;
		}
		if(isSafe(arr,row-1,col+2))
		{
			if(arr[row-1][col+2]==true)
				return false;
		}
		// no condition is triggered so returning true
		return true;
	}
	
	public static boolean  isSafe(boolean[][] arr,int row,int col)
	{
		if(row>=0 && row<arr.length && col>=0 && col<arr[row].length)
		{
			return true;
		}
		return false;
	}
	public static void display(boolean[][] arr)
	{
		
		for(boolean[] a:arr)
		{
			for(boolean b:a)
			{
				if(b==true)
				{System.out.print("K ");}
			else
				{System.out.print("O ");}
			}
			System.out.println(" ");
				
		}
		System.out.println("");
			
	}
		
	
}