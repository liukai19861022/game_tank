package tank;

import java.awt.*;
import java.util.Random;

public class Tank {

    private int x,y;
    public static int WID = ResourceManger.tankD.getWidth();
    public static int HEI = ResourceManger.tankD.getHeight();
    private Dir dir;
    private static final int SPEED = 2;
    private boolean moving = true;
    private TankFrame tf = null;
    private boolean living = true;
    Random random = new Random();
    Group group;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
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

        if (!living) tf.tanks.remove(this);

        switch (dir){
            case RIGHT: g.drawImage(ResourceManger.tankR,x,y,null);break;
            case LEFT: g.drawImage(ResourceManger.tankL,x,y,null);break;
            case DOWN:g.drawImage(ResourceManger.tankD,x,y,null);break;
            case UP:g.drawImage(ResourceManger.tankU,x,y,null);break;
        }

        move();
    }

    public void move(){
        if (!moving) return;
        switch (dir){
            case LEFT: x -= SPEED;
                break;
            case RIGHT: x += SPEED;
                break;
            case UP: y -= SPEED;
                break;
            case DOWN: y += SPEED;
                break;
        }

        if (group == Group.BAD) autoFire();

    }

    public void autoFire(){
        if (random.nextInt(10) > 8){
            this.fire();
        }
    }


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    /**
     * tank类直接使用tankFrame的对象引用、直接对tankFrame中bullet进行操作赋值
     */
    public void fire(){
        int bw=0,bh=0;
        switch (dir){
            case UP:
                bw = 10;
                bh = 12;
                break;
            case DOWN:
                bw = 14;
                bh = 12;
                break;
            case LEFT:
                bw = 12;
                bh = 6;
                break;
            case RIGHT:
                bw = 12;
                bh = 4;
                break;
            default:
                break;
        }

        int bX = this.x + Tank.WID/2 - bw/2;
        int bY = this.y + Tank.HEI/2 - bh/2;
        this.tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
    }

    public void die(){
        this.living = false;
    }
}
