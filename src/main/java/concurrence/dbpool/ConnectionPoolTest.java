package concurrence.dbpool;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by guchao on 18/12/14.
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws Exception {
        int threadCount = 500;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new CountRunner(count, got, notGot), "ConnectionRunner");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke:" + (threadCount * count));
        System.out.println("total got:" + got);
        System.out.println("total notGot:" + notGot);

    }

    static class CountRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public CountRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {

            }
            while (count > 0) {
                try {
                    Connection connection = pool.getConnection(100);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (Exception e) {

                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }

                } catch (InterruptedException e) {

                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}