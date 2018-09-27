package me.ianhe.thread;

/**
 * @author iHelin
 * @since 2018/9/27 17:18
 */
public class KeyPersonThread extends Thread {

    @Override
    public void run() {
        System.out.println(getName() + "开始了战斗");
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "攻击隋军");
        }
        System.out.println(getName() + "结束了战斗");
    }

}
