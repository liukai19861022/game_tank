package cor;

import tank.Bullet;
import tank.Explode;
import tank.GameObject;
import tank.Tank;

public class BulletBulletCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Bullet && o2 instanceof Bullet) {

            Bullet b1 = (Bullet) o1;
            Bullet b2 = (Bullet) o2;

            if (b1.group == b2.group) return true;

            //使用Rectangle工具类、进行碰撞检测
            //如果两个矩形有交集
            if (b1.rect.intersects(b2.rect)){

                b1.die();
                b2.die();

                int explodet1X = b1.getX() + (b1.width/2) - (b1.expImages[0].getWidth()/2);
                int explodet1Y = b1.getY() + (b1.height/2) - (b1.expImages[0].getHeight()/2);
                int explodet2X = b2.getX() + (b2.width/2) - (b2.expImages[0].getWidth()/2);
                int explodet2Y = b2.getY() + (b2.height/2) - (b2.expImages[0].getHeight()/2);
                b1.gm.add(new Explode(explodet1X, explodet1Y, b1.expImages, b1.gm));
                b2.gm.add(new Explode(explodet2X, explodet2Y, b2.expImages, b2.gm));

                System.out.println("子弹撞上了");
                return false;
            }
        }else if (o1 instanceof Tank && o2 instanceof Bullet) {

            return collide(o2, o1);
        }

        return true;
    }
}
