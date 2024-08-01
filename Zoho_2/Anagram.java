public class Anagram {
    public static void main(String[] args) {
        //String s1="zzaab";
        //String s2="zzzab";
        String s1="silent";
        String s2="listen";
        int j=0;
        if(s1.length()!=s2.length())
        {
            System.out.println("Not Anagram");
            return;
        }
        int visited[]=new int[s2.length()];
        for(int i=0;i<s2.length();i++)
        {
            for(j=0;j<s2.length();j++)
            {
                if(s1.charAt(i)==s2.charAt(j) && visited[j]==0)
                {
                    visited[j]=1;
                    break;
                }
            }
        }
        for(int i=0;i<s1.length();i++)
        {
            if(visited[i]==0)
            {
                System.out.println("Not Anagram");
                return;
            }
        }
        System.out.println("Anagram");
    }
}
