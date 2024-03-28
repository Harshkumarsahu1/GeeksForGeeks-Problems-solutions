//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
       int max_deadline =0;
       int max_profit=0;
       
       //fetching the max_deadline to make a timeline array
       for(int i=0;i<arr.length;i++){
           max_deadline=Math.max(max_deadline,arr[i].deadline);
       }
       
       //making the timeline array
       boolean timeline[]=new boolean[max_deadline];
       for(int i=0;i<timeline.length;i++){
           timeline[i]=false;
       }
       
       //sorting the profits
       Arrays.sort(arr,(a,b)->b.profit-a.profit);
       
       int res[]=new int[2];
       
       int count=0;
       //finding the best slot according to profit
       for(int i=0;i<arr.length;i++){
           for(int j=arr[i].deadline-1;j>=0;j--){
               if(timeline[j]==false){
                   max_profit=max_profit+arr[i].profit;
                   timeline[j]=true;
                   count++;
                   res[0]=count;
                   res[1]=max_profit;
                   break;
               }
           }
       }
       return res;
    }
}