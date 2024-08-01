import java.util.Arrays;

public class Sort_Alt_2 {
    static int compare(int a,int b)
    {
        if(a>b)
            return 1;
        else if(a==b)
            return 0;
        else
            return -1;
    }
    public static void main(String[] args) {
        int array[]={15,10,5,3,25,35,1};
        int end=array.length-1;
        int start=0;
        int flag=0;
        int swap=start;
        for(int i=start;i<=end;i++)
        {
            for(int j=i+1;j<=end;j++)
            {
                if(compare(array[i],array[j])==-1)
                {
                    int temp=array[j];
                    array[j]=array[swap];
                    array[swap]=temp;
                }
            }
            if(flag==0)
            {
                flag=1;
                start++;
                swap=end;
            }
            else
            {
                flag=0;
                end--;
                swap=start;
            }
            if(start+1==end)
            {
                if(array[start]>array[end])
                {
                    int temp=array[start];
                    array[start]=array[end];
                    array[end]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }   
}
