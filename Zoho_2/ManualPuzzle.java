import java.util.*;

public class ManualPuzzle {
    static void printPuzzle(int puzzle[][],int n) 
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(puzzle[i][j]>9)
                {
                    System.out.print("  "+puzzle[i][j]);
                }
                else if(puzzle[i][j]==0)
                {
                    System.out.print("    ");
                }
                else
                {
                    System.out.print("   "+puzzle[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    static boolean checkWinner(int puzzle[][],int n) 
    {
        int check=1;
        for(int i=0;i<n;i++) 
        {
            for(int j=0;j<n;j++) 
            {
                if(check==n*n && puzzle[i][j]==0)
                {
                    return true;
                }
                if(puzzle[i][j]!=check) 
                {
                    return false;
                }
                check+=1;
            }
        }
        return false;
    }

    static int findEmptySpace(int puzzle[][],int n) 
    {
        int index=0;
        for (int i=0;i<n;i++) 
        {
            for (int j=0;j<n;j++) 
            {
                if(puzzle[i][j]==0) 
                {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }
    static boolean isValid(int row,int col,int n) 
    {
        if(row>=0 && row<n && col>=0 && col<n)
        {
            return true;
        }
        return false;
    }
    static void swap(int[][] puzzle, int cur_row, int cur_col, int new_row, int new_col) {
        int temp = puzzle[cur_row][cur_col];
        puzzle[cur_row][cur_col] = puzzle[new_row][new_col];
        puzzle[new_row][new_col] = temp;
    }
    static boolean move(int puzzle[][],String direction,int n) 
    {
        int index=findEmptySpace(puzzle,n);
        int row=index/n;
        int col=index%n;
        if(direction.equals("up") && isValid(row-1,col,n))
        {
            swap(puzzle,row,col,row-1,col);
        }
        else if(direction.equals("down") && isValid(row+1,col,n))
        {
            swap(puzzle,row,col,row+1,col);
        }
        else if(direction.equals("left") && isValid(row,col-1,n))
        {
            swap(puzzle,row,col,row,col-1);
        }
        else if(direction.equals("right") && isValid(row,col+1,n))
        {
            swap(puzzle,row,col,row,col+1);
        }
        else
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args) 
    {
        //int puzzle[][]={{2, 7, 4},{1, 6, 3},{8, 0, 5}};
        int puzzle[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,0,15}};
        int n=puzzle.length;

        Scanner sc=new Scanner(System.in);
        while(true) 
        {
            printPuzzle(puzzle,n);
            if(checkWinner(puzzle,n)) 
            {
                System.out.println("YOU WON!");
                break;
            }
            System.out.print("Enter move:");
            String move=sc.nextLine();
            if(!move(puzzle,move,n)) 
            {
                System.out.println("Invalid move! Try again");
            }
        }
        sc.close();
    }
}
