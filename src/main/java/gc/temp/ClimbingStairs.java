package gc.temp;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(10));
	}

	public static int climbStairs(int n) {
		int one = 1;
		int two = 2;
		int result = 0;
		if (n == 1)
			return one;
		else if (n == 2)
			return two;
		else {
			for (int i = 3; i <= n; i++) {
				result = one + two;
				one = two;
				two = result;
			}
		}
		return result;
	}

}
