import java.util.Arrays;

public class Rearrange {
    static int getLength(int a)
    {
        int len=0;
        while(a!=0)
        {
            len++;
            a/=10;
        }
        return len;
    }
    static int check(int a,int b)
    {
        if(a>b)
        {
            return 1;
        }
        else if(a<b)
        {
            return -1;
        }
        return 0;
    }
    static int concat(int a,int b)
    {
        int multiplier=1;
        int len2=getLength(b);
        while(len2!=0)
        {
            multiplier*=10;
            len2--;
        }
        int ans=a*multiplier+b;
        return ans;
    }
    static int compare(int a,int b)
    {
        int len1=getLength(a);
        int len2=getLength(b);
        if(len1==len2)
        {
            return check(a,b);
        }
        int c1=concat(a, b);
        int c2=concat(b, a);
        return check(c1, c2);
    }
    public static void main(String[] args) {
        int data[]={11,3,7,15,63,632,639};
        int len=data.length;
        for(int i=0;i<len-1;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                if(compare(data[i],data[j])==-1)
                {
                    int temp=data[i];
                    data[i]=data[j];
                    data[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }
}
