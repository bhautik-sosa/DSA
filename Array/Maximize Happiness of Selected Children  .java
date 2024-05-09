
class Solution {
    public long maximumHappinessSum(int[] h, int k) {
        long max=0;
        int c=0,value=0;
        Arrays.sort(h);
        for(int i=h.length-1;i>=h.length-k;i--)
        {
            value = h[i]-c++;
            if(value>0)
            {
                max += value;
            }
        }
        return max;
    }
