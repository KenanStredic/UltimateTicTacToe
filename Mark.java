/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kstre_3ikvnbf
 */
enum Mark {
    X("X"),
    O("O"),
    DASH("-");
    
    private String mark;
    Mark(String mark){
        this.mark = mark;
    }
    
    public String getMark(){
        return mark;
    }
    
}
