
public class CharDIff {
    public static void main(String[] args) {
        String s1="Zoho Corp India";
        String s2="Zoho Crop Ioeij";
        int i=0,j=0;
        String ss1,ss2;
        while(i<s1.length() && j<s2.length())
        {
            ss1="";
            ss2="";
            if(s1.charAt(i)==s2.charAt(j))
            {
                i++;
                j++;
                continue;
            }
            while(s1.charAt(i)!=s2.charAt(j))
            {
                ss1+=s1.charAt(i);
                ss2+=s2.charAt(j);
                if(i==s1.length()-1 || j==s2.length()-1)
                {
                    System.out.println(ss1+" , "+ss2);
                    return;
                }
                i++;
                j++;
            }
            System.out.println(ss1+" , "+ss2);
            
        }
    }
}
