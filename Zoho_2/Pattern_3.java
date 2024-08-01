public class Pattern_3 {
    public static void main(String[] args) {
        int num=5,start_row=1,start_col=0,row;
        for(int i=1;i<=num;i++)
        {
            start_row+=i-1;
            start_col=i;
            row=start_row;
            for(int j=1;j<=num;j++)
            {
                System.out.print(row+" ");
                if(i+j<=5)
                {
                    row+=++start_col;
                }
                else
                {
                    row+=start_col--;
                }

            }
            System.out.println();
        }
    }
}
