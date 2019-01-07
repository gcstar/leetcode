package concurrence.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by guchao on 18/12/14.
 */
public class TwinsLockTest {
    private static final TwinsLock lock = new TwinsLock();

    private static ReentrantLock reentrantLock = new ReentrantLock();


    public static void main(String[] args) {
        int count = 10;
        List<Thread> list = new ArrayList<>(10);
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(new Worker(), "Thread-" + i);
            list.add(thread);
        }

        for (Thread thread : list) {
            thread.start();
        }


    }

    private static class Worker implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("current thread:" + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }

        }
    }
}
