package gc.array;

import org.junit.Test;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int removed = 0;
		for(int i=0;i<A.length;i++){
			if(A[i]== elem){
				removed++;
			}else {
				A[i-removed] = A[i];
			}
		}
		return A.length - removed;
	}
	
	@Test
	public void test(){
		int[] a = new int[]{1,2,3,4,51,2,3,45,23,2};
		int i = removeElement(a, 2);
		System.out.println(i);
	}
}
