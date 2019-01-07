package zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.Charset;

/**
 * Created by guchao on 18/12/17.
 */
public class ActiveKeyValueStore extends ConnectionWatch {
    private static final Charset CHARSET = Charset.forName("UTF-8");

    public void write(String path, String value) throws InterruptedException, KeeperException {
        Stat stat = zk.exists(path, false);
        if (stat == null) {
            zk.create(path, value.getBytes(CHARSET), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } else {
            zk.setData(path, value.getBytes(CHARSET), -1);
        }
    }

    public String read(String path, Watcher watcher) throws InterruptedException, KeeperException {
        byte[] data = zk.getData(path, watcher, null);
        return new String(data, CHARSET);
    }

    public static void main(String... args) throws Exception {
        ActiveKeyValueStore store = new ActiveKeyValueStore();
        store.connect("localhost");
        System.out.println(store.read("/gu", store));
        store.write("/gu", "chaor222");
        System.out.println(store.read("/gu", store));
        store.close();
    }

}