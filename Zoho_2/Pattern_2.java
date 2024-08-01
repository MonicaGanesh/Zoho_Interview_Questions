public class Pattern_2 {
    public static void main(String[] args) {
        int num=4,start_row=1,start_col=0,row;
        for(int i=1;i<=num;i++)
        {
            start_row+=i-1;
            start_col=i;
            row=start_row;
            for(int j=1;j<=(num-i)+1;j++)
            {
                System.out.print(row+" ");
                row+=++start_col;
            }
            System.out.println();
        }
    }
}
