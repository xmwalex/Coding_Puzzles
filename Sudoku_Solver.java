/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


*/

public class Solution {
    boolean found =false;
    public void solveSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.')
                    solveSudoku(board,i,j);
            }
        }
    }
    public void solveSudoku(char[][] board, int i, int j){
        int[] n = new int[board.length];
        boolean flag=false;
        for(int k=0;k<board.length;k++){
            if(board[i][k]!='.'){
                n[board[i][k]-'1']=1;
            }
            if(board[k][j]!='.'){
                n[board[k][j]-'1']=1;
            }
        }
            for(int ic=(i/3)*3;ic<(i/3*3+3);ic++){
                for(int jc=(j/3)*3;jc<(j/3*3+3);jc++){
                    if(board[ic][jc]!='.'){
                        n[board[ic][jc]-'1']=1;
                    }
                }
            }
            for(int x=0;x<board.length;x++){
                if(n[x]!=1){
                    board[i][j]=(char)('1'+x);
                    for(int a=i;a<board.length;a++){
                        for(int b=0;b<board.length;b++){
                            if(board[a][b]=='.'){
                                solveSudoku(board,a,b);
                                flag=true;
                                if(found==true)
                                    return;
                                break;
                            }
                        }
                        if(flag==true){
                            break;                        
                        }
                    }
                    if(flag==false){
                        found=true;
                        return;
                    }
                        
                }
            }
            board[i][j]='.';
        }
}
