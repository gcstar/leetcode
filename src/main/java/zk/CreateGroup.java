package zk;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * Created by guchao on 18/12/17.
 */
public class CreateGroup implements Watcher {

    private ZooKeeper zk;

    private CountDownLatch signal = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            signal.countDown();
        }
    }

    private void close() throws InterruptedException {
        zk.close();
    }

    private void connect(String host) throws Exception {
        zk = new ZooKeeper(host, 5000, this);
        signal.await();
    }

    private void create(String groupName) throws Exception {
        String path = "/" + groupName;
        if (zk.exists(path, false) == null) {
            zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("create group:" + path);
        } else {
            System.out.println("group:" + path + " exsits");
        }
    }


    public static void main(String... args) throws Exception {
        CreateGroup test = new CreateGroup();
        test.connect("localhost");
        test.create("test");
        test.close();
    }


}
