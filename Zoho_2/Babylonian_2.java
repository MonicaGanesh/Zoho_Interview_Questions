public class Babylonian_2 {
    static double solve(double guess,double num)
    {
        System.out.println(guess);
        if(guess*guess>=num-0.02 && guess*guess<=num+0.02)
        {
            return guess;
        }
        else
        {
            return solve((1/2.0)*(guess+(num/guess)),num);
        }
    }
    public static void main(String[] args) {
        double num=500;
        double guess=num/2;
        System.out.println(solve(guess,num));
    }
    
}
