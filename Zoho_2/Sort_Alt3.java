public class Sort_Alt3 {
    static void swap(int array[],int a,int b)
    {
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
    static void solve(int array[],int start,int end,int flag)
    {
        if(start>=end)
        {
            for(int i=0;i<array.length;i++)
            {
                System.out.print(array[i]+" ");
            }
            return;
        }
        int max_index=start;
        for(int i=start;i<=end;i++)
        {
            if(array[i]>array[max_index])
            {
                max_index=i;
            }
        }
        if(flag==0)
        {
            swap(array,start,max_index);
            solve(array, start+1, end, 1);
        }
        else
        {
            swap(array,end,max_index);
            solve(array,start,end-1,0);
        }
    }
    public static void main(String[] args) {
        int array[]={15,10,5,3,25,35,1};
        int start=0,end=array.length-1;
        int flag=0;
        solve(array,start,end,flag);
    }          
}
