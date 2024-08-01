public class Array_Pos {
    public static void main(String[] args) {
        int array[]={15,10,5,3,25,35,1};
        int len=array.length;
        int even_array[]=new int[len];
        int odd_array[]=new int[len];
        int cnt1=0,cnt2=0;
        for(int i=0;i<len;i++)
        {
            if(array[i]%2==0)
            {
                even_array[cnt1++]=array[i];
            }
            else
            {
                odd_array[cnt2++]=array[i];
            }
        }
        for(int i=0;i<cnt1;i++)
        {
            System.out.print(even_array[i]+" ");
        }
        System.out.println();
        for(int i=0;i<cnt2;i++)
        {
            System.out.print(odd_array[i]+" ");
        }
    }
}
