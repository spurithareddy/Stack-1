// Time Complexity : O(N), where N is the number of temperatures.
//                   Each element is pushed and popped from the stack at most once.
// Space Complexity : O(N) for the stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Approach: 
// Iterate from the end of the array to the start. 
// Maintain a decreasing stack of temperature values and their indices.
// For each temperature, pop all temperatures from the stack that are less than or equal to the current temperature.
// The top of the stack (after popping) will be the next warmer temperature.
// The difference of indices gives the number of days to wait.

class Pair {
    int first;  // temperature
    int second; // index

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Pair> st = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek().first <= temperatures[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                res[i] = st.peek().second - i;
            }
            st.push(new Pair(temperatures[i], i));
        }
        return res;
    }
}


// Time Complexity : O(N), where N is the number of temperatures.
//                   Each element is pushed and popped from the stack at most once.
// Space Complexity : O(N) for the stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Approach: 
// Iterate from the end of the array to the start. 
// Maintain a decreasing stack of  their indices.
// For each temperature, pop all temperatures from the stack that are less than or equal to the current temperature.
// The top of the stack (after popping) will be the next warmer temperature.
// The difference of indices gives the number of days to wait

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int [] res = new int [len];
        Stack<Integer> st = new Stack<>();
        for(int i = len - 1; i >= 0; i--){
            int in = i;
            while(!st.isEmpty() && st.peek() <= temperatures[i]){
                st.pop();
                in = st.pop();
            }
            if(!st.isEmpty()){
                int val = st.pop();
                res[i] = st.peek() - i;
                st.push(val);
            }
            st.push(i);
            st.push(temperatures[i]);
            
            
        }
        return res;        
    }
}