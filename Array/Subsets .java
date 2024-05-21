
class Solution {
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> out, int index) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(out));
            return;
        }
        // Exclude
        helper(nums, res, out, index + 1);
        // Include
        int elmt = nums[index];
        out.add(elmt);
        helper(nums, res, out, index + 1);
        out.remove(out.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        int index = 0;
        helper(nums, res, out, index);
        return res;
    }
}
