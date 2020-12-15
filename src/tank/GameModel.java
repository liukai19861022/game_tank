package tank;

import cor.BulletTankCollider;
import cor.Collider;
import cor.ColliderChain;
import cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameModel {

    public static GameModel INSTANCE = new GameModel();
    private ColliderChain cc = new ColliderChain();

    Tank mytank = new Tank(360,520, Dir.UP, Group.GOOD, false, this);

    List<GameObject> objects = new ArrayList<GameObject>();

    private GameModel() {

        int initTankCount = Integer.parseInt((String) PropertyMgr.getInstance().get("initTankCount"));
        for (int i=0; i<initTankCount; i++){

            int x = 50 + i*80;
            add(new Tank(x, 100, Dir.DOWN, Group.BAD, true, this));
        }

        //init wall
        int tierNum = 5;
        int wallPosY = (TankFrame.GAME_HEIGHT - tierNum*Wall.HEIGHT) / 2;
        int wallTotalNum = (TankFrame.GAME_WIDTH / Wall.WEIGHT)+1;

        for (int i=0; i<tierNum; i++) {
            for (int j=0; j<wallTotalNum; j++) {
                if (i%2 == 0)
                    add(new Wall(j*Wall.WEIGHT, wallPosY + i * Wall.HEIGHT, this));
                else
                    add(new Wall(j*Wall.WEIGHT-Wall.WEIGHT/2, wallPosY + i * Wall.HEIGHT, this));
            }
        }



    }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    public void add(GameObject go) {

        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.white);
//        g.drawString("子弹数量 ： "+ bullets.size(),10,60);
//        g.drawString("敌人数量 ： "+ tanks.size(),10,80);
//        g.drawString("爆炸数量 ： "+ explodes.size(),10,100);

        g.setColor(c);

        mytank.paint(g);

        //使用计数循环解决 java.util.ConcurrentModificationException 此问题
        for (int i=0; i<objects.size(); i++){
            objects.get(i).paint(g);
        }

        //子弹与敌方tank碰撞检测
        for (int i=0; i<objects.size(); i++) {

            for (int j=i+1; j<objects.size(); j++) { //comparator.compare(o1, o2)

                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                cc.collide(o1, o2);
            }
        }

    }

    public Tank getMaintank() {

        return mytank;
    }

}
