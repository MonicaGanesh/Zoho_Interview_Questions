public class MaxStrLen {
    public static void main(String[] args) {
        String str="I ambhjjhjk from ABCjscdc";
        int char_cnt=0;
        int max_char_cnt=0;
        int len=str.length();
        int start=0;
        int max_start=0;
        for(int i=0;i<len;i++)
        {
            if(str.charAt(i)!=' ')
            {
                char_cnt++;
            }
            if(str.charAt(i)==' ' || i==len-1)
            {
                if(char_cnt>max_char_cnt)
                {
                    max_char_cnt=char_cnt;
                    max_start=start;
                }
                start=i;
                char_cnt=0;
            }
        }
        for(int i=max_start;i<=max_start+max_char_cnt;i++)
        {
            System.out.print(str.charAt(i));
        }
    }
}