/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kstre_3ikvnbf
 */

public class ComputerPlayer extends APlayer{
    
    public ComputerPlayer(String name, String mark){ //constructor
        super(name, mark);
    }
    
    public int randomNumber(int range){ //returns random number between 0 and range
        return (int)(Math.random() * range);
    }
    
    public int selectRowValue(int range){ //select row from random num
        return randomNumber(range);
    }
    
    public int selectColValue(int range){ //select col from random num
        return randomNumber(range);
    }
    
    public int selectBoard(int range){ // select board from random num
        return randomNumber(range);
    }
    
    public int selectMove(int b){ //select move from random num
        return selectRowValue(3)*3+selectColValue(3); 
    }
    
}
