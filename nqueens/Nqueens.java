package nqueens;

public class Nqueens {

public static void main(String[] args)
{
	boolean[][] board=new boolean[4][4];
	System.out.println(nqueens(board,0));;
}
public static int nqueens(boolean[][] board,int row)
{
	if(row==board.length)
	{
		display(board);
		return 1;
	}
	int count=0;
	for(int col=0;col<board.length;col++)
	{
		{
			if(isSafe(board,row,col)==true) 
			{
				board[row][col]=true;
				count=count+nqueens(board,row+1);
				board[row][col]=false;
			}
		}
	}
	return count;
}

private static void display(boolean[][] board) {
	
	for(boolean[] a:board)
	{
		for(boolean b:a)
		{
			if(b==true)
				System.out.print("Q ");
			else
			    System.out.print("X ");
		}
		System.out.println("");
	}
	System.out.println(" ");
	
}
public static boolean isSafe(boolean[][] board,int row,int col)
{
	// checking vertically
	for(int i=0;i<row;i++)
	{
		if(board[i][col]==true)
			return false;
	}
	// checking on the left side 
	int maxLeft=Math.min(row, col);
	for(int i=0;i<maxLeft;i++)
	{
		if(board[row-i-1][col-i-1]==true)
			return false;
	}
	//checking on the right side 
	int maxRight=Math.min(row,board.length-col-1);
	for(int i=0;i<maxRight;i++)
	{
		if(board[row-i-1][col+i+1]==true)
			return false;
	}
	return true;
	
	
	
}
}