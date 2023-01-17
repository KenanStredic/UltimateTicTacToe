/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kstre_3ikvnbf
 */
public class OtherBoard {
    private int boardRowSize = 3; //num of rows 
    private int boardColSize = 3; //num of columns
    private Board[] board; // array of boards
    
    public OtherBoard(){ //constructor
        this(3,3,"BigTTTGame");
    }
    
    public OtherBoard(int row, int col, String name){ //constructor
        board = new Board[boardRowSize*boardColSize];
        this.init();
    }
    
    public Board[] getBoard(){ //getter method for board
       return board;
    }
    
    public Board getBoard(int b){ //getter method for board[b]
        return board[b];
    }
    
    public void setBoards(Board[] board){ //setter method for board
        this.board = board;
    }
    
    public int getBoardRowSize(){ //getter method for boardRowSize
        return boardRowSize;
    }
    
    public void setBoardRowSize(int boardRowSize){ //setter method for boardColSize
        this.boardRowSize = boardRowSize;
    }
    
    public int getBoardColSize(){ //getter method for boardRowSize
        return boardColSize;
    }
    
    public void setBoardColSize(int boardColSize){ //setter method for boardColSize
        this.boardColSize = boardColSize;
    }
    
    
    private void init(){ //intializes board
        for(int i = 0; i < board.length; i++){
                //System.out.println("Board " + (i*3 + j));
                board[i] = new Board();
        }
        System.out.println("Welcome to Ultimate Tic Tac Toe");
    }
    
    public boolean isFull(){ //checks if board is full of marks
        for(Board b: board){
            if(!b.isFull())
                return false;
        }
        return true;
    }
    
    public boolean makeMove(String player,int row, int col,int b){ //makes a move on board while checking if empty
        return board[b].makeMove(player, row, col);
    }
    
    public boolean makeMove(String player, int a, int b){ //makes a move on board while checking if empty
        return board[b].makeMove(player, a);
    }
    
    public String getMark(int row, int col, int b){ // getter method for mark
        return board[b].getBox()[row*boardColSize+col].getPlaceHolder();
    }
    
    public void printUltimateBoard(){ //print all boards in a row 
        for(int i = 0; i < board.length-2; i=i+3){
            for(int j = 0; j < board.length; j=j+3){ 
                for(int k = i;k < i+3; k++){
                    System.out.print("		BOARD#"+k+" ");
                    board[k].print(j,k);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    
    
    public boolean isFull(int b){ //check if board[b] is full
        return board[b].isFull();
    }
            
    public void setBoardWinner(int b, String mark){ //setter method for boardWinner
        board[b].setWinner(mark);
    }
    
    public String getBoardWinner(int b){ //getter method for boardWinner
        return board[b].getWinner();
    }
    
    public void RASpots(int b){ // replaces all available spaces on board[b] with * 
        board[b].RASpots();
    }
    
    public void printASpots(int b){ //prints out all avaiable spaces on board[b]
        board[b].printASpots();
    }
    
}
