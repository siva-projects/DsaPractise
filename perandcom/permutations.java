package perandcom;

import java.util.ArrayList;

public class permutations {

	public static void main(String[] args) {
		String str="abcd";
//		permutaWithRec("",str);
		//System.out.println(permutaWithRecWithReturn("",str));
		
		//System.out.println("total permutations possible are "+permutaCount("",str));
	}

	public static void permutaWithRec(String ans,String org)
	{	   // Just printing the answer we got , not storing it anywhere
		if(org.isEmpty())
		{
			System.out.println(ans);
			return ;
		}
		for(int i=0;i<=ans.length();i++)
		{
			char ch=org.charAt(0);
			String f=ans.substring(0,i);
			String l=ans.substring(i,ans.length());
			permutaWithRec(f+ch+l,org.substring(1));
		}
	
}
	
	public static ArrayList<String> permutaWithRecWithReturn(String ans,String org)
	{	
		if(org.isEmpty())
		{
			ArrayList<String> list = new ArrayList<>();
			list.add(ans);
			return list;
		}
		ArrayList<String> anslist=new ArrayList<>();
		for(int i=0;i<=ans.length();i++)
		{
			char ch=org.charAt(0);
			String f=ans.substring(0,i);
			String l=ans.substring(i,ans.length());
			anslist.addAll(permutaWithRecWithReturn(f+ch+l,org.substring(1)));
		}
		return anslist;
	
}
	
	public static int permutaCount(String ans,String org)
	{	
		if(org.isEmpty())
		{return 1;}
		int count=0;
		for(int i=0;i<=ans.length();i++)
		{
			char ch=org.charAt(0);
			String f=ans.substring(0,i);
			String l=ans.substring(i,ans.length());
			count = count + permutaCount(f+ch+l,org.substring(1));
		}
		return count;
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
