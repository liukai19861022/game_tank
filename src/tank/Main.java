package tank;

import tank.TankFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {
    	// write your code here
        TankFrame tf = new TankFrame();

        //添加敌军坦克
        for (int i=0; i<5; i++){
            int x = 50 + i*80;
            tf.tanks.add(new Tank(x, 100, Dir.DOWN, Group.BAD, tf));
        }

        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
