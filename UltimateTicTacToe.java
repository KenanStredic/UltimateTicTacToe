//Kenan Stredic
//CS 2336.002



/* Analysis:
Create an Ultimate Tic-Tac-Toe game. Each square of the Tic-Tac-Toe board should
contain another TicTacToe Board. To win, The player must complete 3 of the 
Tic-Tac-Toe boards in a line. However, the rules differ from regular Tic-Tac-Toe.
After the first move, the oppponent player must play on the Tic-Tac-Toe board
that correlates with the last played square. If the associated board is full, the
opponent can pick any square and board to play on. However, even if a board is won, 
as long as there is spaces left, the player can place a mark on it. This project has
3 different gameplay modes, player vs player, player vs ai, and ai vs ai. An optional feature 
to the game is to have the possible moves visibile for the player after each turn.
*/
 
/* Design:
I applied the code done in-class to my project. The classes include the driver UltimateTicTacToe,
BigTTTGame, SmallTTTGame, OtherBoardWrapper, OtherBoard, Board, Box, Iboard, HumanPlayer, and 
ComputerPlayer.To start, I made a Box class to act as the squares in the smaller TicTacToe board. 
I then created the Board class to represent the smaller boards that are contained in 
the bigger TicTacToe board. Each Box holds a placeHolder mark that will either be
a dash, a X, or a O. Then the Board class contains an array of boxes and implements methods
from Iboard, a interface with methods that affect the gameplay of TicTacToe. Next, I created the 
otherBoard class to act as the bigger ticTacToe board. It also implements methods
from Iboard along with methods for the array of Boards. To access these methods, I created a 
OtherBoardWrapper class. Next I made a SmallTTTGame class to facilitate all of the gameplay operations of the 
small TicTacToe boards and a BigTTTGame class to facilitate the bigger TicTacToe board. The BigTTTGame class
ties all of other methods together by organizing operations such as switching players, making moves, and checking for winners 
and if the boards are full during each turn. During each turn, the boards are printed out along with
any changes and a list of possible next moves.  Finally, the UltimateTicTacToe class acts as the driver.
*/

/* Test:
All the values are user-inputed during the HumanPlayers turn and are random values
for the ai players. Only valid inputs are allowed and wrong inputs must be reentered. Each square in the smaller boards is represented 
by numbers and they are replaced with markers throughout the game. Overall, the game succesfully runs in all modes and ends
with the result of a winner or a tie printed out.
*/

import java.io.IOException;
public class UltimateTicTacToe {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BigTTTGame game = new BigTTTGame();
        game.setPlayers(new ComputerPlayer("Player 1", "O"), new ComputerPlayer("Player 2", "X"));
        //game.setPlayers(new HumanPlayer("Player 1", "O"), new HumanPlayer("Player 2", "X"));
        game.playGame();
        
    }
    
}

    
    
    