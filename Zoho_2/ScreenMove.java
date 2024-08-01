public class ScreenMove {
        public static void main(String[] args) 
        {
            int width=40;
            int height=30;
            int iter=200;
            String str="ZOHO";
            int curr_width_start=0,curr_height=0;
            int i=0;
            int len=str.length()-1;
            String dir_vertical="Bottom";
            String dir_horizontal="Right";
            while(i!=iter)
            {
                if((dir_vertical.equals("Bottom") && curr_height!=height-1)||(curr_height==0))
                {
                    System.out.print("  B ");
                    dir_vertical="Bottom";
                    curr_height++;
                }
                else if((dir_vertical.equals("Top") && curr_height!=0)||(curr_height==height-1))
                {
                    System.out.print("  T ");
                    dir_vertical="Top";
                    curr_height--;
                }
                if((dir_horizontal.equals("Right") && curr_width_start+len!=width-1)||(curr_width_start==0))
                {
                    System.out.print("  R ");
                    dir_horizontal="Right";
                    curr_width_start++;
                }
                else if((dir_horizontal.equals("Left") && curr_width_start!=0)||(curr_width_start+len==width-1))
                {
                    System.out.print("  L ");
                    dir_horizontal="Left";
                    curr_width_start--;
                }
                System.out.print("("+curr_height+","+curr_width_start+")");
                i++;
                System.out.println(); 
            }
        }
    }    

