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
import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class APlayer {
    private String name; //name of player
    private String mark; //"X" or "O"
    
    public APlayer(String name, String mark){ //intialize player 
        setName(name);
        setMark(mark);
    }
    
    public String getName(){ //getter method for name
        return name;
    }
    
    public void setName(String name){ //setter method for name
        this.name = name;
    }
    
    public String getMark(){ //getter method for mark
        return mark;
    }
    
    public void setMark(String mark){ //setter method for mark
        this.mark = mark;
    }
    
    //abstract methods for selecting board and selecting box for mark
    public abstract int selectBoard(int range) throws NumberFormatException, IOException;
    
    public abstract int selectMove(int range)throws NumberFormatException, IOException;
    
}
