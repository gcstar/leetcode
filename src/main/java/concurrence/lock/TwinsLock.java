package concurrence.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by guchao on 18/12/14.
 */
public class TwinsLock implements Lock {

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException();
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int count) {
            for (; ; ) {
                int current = getState();
                int remain = current - count;
                if (remain < 0 || compareAndSetState(current, remain)) {
                    return remain;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int count) {
            for (; ; ) {
                int current = getState();
                int remain = current + count;
                if (compareAndSetState(current, remain)) {
                    return true;
                }
            }
        }
    }

    private final Sync sync = new Sync(2);

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
