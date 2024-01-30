package perandcom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		String str="abc";
		//subset(str,"");
		//subsetascii(str,"");
		//System.out.println(subsetreturn(str, ""));
		//System.out.println(subsetasciireturn(str,""));
		int[] arr= {1,2,3};
		//{
		//List<List<Integer>> ans = subsetloop(arr);
		List<List<Integer>> ans = subsetloopwithdup(arr);
		for(List<Integer> list : ans)
		{
			System.out.println(list);
		}
//		//}
	
	}
	public static void subset(String org,String ans)
	{				// Just printing the ans here :)
		 
		if(org.isEmpty())
			{
			System.out.println(ans);
			return ;
			}
		char c = org.charAt(0);
		subset(org.substring(1),ans+c);
		subset(org.substring(1),ans);
	}
	
	public static ArrayList<String> subsetreturn(String org,String ans)
	{					// Storing the ans in the arraylist and then returning :)
		 ArrayList<String> list=new ArrayList<>();
		 ArrayList<String> ansfrombelow=new ArrayList<>();
		if(org.isEmpty())
			{
			list.add(ans);
			 return list;
			}
		char c = org.charAt(0);
		ansfrombelow=subsetreturn(org.substring(1),ans+c);
		list.addAll(ansfrombelow);
		ansfrombelow=subsetreturn(org.substring(1),ans);
		list.addAll(ansfrombelow);
		
		return list;
	}
	
	public static void subsetascii(String org,String ans)
	{				// Just printing the ans here as ASCII NUMBERS :)
		 
		if(org.isEmpty())
			{
			System.out.println(ans);
			return ;
			}
		char c = org.charAt(0);
		subsetascii(org.substring(1),ans+c);
		subsetascii(org.substring(1),ans);
		subsetascii(org.substring(1),ans+(c+0));
	}
	
	public static ArrayList<String> subsetasciireturn(String org,String ans)
	{					// Storing the ans in the arraylist and then returning :)
		 ArrayList<String> list=new ArrayList<>();
		 ArrayList<String> ansfrombelow=new ArrayList<>();
		if(org.isEmpty())
			{
			list.add(ans);
			 return list;
			}
		char c = org.charAt(0);
		ansfrombelow=subsetasciireturn(org.substring(1),ans+c);
		list.addAll(ansfrombelow);
		ansfrombelow=subsetasciireturn(org.substring(1),ans);
		list.addAll(ansfrombelow);
		ansfrombelow=subsetasciireturn(org.substring(1),ans+(c+0));
		list.addAll(ansfrombelow);
		
		return list;
	}
	
	public static List<List<Integer>>subsetloop(int[] arr)
	{
		List<List<Integer>> outerlist=new ArrayList<>();
			
			outerlist.add(new ArrayList<>());
			
			for(int num: arr)
			{
				int n=outerlist.size();
				for( int i=0;i<n;i++)
				{
					List<Integer> innerlist = new ArrayList<>(outerlist.get(i));
					innerlist.add(num);
					outerlist.add(innerlist);
				}
			}
			return outerlist;
		}
	
	public static List<List<Integer>>subsetloopwithdup(int[] arr)
	{
		Arrays.sort(arr);
		List<List<Integer>> outerlist=new ArrayList<>();
			
			outerlist.add(new ArrayList<>());
			int start=0;
			int end=0;
			for(int i=0;i<arr.length;i++)
			{
				start = 0;
				// if current and previous elements are same , s = e+1;
				if(i>0 && arr[i]==arr[i-1])
				{
					start = end + 1;
				}
				end = outerlist.size() - 1;
				int n = outerlist.size();
				for(int j=start;j<n;j++)
				{
					List<Integer> internal=new ArrayList<>(outerlist.get(j));
					internal.add(arr[i]);
					outerlist.add(internal);
				}
			}
			return outerlist; 
		}
	
	

}

