package io.github.ihelin.demo.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * VM options:-Xmx8m -XX:+PrintGCDetails
 * 模拟内存泄漏
 *
 * @author iHelin
 * @since 2019-01-16 17:13
 */
public class KeyLessEntry {

    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    public static void main(String[] args) {
        Map<Key, String> m = new HashMap<>();
        while (true) {
            for (int i = 0; i < 10000; i++) {
                if (!m.containsKey(new Key(i))) {
                    m.put(new Key(i), "Number:" + i);
                }
            }
        }
    }

}
