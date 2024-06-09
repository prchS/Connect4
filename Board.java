import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.InflaterOutputStream;

import javax.print.attribute.standard.NumberUpSupported;
import javax.swing.InputVerifier;


public class Board {
	private static final String P = null;
	public static ArrayList[][] table = new ArrayList[6][7];
	public static int in=0; 
	
	
	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;





	
	
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 * You may add private and public methods if you wish. In fact, to achieve
	 * what the assignment is asking, you'll have to
	 * 
	 */
	public static void initialize(){
		for (int l1 = 0; l1 <table.length; l1++) {
            for (int c1 = 0; c1 < table[l1].length; c1++) {
                table[l1][c1]= new ArrayList();
			}
		}
	}
	
	public static void Board() {
		initialize();
	}
	
	public static void printBoard() {
		/*while(in<=1){
			Board();
			in++;
		} */

		for (int row = 0; row <table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                System.out.printf(table[row][col] + "  |  ");
            }
            System.out.println();
			System.out.println("--------------------------------------");
		}


	
}
	public boolean ColumnCheck(int x1) {
		boolean tempColCheck=false;
		for(int row1=5;row1>=0;row1--){
			if(table[row1][x1-1].size()==0){
				tempColCheck=true;
				
			
			}
		
		else{
			tempColCheck= false;
		}	
	}
	return tempColCheck;
	}
	
	public boolean containsWin() { 
		//char tempSymbol=ConnectFour.player2.symbol2;
		/*ArrayList<Character> temp = new ArrayList<Character>(1);

		if(ConnectFour.isP1Turn==true){
			temp.add(0,'R'); // temp[0]="R"

		} 
		else if (ConnectFour.isP1Turn==false){
			temp.add(0,'B');//temp[0]="B"
		}*/
		
		boolean tempwin=false;
		//horizontal locations for win
		for (int c=0;c<(NUM_OF_COLUMNS-3);c++){
			for(int r=0;r<(NUM_OF_ROW);r++){
				if ((table[r][c].size()==1 && table[r][c+1].size()==1 && table[r][c+2].size() == 1 && table[r][c+3].size() == 1)){
					if (table[r][c].get(0) != null && table[r][c].get(0)==table[r][c+1].get(0) && table[r][c+1].get(0)==table[r][c+2].get(0) && table[r][c+2].get(0)==table[r][c+3].get(0)){
						tempwin=true;
					}
				}
 
			}
		}
 
    //Check vertical locations for win
    for (int c1=0;c1<(NUM_OF_COLUMNS);c1++){
				for(int r1=0;r1<(NUM_OF_ROW)-3;r1++){
					if(table[r1][c1].size()==1 && table[r1+1][c1].size()==1 && table[r1+2][c1].size() == 1 && table[r1+3][c1].size() == 1) {
						if (table[r1][c1].get(0) != null &&
						 table[r1][c1].get(0)==table[r1+1][c1].get(0) && 
						table[r1+1][c1].get(0)==table[r1+2][c1].get(0) && 
						table[r1+2][c1].get(0)==table[r1+3][c1].get(0)){
							tempwin= true;
						}
					}
	}
}
    //Check positively sloped diaganols
    for (int c2=0;c2<(NUM_OF_COLUMNS)-3;c2++){
				for(int r2=0;r2<(NUM_OF_ROW)-3;r2++){
					if(table[r2][c2].size()==1 && table[r2+1][c2+1].size()==1 && table[r2+2][c2+2].size() == 1 && table[r2+3][c2+3].size() == 1) {
					if (table[r2][c2].get(0) != null &&
					table[r2][c2].get(0)==table[r2+1][c2+1].get(0) && 
					table[r2+1][c2+1].get(0)==table[r2+2][c2+2].get(0)&&
					table[r2+1][c2+1].get(0)==table[r2+3][c2+3].get(0)){
						tempwin=true;
					}
				}
			}
			}
 
    // Check negatively sloped diaganols
    for (int c3=0;c3<(NUM_OF_COLUMNS)-3 ;c3++){
        for(int r3=3;r3<NUM_OF_ROW;r3++){
			if(table[r3][c3].size()==1 && table[r3-1][c3+1].size()==1 && table[r3-2][c3+2].size() == 1 && table[r3-3][c3+3].size() == 1) {
				if (table[r3][c3].get(0)!= null &&
				table[r3][c3].get(0)==table[r3-1][c3+1].get(0) &&
				table[r3-1][c3+1].get(0)==table[r3-2][c3+2].get(0) && 
				table[r3-2][c3+2].get(0) ==  table[r3-3][c3+3].get(0)){
					tempwin = true;
				}
			}
	}
}
return tempwin;
	}
	
	public boolean isTie(){
		boolean tieval=false;
				//System.out.println(table[cl1][cl2]);
		if (table[0][0].size()==1 && table[0][1].size()==1&&table[0][2].size()==1&&table[0][3].size()==1 &&table[0][4].size()==1&&table[0][5].size()==1&&table[0][6].size()==1 &&
			table[1][0].size()==1 && table[1][1].size()==1&&table[1][2].size()==1&&table[1][3].size()==1 &&table[1][4].size()==1&&table[1][5].size()==1&&table[1][6].size()==1 &&
			table[2][0].size()==1 && table[2][1].size()==1&&table[2][2].size()==1&&table[2][3].size()==1 &&table[2][4].size()==1&&table[2][5].size()==1&&table[2][6].size()==1 &&
			table[3][0].size()==1 && table[3][1].size()==1&&table[3][2].size()==1&&table[3][3].size()==1 &&table[3][4].size()==1&&table[3][5].size()==1&&table[3][6].size()==1 &&
			table[4][0].size()==1 && table[4][1].size()==1&&table[4][2].size()==1&&table[4][3].size()==1 &&table[4][4].size()==1&&table[4][5].size()==1&&table[4][6].size()==1 &&
			table[5][0].size()==1 && table[5][1].size()==1&&table[5][2].size()==1&&table[5][3].size()==1 &&table[5][4].size()==1&&table[5][5].size()==1&&table[5][6].size()==1 
		){
				tieval=true;
			}
			else{
				tieval=false;
			}

	return tieval;
}
	
	public void reset() {
		initialize();
	}
	public void inputVal(int val,char symbol){
		for(int row1=5;row1>=0;row1--){
			if(table[row1][val-1].size()==0){
				table[row1][val-1].add(symbol);
				return;
			}

		}
	}
	public boolean isWinningMove(char symbol){
		boolean tempVal=false;
		for( int col=1;col<8;col++){ //col = 1
			inputVal(col,symbol); // 1 , sym
			if(containsWin()==true){
				return true;
			}
			else{
				for(int row=0; row<=5;row++){//row =0
					if (table[row][col-1].size()==1){ // table[0][0].size() == 1
						table[row][col-1].remove(0);
						break;
			
			}
				}
				

			}
		
		}
		return false;
	}
	public boolean Blocker(char symbol){
		//check for horizontal wins
		boolean tempVal;
		for (int c=0;c<(NUM_OF_COLUMNS-3);c++){
			for(int r=0;r<(NUM_OF_ROW);r++){
				if ((table[r][c].size()==0 && table[r][c+1].size()==1 && table[r][c+2].size() == 1 && table[r][c+3].size() == 1)){
					if( table[r][c+1]==table[r][c+2] && table[r][c+2] == table[r][c+3]){
						inputVal(c,symbol);
						return true;
					}
				}
				else if ((table[r][c].size()==1 && table[r][c+1].size()==0 && table[r][c+2].size() == 1 && table[r][c+3].size() == 1)){
					if( table[r][c]==table[r][c+2] && table[r][c+2] == table[r][c+3]){
						inputVal(c+1,symbol);
						return true;

					}

				}
				else if ((table[r][c].size()==1 && table[r][c+1].size()==1 && table[r][c+2].size() == 0 && table[r][c+3].size() == 1)){
					if( table[r][c]==table[r][c+1] && table[r][c+2] == table[r][c+3]){
						inputVal(c+2,symbol);
						return true;


					}

				}
				else if((table[r][c].size()==1 && table[r][c+1].size()==1 && table[r][c+2].size() == 1 && table[r][c+3].size() == 0)){
					if( table[r][c]==table[r][c+1] && table[r][c+1] == table[r][c+2]){
						inputVal(c+3, symbol);
						return true;

					}

				}
			}
			
		}
		//vertical check
		for (int c=0;c<(NUM_OF_COLUMNS);c++){
			for(int r=0;r<(NUM_OF_ROW-3);r++){
				if ((table[r][c].size()==0 && table[r+1][c].size()==1 && table[r+2][c].size() == 1 && table[r+3][c].size() == 1)){
					if( table[r+1][c]==table[r+2][c] && table[r+2][c] == table[r+3][c]){
						inputVal(c,symbol);
						return true;
					}
				}

				}
				
			}
		// upper diagonal
		for (int c=0;c<(NUM_OF_COLUMNS-3);c++){
			for(int r=3;r<(NUM_OF_ROW);r++){
				if ((table[r][c].size()==0 && table[r-1][c+1].size()==1 && table[r-2][c+2].size() == 1 && table[r-3][c+3].size() == 1)){
					if( table[r-1][c+1]==table[r-2][c+2] && table[r-2][c+2] == table[r-3][c+3]){
						inputVal(c,symbol);
						return true;
					}
				}
				else if ((table[r][c].size()==1 && table[r-1][c+1].size()==0 && table[r-2][c+2].size() == 1 && table[r-3][c+3].size() == 1)){
					if( table[r][c]==table[r-2][c+2] && table[r-2][c+2] == table[r-3][c+3]){
						inputVal(c+1,symbol);
						return true;

					}

				}
				else if ((table[r][c].size()==1 && table[r-1][c+1].size()==1 && table[r-2][c+2].size() == 0 && table[r-3][c+3].size() == 1)){
					if( table[r][c]==table[r][c+1] && table[r][c+2] == table[r][c+3]){
						inputVal(c+2,symbol);
						return true;


					}

				}
				else if((table[r][c].size()==1 && table[r-1][c+1].size()==1 && table[r-2][c+2].size() == 1 && table[r-3][c+3].size() == 0)){
					if( table[r][c]==table[r][c+1] && table[r][c+1] == table[r][c+2]){
						inputVal(c+3, symbol);
						return true;

					}

				}
			}
		}
		for (int c=0;c<(NUM_OF_COLUMNS-3);c++){
			for(int r=0;r<(NUM_OF_ROW)-3;r++){
				if ((table[r][c].size()==0 && table[r+1][c+1].size()==1 && table[r+2][c+2].size() == 1 && table[r+3][c+3].size() == 1)){
					if( table[r+1][c+1]==table[r+2][c+2] && table[r+2][c+2] == table[r+3][c+3]){
						inputVal(c,symbol);
						return true;
					}
				}
				else if ((table[r][c].size()==1 && table[r+1][c+1].size()==0 && table[r+2][c+2].size() == 1 && table[r+3][c+3].size() == 1)){
					if( table[r][c]==table[r+2][c+2] && table[r+2][c+2] == table[r+3][c+3]){
						inputVal(c+1,symbol);
						return true;

					}

				}
				 else if ((table[r][c].size()==1 && table[r+1][c+1].size()==1 && table[r+2][c+2].size() == 0 && table[r+3][c+3].size() == 1)){
					if( table[r][c]==table[r+1][c+1] && table[r+1][c+1] == table[r+3][c+3]){
						inputVal(c+2,symbol);
						return true;


					}

				}
				else if((table[r][c].size()==1 && table[r+1][c+1].size()==1 && table[r+2][c+2].size() == 1 && table[r+3][c+3].size() == 0)){
					if( table[r][c]==table[r+1][c+1] && table[r+1][c+1] == table[r+2][c+2]){
						inputVal(c+3, symbol);
						return true;

					}

				}
			}
		}
		return false;
		}
	public static void main(String[] args) {
		Board board = new Board();
		for(int l12=0;l12<=1;l12++){
			board.reset();
		}
		System.out.println(	board.isTie());
		//System.out.println(board.containsWin()); 

	}
	


}

	

