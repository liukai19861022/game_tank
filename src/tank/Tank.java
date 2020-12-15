package tank;

import fireStrategy.DefaultFireStrategy;
import fireStrategy.FireStrategy;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Tank extends GameObject{

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
    public Rectangle rect = new Rectangle();
    public GameModel gm;

    public Tank(int x, int y, Dir dir, Group group, boolean moving, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.moving = moving;
        this.gm = gm;

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

        if (!living) gm.remove(this);

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
            this.fire(DefaultFireStrategy.getInstance());

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

    public Dir getOffetCurrentRightDir() {

        Dir[] dirs = Dir.values();
        int key = Arrays.binarySearch(dirs, this.dir);

        int maxKey = dirs.length-1;
        int nextKey = key < maxKey ? key+1 : 0;

        return dirs[nextKey];
    }

    /**
     * tank类直接使用tankFrame的对象引用、直接对tankFrame中bullet进行操作赋值
     */
    public void fire(FireStrategy fireStrategy){

        fireStrategy.fire(this.gm, this);
    }

    public void die(){
        this.living = false;
    }
}