import java.awt.*;
import java.util.List;


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

        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y, WID, HEI);
        g.setColor(c);

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
    public List<Bullet> fire(List<Bullet> bulletList){

        bulletList.add(new Bullet(this.x+(Tank.WID/2-5), this.y+Tank.HEI/2-5,this.dir ));
        return bulletList;
    }
     */

    /**
     * tank类直接使用tankFrame的对象引用、直接对tankFrame中bullet进行操作赋值
     */
    public void fire(){

        this.tf.bullets.add(new Bullet(this.x+(Tank.WID/2-5), this.y+Tank.HEI/2-5,this.dir, this.tf ));
    }

}
