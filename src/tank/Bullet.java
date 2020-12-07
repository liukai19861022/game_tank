package tank;

import tank.Dir;
import tank.TankFrame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Bullet {

    private int x,y;
//    public static int WID=ResourceManger.bulletD.getWidth();
//    public static int HEI=ResourceManger.bulletD.getHeight();
    public static int WID;
    public static int HEI;
    private static final int SPEED = 10;
    private Dir dir;
    private boolean living = true;
    private GameModel gm;
    private Group group;
    private Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group, GameModel gm) {

        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        if (this.group == Group.GOOD) {
            setHEI(ResourceManger.goodBulletD.getHeight());
            setWID(ResourceManger.goodBulletD.getWidth());
        }else if (this.group == Group.BAD) {
            setHEI(ResourceManger.badBulletD.getHeight());
            setWID(ResourceManger.badBulletD.getWidth());
        }


        //init rect
        rect.x = x;
        rect.y = y;
        rect.width = WID;
        rect.height = HEI;
    }

    private void setWID(int wid) {
        WID = wid;
    }

    private void setHEI(int hei) {
        HEI = hei;
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

        if (living == false) this.gm.bullets.remove(this);

        BufferedImage img;
        switch (dir){
            case UP:
                img = this.group == Group.GOOD ? ResourceManger.goodBulletU : ResourceManger.badBulletU;
                g.drawImage(img, x, y, null);
                break;
            case DOWN:
                img = this.group == Group.GOOD ? ResourceManger.goodBulletD : ResourceManger.badBulletD;
                g.drawImage(img, x, y, null);
                break;
            case LEFT:
                img = this.group == Group.GOOD ? ResourceManger.goodBulletL : ResourceManger.badBulletL;
                g.drawImage(img, x, y, null);
                break;
            case RIGHT:
                img = this.group == Group.GOOD ? ResourceManger.goodBulletR : ResourceManger.badBulletR;
                g.drawImage(img, x, y, null);
                break;
        }

        move();
    }

    /**
     * 坦克碰撞检测
     * @param tank
     * @return
     */
    public void collideWith(Tank tank){

        if (this.group == tank.getGroup()) return ;

        /*
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
        //如果两个矩形有交集
        if (rect.intersects(tank.getRect())){
            tank.die();
            die();
            int explodeX = tank.getX() + (Tank.WID/2) - (Explode.WID/2);
            int explodeY = tank.getY() + (Tank.HEI/2) - (Explode.HEI/2);
            this.gm.explodes.add(new Explode(explodeX, explodeY, this.group, gm));
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

        //update rect
        rect.x = x;
        rect.y = y;

        if (x<0 || y <0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) living = false;
    }

    public void die(){
        this.living = false;
    }
}
