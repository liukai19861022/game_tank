package tank;

import java.awt.*;

public class Explode {

    private int x,y;
    public static int WID=ResourceManger.explodes[0].getWidth();
    public static int HEI=ResourceManger.explodes[0].getHeight();
    private TankFrame tf = null;
    private int step = 0;
    private boolean living = true;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        //播放声音、卡顿
        //new Audio("audio/explode.wav").play();
    }

    public int getX() {
        return x;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g){

        g.drawImage(ResourceManger.explodes[step++], x, y, null);
        if (step >= ResourceManger.explodes.length){
            step =0;
            living = false;
        }
    }
}
