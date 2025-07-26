// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1); // Initialize result with -1, as default is no greater element

        Stack<Integer> st = new Stack<>(); // Stack to store indices of elements

        // Loop twice through the array to simulate circular nature
        for (int i = 0; i < 2 * n; i++) {
            // While current element is greater than the element at index stored on top of the stack
            // That means we found the next greater element for index at top of stack
            while (!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
                int poppedIdx = st.pop(); // Get the index
                res[poppedIdx] = nums[i % n]; // Assign the next greater element
            }

            // Only push indices from the first pass (i < n) to the stack
            // Second pass is only to resolve circular lookups
            if (i < n) {
                st.push(i % n);
            }
        }

        return res;
    }
}
