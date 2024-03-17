//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head==null || head.next==null){
            return head;
        }
        Node mid=FindMid(head);
        Node left=head;
        Node right=mid.next;
        mid.next=null;
        left=mergeSort(left);
        right=mergeSort(right);
        return merge(left,right);
        
    }
    static Node FindMid(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    static Node merge(Node left,Node right){
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(left!=null && right!=null){
            if(left.data<=right.data){
                temp.next=new Node(left.data);
                temp=temp.next;
                left=left.next;
            }else{
                temp.next=new Node(right.data);
                temp=temp.next;
                right=right.next;
            }
        }
        while(left!=null){
             temp.next=new Node(left.data);
                temp=temp.next;
                left=left.next;
        }
        while(right!=null){
            temp.next=new Node(right.data);
            temp=temp.next;
            right=right.next;
        }
        return dummy.next;
    }
}


