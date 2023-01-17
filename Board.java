/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kstre_3ikvnbf
 */
public class Board implements Iboard{
    private Box[] boxes; //array of boxes to store placeHolders
    private String name; //name of board
    private int boardRowSize; //num of rows
    private int boardColSize; //num of columns
    private String winner = ""; //winner of board
    
    
    public Board(){ //construtor
        this(3, 3, "3*3 board");
    }
    
    public Board(int rowSize, int colSize, String name){ //constructor
        this.setSize(rowSize, colSize);
        this.setName(name);
        this.init();
    }
    
    public Box[] getBox(){ //getter method for boxes
        return boxes;
    }
    
    private void setBoxes(Box[] boxes){ //setter method for boxes
        this.boxes = boxes;
    }
    
    public int getRowSize(){ //getter method for boardRowSize
        return boardRowSize;
    }
    
    public int getColSize(){ //getter method for boardColSize
        return this.boardColSize;
    }
    
    public String getName(){ //getter method for name
        return this.name;
    }
     
    private void setName(String name){ //setter method for name
        this.name = name;
    }
    
    public String getWinner(){ //getter method for winner
        return winner;
    }
    
    public void setWinner(String winner){ //setter method for winner
        this.winner = winner;
    }
    
    private void init(){ //intitalize boxes
        boxes = new Box[boardColSize * boardRowSize];
        for(int i = 0; i < boxes.length; i++){
            Box b = new Box();
            boxes[i] = b;
        }
        for(int i = 0; i <boxes.length; i++)
            boxes[i].setPlaceHolder(i+"");
    }
    
    public boolean isFull(){//checks if board is full of marks
        for(Box b: boxes){
            if(b.isAvailable()) 
                return false;
        }
        return true;
    }
    
    public boolean makeMove(String mark, int row, int col){ //makes move on board while checking if empty using row and column
        return boxes[row * this.boardRowSize + col].setPlaceHolder(mark);
    }
    
    public boolean makeMove(String mark, int a){ //makes move on board whiel checking if empty using index
        return boxes[a].setPlaceHolder(mark);
    }
    
    
    public String getMark(int row, int col){ //getter method for mark
        return boxes[row* this.boardRowSize + col].getPlaceHolder();
    }
    
    public void print(int a, int board){ //prints out boxes array by value using box print method
        for(int i = a; i < a+3; i++){
                boxes[i].print();
            }
        System.out.print("|");
    }
    
    public void setSize(int row, int col){ //setter method for boardColSize and boardRowSize
        if(row<3 || col < 3){
            System.out.println("min board size is 3*3");
        }else{
            this.boardColSize = col;
            this.boardRowSize = row;
        }
    }
    
    public void RASpots(){// replaces available spaces on board with *
        for(int i = 0; i < boxes.length; i++){
            if(boxes[i].isAvailable())
                boxes[i].setPlaceHolder("*");
        }
    }
    
    public void printASpots(){// prints out all available spaces on board
        int empty[] = new int[9];
        int k = 0;
        
        for(int i = 0; i < boxes.length;i++){
            if(boxes[i].isAvailable())
                empty[k++]=i;
        }
        
        for(int i = 0;i < k-1;i++)
            System.out.print(empty[i]+", ");
        System.out.println(empty[k-1]);
    }
    
    
}
