import java.nio.InvalidMarkException;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ConnectFour {

	public static Player player1;
	public static Player player2;
	public static boolean isP1Turn; //true iff it is player one's turn to play.
	private Board board;
	
	public ConnectFour(Board board) {
		this.board = board;
		isP1Turn = true;
	}
	
	public void setPlayer1(Player player1) {
		this.player1 = player1; 
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2; 
	}
	/*public static char charPlayer1(){
		return player1.getChar();
	}
	public static char charPlayer2(){
		return player2.getChar();
	}*/
	
	public void playGame(){
		board.reset();
		board.printBoard();
		while(!gameIsOver()) {
			System.out.println("It is " + getCurrentPlayer().getName() + "'s turn.");
			getCurrentPlayer().makeMove(board);
			board.printBoard();
			changeTurns();
		}
		if(board.containsWin()) { 
			changeTurns();
			System.out.println("Congratulations " + getCurrentPlayer().getName() + ", you have won!");
		}
		else {
			System.out.println("The game is a tie. You both lose.");
		}
	}
	
	private boolean gameIsOver() {
		return board.containsWin() || board.isTie();
	}
	
	private static Player getCurrentPlayer() {
		if(isP1Turn) {
			return player1;
		}
		return player2;
	}
	
	private void changeTurns() {
		isP1Turn = !isP1Turn;
	}
	/*public static void main(String[] args) {
		int ilm=0;
		Board board = new Board();
        ConnectFour game = new ConnectFour(board);
		game.setPlayer2(new HumanPlayer('B', board, "Bob"));
        game.setPlayer1(new HumanPlayer('R', board, "Alice"));
		board.reset();
		while(ilm<=20){
			System.out.println("It is " + getCurrentPlayer().getName() + "'s turn.");
			getCurrentPlayer().makeMove(board);
			board.printBoard();
			board.containsWin();
			//System.out.println(board.containsWin());
			changeTurns();
			ilm++;
		}

		}*/
	}
