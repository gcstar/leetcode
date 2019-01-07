package concurrence.dbpool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by guchao on 18/12/14.
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList();

    public ConnectionPool(int capacity) {
        if (capacity > 0) {
            for (int i = 0; i < capacity; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection getConnection(long mills) throws InterruptedException {

        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remain = mills;
                while (pool.isEmpty() && remain > 0) {
                    pool.wait(remain);
                    remain = future - System.currentTimeMillis();
                }
                Connection conn = null;
                if (!pool.isEmpty()) {
                    conn = pool.removeFirst();
                }
                return conn;
            }
        }
    }


}
