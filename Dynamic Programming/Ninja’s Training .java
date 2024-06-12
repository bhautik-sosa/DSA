
import java.util.Arrays;
public class Solution {
    public static int ninjaTraining(int days, int points[][]) {

        // int[][] dp = new int[days][4];
        // for( int i=0 ; i < days ; i++ ){
        //     Arrays.fill(dp[i] , -1);
        // }
        // return helper( day-1 , 3 , points , dp);

        // Tabulation :- 

            // dp[0][0] = Math.max( points[0][1] , points[0][2]);
            // dp[0][1] = Math.max( points[0][0] , points[0][2]);
            // dp[0][2] = Math.max( points[0][0] , points[0][1]);
            // dp[0][3] = Math.max( points[0][1] , Math.max(points[0][2] , points[0][0]) );

            // for( int day=1 ; day < days ; day++ ){

            //     for( int last = 0 ; last < 4 ; last++){

            //         dp[day][last] = 0;

            //         for(int i=0 ; i < 3 ; i++){

            //             if( i != last ){
            //                 int pnt = points[day][i] + dp[day-1][i];
            //                 dp[day][last] = Math.max( dp[day][last] , pnt);
            //             }
            //         }
            //     }
            // }

            // return dp[days-1][3];

            int[] prev = new int[4];
            prev[0] = Math.max( points[0][1] , points[0][2]);
            prev[1] = Math.max( points[0][0] , points[0][2]);
            prev[2] = Math.max( points[0][0] , points[0][1]);
            prev[3] = Math.max( points[0][1] , Math.max(points[0][2] , points[0][0]) );

            for( int day =1 ; day < days ; day++){
                
                int[] temp = new int[4];

                for( int last = 0 ; last < 4 ; last++){

                    for( int i=0 ; i < 3 ; i++){
                        
                        if( i != last ){
                            temp[last] = Math.max( temp[last] , points[day][i] + prev[i]);
                        }
                    }
                }

                prev = temp;
            }

            return prev[3];

    }


    // Memoization :-
        public static int helper( int day , int last , int[][] points , int[][] dp){

            if( day == 0 ){
                int max = 0;
                for( int i=0 ; i < 3 ; i++ ){
                    if( i != last ) max = Math.max( max ,  points[0][i]);
                }
                return max;
            }
            
            if( dp[day][last] != -1 ) return dp[day][last];

            int max = 0;
            for( int i=0 ; i < 3 ; i++ ){
                if( i != last ){
                    int pnt = points[day][i] + helper(day-1 , i , points, dp);
                    max = Math.max( max , pnt);
                }
            }
            return dp[day][last] = max;
        }

}
