package easy.two_sum_1;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		int[] a = {2,7,11,15};
		int[] twoSum = twoSum(a,9);
	}

    public static int[] twoSum(int[] nums, int target) {
    	Stack<Integer> st1 = new Stack<>();
    	Stack<Integer> st2 = new Stack<>();
    	st2.add(1);
    	boolean value = !(st1.isEmpty() && st2.isEmpty());
    	System.out.println(value);
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            if(!map.isEmpty()){
                if(map.containsKey(target-n))
                {
                    int index = map.get(target-n);
                    ans[0] = i;
                        ans[1] = index;
                    return ans;
                    }
            }
            map.put(n,i);
        }
        return ans;
    }
}
