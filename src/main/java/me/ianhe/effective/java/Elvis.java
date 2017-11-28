package me.ianhe.effective.java;

/**
 * 单例
 *
 * @author iHelin
 * @since 2017/11/27 14:27
 */
public class Elvis {

    public static final Elvis INSTANCE = new Elvis();

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
