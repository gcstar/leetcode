package zk;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by guchao on 18/12/17.
 */
public class ConcurrenttTest {
    public interface ConcurrenttTask {
        void run();
    }

    private CountDownLatch begin = new CountDownLatch(1);
    private CountDownLatch end;
    private CopyOnWriteArrayList<Long> list = new CopyOnWriteArrayList<>();
    private AtomicInteger err = new AtomicInteger();
    private ConcurrenttTask[] tasks = null;

    public ConcurrenttTest(ConcurrenttTask[] tasks) {
        this.tasks = tasks;
        if (tasks == null) {
            System.exit(1);
        }
        end = new CountDownLatch(tasks.length);
        start();

    }

    private void start() {
        createThread();
        begin.countDown();
        try {
            end.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
        }

        getExctuctionTime();


    }

    private void createThread() {
        long length = end.getCount();
        for (int i = 0; i < length; i++) {
            final int j = i;
            new Thread(() -> {
                try {
                    begin.await();
                    long start = System.currentTimeMillis();
                    tasks[j].run();
                    long end = (System.currentTimeMillis() - start);
                    list.add(end);

                } catch (Exception ex) {
                    err.incrementAndGet();
                }
                end.countDown();
            }).start();
        }
    }

    private void getExctuctionTime() {

        int size = list.size();
        Collections.sort(list);
        long min = list.get(0);
        long max = list.get(size - 1);
        long sum = 0;
        for (long i : list) {
            sum += i;
        }
        long avg = sum / size;
        System.out.println("max:" + max + ",min:" + min + ",sum:" + sum + ",avg:" + avg);

    }

}
