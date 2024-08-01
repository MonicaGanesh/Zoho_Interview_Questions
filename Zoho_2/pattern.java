public class pattern {
    public static void main(String[] args) {
        int n=5;
        int space=-1;
        int size=n*2;
        for(int i=1;i<size;i++)
        {
            for(int j=1;j<size;j++)
            {
                if(j>=Math.abs(n-i)+2 && j<Math.abs(n-i)+2+space)
                {
                    System.out.print("  ");
                }
                else
                {
                    System.out.print("* ");
                }
            }
            if(i<n)
            {
                space+=2;
            }
            else
            {
                space-=2;
            }
            System.out.println();
        }
    }
}
