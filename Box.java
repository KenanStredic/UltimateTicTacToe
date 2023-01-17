/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kstre_3ikvnbf
 */
public class Box {
    private String placeHolder = ""; //placeHolder
    
    public Box(){ //constructor
    }
    
    public Box(String placeHolder){ //constructor
        setPlaceHolder(placeHolder);
    }
    
    public String getPlaceHolder(){ //getter method for placeHolder
        return placeHolder;
    }
    
    public boolean setPlaceHolder(String placeHolder){ //setter method for placeHolder
        if(isAvailable()){ 
            this.placeHolder = placeHolder;
            return true;
        
        }
        else
            return false;
    }
    
    public void print(){ // prints placeHolder value
        System.out.print("| " + getPlaceHolder() + " ");
    }
    
    public boolean isAvailable(){ //checks if placeHolder is dash 
            return !getPlaceHolder().equals("X") && !getPlaceHolder().equals("O");
                
    }
    
   
    
           
}
