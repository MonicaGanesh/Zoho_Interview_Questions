import java.util.Arrays;

public class Fibo {
    public static void main(String[] args) {
        int n=120;
        int e=0;
        int f[]=new int[n];
        f[0]=0;
        f[1]=1;

        for(int i=2;i<n;i++)
        {
            f[i]=f[i-1]+f[i-2];
            if(f[i]>n)
            {
                e=i;
                break;
            }
        }
        System.out.println(Arrays.toString(f));
        int l=e-1;
        while(l>=2)
        {
            for(int i=0;i<l;i++)
            {
                for(int j=i+2;j<l-1;j++)
                {
                    if(f[l]+f[i]+f[j]==n)
                    {
                        System.out.println(f[l]+"+"+f[j]+"+"+f[i]);
                        return;
                    }
                }
            }
            l--;
        }
        System.out.println("Not Possible!");
    }
}
