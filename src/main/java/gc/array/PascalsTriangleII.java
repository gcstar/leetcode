package gc.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		if(rowIndex == 0){
			list.add(1);
			return list;
		}else if(rowIndex==1){
			list.add(1);
			list.add(1);
			return list;
		}else {
			list.add(1);
			list.add(1);
			for(int i=1;i<rowIndex;i++){
				list.add(i, list.get(i-1)+list.get(i));
			}
			return list;
		}
  }
	@Test
	public void test(){
		System.out.println(getRow(4));
	}
}