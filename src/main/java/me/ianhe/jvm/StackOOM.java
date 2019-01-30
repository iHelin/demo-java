package me.ianhe.jvm;

/**
 * java虚拟机栈及本地方法栈
 * 添加jvm参数
 * -Xss160k
 *
 * @author iHelin
 * @since 2018/3/9 16:54
 */
public class StackOOM {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackOOM oom = new StackOOM();
        try {
            oom.stackLeak();
        } catch (Throwable err) {
            System.out.println("Stack length:" + oom.stackLength);
            throw err;
        }
    }

}
