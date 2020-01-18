package test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * map测试
 *
 * @author chenhonghao
 * @date 2020-01-17 16:14
 */
public class MapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>(4);
        String value = concurrentHashMap.put("1","11");
        System.out.println(value);
        value = concurrentHashMap.put("5","22");
        System.out.println(value);
    }
}