import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class HumanPlayer extends Player{
    //public static int input2;
    //private boolean isValid= true;
    //private static char symbol;
    //private Board board;
    //private static String name;
    public static char symbol2;
     public  HumanPlayer(char symbol,Board board,String name){
        super(symbol, board, name);
        this.symbol=symbol;
        symbol=symbol2;

    }
    /*public void makeMove(Board board){
        /*while(isValid==true){
            Scanner input = new Scanner(System.in);
            System.out.printf("%s,Enter an input :",this.name);
            input2 = input.nextInt();
        if (this.board.ColumnCheck(input2)==true){
            isValid=false;
        }
        else{
            System.out.println("Column is full,try another input for a different column");
        }

        }*/
        //super.makeMove(board); 

    //}
    public void makeMove(Board board){
		boolean isValid=true;
        while(isValid==true){
            Scanner input = new Scanner(System.in);
            System.out.printf("%s, %c Enter an input :",name,symbol);
            input2 = input.nextInt();
        if (this.board.ColumnCheck(input2)==true){
			board.inputVal(input2,symbol);
            isValid=false;
        }
        else{
            System.out.println("Column is full,try another input for a different column");
        }
	}
}
    public static void main(String[] args) {
        Board board = new Board();
        ConnectFour game = new ConnectFour(board);
        game.setPlayer1(new HumanPlayer('R', board, "Alice"));
        game.setPlayer2(new HumanPlayer('B', board, "Bob"));
        //setPlayer1.makeMove(board);


        }
    
    /*@Override
    public void makeMove(Board board) {
        // TODO Auto-generated method stub
        
    }*/
}

