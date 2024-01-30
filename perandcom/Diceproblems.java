package perandcom;

import java.util.ArrayList;
import java.util.Arrays;

public class Diceproblems {

	public static void main(String[] args) {
//		System.out.println(diceProblem("",4));
//		System.out.println(diceProblemWithListReturn("",3,3));
//		System.out.println(diceProblemWithListReturn1("",3,3));
		Boolean[][] maze=new Boolean[3][3];
		for(int i=0;i<maze.length;i++)
		{
			for(int j=0;j<maze[i].length;j++)
			{
				maze[i][j]=true;
			}
		}
		maze[1][1]=false;
		System.out.println(diceProblemWithListReturn2("",maze,0,0));

	}
	
	
	//////////////////////  FIRST ONE /////////////////////////////////////
	public static ArrayList<String> diceProblem(String ans,int org)
	{
		  // if face is smtng like 8,or,9 then dicepro(String ans,int org,int face)
				ArrayList<String> list =new ArrayList<>();
				if(org==0)
				{
					list.add(ans);
					return list;
				}
				for(int i=1;i<=6 && i<=org;i++)//for(int i=1;i<=face && i<=org;i++)
				{
					list.addAll(diceProblem(ans+i,org-i));//list.addAll(dicePro(ans+i,org-i,face));
				}
				return list;
				
	
	}
	public static ArrayList<String> diceProblemWithListReturn(String ans,int row,int col)
	{   		// only you can go either RIGHT OR DOWN NOT DIAGONALLY 
		ArrayList<String> answer=new ArrayList<>();
		if(row==1 && col==1)
		{
			answer.add(ans);
			return answer;
		}
		if(col>1)
		{
			answer.addAll(diceProblemWithListReturn(ans+'r',row,col-1));
		}
		if(row>1)
		{
		answer.addAll(diceProblemWithListReturn(ans+'d',row-1,col));
		}
		
		return answer;
		
		 
	}
	public static ArrayList<String> diceProblemWithListReturn1(String ans,int row,int col)
	{   		// only you can go either RIGHT OR DOWN and ALSO DIAGONALLY 
		ArrayList<String> answer=new ArrayList<>();
		if(row==1 && col==1)
		{
			answer.add(ans);
			return answer;
		}
		if(col>1)
		{
			answer.addAll(diceProblemWithListReturn1(ans+'r',row,col-1));
		}
		if(row>1)
		{
		answer.addAll(diceProblemWithListReturn1(ans+'d',row-1,col));
		}
		if(row>1 && col>1)
		{
			answer.addAll(diceProblemWithListReturn1(ans+'D',row-1,col-1));
		}
		
		return answer;
		
		
//////////////////////    SECOND ONE /////////////////////////////////////
		 
	}
	public static ArrayList<String> diceProblemWithListReturn2(String ans,Boolean [][]  maze,int row,int col)
	{   		// only you can go either RIGHT OR DOWN and ALSO DIAGONALLY AND THE
		// CONDITION YOU CAN'T GO THROUGH 1,1 MATRIX 
		ArrayList<String> answer=new ArrayList<>();
		if(maze[row][col]==true)
		{
			if(row==maze.length-1 && col==maze[0].length-1)
			{
				answer.add(ans);
				return answer;
			}
		}
		else
		{
			return answer;
		}
		if(col<maze[0].length-1)
		{
			answer.addAll(diceProblemWithListReturn2(ans+'r',maze,row,col+1));
		}
		if(row<maze.length-1)
		{
		answer.addAll(diceProblemWithListReturn2(ans+'d',maze,row+1,col));
		}
		if(row<maze.length-1 && col<maze[0].length-1)
		{
			answer.addAll(diceProblemWithListReturn2(ans+'D',maze,row+1,col+1));
		}
		
		return answer;
		
		 
	}
	
//////////////////////THIRD ONE /////////////////////////////////////
	
	
	
