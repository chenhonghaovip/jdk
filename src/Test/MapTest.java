package Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * map测试
 *
 * @author chenhonghao
 * @date 2020-01-17 16:14
 */
public class MapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("11","11");
    }
}
