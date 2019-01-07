package concurrence.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guchao on 18/12/14.
 */
public class MutexTest {
    private static int count = 0;

    private static Mutex mutex = new Mutex();

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 1000;
        List<Thread> threadList = new ArrayList<>(10);
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                mutex.lock();
                for (int j = 0; j < 1000; j++) {
                    count++;
                }
                mutex.unlock();
            });
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.start();
        }

        System.out.println("count=" + count);
    }
}
