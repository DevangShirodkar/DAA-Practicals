import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Queen
{
    static boolean isAttack(int i,int j,int board[][])
    {
        for(int k=0;k<board.length;k++)
        {
            if((board[i][k] == 1) || (board[k][j] == 1))
                return true;
        }

        for(int k=0;k<board.length;k++){

            for(int l=0;l<board.length;l++){
                if(((k+l) == (i+j)) || ((k-l) == (i-j))){
                    if(board[k][l] == 1)
                        return true;
                }
            }
        }
        return false;
    }

    static boolean nQueen(int n,int board[][]){

        if(n==0)
            return true;
        for(int i=0;i<board.length;i++){

            for(int j=0;j<board.length;j++){

                if((!isAttack(i,j,board)) && (board[i][j]!=1)){
                    board[i][j] = 1;

                    if(nQueen(n-1,board)==true){
                        return true;
                    }
                    board[i][j] = 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)throws IOException
    {
        
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       System.out.println("Enter the value of N for NxN chessboard");
       int N = Integer.parseInt(br.readLine());

        int i,j;
        int board[][] = new int[N][N];
        nQueen(N,board);

        for(i=0;i<N;i++)
        {
            for(j=0;j<N;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}