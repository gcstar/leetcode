package zk;

/**
 * Created by guchao on 18/12/17.
 */
public class DistributedLockTest {

    public static void main(String... args) {
        new Thread(() -> {
            DistributedLock lock = null;
            try {
                lock = new DistributedLock("localhost:2181", "test1");
                lock.lock();
                Thread.sleep(1000L);
                System.out.println("Thread " + Thread.currentThread().getName() + " running");

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (lock != null) {
                    lock.unlock();
                }
            }
        }).start();


        try {
            Thread.sleep(1000L);
        } catch (Exception ex) {

        }
        ConcurrenttTest.ConcurrenttTask[] tasks = new ConcurrenttTest.ConcurrenttTask[60];

        for (int i = 0; i < tasks.length; i++) {
            ConcurrenttTest.ConcurrenttTask task1 = new ConcurrenttTest.ConcurrenttTask() {
                @Override
                public void run() {
                    DistributedLock lock = null;
                    try {
                        lock = new DistributedLock("localhost:2181", "test1");
                        lock.lock();
                        System.out.println("Thread " + Thread.currentThread().getName() + " runnning");
                    } catch (Exception ex) {
                    } finally {
                        if (lock != null) {
                            lock.unlock();
                        }
                    }

                }
            };

            tasks[i] = task1;
        }

        new ConcurrenttTest(tasks);


    }
}
