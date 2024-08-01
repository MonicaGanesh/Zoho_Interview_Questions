import java.util.Arrays;

public class GaussElimination {
    public static void main(String[] args) {
        /*2x+3y+z=1
        4x+y−2z=2
        3x+2y+3z=3*/
        double matrix[][]={{2,3,1,1},{4,1,-2,2},{3,2,3,3}};
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++)
        {
            System.out.println(Arrays.toString(matrix[i]));
        }
        for(int i=0;i<rows-1;i++)
        {
            for(int j=i+1;j<rows;j++)
            {
                double factor=matrix[j][i]/matrix[i][i];
                for(int k=i;k<cols;k++)
                {
                    matrix[j][k]-=factor*matrix[i][k];
                }
            }
        }
        System.out.println("Upper Triangular matrix:(After forward Elimination)");
        for(int i=0;i<rows;i++)
        {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("Backward Substitution");
        double soln[]=new double[rows];
        for(int i=rows-1;i>=0;i--)
        {
            soln[i]=matrix[i][cols-1];
            for(int j=i+1;j<rows;j++)
            {
                soln[i]-=matrix[i][j]*soln[j];
            }
            soln[i]/=matrix[i][i];
        }
        System.out.println(Arrays.toString(soln));

    }
}
