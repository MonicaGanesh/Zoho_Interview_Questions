
public class SortAlt {
    static void swap(int array[],int start,int max_index,int min_index)
    {
        int temp;
        if(min_index==start && max_index==start+1)
        {
            temp=array[max_index];
            array[max_index]=array[min_index];
            array[min_index]=temp;
        }
        else
        {
            temp=array[start];
            array[start]=array[max_index];
            array[max_index]=temp;
    
            temp=array[start+1];
            array[start+1]=array[min_index];
            array[min_index]=temp;
        }
    }
    static void solve(int array[],int start,int end)
    {
        if(start+1>=end)
        {
            for(int i=0;i<end;i++)
            {
                System.out.print(array[i]+" ");
            }
            return;
        }
        int max_index=start,min_index=start;
        for(int i=start;i<=end;i++)
        {
            if(array[i]>array[max_index])
            {
                max_index=i;
            }
            if(array[i]<array[min_index])
            {
                min_index=i;
            }
        }
        if(max_index!=start || min_index!=start+1)
        {
            swap(array,start,max_index,min_index);
        }
        start+=2;
        solve(array,start,end);
    }
    public static void main(String[] args) {
        int array[]={15,10,5,3,25,35,1};
        int start=0,end=array.length-1;
        solve(array,start,end);
    }
}

