package gc.temp;

public class TrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(1808548329));

	}
	
	private static int trailingZeroes(int n){
		int count = 0;
	while(n>1){
		count+=n/5;
		n/=5;
	}
		return count;
	}

}
