package tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameModel {

    public static GameModel INSTANCE = new GameModel();

    Tank mytank = new Tank(200,200, Dir.DOWN, Group.GOOD, false, this);

    List<Bullet> bullets = new ArrayList<Bullet>();
    List<Tank> tanks = new ArrayList<Tank>();
    List<Explode> explodes = new ArrayList<Explode>();


    private GameModel() {

        int initTankCount = Integer.parseInt((String) PropertyMgr.getInstance().get("initTankCount"));
        for (int i=0; i<initTankCount; i++){

            int x = 50 + i*80;
            this.tanks.add(new Tank(x, 100, Dir.DOWN, Group.BAD, true, this));
        }
    }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹数量 ： "+ bullets.size(),10,60);
        g.drawString("敌人数量 ： "+ tanks.size(),10,80);
        g.drawString("爆炸数量 ： "+ explodes.size(),10,100);

        g.setColor(c);

        mytank.paint(g);

        //使用计数循环解决 java.util.ConcurrentModificationException 此问题
        for (int i=0; i<bullets.size(); i++){
            bullets.get(i).paint(g);
        }

        for (int i=0; i<tanks.size(); i++){
            tanks.get(i).paint(g);
        }

        //子弹与敌方tank碰撞检测
        for (Iterator<Bullet> bulIt = bullets.iterator(); bulIt.hasNext();){

            Bullet bullet = bulIt.next();
            for (Iterator<Tank> tankIt = tanks.iterator(); tankIt.hasNext(); ){

                Tank tank = tankIt.next();
                bullet.collideWith(tank);
            }
        }

        //爆炸特效
        for (Iterator<Explode> it = explodes.iterator(); it.hasNext();){
            Explode e = it.next();
            e.paint(g);
            if (!e.isLiving()){
                it.remove();
            }
        }
    }

    public Tank getMaintank() {

        return mytank;
    }

    public List<Bullet> getBullets() {
        return this.bullets;
    }
}
