//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node Reverse(Node head){
        Node nn=null;
        Node cn=head;
        Node prev=null;
        Node next=null;
        
        while(cn!=null){
            nn=cn.next;
            cn.next=prev;
            prev=cn;
            cn=nn;
        }
        
        return prev;
    }
    public static Node addOne(Node head) 
    { 
        if(head.next==null){
            head.data+=1;
            return head;
        }
        
        Node temp=Reverse(head);
        Node k=temp;
        int carry=1;
        while(temp!=null){
            int val=temp.data+carry;
            if(val<9){
                temp.data=val;
                Node ans=Reverse(k);
                return ans;
            }
            else{
                temp.data=val%10;
                carry=val/10;
            }
            
            temp=temp.next;
        }
        
        if(carry==1){
            Node header=new Node(1);
            header.data=1;
            header.next=head;
            head=header;
            Node ans2=Reverse(k);
            return head;
            
            
        }
        
        Node ans3=Reverse(k);
        return ans3;
        
    }
}