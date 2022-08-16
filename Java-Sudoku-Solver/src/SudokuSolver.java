/*
 Author: Ryan Woodward
 Date: 8-15-2022
 Program: Java Program that solves sudoku puzzles
 */



public class SudokuSolver {
	
	//------------------------------
	// Fields
	//------------------------------
	private static final int GRID_SIZE = 9;
	
	//------------------------------
	// Methods
	//------------------------------
	
	public static void main(String[] args) {
		
		int [][] board = {
				{7, 0, 2, 0, 5, 0, 6, 0, 0},
				{0, 0, 0, 0, 0, 3, 0, 0, 0},
				{1, 0, 0, 0, 0, 9, 5, 0, 0},
				{8, 0, 0, 0, 0, 0, 0, 9, 0},
				{0, 4, 3, 0, 0, 0, 7, 5, 0},
				{0, 9, 0, 0, 0, 0, 0, 0, 8},
				{0, 0, 9, 7, 0, 0, 0, 0, 5},
				{0, 0, 0, 2, 0, 0, 0, 0, 0},
				{0, 0, 7, 0, 4, 0, 2, 0, 3}
		};
		
		printBoard(board);
		
		if(solveBoard(board)) {
			System.out.println("\nSolved successfully!\n");
		}else {
			System.out.println("Unsolvable Board!");
		}
		
		printBoard(board);
		
	}//main()
	
	/**
	 * 
	 * @param board
	 * @param number
	 * @param row
	 * @return
	 */
	private static boolean isNumberInRow(int[][] board, int number, int row) {
		
		for(int idx = 0; idx < GRID_SIZE; idx++) {
		
			if(board[row][idx]==number) {
				return true;
			}
		}
		return false;
	}// isNumberInRow()
	
	/**
	 * 
	 * @param board
	 * @param number
	 * @param column
	 * @return
	 */
	private static boolean isNumberInColumn(int[][] board, int number, int column) {
		
		for(int idx = 0; idx < GRID_SIZE; idx++) {
			
			if(board[idx][column]==number) {
				return true;
			}
		}
		return false;
	}// isNumberInRow()
	
	/**
	 * 
	 * @param board
	 * @param number
	 * @param row
	 * @param column
	 * @return
	 */
	private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
		
		int localBoxRow = row - row %3;
		int localBoxCol = column - column %3;
		
		for(int idx = localBoxRow; idx < localBoxRow + 3; idx++) {
			
			for(int jdx = localBoxCol; jdx < localBoxCol + 3; jdx++) {
				
				if(board[idx][jdx] == number) {
					return true;
				}
			}
		}
		return false;
	}// isNumberInBox()
	
	/**
	 * 
	 * @param board
	 * @param number
	 * @param row
	 * @param column
	 * @return
	 */
	private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
		
		return !isNumberInRow(board, number, row) && 
				!isNumberInColumn(board, number, column) && 
				! isNumberInBox(board, number, row, column);
	}// isValidPlacement()
	
	/**
	 * 
	 * @param board
	 * @return true/false
	 */
	private static boolean solveBoard(int[][] board) {
		
		for(int row = 0; row < GRID_SIZE; row++) {
			for(int col = 0; col < GRID_SIZE; col++) {
				if(board[row][col] == 0) {
					for(int numToTry = 1; numToTry <= GRID_SIZE; numToTry++) {
						if(isValidPlacement(board, numToTry, row, col)) {
							board[row][col] = numToTry;
							
							if(solveBoard(board)) {
								return true;
							}else {
								board[row][col] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}// solveBoard()
	
	/**
	 * 
	 * @param board
	 */
	private static void printBoard(int[][] board) {
		for(int row = 0; row < GRID_SIZE; row++) {
			if(row %3 == 0 && row !=0) {
				System.out.println("---------");
			}
			
			for(int column = 0; column < GRID_SIZE; column++) {
				
				if(column%3 == 0 && column !=0) {
					System.out.print("|");
				}
				System.out.print(board[row][column]);
			}
			System.out.println();
		}
	}

}//SudokuSolver Class























