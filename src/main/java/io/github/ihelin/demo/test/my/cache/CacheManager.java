package io.github.ihelin.demo.test.my.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * 缓存实现
 *
 * @author iHelin
 * @since 2017/11/27 14:34
 */
public class CacheManager {

    private static final HashMap<String, Object> cacheMap = new HashMap<>();

    /**
     * 单实例构造方法
     */
    private CacheManager() {
        super();
    }

    /**
     * 获取布尔值的缓存
     *
     * @param key
     * @return
     */
    public static boolean getSimpleFlag(String key) {
        try {
            return (Boolean) cacheMap.get(key);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static long getServerStartdt(String key) {
        try {
            return (Long) cacheMap.get(key);
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * 设置布尔值的缓存
     *
     * @param key
     * @param flag 是否允许被覆盖
     * @return
     */
    public synchronized static boolean setSimpleFlag(String key, boolean flag) {
        // 假如为真不允许被覆盖
        if (flag && getSimpleFlag(key)) {
            return false;
        } else {
            cacheMap.put(key, flag);
            return true;
        }
    }

    public synchronized static boolean setSimpleFlag(String key, long serverbegrundt) {
        if (cacheMap.get(key) == null) {
            cacheMap.put(key, serverbegrundt);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 得到缓存，同步静态方法
     *
     * @param key
     * @return
     */
    private synchronized static Cache getCache(String key) {
        return (Cache) cacheMap.get(key);
    }

    /**
     * 判断是否存在一个缓存
     *
     * @param key
     * @return
     */
    private synchronized static boolean hasCache(String key) {
        return cacheMap.containsKey(key);
    }

    /**
     * 清除所有缓存
     */
    public synchronized static void clearAll() {
        cacheMap.clear();
    }

    /**
     * 清除某一类特定缓存,通过遍历HashMap下的所有对象，来判断它的key与传入的type是否匹配
     *
     * @param type
     */
    public synchronized static void clearAll(String type) {
        Iterator<?> i = cacheMap.entrySet().iterator();
        String key;
        ArrayList<String> arr = new ArrayList<>();
        try {
            while (i.hasNext()) {
                Entry<String, Object> entry = (Entry<String, Object>) i.next();
                key = entry.getKey();
                // 如果匹配则删除掉
                if (key.startsWith(type)) {
                    arr.add(key);
                }
            }
            for (int k = 0; k < arr.size(); k++) {
                clearOnly(arr.get(k));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 清除指定的缓存
     *
     * @param key
     */
    public synchronized static void clearOnly(String key) {
        cacheMap.remove(key);
    }

    /**
     * 载入缓存
     *
     * @param key
     * @param obj
     */
    public synchronized static void putCache(String key, Cache obj) {
        cacheMap.put(key, obj);
    }

    /**
     * 获取缓存信息
     *
     * @param key
     * @return
     */
    public static Cache getCacheInfo(String key) {
        if (hasCache(key)) {
            Cache cache = getCache(key);
            // 调用判断是否终止方法
            if (cacheExpired(cache)) {
                cache.setExpired(true);
            }
            return cache;
        } else {
            return null;
        }
    }

    /**
     * 载入缓存信息
     *
     * @param key
     * @param obj
     * @param dt
     * @param expired
     */
    public static void putCacheInfo(String key, Cache obj, long dt, boolean expired) {
        Cache cache = new Cache();
        cache.setKey(key);
        // 设置多久后更新缓存
        cache.setTimeOut(dt + System.currentTimeMillis());
        cache.setValue(obj);
        cache.setExpired(expired);
        cacheMap.put(key, cache);
    }

    /**
     * 重写载入缓存信息方法
     *
     * @param key
     * @param obj
     * @param dt
     */
    public static void putCacheInfo(String key, Cache obj, long dt) {
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setTimeOut(dt + System.currentTimeMillis());
        cache.setValue(obj);
        //缓存默认载入时，过期状态为FALSE
        cache.setExpired(false);
        cacheMap.put(key, cache);
    }

    /**
     * 判断缓存是否过期
     *
     * @param cache
     * @return
     */
    public static boolean cacheExpired(Cache cache) {
        // 传入的缓存不存在
        if (null == cache) {
            return false;
        }
        // 系统当前的毫秒数
        long nowDt = System.currentTimeMillis();
        // 缓存内的过期毫秒数
        long cacheDt = cache.getTimeOut();

        return cacheDt > 0 && cacheDt <= nowDt;
    }

    /**
     * 获取缓存中的大小
     *
     * @return
     */
    public static int getCacheSize() {
        return cacheMap.size();
    }

    /**
     * 获取指定的类型的大小
     *
     * @param type
     * @return
     */
    public static int getCacheSize(String type) {
        int k = 0;
        Iterator<?> i = cacheMap.entrySet().iterator();
        String key;
        try {
            while (i.hasNext()) {
                Entry<?, ?> entry = (Entry<?, ?>) i.next();
                key = (String) entry.getKey();
                // 如果匹配则删除掉
                if (key.indexOf(type) != -1) {
                    k++;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return k;
    }

    /**
     * 获取缓存对象中的所有键值名称
     *
     * @return
     */
    public static ArrayList<String> getCacheAllkey() {
        ArrayList<String> a = new ArrayList<>();
        try {
            Iterator<?> i = cacheMap.entrySet().iterator();
            while (i.hasNext()) {
                Entry entry = (Entry) i.next();
                a.add((String) entry.getKey());
            }
        } catch (Exception ex) {
        } finally {
            return a;
        }
    }

    /**
     * 获取缓存对象中指定类型 的键值名称
     *
     * @param type
     * @return
     */
    public static ArrayList<String> getCacheListkey(String type) {
        ArrayList a = new ArrayList();
        String key;
        try {
            Iterator i = cacheMap.entrySet().iterator();
            while (i.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
                key = (String) entry.getKey();
                if (key.indexOf(type) != -1) {
                    a.add(key);
                }
            }
        } catch (Exception ex) {
        } finally {
            return a;
        }
    }

    public static void main(String[] args) {
        // System.out.println(CacheManager.getSimpleFlag("alksd"));
        CacheManager.putCache("abc", new Cache());
        CacheManager.putCache("def", new Cache());
        CacheManager.putCache("ccc", new Cache());
        CacheManager.clearOnly("");
        Cache c = new Cache();
        for (int i = 0; i < 10; i++) {
            CacheManager.putCache(String.valueOf(i), c);
        }
        CacheManager.putCache("aaaaaaaa", c);
        CacheManager.putCache("abchcy;alskd", c);
        CacheManager.putCache("cccccccc", c);
        CacheManager.putCache("abcoqiwhcy", c);
        System.out.println("删除前的大小：" + CacheManager.getCacheSize());
        CacheManager.getCacheAllkey();
        CacheManager.clearAll("aaaa");
        System.out.println("删除后的大小：" + CacheManager.getCacheSize());
        CacheManager.clearAll("abchcy;alskd");
        System.out.println("删除后的大小：" + CacheManager.getCacheSize());
        CacheManager.clearAll();
        System.out.println("删除后的大小：" + CacheManager.getCacheSize());
        CacheManager.getCacheAllkey();
    }
}
