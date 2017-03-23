package gc.temp;

public class SingleNumber {

	public static void main(String[] args) {
//			System.out.println(12^12);
		int[] a = {1,1,2,3,4,2,3,4,6};
		System.out.println(findSingleNumber(a));
	}

	private static int findSingleNumber(int[] a) {
		int result = 0;
		for(int i:a){
			result ^=i;
		}
		return result;
	}

}
