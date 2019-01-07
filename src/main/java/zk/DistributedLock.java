package zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by guchao on 18/12/17.
 */
public class DistributedLock implements Lock, Watcher {
    private ZooKeeper zk;
    private String root = "/locks";
    private String lockName;
    private String waitNode;
    private String myZnode;
    private CountDownLatch latch;
    private int sessionTimeout = 3000;
    private List<Exception> exception = new ArrayList();


    public DistributedLock(String host, String lockName) {
        this.lockName = lockName;
        try {
            zk = new ZooKeeper(host, sessionTimeout, this);
            Stat stat = zk.exists(root, false);
            if (stat == null) {
                zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }

        } catch (IOException ex) {
            exception.add(ex);
        } catch (InterruptedException ex) {
            exception.add(ex);
        } catch (KeeperException ex) {
            exception.add(ex);
        }

    }


    @Override
    public void lock() {
        if (exception.size() > 0) {
            throw new LockException(exception.get(0));
        }

        try {
            if (this.tryLock()) {
                System.out.println("Thread " + Thread.currentThread().getName() + " " + myZnode + " get lock true");
                return;
            } else {
                waitForLock(waitNode, sessionTimeout);
            }
        } catch (KeeperException ex) {
            throw new LockException(ex);
        } catch (InterruptedException ex) {
            throw new LockException(ex);
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        this.lock();
    }

    @Override
    public boolean tryLock() {
        try {
            String splitLock = "_lock_";
            if (lockName.contains("lock"))
                throw new LockException("lockName cannot contain 'lock'");

            myZnode = zk.create(root + "/" + lockName + splitLock, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(myZnode + " is created");

            List<String> children = zk.getChildren(root, false);
            List<String> lockObjNodes = new ArrayList<>();
            for (String child : children) {
                String name = child.split(splitLock)[0];
                if (name.equals(lockName))
                    lockObjNodes.add(child);
            }

            Collections.sort(lockObjNodes);
            System.out.println(myZnode + "==" + lockObjNodes.get(0));
            if (myZnode.equals(root + "/" + lockObjNodes.get(0)))
                return true;
            String subMyZnode = myZnode.substring(myZnode.lastIndexOf("/") + 1);
            waitNode = lockObjNodes.get(Collections.binarySearch(lockObjNodes, subMyZnode) - 1);


        } catch (KeeperException ex) {
            throw new LockException(ex);

        } catch (InterruptedException ex) {
            throw new LockException(ex);
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {

        try {
            if (tryLock()) {
                return true;
            } else {
                return waitForLock(waitNode, time);
            }
        } catch (KeeperException ex) {

        }
        return false;
    }

    private boolean waitForLock(String lower, long waitTime) throws InterruptedException, KeeperException {
        Stat stat = zk.exists(root + "/" + lower, false);
        if (stat != null) {
            System.out.println("Thread " + Thread.currentThread().getName() + " wait for " + root + "/" + lower);
            this.latch = new CountDownLatch(1);
            latch.await(waitTime, TimeUnit.MILLISECONDS);
            this.latch = null;

        }
        return true;
    }

    @Override
    public void unlock() {
        try {
            System.out.println("try unlock " + myZnode);
            zk.delete(myZnode, -1);
            myZnode = null;
            zk.close();

        } catch (InterruptedException ex) {

        } catch (KeeperException ex) {

        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (this.latch != null) {
            this.latch.countDown();
        }
    }

    public class LockException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public LockException(String e) {
            super(e);
        }

        public LockException(Exception e) {
            super(e);
        }
    }

}
