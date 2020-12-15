package cor;

import tank.Bullet;
import tank.Explode;
import tank.GameObject;
import tank.Tank;

public class TankTankCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Tank && o2 instanceof Tank) {

            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;

            //使用Rectangle工具类、进行碰撞检测
            //如果两个矩形有交集
            if (t1.rect.intersects(t2.rect)){

                t1.die();
                t2.die();
                int explodet1X = t1.getX() + (Tank.WID/2) - (Explode.WID/2);
                int explodet1Y = t1.getY() + (Tank.HEI/2) - (Explode.HEI/2);
                int explodet2X = t2.getX() + (Tank.WID/2) - (Explode.WID/2);
                int explodet2Y = t2.getY() + (Tank.HEI/2) - (Explode.HEI/2);
                t1.gm.add(new Explode(explodet1X, explodet1Y, t1.getGroup(), t1.gm));
                t2.gm.add(new Explode(explodet2X, explodet2Y, t2.getGroup(), t2.gm));

                return false;
            }
        }else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);
        }

        return true;
    }
}
