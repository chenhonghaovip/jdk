package test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * map测试
 *
 * @author chenhonghao
 * @date 2020-01-17 16:14
 */
public class MapTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    public static void main(String[] args) {

        reentrantLock.lock();
        try {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("11111");
        } finally {
            reentrantLock.unlock();
        }
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), r -> new Thread(r,"aaa"+atomicInteger.incrementAndGet()));
        executorService.execute(()->{
            try {
                reentrantReadWriteLock.readLock().lock();
                test();
            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        });
        executorService.execute(()-> {
            try {
                reentrantReadWriteLock.readLock().lock();
                test();
            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        });
    }

    private static void test(){
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->"123");
        threadLocal.set("123");
        System.out.println(Thread.currentThread().getName()+"start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"end");
    }

    private static class Node{
        private int num;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
