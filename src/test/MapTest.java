package test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * map测试
 *
 * @author chenhonghao
 * @date 2020-01-17 16:14
 */
public class MapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>(4);
        String value = concurrentHashMap.put("1","1d1");
        System.out.println(value);
        value = concurrentHashMap.put("5","22");
        System.out.println(value);
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

        try {

        } finally {
            reentrantLock.unlock();
        }

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.writeLock().lock();
        reentrantReadWriteLock.writeLock().unlock();
        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.readLock().unlock();
    }
}
