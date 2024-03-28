//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    Node (int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        PriorityQueue<Node> heap = new PriorityQueue<>((a,b)-> {
            if(a.data == b.data){
                return 1;
            }
            return a.data - b.data;
        } );
        for(int i=0; i<f.length; i++){
            heap.add(new Node(f[i]));
        }
        while(heap.size()>=2){
            Node temp1 = heap.remove();
            Node temp2 = heap.remove();
            heap.add(new Node(temp1.data+temp2.data, temp1, temp2));
        }
        Node tree = heap.remove();
        ArrayList<String> ans = new ArrayList<>();
        findCode(tree,"", ans);
        return ans;
    }
    public void findCode(Node root, String str, ArrayList<String> ans){
        if(root==null)
        return ;
        if(root.left==null && root.right== null){
            ans.add(str);
            return;
        }
        findCode(root.left,str+"0", ans);
        findCode(root.right,str+"1", ans);
        
        
    }
}

