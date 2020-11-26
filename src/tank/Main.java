package tank;

import tank.TankFrame;

import java.util.Arrays;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws InterruptedException {
    	// write your code here
        TankFrame tf = new TankFrame();

        for (int i=0; i<100; i++) {

            new Thread(()->{PropertyMgr.getInstance();}).start();
        }

        int initTankCount = Integer.parseInt((String) PropertyMgr.getInstance().get("initTankCount"));
        for (int i=0; i<initTankCount; i++){

            int x = 50 + i*80;
            tf.tanks.add(new Tank(x, 100, Dir.DOWN, Group.BAD, true, tf));
        }

        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}