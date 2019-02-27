package me.ianhe.test.my.map;

/**
 * @author iHelin
 * @since 2017/8/2 16:15
 */
public interface MyMap<K, V> {

    V put(K k, V v);

    V get(K k);

    interface Entry<K, V> {
        K getKey();

        V getValue();
    }

}
