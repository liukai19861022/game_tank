package tank;

import tank.Dir;
import tank.TankFrame;

import java.awt.*;
import java.util.List;

public class Bullet {

    private int x,y;
    public static int WID=ResourceManger.bulletD.getWidth();
    public static int HEI=ResourceManger.bulletD.getHeight();
    private static final int SPEED = 10;
    private Dir dir;
    private boolean living = true;
    private TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public int getX() {
        return x;
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

        if (living == false) this.tf.bullets.remove(this);

        switch (dir){
            case UP:g.drawImage(ResourceManger.bulletU,x,y,null);break;
            case DOWN:g.drawImage(ResourceManger.bulletD,x,y,null);break;
            case LEFT:g.drawImage(ResourceManger.bulletL,x,y,null);break;
            case RIGHT:g.drawImage(ResourceManger.bulletR,x,y,null);break;
        }

        move();
    }

    /**
     * 坦克碰撞检测
     * @param tank
     * @return
     */
    public boolean collideWith(Tank tank){

        /*
        //low代码
        int minx = tank.getX();
        int miny = tank.getY();
        int maxx = minx + Tank.WID;
        int maxy = miny + Tank.HEI;

        if ((x>minx && x<maxx) && (y>miny && y<maxy)){
            return true;
        }else {
            return false;
        }
         */

        //使用Rectangle工具类、进行碰撞检测
        //子弹的矩形
        Rectangle rectBullet = new Rectangle(x, y, WID, HEI);
        //坦克的矩形
        Rectangle rectTank = new Rectangle(tank.getX(), tank.getY(), Tank.WID, Tank.HEI);
        //如果两个矩形有交集
        if (rectBullet.intersects(rectTank)){
            tank.die();
            die();
            return true;
        }else {
            return false;
        }
    }


    public void move(){

        switch (dir){
            case UP: y-=SPEED;break;
            case DOWN: y+=SPEED;break;
            case LEFT: x-=SPEED;break;
            case RIGHT: x+=SPEED;break;
            default: break;
        }
        if (x<0 || y <0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) living = false;
    }

    public void die(){
        this.living = false;
    }
}