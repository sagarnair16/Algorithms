package snippet;

public class MaxSubArray {
	
	public static void main(String[] args){
		
		int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
		maxSub(arr);
		
	}
	
	public static void maxSub(int[] arr){
		int j,i=0,max=Integer.MIN_VALUE;
		while(i<arr.length){
			int sum=0;
			j=i;
			while(j<arr.length && sum>=0){
				sum=sum+arr[j];
				max=Math.max(max, sum);
				j++;
			}
			if(sum<1) i=j;
			else i++;
		}
		System.out.println(max);
	}

}
