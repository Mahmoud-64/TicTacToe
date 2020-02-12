/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

/**
 *
 * @author hagar
 */
public class gameLogic {
    private char[] board;
    protected char currentPlayerMark;
    char winner='-';
    
    //Gives us access to currentPlayerMark
    public gameLogic() {
        board = new char[9];
        currentPlayerMark = 'x';
        initializeBoard();
    }
    

    // Set/Reset the board back to all empty values.
    public void initializeBoard() {

        // Loop through board
        for (int i = 0; i < 9; i++) {
            board[i] = '-';
        }
        printBoard();                       //<==============
    }
    
    // Print the current board (may be replaced by GUI implementation later)
    public void printBoard() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[j+i*3] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    // Otherwise the board is full.
    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j+i*3] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;
    }
    

    // Change player marks back and forth.
    public void changePlayer() {
        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        }
        else {
            currentPlayerMark = 'x';
        }
    }
    
    // Places a mark at the cell specified by row and col with the mark of the current player.
    public boolean placeMark(int pos) {

        if(currentPlayerMark!='-')
        {
            // Make sure that row and column are in bounds of the board.
            if ((pos >= 0) && (pos < 9)) {
                    if (board[pos] == '-') {
                        board[pos] = currentPlayerMark;
                        return true;
                    }
            }
        }
        return false;
    }
    
    /*====================================================*/
    
    
    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board.
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }    
    

    // Loop through rows and see if any are winners.
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0+i*3], board[1+i*3], board[2+i*3]) == true) {
                return true;
            }
        }
        return false;
    }


    // Loop through columns and see if any are winners.
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0+i], board[3+i], board[6+i]) == true) {
                return true;
            }
        }
        return false;
    }


    // Check the two diagonals to see if either is a win. Return true if either wins.
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0], board[4], board[8]) == true) || (checkRowCol(board[2], board[4], board[6]) == true));
    }
    
    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }
    
        synchronized public boolean updateGame(int pos)
        {
            boolean checked;
            checked = placeMark(pos);
            if(checked == true)
            {
                if(checkForWin())
                {
                    winner=currentPlayerMark;
//                    System.out.println("current player before "+currentPlayerMark);
                    currentPlayerMark='-';
//                    System.out.println("current player after "+currentPlayerMark);
                }
                else
                {
                    changePlayer();
                }
            }
            if(isBoardFull())
            {
                //game finished
            }
            return checked;
        }
    
    
    
    
}
