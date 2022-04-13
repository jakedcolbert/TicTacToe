package TicTacToe; 

import java.util.*;
import java.io.*;
import java.net.*;

public class TicTacToe{
    public static void main(String[] args){
        
        ///EchoMultiServer.start(7777);
      
      
      
        writeBoardState(); // begin game
        
        while(!gameOver){ // initiate each round
            turn(player);
        }
        ///EchoMultiServer.stop();
        return; // end game
        
    }
    
    public static void turn(char symbol){
        Scanner scan = new Scanner(System.in);
        System.out.println("Indicate your placement (1-9): ");
        int pos = scan.nextInt();
        
        if (taken[pos - 1]){ //error
            System.out.println(ANSI_RED + "\nPlease Choose a placement that has not already been chosen.\n" + ANSI_RESET);
        } else {
            switch(pos) {
                    case 1:
                        gameBoard[0][0] = symbol;
                        break;
                    case 2:
                        gameBoard[0][2] = symbol;
                        break;
                    case 3:
                        gameBoard[0][4] = symbol;
                        break;
                    case 4:
                        gameBoard[2][0] = symbol;
                        break;
                    case 5:
                        gameBoard[2][2] = symbol;
                        break;
                    case 6:
                        gameBoard[2][4] = symbol;
                        break;
                    case 7:
                        gameBoard[4][0] = symbol;
                        break;
                    case 8:
                        gameBoard[4][2] = symbol;
                        break;
                    case 9:
                        gameBoard[4][4] = symbol;
                        break;
            }
            System.out.println("");
            taken[pos - 1] = true;
            writeBoardState();
            System.out.println("");
            checkWin();
            oppositeTurn();
       }
            
    }
    
    public static void checkWin(){
        
        // each column
        
        if(gameBoard[0][0] == gameBoard[0][2] && gameBoard[0][2] == gameBoard[0][4])
            gameOver();
        if(gameBoard[2][0] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[2][4])
            gameOver();
        if(gameBoard[4][0] == gameBoard[4][2] && gameBoard[4][2] == gameBoard[4][4])
            gameOver();
        
        // each row
        
        if(gameBoard[0][0] == gameBoard[2][0] && gameBoard[2][0] == gameBoard[4][0])
            gameOver();
        if(gameBoard[0][2] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][2])
            gameOver();
        if(gameBoard[0][4] == gameBoard[2][4] && gameBoard[2][4] == gameBoard[4][4])
            gameOver();
        
        // each diagonal
        
        if(gameBoard[0][0] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][4])
            gameOver();
        if(gameBoard[4][0] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[0][4])
            gameOver();
        
    }
    
    public static void gameOver(){
        System.out.println("-----------------\nGame Over - " + player + " Won\n-----------------");
        gameOver = true;
    }
    
    /**
     write the current state of the board
     */
    public static void writeBoardState(){
        for(char[] row : gameBoard){
            for(char c : row){
                if (c == 'X')
                    System.out.print(ANSI_X + c + ANSI_RESET);
                else if (c == 'O')
                    System.out.print(ANSI_O + c + ANSI_RESET);
                else
                    System.out.print(c);
            }
            System.out.println();
        }
    }
    
    /**
     return the opposite of the current turn
     */
    public static void oppositeTurn(){
        if (player == 'X')
            player = 'O';
        else
            player = 'X';
    }
    
    static char player = 'X';
    static char[][] gameBoard = {{'1', '|', '2', '|', '3'},
                        {'-', '+', '-', '+', '-'},
                        {'4', '|', '5', '|', '6'},
                        {'-', '+', '-', '+', '-'},
                        {'7', '|', '8', '|', '9'}};
    
    static boolean[] taken = new boolean[]{ false, false, false, false, false, false, false, false, false };
    
    static boolean gameOver = false;
    
    
    // text colors
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    
    public static final String ANSI_X = "\u001B[31;1m";
    public static final String ANSI_O = "\u001B[36;1m";
    
    // background colors
    
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
}
