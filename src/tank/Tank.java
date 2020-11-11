package tank;

import java.awt.*;


public class Tank {

    private int x,y;
    public static int WID=50,HEI=50;
    private Dir dir;
    private static final int SPEED = 10;
    private boolean moving = false;
    private TankFrame tf = null;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
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
     * 废弃
     * @param bulletList
     * @return
     */
    /*
    public List<tank.Bullet> fire(List<tank.Bullet> bulletList){

        bulletList.add(new tank.Bullet(this.x+(tank.Tank.WID/2-5), this.y+tank.Tank.HEI/2-5,this.dir ));
        return bulletList;
    }
     */

    /**
     * tank类直接使用tankFrame的对象引用、直接对tankFrame中bullet进行操作赋值
     */
    public void fire(){
//        int bw=0,bh=0,tw=0,th=0;
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

        this.tf.bullets.add(new Bullet(this.x+Tank.WID/2-bw/2, this.y+Tank.HEI/2-bh/2,this.dir, this.tf ));
    }

}
