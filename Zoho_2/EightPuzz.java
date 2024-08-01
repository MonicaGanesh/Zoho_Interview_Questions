import java.util.*;
class State 
{
    int[][] board;
    int cost; 
    State(int[][] board,int cost) 
    {
            this.board=board;
            this.cost=cost;
    }
}
public class EightPuzz
{
    static void printPuzzle(int puzzle[][]) 
    {
        for(int i=0;i<puzzle.length;i++)
        {
            for(int j=0;j<puzzle.length;j++)
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
    static int findBlank(int board[][],int n) 
    {
        int index=0;
        for (int i=0;i<n;i++) 
        {
            for (int j=0;j<n;j++) 
            {
                if(board[i][j]==0) 
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

    static int[][] move(int board[][],int row,int col,int new_row,int new_col,int n) 
    {
        int[][] new_board=new int[n][n];
        for(int i=0;i<n;i++) 
        {
            for(int j=0;j<n;j++)
            {
                new_board[i][j]=board[i][j];
            }
        }

        int temp=new_board[row][col];
        new_board[row][col]=new_board[new_row][new_col];
        new_board[new_row][new_col]=temp;

        return new_board;
    }
    static int countMisplacedTiles(int board[][],int goal[][],int n) 
    {
        int count=0;
        for(int i=0;i<n;i++) 
        {
            for(int j=0;j<n;j++) 
            {
                if(board[i][j]!=goal[i][j]) 
                {
                    count++;
                }
            }
        }
        return count;
    }
    static boolean checkSimilar(int board[][],int goal[][])
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                if(board[i][j]!=goal[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean containsBoard(int board[][],ArrayList<int[][]> visited)
    {
        for(int old_board[][]:visited)
        {
            if(checkSimilar(old_board, board))
            {
                return true;
            }
        }
        return false;
    }
    static boolean solve(int[][] board,int[][] goal,int n)
    {
        PriorityQueue<State> queue=new PriorityQueue<>(Comparator.comparingInt(s->s.cost));
        ArrayList<int[][]> visited=new ArrayList<>();

        queue.add(new State(board,countMisplacedTiles(board,goal,n)));

        while(!queue.isEmpty()) 
        {
            State current_state=queue.poll();
            int current_board[][]=current_state.board;

            if(checkSimilar(current_board,goal)) 
            {
                printPuzzle(current_board);
                System.out.println("Solution found");
                return true;
            }
            if(containsBoard(current_board,visited)) 
            {
                continue;
            }
            printPuzzle(current_board);
            visited.add(current_board);

            int blank_pos=findBlank(current_board,n);
            int x=blank_pos/n;
            int y=blank_pos%n;

            int[][] directions={{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] direction:directions) 
            {
                int new_x=x+direction[0];
                int new_y=y+direction[1];
                if(isValid(new_x,new_y,n)) 
                {
                    int[][] new_board=move(current_board,x,y,new_x,new_y,n);
                    int newCost=countMisplacedTiles(new_board, goal,n);
                    queue.add(new State(new_board, newCost));
                }
            }
        }
        System.out.println("No solution found");
        return false;
    }
    public static void main(String[] args) 
    {
        //int board[][]={{2,4,1},{3,5,6},{8,0,7}};
        //int goal[][]={{1,2,3},{4,5,6},{7,8,0}};
        int board[][]={{1,2,5,4},{11,6,10,8},{9,7,13,12},{3,14,0,15}};
        int goal[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        int n=board.length;
        solve(board,goal,n);
    }
}
