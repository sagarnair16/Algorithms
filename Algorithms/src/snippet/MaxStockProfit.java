package snippet;

public class MaxStockProfit {
	
	public static void main(String[] args){
		
		int[] arr={7, 1, 5, 3, 6, 4};
		profit(arr);
		
	}
	
	public static void profit(int[] arr){
	int min=arr[0];
	int max=Integer.MIN_VALUE;
	for(int i=1;i<arr.length;i++){
		if(arr[i]<min){
			min=arr[i];
		}
		else max=Math.max(max, arr[i]-min);
	}
	System.out.println(max);
	}

}
