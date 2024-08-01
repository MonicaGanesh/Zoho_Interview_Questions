import java.util.Arrays;

public class SortStringNo {
    static int compare(String s1,String s2)
    {
        int len1=s1.length();
        int len2=s2.length();
        if(len1>len2)
        {
            return 1;
        }
        else if(len1<len2)
        {
            return -1;
        }
        int i=0;
        while(i!=len1)
        {
            if(s1.charAt(i)>s2.charAt(i))
            {
                return 1;
            }
            else if(s1.charAt(i)<s2.charAt(i))
            {
                return -1;
            }
            i++;
        }
        return 0;
    }
    public static void main(String[] args) {
        String numbers[]={"123","37","5","12"};
        int len=numbers.length;
        for(int i=0;i<len-1;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                if(compare(numbers[i],numbers[j])==1)
                {
                    String temp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
