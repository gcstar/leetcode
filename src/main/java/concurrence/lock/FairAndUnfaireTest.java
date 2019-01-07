package concurrence.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by guchao on 18/12/14.
 */
public class FairAndUnfaireTest {

    private static ReentrantLock2 fair = new ReentrantLock2(true);
    private static ReentrantLock2 unFair = new ReentrantLock2(false);


    public static void main(String[] args) {
        int count = 5;
        List<Thread> fairList = new ArrayList<>(count);
        List<Thread> unFairList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            Thread fairThread = new Thread(() -> {
                fair.lock();
                try {
                    Thread.sleep(1000);
                    System.out.println(fair.getQueuedThreads());
                } catch (Exception e) {
                } finally {
                    fair.unlock();
                }

            }, "fair-thread-" + i);
            Thread unFairThread = new Thread(() -> {
                unFair.lock();
                try {
                    Thread.sleep(1000);
                    System.out.println(unFair.getQueuedThreads());
                } catch (Exception e) {
                } finally {
                    unFair.unlock();
                }
            }, "unfair-thread-" + i);

            fairList.add(fairThread);
            unFairList.add(unFairThread);
        }
        for (Thread thread : fairList) {
            thread.start();
        }
        for (Thread thread : unFairList) {
            thread.start();
        }

    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> list = new ArrayList(super.getQueuedThreads());
            Collections.reverse(list);
            return list;
        }
    }
}
