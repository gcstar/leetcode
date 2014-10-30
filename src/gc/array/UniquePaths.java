package gc.array;

import java.math.BigInteger;

import org.junit.Test;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] value;
		if (m <= 0 || n <= 0) {
			return 0;
		}
		if (m == 1 && n == 1) {
			return 1;
		} else if (m == 1 && n == 2) {
			return 1;
		} else if (m == 2 && n == 1) {
			return 1;
		} else {
		    value = new int[100][100];
		    value[0][1]=value[0][0]=value[1][0]=1;
		    for(int i = 2;i<100;i++){
		    	value[0][i] =1;
		    }
		    for(int j = 2;j<100;j++){
		    	value[j][0] =1;
		    }
		    for(int i = 1;i<100;i++){
		    	for(int j=1;j<100;j++){
		    		value[i][j]=value[i-1][j]+value[i][j-1];
		    	}
		    }
		}
		return value[m-1][n-1];

	}


	@Test
	public void test(){
		System.out.println(uniquePaths(100, 100));
	}

}
