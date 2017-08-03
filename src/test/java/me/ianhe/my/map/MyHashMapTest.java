package me.ianhe.my.map;

import org.junit.Test;

/**
 * @author iHelin
 * @since 2017/8/2 16:42
 */
public class MyHashMapTest {

    @Test
    public void testPutAndGet() {
        MyMap<String, String> map = new MyHashMap<>();
        for (int i = 0; i < 500; i++) {
            map.put("key" + i, "value" + i);
        }
        for (int i = 0; i < 500; i++) {
            System.out.println("key" + i + ",value is:" + map.get("key" + i));
        }
    }

}