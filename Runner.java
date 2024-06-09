import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
    
        Board board = new Board();
        ConnectFour game = new ConnectFour(board);
        game.setPlayer1(new HumanPlayer('R', board, "Alice"));
        game.setPlayer2(new HumanPlayer('B', board, "Bob")); // game. setplayer1(player1)
        game.playGame();
    }
    
    
}

