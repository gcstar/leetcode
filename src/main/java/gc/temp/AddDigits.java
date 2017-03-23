package gc.temp;

import java.util.Scanner;

public class AddDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int i = sc.nextInt();
			calculate(i);
		}

	}
	
	public static void calculate(int i ){
		int result = 0;
		while(i !=0){
			int j = i % 10;
			result+=j;
			i /=10;
		}
		if(result>10){
			calculate(result);
		}else{
			System.err.println(result);
		}
	}

}
