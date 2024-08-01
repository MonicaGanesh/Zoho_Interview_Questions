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
public class Tree_Min_No_Recursion {
    static Node insertData(Node nn,Node root)
    {
        Node temp=null;
        if(root==null)
        {
            root=nn;
        }
        else if(root.value>nn.value)
        {
            temp=root;
            root=nn;
            root.left=temp;
        }
        else
        {
            root.right=insertData(nn,root.right);
        }
        return root;
    }
    public static Node solve(int data[])
    {
        Node root=null;
        Node nn;
        for(int i=0;i<data.length;i++)
        {
            nn=new Node(data[i]);
            root=insertData(nn,root);      
        }
        return root;
    }
    public static void inorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.value+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        
        int data[]={7,5,8};
        Node ans=solve(data);
        ans=insertData(new Node(6),ans);
        inorder(ans);
    }
}