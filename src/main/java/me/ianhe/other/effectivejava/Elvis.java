package me.ianhe.other.effectivejava;

/**
 * 单例 - 使用枚举实现
 *
 * @author iHelin
 * @since 2017/11/27 14:27
 */
public class Elvis {

    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {

    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public Object readResolve() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {

    }

}
