public class MazezMove {
    static void initializeMatrix(boolean matrix[][])
    {
        int len=matrix.length;
        for(int i=0;i<len;i++)
        {
            for(int j=0;j<len;j++)
            {
                matrix[i][j]=false;
            }
        }
    }
    static void printMatrix(boolean matrix[][],int row,int col)
    {
        int len=matrix.length;
        for(int i=0;i<len;i++)
        {
            for(int j=0;j<len;j++)
            {
                if(i==row && j==col)
                {
                    System.out.print(" A");
                }
                else if(matrix[i][j]==false)
                {
                    System.out.print(" W");
                }
                else
                {
                    System.out.print(" B");
                }
            }
            System.out.println();
        }
    }
    static boolean isValid(int row,int col,int n)
    {
        if(row<0 || row>=n || col<0 || col>=n)
        {
            return false;
        }
        return true;
    }

    static void solve(boolean matrix[][],int curr_row,int curr_col,char init_direction,int iter)
    {
        int i=0;
        char desired_direction;
        if(init_direction=='D')
        {
            curr_row+=1;
        }
        else if(init_direction=='U')
        {
            curr_row-=1;
        }        
        else if(init_direction=='L')
        {
            curr_col-=1;
        }
        else
        {
            curr_col+=1;
        }
        while(i!=iter)
        {
            System.out.println(i+" "+curr_row+" "+curr_col+" "+init_direction);

            if(matrix[curr_row][curr_col]==false)
            {
                desired_direction='L';
            }
            else
            {
                desired_direction='R';
            }
            matrix[curr_row][curr_col]=!matrix[curr_row][curr_col];
            if(init_direction=='D' && desired_direction=='L')
            {
                curr_col+=1;
                init_direction='R';
                
            }
            else if(init_direction=='D' && desired_direction=='R')
            {
                curr_col-=1;
                init_direction='L';
            }
            else if(init_direction=='U' && desired_direction=='R')
            {
                curr_col+=1;
                init_direction='R';
            }
            else if(init_direction=='U' && desired_direction=='L')
            {
                curr_col-=1;
                init_direction='L';
            }
            else if(init_direction=='L' && desired_direction=='L')
            {
                curr_row+=1;
                init_direction='D';
            }
            else if(init_direction=='L' && desired_direction=='R')
            {
                curr_row-=1;
                init_direction='U';
            }
            else if(init_direction=='R' && desired_direction=='R')
            {
                curr_row+=1;
                init_direction='D';
            }
            else if(init_direction=='R' && desired_direction=='L')
            {
                curr_row-=1;
                init_direction='U';
            }
            if(!isValid(curr_row, curr_col, matrix.length))
            {
                break;
            }
            i++;
        }
        //printMatrix(matrix, curr_row, curr_col);
    }
    public static void main(String[] args) {
        boolean matrix[][]=new boolean[30][30];
        int curr_row=15;
        int curr_col=15;
        char direction='D';
        int iter=10000;
        initializeMatrix(matrix);
        //printMatrix(matrix,curr_row,curr_col);
        solve(matrix,curr_row,curr_col,direction,iter);
    }
    
}