	public static ArrayList<String> diceProblemWithListReturn3(String ans,int[][] path,Boolean [][]  maze,int row,int col,int level)
	{   		// only you can go either RIGHT OR LEFT OR DOWN OR UP and ALSO DIAGONALLY 
				// THIS INVOLVES USAGE OF BACKTRACKING TO AVOID STACKOVER FLOW...
		ArrayList <String> answer=new ArrayList<>();
		if(maze[row][col]==true)
		{
			if(row==maze.length-1 && col==maze[0].length-1)
			{
				answer.add(ans);
				return answer;
			}
		}
		else
		{
			return answer;
		}
		maze[row][col]=false; // THIS IS STEP 1 FOR BACKTRACKING
		if(row<maze.length-1)
		{
			
			answer.addAll(diceProblemWithListReturn3(ans+"d",path,maze,row+1,col,level+1));

		}
		if(col<maze[0].length-1)
		{
			
			answer.addAll(diceProblemWithListReturn3(ans+"r",path,maze,row,col+1,level+1));
			
		}
		if(row>0)
		{
			
			answer.addAll(diceProblemWithListReturn3(ans+"u",path,maze,row-1,col,level+1));
			
		}
		if(col>0)
		{
			
			answer.addAll(diceProblemWithListReturn3(ans+"l",path,maze,row,col-1,level+1));
			
		}
		if(row<maze.length-1 && col<maze[0].length-1)
		{

			answer.addAll(diceProblemWithListReturn3(ans+"D",path,maze,row+1,col+1,level+1));
		
		}
		maze[row][col]=true; // THIS IS STEP 2 FOR BACKTRACKING.
		return answer;
		}
	
	
////////////////////// FOURTH ONE /////////////////////////////////////
	
	
	public static ArrayList<String> diceProblemWithListReturn4(String ans,int[][] path,Boolean [][]  maze,int row,int col,int level)
	{   		// only you can go either RIGHT OR LEFT OR DOWN OR UP and ALSO DIAGONALLY 
				// THIS INVOLVES USAGE OF BACKTRACKING TO AVOID STACKOVER FLOW...
				// THIS IS TO PRINT THE PATH WE ARE FOLLOWING .....
		ArrayList <String> answer=new ArrayList<>();
		if(maze[row][col]==true)
		{
			if(row==maze.length-1 && col==maze[0].length-1)
			{
				path[row][col]=level;
				answer.add(ans);
				for(int[] arr: path) // USING AN ARRAY CALLED PATH TO PRINT THE PATH
				{
					System.out.println(Arrays.toString(arr));
				}
				System.out.print(ans);
				System.out.println("");
				return answer;
			}
		}
		else
		{
			return answer;
		}
		maze[row][col]=false; // THIS IS STEP 1 FOR BACKTRACKING
		path[row][col]=level;	// MATH THAT ARRAY[ROW][COL]=1 TO SEE THE PATH
		if(row<maze.length-1)
		{
			
			answer.addAll(diceProblemWithListReturn4(ans+"d",path,maze,row+1,col,level+1));

		}
		if(col<maze[0].length-1)
		{
			
			answer.addAll(diceProblemWithListReturn4(ans+"r",path,maze,row,col+1,level+1));
			
		}
		if(row>0)
		{
			
			answer.addAll(diceProblemWithListReturn4(ans+"u",path,maze,row-1,col,level+1));
			
		}
		if(col>0)
		{
			
			answer.addAll(diceProblemWithListReturn4(ans+"l",path,maze,row,col-1,level+1));
			
		}
		if(row<maze.length-1 && col<maze[0].length-1)
		{

			answer.addAll(diceProblemWithListReturn4(ans+"D",path,maze,row+1,col+1,level+1));
		
		}
		maze[row][col]=true; // THIS IS STEP 2 FOR BACKTRACKING.
		path[row][col]=0;	// AGAIN MAKING BACK THE ARRAY AS ORIGINAL AS IT IS...
		return answer;
		}

}
