class Node{
    int value;
    Node left;
    Node right;
    Node(int value)
    {
        this.value=value;
        this.left=null;
        this.right=null;
    }
}
public class Tree_Min {
    static int findMin(int data[],int start,int end)
    {
        int mini=start;
        for(int i=start+1;i<=end;i++)
        {
            if(data[i]<data[mini])
            {
                mini=i;
            }
        }
        return mini;
    }
    public static Node solve(Node root,int data[], int start,int end)
    {
        if(start>end)
        {
            return null;
        }
        int mini=findMin(data, start, end);
        root=new Node(data[mini]);
        //System.out.println(root.value);
        root.left=solve(root,data, start, mini-1);
        root.right=solve(root,data, mini+1, end);
        return root;
    }
    public static void preorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        preorder(root.left);
        System.out.print(root.value+" ");
        preorder(root.right);
    }
    public static void main(String[] args) {
        
        int data[]={12,25,34,77,20,2,5,61,6,18,3,32,9};
        int start=0,end=data.length-1;

        Node root=null;
        Node ans=solve(root,data,start,end);
        preorder(ans);
    }
}
