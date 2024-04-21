
class Solution {
    public int maximumDifference(int[] nums) {
        // If the array has less than 2 elements, return -1 as we can't find a difference
        if(nums.length < 2)
            return -1;

        // Initialize the maximum difference and the minimum element with the first two elements of the array
        int max_dif = nums[1] - nums[0];
        int min_element =  nums[0];
        int cur_dif = max_dif;

        // Iterate over the array starting from the first index
        for(int i=0;i<nums.length;i++){
            // If the current element is less than the minimum element found so far, update the minimum element
            if(nums[i] < min_element)
                min_element = nums[i];
            else{
                // Calculate the current difference as the difference between the current element and the minimum element
                cur_dif = nums[i] - min_element;
                // If the current difference is greater than the maximum difference found so far, update the maximum difference
                if(cur_dif > max_dif)
                    max_dif = cur_dif;
            }
        }

        // If the maximum difference is 0, it means all elements are the same, so return -1
        if(max_dif == 0)
            return -1;

        // Return the maximum difference
        return max_dif;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 10, 6, 4, 8, 1};
        int maxDifference = solution.maximumDifference(nums);
        System.out.println("The maximum difference is: " + maxDifference);
    }
}