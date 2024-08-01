public class Babylonian {
    public static double solve(double num,double n)
    {
        //System.out.println(num);
        if((num/2)*(num/2)>=n-0.02 && (num/2)*(num/2)<=n+0.02)
            return num/2;
        else if((num/2)*(num/2)>n)
            return solve(num/2,n);
        else
            return solve((num+(num/2)),n);

    }
    public static void main(String[] args) {
        double num=200;
        System.out.println(solve(num,num));

    }
}
