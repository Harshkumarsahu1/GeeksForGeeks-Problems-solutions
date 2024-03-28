//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String arr[] = in.readLine().trim().split("\\s+");
            int S = Integer.parseInt(arr[0]);
            int N = Integer.parseInt(arr[1]);
            int M = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.minimumDays(S, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumDays(int s, int n, int m){
        // code here
        if(n<m){
            return -1;
        }
        int sundays=s/7;
        int buyingdays=s-sundays;
        int check=n/m;
        int count=0;
       int total=s*m;
        if(s*m%n==0){
            count=total/n;
        }else{
            count=(total/n)+1;
        }
        if(count>buyingdays){
            return -1;
        }
        return count;
    }
}