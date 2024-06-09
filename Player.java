import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;



public abstract class Player {
	
	protected char symbol;
	protected Board board;
	protected String name;
	public static int input2;


	
	public Player(char symbol, Board board, String name) {
		this.symbol = symbol;
		this.board = board;
		this.name = name;
		//symbol2=symbol;
	}
	
	public String getName() {
		return name;
	}
	//public static char getChar(){
		
	//}
	
    /*public void makeMove(Board board){
		boolean isValid=true;
        while(isValid==true){
            Scanner input = new Scanner(System.in);
            System.out.printf("%s, %c Enter an input :",this.name,symbol2);
            input2 = input.nextInt();
        if (this.board.ColumnCheck(input2)==true){
			board.inputVal(input2,symbol2);
            isValid=false;
        }
        else{
            System.out.println("Column is full,try another input for a different column");
        }
	}*/
	public abstract void makeMove(Board board);

}
