package recursion;

import java.util.ArrayList;

public class Findandarraylistreturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,5,1,2,3};
		ArrayList<Integer> list = new ArrayList<>();
		//System.out.println(findandarraylistreturn(arr,10,list,0));
	}
	static ArrayList<Integer> findandarraylistreturn(int[] arr,int target,ArrayList<Integer> list,int index)
	{    // finding the target in the array and returning them as an arraylist
		if(index==arr.length)
		{return list;}
		if(arr[index]==target)
		{
			list.add(index);
		}
			return findandarraylistreturn(arr,target,list,index+1);
	}
}
