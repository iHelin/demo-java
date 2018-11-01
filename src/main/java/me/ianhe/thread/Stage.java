package me.ianhe.thread;

/**
 * 舞台
 *
 * @author iHelin
 * @since 2017/11/21 12:12
 */
public class Stage extends Thread {

    @Override
    public void run() {
        System.out.println(getName() + "：欢迎观看隋唐演义");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println(getName() + "：大幕徐徐拉开");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println(getName() + "：话说隋朝末年，隋军与农民军杀得昏天黑地...");

        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");

        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //舞台线程休眠，专心看厮杀
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + "：双方激战正酣，半路杀出了个程咬金");
        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");
        System.out.println(getName() + "：程咬金的理想就是结束战争，是百姓安居乐业~！");
        //
        armyTaskOfSuiDynasty.setKeepRunning(false);
        armyTaskOfRevolt.setKeepRunning(false);

        try {
            //armyOfSuiDynasty.join();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mrCheng.start();
        try {
            //等待指定的线程终止
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "：战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民作出了贡献！");
        System.out.println(getName() + "：谢谢观看");
    }

    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.setName("舞台");
        stage.start();
    }

}
