/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
     * 1- start the game message
     * 2- select the current player index
     * 3- player should select row and col to place the mark
     * 4- board should check if the box is available and if so place the mark otherwise repeat the process
     * 5- then print the board
     * 6- repeat the steps for the other player until one player win or board is full
     */
public class SmallTTTGame {
    private Board board; // board for small TicTacToe
    private String name = "Small TicTacToe"; //name of game
    private int gameRowSize = 3; // num of rows
    private int gameColSize = 3; // num of cols
    private int currentPlayerIndex = -1; // index of current player
    
    public SmallTTTGame(Board board){ // constructor
        setBoard(board);
    }
    
    public SmallTTTGame(){ //constructor
        setBoard();
        setGameRowSize(board.getRowSize());
        setGameColSize(board.getColSize());
    }
    
    
    public Board getBoard(){ //getter method for board
        return board;
    }
    
    public String getName(){ //getter method for name
        return name;
    }
    
    public void setName(String name){ //setter method for name
        this.name = name;
    }
    
    public void setBoard(Board board){ //setter method for board
        this.board = board;
    }
    
    public int getCurrentPlayerIndex(){ //getter method for currentPlayerIndex
        return currentPlayerIndex;
    }
    
    public void setCurrentPlayerIndex(int currentPlayerIndex){ //setter method for curentPlayerIndex
        this.currentPlayerIndex = currentPlayerIndex;
    }
    
    public int getGameRowSize(){ // getter method for gameRowSize
        return gameRowSize;
    }
    
    public void setGameRowSize(int gameRowSize){ // setter method for gameRowSize
        this.gameRowSize = gameRowSize;
    }
    
    public int getGameColSize(int gameColSize){ // getter method for gameColSize
        return gameColSize;
    }
    
    public void setGameColSize(int gameColSize){ // setter method for gameColSize
        this.gameColSize = gameColSize;
    }
    
    private void setBoard(){ //setter method for board
        this.board = new Board();
    }
    
    public boolean isWinner(String mark){ //check if mark occurs in all rows of a column, all columns of a row, or in a diagonal
        if(checkRow(mark) || checkCol(mark)|| checkDiagRL(mark) || checkDiagLR(mark))
            return true;
        else
            return false;
    }
    
    public boolean checkDiagLR(String mark){ // check if mark occurs in left diagonol;
        return board.getMark(0, 0).equals(mark) && board.getMark(1, 1).equals(mark) && board.getMark(2,2).equals(mark);
    }
    
    public boolean checkDiagRL(String mark){ // check if mark occurs in right diagonol
        return board.getMark(0, 2).equals(mark) && board.getMark(1, 1).equals(mark) && board.getMark(2,0).equals(mark);
}
     public boolean checkCol(String mark){ // check if mark occurs in all rows of a column
        for(int i = 0;i<board.getRowSize();i++){
            int c = 0;
            for(int j = 0;j < board.getRowSize();j++){
                if(!board.getMark(j, i).equals(mark)){
                    c = 1;
                    break;
                }
            }
            if(c==0)
                return true;
        }
        return false;
    }
    
    
    public boolean checkRow(String mark){ // check if mark occurs in all columns of a row
        for(int i = 0;i<board.getRowSize();i++){
            int c = 0;
            for(int j = 0;j < board.getRowSize();j++){
                if(!board.getMark(i, j).equals(mark)){
                    c = 1;
                    break;
                }
            }
            if(c==0)
                return true;
        }
        return false;
    }
    
    public String getWinner(String player1, String player2){ // getter method for the winner
        if(isWinner(player1)) 
            return player1;
        else if(isWinner(player2)) 
            return player2;
        else 
            return "Tie";
    }
    
    
    
   
    
    
    
}
