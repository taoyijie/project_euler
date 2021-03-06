package level5;

import java.util.Arrays;

public class P114 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len = 50;
		int minLen = 3;
		
		long[][] dp = new long[len+1][len+1];
		for(int i=0;i<dp.length;i++){
			dp[0][i] = 1;
		}
		for(int i=0;i<dp.length;i++){
			Arrays.fill(dp[i], 1);
		}
		for(int j=3;j<dp.length;j++){
			for(int i=1;i<dp.length;i++){				
				if(i>=j+1){
					dp[i][j] = dp[i-1][j];
				}
				for(int l=minLen;l<=j;l++){
					if(i>=l+1)
						dp[i][j] += dp[i-l-1][j];
				}
				if(i==j)
					dp[i][j] = dp[i][j-1] + 1;
				if(i<j)
					dp[i][j] = dp[i][i];
			}
			
		}
		for(int i=0;i<len+1;i++)
			System.out.println(Arrays.toString(dp[i]));
	}
}
