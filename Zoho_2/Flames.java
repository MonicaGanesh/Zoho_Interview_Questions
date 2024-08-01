public class Flames {
    public static void main(String[] args) {
        String pair1="suriya";
        String pair2="jothika";
        String unique="";
        String flames="FLAMES";
        int len1=pair1.length();
        int len2=pair2.length();
        int visited2[]=new int[len2];
        int visited1[]=new int[len1];
        for(int i=0;i<len1;i++)
        {
            for(int j=0;j<len2;j++)
            {
                if(visited2[j]==0 && pair1.charAt(i)==pair2.charAt(j))
                {
                    visited2[j]=1;
                    visited1[i]=1;
                    break;
                }
            }
        }
        for(int i=0;i<len1;i++)
        {
            if(visited1[i]==0)
            {
                unique+=pair1.charAt(i);
            }
        }
        for(int i=0;i<len2;i++)
        {
            if(visited2[i]==0)
            {
                unique+=pair2.charAt(i);
            }
        }
        System.out.println(unique);
        int strlen=unique.length();
        int len=flames.length();
        int visited[]=new int[len];
        int ind=0;
        int flen=len;
        while(len!=1)
        {
            int cnt=strlen%len;
            if(cnt==0)
                cnt=len;
            //System.out.println(cnt);
            while(cnt!=0)
            {
                if(visited[ind]==0)
                {
                    cnt--;
                    //System.out.println(flames.charAt(ind)+" ^^^ "+ind);
                }
                if(visited[ind]==0 && cnt==0)
                {
                    visited[ind]=1;
                    break;
                }
                ind++;
                if(ind==flen)
                {
                    ind=0;
                    continue;
                }

            }
            len--;
        }
        len=flames.length();
        for(int i=0;i<len;i++)
        {
            if(visited[i]==0)
            {
                System.out.println(flames.charAt(i));
            }
        }
    }
}
