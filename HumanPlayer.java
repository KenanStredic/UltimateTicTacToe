/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kstre_3ikvnbf
 */
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanPlayer extends APlayer{
    
    BufferedReader in = new BufferedReader (new InputStreamReader(System.in)); //accepts user inputs
    public HumanPlayer(String name, String mark){ //construtor
        super(name,mark);
    }
    
   
    
    public int selectBoard(int range) throws IOException{ //select board from user input
        int b;
        do{
            try{
                System.out.println("Please select a valid board: ");
                System.out.print("Selected Board : ");
                b = Integer.parseInt(in.readLine());
                        
            }
            catch (NumberFormatException e){//checks if input is valid integer
                System.out.println("Input is not valid. Please try again.");
                System.out.println("Please select a valid board: ");
                System.out.print("Seleted Board : ");
                b = Integer.parseInt(in.readLine());
            }
        }while(b<0 || b>8);
        return b;
    }
    
    public int selectMove(int range) throws IOException{//select move from user input
        int move;
        do{
            try{
                System.out.println("Please select a valid square on the selected board: ");
                System.out.print("Selected Square : ");
                move = Integer.parseInt(in.readLine());
            }
            catch (NumberFormatException e) { //checks if input is valid integer
                System.out.println("Input is not valid. Please try again.");
                System.out.println("Please select a valid square on the selected board: ");
                System.out.print("Selected Square : ");
                move = Integer.parseInt(in.readLine());
            }
        }while(move<0 || move>8);
    return move;
}
}
