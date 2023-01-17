/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kstre_3ikvnbf
 */

import java.io.IOException;
public class BigTTTGame {
    private APlayer[] players; //intializes players array
    private SmallTTTGame[] games; // array of small TicTacToe games
    private OtherBoardWrapper board; // board for big TicTacToe
    private String name = "Big TicTacToe"; // name of game
    private int gameRowSize = 3; // num of rows
    private int gameColSize = 3;// num of cols
    private int currentPlayerIndex = -1; //index of currentPlayer
    
    public BigTTTGame(OtherBoardWrapper board){ // constructor
        this.board = board;
    }
    
    public BigTTTGame() throws NumberFormatException, IOException{ //constructor 
        setBoard();
        setPlayers();
        setGames();
        setGameRowSize(board.getRowSize());
        setGameColSize(board.getColSize());
    }
    
    public int getGameRowSize(){ // getter method for gameRowSize
        return gameRowSize;
    }
    
    public void setGameRowSize(int gameRowSize){ // setter method for gameRowSize
        this.gameRowSize = gameRowSize;
    }
    
    public int getGameColSize(){ // getter method for gameColSize
        return gameColSize;
    }
    
    public void setGameColSize(int gameColSize){ // setter method for gameColSize
        this.gameColSize = gameColSize;
    }
    
    private void setGames(){ // setter method for games
        games = new SmallTTTGame[9];
        for(int i = 0; i < games.length; i++)
            games[i] = new SmallTTTGame();
    }
    
    private void setBoard(){ // setter method for board
        this.board = new OtherBoardWrapper();
    }
    
    public void setPlayers(){ // setter method for players
       players = new APlayer[2];
       currentPlayerIndex=0;
       players[currentPlayerIndex++] = new HumanPlayer("Player 1", "X");
       players[currentPlayerIndex--] = new ComputerPlayer("Player 2", "O");
    }
    
    public void setPlayers(APlayer player1, APlayer player2){ // setter method for players
        players = new APlayer[2];
        currentPlayerIndex=0;
        players[currentPlayerIndex++] = player1;
        players[currentPlayerIndex--] = player2;
    }
    
    public void playGame() throws NumberFormatException, IOException{ //starts big TicTacToe game
        board.printUltimateBoard();
        System.out.println();
        
        boolean ifRASpots[] = new boolean[9];
        setRASpots(ifRASpots);
        
        System.out.println("Current player: " + players[currentPlayerIndex].getMark());
        int b = players[currentPlayerIndex].selectBoard(board.getRowSize()*board.getColSize());
        System.out.println("Selected board: " + b);
        while(!gameOver()){
            int move = makeMove(b);
            
            if(!ifRASpots[b] && ifWinner(b)){
                RASpots(b);
                ifRASpots[b]=true;
                board.setBoardWinner(b, getWinner(b));
            }
            
            board.printUltimateBoard();
            
            if(board.isFull(b)){
                board.setBoardWinner(b, getWinner(b));
            }
            
            printWinners();
            switchPlayers();
            b = move;
            
            if(!gameOver()){
                System.out.println("Current player: "+players[currentPlayerIndex].getMark());
                System.out.println("Selected board: " + b);
            }
        }
        printGameWinner();
    }
    
    private int makeMove(int b) throws NumberFormatException, IOException{ //makes a move on big TicTacToe while checking if full
        if(board.isFull(b)){
            System.out.println("The selected board is full");
            while(board.isFull(b)){
                b = players[currentPlayerIndex].selectBoard(getGameColSize()*getGameRowSize());
            }
            System.out.println("Selected board: " + b);
        }
        printPossibleMoves(b);
        
        int move = players[currentPlayerIndex].selectMove(b);
        while(!board.makeMove(players[currentPlayerIndex].getMark(), move, b)){
            move = players[currentPlayerIndex].selectMove(b);
        }
        if(players[currentPlayerIndex].getMark().equals("O") || players[currentPlayerIndex].getMark().equals("X"))
            System.out.println("Selected Square: " + move);
        return move;
    }
    
    
    private void printPossibleMoves(int b){ // prints all possbile moves on board[b]
        System.out.println("Possible legal move(s): ");
        board.printASpots(b);
    }
    
    
    private void setRASpots(boolean[] c){ // setter method for c array
        for(int i = 0; i < 9; i++){
            c[i] = false;
        }
    }
   
    
    private void printGameWinner(){ // prints winner of the big TicTacToe game
        if(isWinner("X"))
            System.out.println("Game winner is X");
        else if(isWinner("O"))
            System.out.println("Game winner is O");
        else
            System.out.println("There is no winner");
    }
    
    private void RASpots(int b){ // replaces all available spaces on board[b] with *
       board.RASpots(b);
    }
    
    private boolean ifWinner(int b){ // checks if board has winner
        return getWinner(b).equals("X") || getWinner(b).equals("O");
    }
    
    private void printWinners(){ // prints winner of small TicTacToe game
        for(int i = 0; i < 9; i++){
            if(!board.getBoardWinner(i).equals(""))
                System.out.println("Winner of board " + i + " is " + board.getBoardWinner(i));
        }
        System.out.println();
    }

    
    private void switchPlayers(){ // switches players
        if(currentPlayerIndex == 0)
            currentPlayerIndex++; 
        else{
            currentPlayerIndex--;
        }
    }
    
    private String getWinner(int b){ // getter method for winner of small TicTacToe
        games[b].setBoard(board.getBoard(b));
        return games[b].getWinner(players[0].getMark(),players[1].getMark());
        
    }
       
    private boolean gameOver(){ // checks if game is over
        return board.isFull() || isWinner("X") || isWinner("O");
    }
    
    
    private boolean isWinner(String mark){ // checks if mark occurs in all rows of a column, all columns of a row, or in diagonol
        for(int i = 0; i<board.getRowSize()*board.getColSize();i++){
            if(games[i].checkRow(mark) || games[i].checkCol(mark) || games[i].checkDiagLR(mark) || games[i].checkDiagRL(mark))
                board.setBoardWinner(i, mark);
        }
        return checkRow(mark) || checkCol(mark) || checkDiagRL(mark) || checkDiagLR(mark);
    }
    
    
    private boolean checkCol(String mark){ // checks if mark occurs in all rows of a column
        for(int i = 0; i < board.getColSize()*board.getRowSize()-6;i=i+3){
            if(board.getBoardWinner(i).equals(mark) && board.getBoardWinner(i+3).equals(mark) && board.getBoardWinner(i+6).equals(mark))
                return true;
        }
        return false;
    }
    
    private boolean checkRow(String mark){ // checks if mark occurs in all columns of a row
        for(int i = 0; i < board.getColSize()*board.getRowSize()-3;i=i+3){
            if(board.getBoardWinner(i).equals(mark) && board.getBoardWinner(i+1).equals(mark) && board.getBoardWinner(i+2).equals(mark))
                return true;
        }
        return false;
    }
    
    private boolean checkDiagLR(String mark){ // checks if mark occurs in left diagonol
        return board.getBoardWinner(0).equals(mark) && board.getBoardWinner(4).equals(mark) && board.getBoardWinner(8).equals(mark);
    }
    
    private boolean checkDiagRL(String mark){ // checks if mark occurs in right diagonol
        return board.getBoardWinner(2).equals(mark) && board.getBoardWinner(4).equals(mark) && board.getBoardWinner(6).equals(mark);
        }
}
