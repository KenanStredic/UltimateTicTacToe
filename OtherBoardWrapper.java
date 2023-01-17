/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kstre_3ikvnbf
 */
public class OtherBoardWrapper implements Iboard{
    OtherBoard otherBoard = new OtherBoard(); //intializes otherBoard
    
    
    public void printUltimateBoard(){ //calls otherBoard printUltimateBoard()
        otherBoard.printUltimateBoard();
    }
    
    
    public String getMark(int row, int col, int b){ //calls otherBoard getMark()
        return otherBoard.getMark(row, col, b);
    }
    
    
    public boolean makeMove(String player, int row, int col){ //calls otherBoard makeMove
        return otherBoard.makeMove(player, row, col);
    }
    
    public int getColSize(){ //calls otherBoard getBoardColSize
        return otherBoard.getBoardColSize();
    }
    
    public int getRowSize(){ // calls otherBoard getBoardRowSize
        return otherBoard.getBoardRowSize();
    }
    
    
    public boolean isFull(){ // calls otherBoard isFull()
        return otherBoard.isFull();
    }
    
    public boolean isFull(int b){ // calls otherBoard isFull()
        return otherBoard.isFull(b);
    }
    
    public void setBoardWinner(int b, String mark){ // calls otherBoard setBoardWinner()
        otherBoard.setBoardWinner(b, mark);
    }
    
    public String getBoardWinner(int b){ // calls otherBoard getBoardWinner()
        return otherBoard.getBoardWinner(b);
    }
    
    public Board getBoard(int b){ // calls otherBoard getBoard()
        return otherBoard.getBoard(b);
    }
    
    public void RASpots(int b){ // calls otherBoard RASpots()
        otherBoard.RASpots(b);
    }
    
    public void printASpots(int b){ // calls otherBoard printASPots()
        otherBoard.printASpots(b);
    }
    
    
    
}
