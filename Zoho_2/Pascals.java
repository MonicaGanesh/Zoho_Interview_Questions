
public class Pascals {
    public static void main(String[] args) {
        int n=10;
        int mat[][]=new int[n+1][];
        mat[0]=new int[1];
        mat[0][0]=1;
        for(int i=1;i<n;i++)
        {
            mat[i]=new int[i+1]; 
            mat[i][0]=1;
            for(int j=1;j<i;j++)
            {
                if(i-1>0)
                    mat[i][j]=mat[i-1][j-1]+mat[i-1][j];
            }
            mat[i][i]=1;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
