package week06;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		//array with current values of 9 squares (using values as labels initially)
		String[] currentBoard = {"1","2","3","4","5","6","7","8","9"};
		
		//array to keep track of which squares have been used
		boolean[] used = new boolean[9];

		//WELCOME MESSAGE
		System.out.println("Hello, and welcome to Tic Tac Toe!");
		System.out.println("On your turn, please enter the square 1-9 where you want to put your mark.");
		System.out.println("Player X goes first!");
		int i = 1;
		
		//calls turn method up to 9 times; if no winner, game is declared a tie
		for (int index = 0; index < 10; index++) {
			if (index == 9) {
				System.out.println("Cat's game! Try again!");
				System.exit(0);
			} else {
				i = turn(i, currentBoard, used);
			}
		}
		
	}
	
	//Displays board with current choices
	public static void displayBoard(String[] currentBoard) {
		System.out.println("T I C  T A C  T O E");
		System.out.println("-------------------");
		System.out.println("|     |     |     |");
		System.out.println("|  " + currentBoard[0] + "  |  " + currentBoard[1] + "  |  " + currentBoard[2] + "  |");
		System.out.println("|     |     |     |");
		System.out.println("-------------------");
		System.out.println("|     |     |     |");
		System.out.println("|  " + currentBoard[3] + "  |  " + currentBoard[4] + "  |  " + currentBoard[5] + "  |");
		System.out.println("|     |     |     |");
		System.out.println("-------------------");
		System.out.println("|     |     |     |");
		System.out.println("|  " + currentBoard[6] + "  |  " + currentBoard[7] + "  |  " + currentBoard[8] + "  |");
		System.out.println("|     |     |     |");
		System.out.println("-------------------");

	}
	
	//turn method--uses counter int to determine whose turn it us
	public static int turn(int i, String[] currentBoard, boolean[] used) {
		
		//figure out whose turn it is
		if(i % 2 != 0) {
			//Show updated game board
			displayBoard(currentBoard);
			
			//prompt user input
			System.out.println("Player X, please choose where to put your mark.");

			//make sure target hasn't been taken yet
			boolean flag = true;
			while (flag) {
				//take input for location of next mark
				
				Scanner sc = new Scanner(System.in);
				int target = sc.nextInt();
			
				if (target < 1 || target > 9){
					System.out.println("Pick a number from 1-9, you goose.");
				} else if (used[target-1] == true) {
					System.out.println("This square has already been used. Please try again.");
				} else {
					currentBoard[target-1] = "X";
					used[target-1] = true;
					flag = false;
				}
			}
			
			//run check to see if mark creates winning line
			if (isWinner(currentBoard) == true) {
				displayBoard(currentBoard);
				System.out.println("X wins!!");
				System.exit(0);
			} else {
				i += 1;
			}
		} else {
			
			//O's turn, same as above
			//If I had used an interface and some abstract classes, I wouldn't have had to
			//repeat this code.
			displayBoard(currentBoard);
			
			System.out.println("Player O, please choose where to put your mark.");

			boolean flag = true;
			while (flag) {
				//take input for location of next mark
				
				Scanner sc = new Scanner(System.in);
				int target = sc.nextInt();
			
				if (target < 1 || target > 9){
					System.out.println("Pick a number from 1-9, you goose.");
				} else if (used[target-1] == true) {
					System.out.println("This square has already been used. Please try again.");
				} else {
					currentBoard[target-1] = "O";
					used[target-1] = true;
					flag = false;
				}
			}
			
			if (isWinner(currentBoard) == true) {
				displayBoard(currentBoard);
				System.out.println("O wins!!");
				System.exit(0);
			} else {
				i += 1;
			}
		}
		return i;
	}
	
	//Was originally going to be a method to clear console screen, but it doesn't work...
	//public static void clearScreen() {
	//	System.out.print("\033[H\033[2J");
	//	System.out.flush();
	//}
	
	//rather inelegant, but looks at all 8 win scenarios to see if either player meets them
	public static boolean isWinner(String[] currentBoard) {
		//across wins
		if ( currentBoard[0] == currentBoard[1] && currentBoard[0] == currentBoard[2]) {
			return true;
		} else if (currentBoard[3] == currentBoard[4] && currentBoard[3] == currentBoard[5]) {
			return true;
		} else if (currentBoard[6] == currentBoard[7] && currentBoard[6] == currentBoard[8]) {
			return true;
			
		//up/down wins	
		} else if (currentBoard[0] == currentBoard[3] && currentBoard[0] == currentBoard[6]) {
			return true;
		} else if (currentBoard[1] == currentBoard[4] && currentBoard[1] == currentBoard[7]) {
			return true;
		} else if (currentBoard[2] == currentBoard[5] && currentBoard[2] == currentBoard[8]) {
			return true;
			
		//diagonal wins	
		} else if (currentBoard[0] == currentBoard[4] && currentBoard[0] == currentBoard[8]) {
			return true;
		} else if (currentBoard[2] == currentBoard[4] && currentBoard[2] == currentBoard[6]) {
			return true;
			
		//if no win conditions met, game continues
		} else {
			return false;
		}
	}
}
