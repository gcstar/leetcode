package gc.temp;

public class IsUgly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(21));

	}
	
	private static boolean isUgly(int n){
		if(n ==0 )return false;
		boolean result = true;
		while(n!=1){
			if( n % 2 ==0){
				 n = n /2;
			}else if( n % 3 == 0){
				n = n /3;
			}else if(n % 5 ==0){
				n = n /5;
			}else {
				result = false;
				break;
			}
		}
		return result;
	}

}
