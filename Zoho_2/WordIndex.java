public class WordIndex {
    public static void main(String[] args) {
        String str="I live in Madurai";
        String subStr="in";
        int len1=str.length();
        int i=0,j=0,start=-1;
        int len2=subStr.length();

        while(len1!=i)
        {
            while(str.charAt(i)!=subStr.charAt(j))
            {
                i++;
            }
            start=i;
            j=0;
            while(str.charAt(i)==subStr.charAt(j))
            {
                i++;
                j++;
                if(j==len2)
                {
                    System.out.println(start);
                    return;
                }
                if(i==len1)
                {
                    start=-1;
                    System.out.println(start);
                    return;
                }
            }
            i=start+1;
            j=0;
            start=-1;
        }
    }
}
