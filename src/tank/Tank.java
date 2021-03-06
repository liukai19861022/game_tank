package tank;

import java.awt.*;
import java.util.Random;

public class Tank {

    private int x,y;
    public static int WID = ResourceManger.badTankU.getWidth();
    public static int HEI = ResourceManger.badTankU.getHeight();
    private Dir dir;
    private static final int SPEED = 4;
    private boolean moving = false;
    private TankFrame tf = null;
    private boolean living = true;
    private Random random = new Random();
    private Group group;
    private Rectangle rect = new Rectangle();

    public Tank(int x, int y, Dir dir, Group group, boolean moving, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.moving = moving;
        this.tf = tf;

        //init rect
        rect.x = x;
        rect.y = y;
        rect.width = WID;
        rect.height = HEI;

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
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
            case RIGHT: g.drawImage(group == Group.GOOD ? ResourceManger.goodTankR : ResourceManger.badTankR, x, y, null);break;
            case LEFT: g.drawImage(group == Group.GOOD ? ResourceManger.goodTankL : ResourceManger.badTankL, x, y, null);break;
            case DOWN:g.drawImage(group == Group.GOOD ? ResourceManger.goodTankD : ResourceManger.badTankD, x, y, null);break;
            case UP:g.drawImage(group == Group.GOOD ? ResourceManger.goodTankU : ResourceManger.badTankU, x, y, null);break;
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

        //update rect
        rect.x = x;
        rect.y = y;

        if (group == Group.BAD && random.nextInt(100) > 95)
            this.fire();

        if (group == Group.BAD && random.nextInt(100) > 96)
            dir = Dir.values()[random.nextInt(4)];

        boundsCheck();
    }

    public void boundsCheck(){

        int border = 2;
        int upY = 30 + border; //含菜单条
        int bottomY = TankFrame.GAME_HEIGHT - Tank.HEI - border;
        int leftX = 0 +border;
        int rightX = TankFrame.GAME_WIDTH - Tank.WID - border;
        if (x< leftX) x = leftX;
        if (x > rightX) x = rightX;
        if (y < upY) y = upY;
        if (y > bottomY) y = bottomY;
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
        int bw=Bullet.WID,bh=Bullet.HEI;

        int bX = this.x + Tank.WID/2 - bw/2;
        int bY = this.y + Tank.HEI/2 - bh/2;
        this.tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
    }

    public void die(){
        this.living = false;
    }
}
