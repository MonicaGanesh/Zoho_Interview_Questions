import java.util.Arrays;
import java.util.Scanner;

public class Roman {
    public static int index(char i,char str[])
    {
        int ind=0;
        for(int j=0;j<str.length;j++)
        {
            if(i==str[j])
            {
                ind=j;
                break;
            }
        }
        return ind;
    }
    public static void main(String[] args) {
        char str[]={'I','V','X','L','C','D','M'};
        int val[]={1,5,10,50,100,500,1000};
        //String s="MCMXC";
        String s;
        int cnt[]=new int[str.length];
        //String s="XIX";
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        int sum=0;
        int ind1=0,ind2=0;
        for(int i=0;i<s.length()-1;i++)
        {
            ind1=index(s.charAt(i),str);
            ind2=index(s.charAt(i+1),str);
            cnt[ind1]++;
            System.out.println(Arrays.toString(cnt));
            if((s.charAt(i)=='V' || s.charAt(i)=='L' || s.charAt(i)=='D') && cnt[ind1]>1)
            {
                System.out.println("Invalid Input");
                return;
            }
            else if(cnt[ind1]>3)
            {
                System.out.println("Invalid Input");
                return;
            }
            if(val[ind1]>=val[ind2])
            {
                sum+=val[ind1];
                if(i+1==s.length()-1)
                {
                    sum+=val[ind2];
                    return;
                }
            }
            else
            {
                sum+=val[ind2]-val[ind1];
                i++;
            }
            System.out.println(str[ind1]+" "+str[ind2]+" "+sum);
            sc.close();
        }
        System.out.println(sum);
    }
    
}
