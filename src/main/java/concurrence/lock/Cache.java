package concurrence.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by guchao on 18/12/14.
 */
public class Cache {
    static Map<String, Object> cache = new HashMap();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();


    public static final Object get(String key) {
        rwl.readLock().lock();
        try {
            return cache.get(key);
        } catch (Exception e) {
        } finally {
            rwl.readLock().unlock();
        }
        return null;
    }

    public static final void put(String key, Object value) {
        rwl.writeLock().lock();
        try {
            cache.put(key, value);
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public static final void clear() {
        rwl.writeLock().lock();
        try {
            cache.clear();
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 100000;


        for (int i = 0; i < count; i++) {
            Cache.put(String.valueOf(i), i);
            map.put(String.valueOf(i), i);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int vaule = entry.getValue();
            if (Integer.valueOf(key) != vaule) {
                System.out.println("key:" + key + ",value:" + vaule);
            }

        }

    }

}
