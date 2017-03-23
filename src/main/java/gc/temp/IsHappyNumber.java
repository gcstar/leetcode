package gc.temp;

public class IsHappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(11));
		
	}

	public  static boolean isHappy(int n) {
		int nextN = 0;
		int divide = n;
		while(divide!=0){
			int yushu = divide % 10;
			nextN += Math.pow(yushu, 2);
			divide /=10;
		}
		if(nextN!= n || nextN !=1){
			return isHappy(nextN);
		}
		return true;
	}

}
