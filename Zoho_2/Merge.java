//import java.util.Arrays;

public class Merge {
    static void sort(int interval[][],int s,int e)
    {
        if(s>=e)
        return;
        int p=partition(interval,s,e);
        sort(interval, s, p-1);
        sort(interval, p+1, e);
        
    }
    static int partition(int interval[][],int s,int e)
    {
        int p=interval[s][0];
        int pind=0;
        for(int i=s+1;i<=e;i++)
        {
            if(interval[i][0]<p)
            pind++;
        }
        pind+=s;
        swap(interval,s,pind);
        int i=s,j=e;
        while(i<pind && j>pind)
        {
            while(interval[i][0]<p)
            i++;
            while(interval[j][0]>p)
            j--;
            if(i<pind && j>pind)
            {
                swap(interval,i++,j--);
            }
        }
        return pind;
    }
    static void swap(int interval[][],int s,int e)
    {
        int temp[]=interval[s];
        interval[s]=interval[e];
        interval[e]=temp;
    }
    public static void main(String[] args) {
        //int interval[][]={{2,4},{6,9},{1,7},{4,7}};
        int interval[][]={{1,3},{2,4},{6,8},{9,10}};
        sort(interval,0,interval.length-1);
        int stack[][]=new int[interval.length][2];
        stack[0][0]=interval[0][0];
        stack[0][1]=interval[0][1];
        int top=0;
        int ind=1;
        while(ind!=interval.length)
        {
            if(stack[top][1]>=interval[ind][0])
            {
                stack[top][1]=interval[ind][1];
            }
            else
            {
                top++;
                stack[top]=interval[ind];
            }
            ind++;
        }
        for(int i=0;i<=top;i++)
        {
            for(int j=0;j<stack[i].length;j++)
            {
                System.out.print(stack[i][j]+" ");
            }
            System.out.println();
        }
    }

}
