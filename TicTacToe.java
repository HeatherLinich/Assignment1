/*
Name: Heather Linich
File: TicTacToe.java
Desc: This program creates a tic tac toe game for the user
*/

import java.util.Scanner;

public class TicTacToe
{
   public static void main(String[] args)
   {
    
	Scanner input = new Scanner(System.in);

	 char guess = ' ';
		
	 char[][] fullBoard = new char[3][3];
		 
	 while(hasWon(fullBoard, guess) == false && boardFull(fullBoard) == false)
	  {
		System.out.print("Player X (press 1) or Player O (press 2)?");
	    int player = input.nextInt();
						
		 if(player == 1)
		 guess = 'X';
   		 else if(player == 2)
		 guess = 'O';

		 makeAMove(fullBoard,guess);
 	  }
		
	}
	
	public static void displayBoard( char[][] board)
	{
	  System.out.print(board[0][0] + "|" + board [0][1] + "|" + board[0][2] + "\n");
	  System.out.println("--------");
	  System.out.print(board[1][0] + "|" + board [1][1] + "|" + board[1][2] + "\n");	  
	  System.out.println("--------");
	  System.out.print(board[2][0] + "|" + board [2][1] + "|" + board[2][2] + "\n");
	  	  	
	}	//end displayBoard	
	
	public static void makeAMove(char[][] board, char Guess)
	{
	  Scanner input = new Scanner(System.in);
		 	 
	 if(Guess == 'X')
	 {
	 System.out.print("Player X - Enter a row number, 0,1,2 : ");
	 int Row = input.nextInt();
	 
	 System.out.print("Player X - Enter a column number, 0,1,2 : ");
	 int Col = input.nextInt();
		if(board[Row][Col] == 'X' || board[Row][Col] == 'O')  //remove
			{  
				System.out.println("\n**Space already taken, please choose again.**\n");
			}
		else
			{  //remove
				board[Row][Col] = 'X';
	 
				displayBoard(board);
			}
	 }
	 else if(Guess == 'O')
	 {
	 System.out.print("Player O - Enter a row number, 0,1,2 : ");
	 int Row = input.nextInt();
	 
	 System.out.print("Player O - Enter a column number, 0,1,2 : ");
	 int Col = input.nextInt();
		 if(board[Row][Col] == 'X' || board[Row][Col] == 'O')
		 {
			System.out.println("\n**Space already taken, please choose again.**\n");
		}
		 else
		 {	 
			board[Row][Col] = 'O';
	
			displayBoard(board);
		 }
	}	
		 
	} //end of makeAMove
	
	public static boolean hasWon(char[][]board, char Guess)
	{
	  if((board[0][0] == Guess && board[0][1] == Guess && board[0][2] == Guess) ||
	  (board[1][0] == Guess && board[1][1] == Guess && board[1][2] == Guess) ||
	  (board[2][0] == Guess && board[2][1] == Guess && board[2][2] == Guess) ||
	  (board[0][0] == Guess && board[1][0] == Guess && board[2][0] == Guess) ||
	  (board[0][1] == Guess && board[1][1] == Guess && board[2][2] == Guess) ||
	  (board[0][2] == Guess && board[1][2] == Guess && board[2][2] == Guess) ||
	  (board[0][0] == Guess && board[1][1] == Guess && board[2][2] == Guess) ||
	  (board[2][0] == Guess && board[1][1] == Guess && board[0][2] == Guess))
		{
	     System.out.println("\n" + Guess + " is the winner!");
		 System.exit(0);  
		   return true;
		}
		else
		 return false;
	}
	  
	public static boolean boardFull(char[][]board)
	{
	  int full = 0;
	  
	  for(int i = 0; i<board.length; i++)
			for(int j = 0; j<board.length; j++)
				{
					if(board[i][j] == 'X' || board[i][j] == 'O')
					full++;
				}
		
	  if(full<9)
		return false;
		else
		 {
		   System.out.println("\nBoard full. No more moves.");
		   System.exit(0);
		   return true;
		 }
	}
	
}	//end of class