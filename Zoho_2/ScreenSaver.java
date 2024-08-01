public class ScreenSaver {
    public static void main(String[] args) {
        int width=40;
        int height=30;
        int iter=50;
        String str="ZOHO";
        int curr_width_start=0,curr_height=0;
        int i=0;
        int len=str.length()-1;
        while(i!=iter)
        {
            while((curr_width_start+len!=width-1) && curr_height!=height-1 && i!=iter)
            {
                System.out.println("("+curr_height+","+curr_width_start+")");
                curr_height++;
                curr_width_start++;
                i++;
            }
            while((curr_width_start+len!=width-1) && curr_height!=0 && i!=iter)
            {
                System.out.println("("+curr_height+","+curr_width_start+")");
                curr_height--;
                curr_width_start++;
                i++;
            }
            while(curr_width_start!=0 && curr_height!=0 && i!=iter)
            {
                System.out.println("("+curr_height+","+curr_width_start+")");
                curr_height--;
                curr_width_start--;
                i++;
            }
            if(curr_width_start!=0 && curr_height!=height-1 && i!=iter)
            {
                System.out.println("("+curr_height+","+curr_width_start+")");
                curr_height++;
                curr_width_start--;
                i++;
            }

        }
    }
}
