package gc.temp;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
			System.out.println(titleToNumber("AZ"));
	}

	public static int titleToNumber(String s) {
		int result = 0;
		int pow = 0;
		char[] chars = s.toCharArray();
		for(int i = chars.length -1 ;i >= 0;i--){
			result +=  (int)(chars[i] - 64) * Math.pow(26, pow++);
		}
		return result;
	}

}
