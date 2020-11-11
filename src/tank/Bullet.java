package tank;

import tank.Dir;
import tank.TankFrame;

import java.awt.*;
import java.util.List;

public class Bullet {

    private int x,y;
    private static int WID=10,HEI=10;
    private static final int SPEED = 8;
    private Dir dir;
    private boolean live = true;
    private TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){

        if (live == false) this.tf.bullets.remove(this);

        //验证子弹是否击毁坦克
        attackFinish();

        switch (dir){
            case UP:g.drawImage(ResourceManger.bulletU,x,y,null);break;
            case DOWN:g.drawImage(ResourceManger.bulletD,x,y,null);break;
            case LEFT:g.drawImage(ResourceManger.bulletL,x,y,null);break;
            case RIGHT:g.drawImage(ResourceManger.bulletR,x,y,null);break;
        }

        move();
    }

    public void attackFinish(){

        List<Tank> foes = this.tf.foes;
        for (int i=0; i<foes.size(); i++){
            Tank tank = foes.get(i);
            int minx = tank.getX();
            int miny = tank.getY();
            int maxx = minx + Tank.WID;
            int maxy = miny + Tank.HEI;

            if ((x>minx && x<maxx) && (y>miny && y<maxy)){
                this.tf.foes.remove(tank);
                this.tf.bullets.remove(this);
            }
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
        if (x<0 || y <0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) live = false;
    }
}
