import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class AIPlayer extends Player{

    public static char symbol2;
     public  AIPlayer(char symbol,Board board,String name){
        super(symbol, board, name);
        this.symbol=symbol;
        this.board=board;
        symbol=symbol2;

    }
    
		
    public void makeMove(Board board){
        if (board.isWinningMove(symbol)==true){
            return;
        }
        if(board.isWinningMove(symbol)==true){
            board.Blocker(symbol);
            Random rand = new Random();
            int i=rand.nextInt(7)+1;
            board.inputVal(i, symbol);
        }
        else{
            Random rand = new Random();
            int i=rand.nextInt(7)+1;
            board.inputVal(i, symbol);
        }
		
	
}
}


        
    
    