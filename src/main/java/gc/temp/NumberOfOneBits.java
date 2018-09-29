package gc.temp;

public class NumberOfOneBits {

	public static void main(String[] args) {
		System.out.println(hammingWeight(21341234));
	}
	
	private static int hammingWeight(int n){
		int result = 0;
		while(n  !=0){
			result = result +(n & 1 );
			n  = n>>>1;//无符号右移
		}
		return result;
	}

}
