package zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by guchao on 18/12/17.
 */
public class ConnectionWatch implements Watcher {
    private static final int SESSION_TIME_OUT = 5000;

    protected ZooKeeper zk;
    private CountDownLatch signal = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            signal.countDown();
        }
    }

    public void connect(String host) throws InterruptedException,IOException {
        zk = new ZooKeeper(host, SESSION_TIME_OUT, this);
        signal.await();
    }

    public void close() throws InterruptedException {
        zk.close();
    }
}
