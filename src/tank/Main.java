package tank;

import tank.TankFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {
    	// write your code here
        TankFrame tf = new TankFrame();

        //添加敌军坦克
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
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