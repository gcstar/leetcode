package array;

import java.util.*;

/**
 * Created by guchao on 19/1/4.
 * leetcode 414
 */
public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {


        Set<Integer> set = new HashSet();
        for (int n : nums) {
            set.add(n);
        }
        int[] distictNums = new int[set.size()];
        int index = 0;


        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            distictNums[index++] = next;
        }

        if (distictNums.length == 1) return distictNums[0];
        if (distictNums.length == 2) return Math.max(distictNums[0], distictNums[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < 3; i++) {
            queue.add(distictNums[i]);
        }
        for (int i = 3; i < distictNums.length; i++) {
            int num = queue.peek();
            if (distictNums[i] >= num) {
                queue.remove();
                queue.add(distictNums[i]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1, 2, 2, 3}));
    }
}
