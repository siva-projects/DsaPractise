package recursion;

import java.util.ArrayList;

public class Findandarraylistreturn1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,5,1,2,3};
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(findandarraylistreturn1(arr,10,0));
	}
	static ArrayList<Integer> findandarraylistreturn1(int[] arr,int target,int index)
	{  //finding the target in the array and returning them as an arraylist but creating arraylist within the method itself
		ArrayList<Integer> list= new ArrayList<>();
		if(index==arr.length)
			return list;
		if(arr[index]==target)
			list.add(index);
		ArrayList<Integer> ansfrombelowcalls=new ArrayList<>();
		ansfrombelowcalls=findandarraylistreturn1(arr,target,index+1);
		list.addAll(ansfrombelowcalls);
		return list;
	}
}
