import java.util.Arrays;

public class Determinant {
    static int deter(int mat[][],int n)
    {
        if(n==2)
            return mat[0][0]*mat[1][1]-mat[1][0]*mat[0][1];
        else if(n==1)
            return mat[0][0];
        else
        {
            int mat1[][]=new int[n-1][n-1];
            int r=0,c=0;
            int det=0;
            for(int i=0;i<n;i++)
            {
                r=0;
                for(int j=1;j<n;j++)
                {
                    c=0;
                    for(int k=0;k<n;k++)
                    {
                        if(k!=i)
                        {
                            System.out.println(i+" "+j+" "+k+" "+r+" "+c);
                            mat1[r][c++]=mat[j][k];
                        }
                    }
                    r++;
                }
                for(int l=0;l<n-1;l++)
                {
                    System.out.println(Arrays.toString(mat1[l]));
                }

                det+=(int)Math.pow(-1,i)*mat[0][i]*deter(mat1, n-1);
                System.out.println(det);
            }
            return det;
        }
    }
    public static void main(String[] args) {
        int matrix[][]={{1,3,0},{4,1,0},{2,0,1}};
        int n=matrix.length;
        System.out.println(deter(matrix, n));
    }
}
