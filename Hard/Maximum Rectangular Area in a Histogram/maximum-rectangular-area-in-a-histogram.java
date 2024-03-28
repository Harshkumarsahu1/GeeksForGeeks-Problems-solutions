//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
public static long getMaxArea(long hist[], long n) {
    return largestRectangleArea(hist);
}

public static long largestRectangleArea(long[] heights) {
    int n = heights.length;
    Stack<Long> st = new Stack<>();
    long leftSmall[] = new long[n];
    long rightSmall[] = new long[n];
    for (int i = 0; i < n; i++) {
        while (!st.isEmpty() && heights[st.peek().intValue()] >= heights[i]) {
            st.pop();
        }

        if (st.isEmpty()) leftSmall[i] = 0;
        else leftSmall[i] = st.peek() + 1;
        st.push((long) i);
    }

    // clear the stack to be re-used
    while (!st.isEmpty()) st.pop();

    for (int i = n - 1; i >= 0; i--) {
        while (!st.isEmpty() && heights[st.peek().intValue()] >= heights[i]) {
            st.pop();
        }

        if (st.isEmpty()) rightSmall[i] = n - 1;
        else rightSmall[i] = st.peek() - 1;

        st.push((long) i);
    }

    long maxA = 0;
    for (int i = 0; i < n; i++) {
        maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
    }
    return maxA;
}

        
}



