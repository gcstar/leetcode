package gc.temp;

public class IsPowerOfTwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(3));
	}

	private static boolean isPowerOfTwo(int n) {
		if(n<=0) return false;
		boolean result = true;
		int time = 0;
		while(n != 0){
			if((n & 1) == 1) time++;
			n >>>= 1;
		}
		return time == 1?true:false;
	}

}
