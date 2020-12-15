package cor;

import tank.Bullet;
import tank.Explode;
import tank.GameObject;
import tank.Tank;

public class BulletTankCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Bullet && o2 instanceof Tank) {

            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;

            if (bullet.group == tank.getGroup()) return false;

            //使用Rectangle工具类、进行碰撞检测
            //如果两个矩形有交集
            if (bullet.rect.intersects(tank.rect)){

                tank.die();
                bullet.die();
                int explodeX = tank.getX() + (Tank.WID/2) - (Explode.WID/2);
                int explodeY = tank.getY() + (Tank.HEI/2) - (Explode.HEI/2);
                bullet.gm.add(new Explode(explodeX, explodeY, bullet.group, bullet.gm));

                return false;
            }
        }else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);
        }

        return true;
    }
}
