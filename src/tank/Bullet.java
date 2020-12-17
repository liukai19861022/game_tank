package tank;

import tank.Dir;
import tank.TankFrame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Bullet extends GameObject{

    public int width;
    public int height;
    private static final int SPEED = 10;
    private Dir dir;
    private boolean living = true;
    public Group group;
    public Rectangle rect = new Rectangle();
    public BufferedImage[] images;
    public BufferedImage[] expImages;

    public Bullet(int x, int y, BufferedImage[] images, BufferedImage[] expImages, Dir dir, Group group) {

        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.images = images;
        this.expImages = expImages;

        height = images[0].getHeight();
        width = images[0].getWidth();

        //init rect
        rect.x = x;
        rect.y = y;

        //加大子弹面积、增加4倍碰撞机会
        rect.width = width*4;
        rect.height = height*4;
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

        if (living == false) GameModel.getInstance().remove(this);

        switch (dir){
            case UP: g.drawImage(images[0], x, y, null);break;
            case RIGHT: g.drawImage(images[1], x, y, null);break;
            case DOWN: g.drawImage(images[2], x, y, null);break;
            case LEFT: g.drawImage(images[3], x, y, null);break;
        }

        move();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    /**
     * 坦克碰撞检测
     * 废弃
     * @param tank
     * @return
     */
    public void collideWith(Tank tank){

        if (this.group == tank.getGroup()) return ;

        /**
         * 第一种情况：
         *     tkMinx|---------------------|tkMaxX
         *     |-------|bulMaxX
         *     bulMaxX >= tkMinx && bulMaxX <= tkMaxX //碰撞检测x成立
         *
         * 第二种情况：
         *     tkMinX|---------------------|tkMaxX
         *       bulMinX|-------|bulMaxX
         * 第三种情况：
         *     tkMinX|---------------------|tkMaxX
         *                       bulMinX|-------|bulMaxX
         * 第二种和第三种均为 bulMinX >= tkMinX && bulMax <= tkMaxX 、可直接忽视 bulMaxX所处位置。
         *      bulMinX >= tkMinX && bulMax <= tkMaxX //碰撞检测x成立
         */
        /*
        int bulMinX = this.x;
        int bulMaxX = bulMinX + Bullet.WID;
        int tkMinX = tank.getX();
        int tkMaxX = tkMinX + Tank.WID;
        int bulMinY = this.y;
        int bulMaxY = bulMinY + Bullet.HEI;
        int tkMinY = tank.getY();
        int tkMaxY = tkMinY + Tank.HEI;

        if (((bulMaxX >= tkMinX && bulMaxX <= tkMaxX) || (bulMinX >= tkMinX && bulMinX <= tkMaxX)) && ((bulMaxY >= tkMinY && bulMaxY <= tkMaxY) || (bulMinY >= tkMinY && bulMinY <= tkMaxY))) {
            tank.die();
            die();
            int explodeX = tank.getX() + (Tank.WID/2) - (Explode.WID/2);
            int explodeY = tank.getY() + (Tank.HEI/2) - (Explode.HEI/2);
            this.gm.add(new Explode(explodeX, explodeY, this.group, gm));
        }
        */
//        ...
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
