
class Solution {
    public List<List<Integer>> CombinationSum2(int[] arr, int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr); // Sort the array to handle duplicates
        
        List<Integer> path = new ArrayList<>();
        helper(0, arr, 0, k, path, ans);
        
        return ans;
    }
    
    public void helper(int ind, int[] arr, int sum, int k, List<Integer> path, List<List<Integer>> ans) {
        if (sum > k) return; // If sum exceeds k, terminate
        if (sum == k) {
            ans.add(new ArrayList<>(path)); // Add a copy of path to ans
            return;
        }
        
        for (int i = ind; i < arr.length; i++) {
            // Skip duplicates
            if (i > ind && arr[i] == arr[i - 1])
                continue;
            
            sum += arr[i];
            path.add(arr[i]);
            helper(i + 1, arr, sum, k, path, ans);
            path.remove(path.size() - 1);
            sum -= arr[i];
        }
    }
}
