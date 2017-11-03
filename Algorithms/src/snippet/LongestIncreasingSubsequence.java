package snippet;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args){
		int[] arr={2,2};
		System.out.println(lis(arr));
	}

	private static int lis(int[] nums) {
		if(nums.length==0) return 0;
		if(nums.length==1) return 1;
		
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int i=0,j=0;
		int max=1;
		for(i=1;i<nums.length;i++){
			for(j=0;j<i;j++){
				if(nums[j]<nums[i]){
					dp[i]=Math.max(dp[i], dp[j]+1);
					max=Math.max(max, dp[i]);
				}
			}
		}
		return max;
		
	}

}
