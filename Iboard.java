/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kstre_3ikvnbf
 */
public interface Iboard {
    boolean isFull();
    boolean makeMove(String player, int row, int col);
    int getColSize();
    int getRowSize();
}
