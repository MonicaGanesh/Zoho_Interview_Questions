import java.util.Arrays;

public class Factor {
    static int getFactor(int num)
    {
        int cnt=2;
        for(int i=2;i<num/2;i++)
        {
            if(num%i==0)
                cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        int arr[]={7,9,12,15,24};
        int temp;
        int len=arr.length;
        
        for(int i=0;i<len-1;i++)
        {
            for(int j=i;j<len;j++)
            {
                if(getFactor(arr[i])<getFactor(arr[j]))
                {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
