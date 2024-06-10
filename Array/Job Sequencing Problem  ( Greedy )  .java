/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/

class Solution{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n){
        // Your code here
        
        Arrays.sort(arr, Comparator.comparingInt(job -> -job.profit));
        int mx = 0;
        for( Job x : arr ) mx = Math.max( mx , x.deadline);
        
        int[] hash = new int[mx+1];
        Arrays.fill( hash , -1);
        
        int maxProfit = 0;
        int jobDone = 0;
        
        for( int i=0 ; i < n ; i++ ){
            
            Job job = arr[i];
            for( int j = job.deadline ; j > 0 ; j--){
                
                if( hash[j] == -1 ){
                    
                    hash[j] = job.deadline;
                    maxProfit += job.profit;
                    jobDone++;
                    break;
                }
            }
        }
        
        int[] ans = new int[2];
        ans[0] = jobDone;
        ans[1] = maxProfit;
        
        return ans;
    }
}
