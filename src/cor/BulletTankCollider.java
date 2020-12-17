package cor;

import tank.*;

public class BulletTankCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Bullet && o2 instanceof Tank) {

            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;

            if (bullet.group == tank.getGroup()) return true;

            //使用Rectangle工具类、进行碰撞检测
            //如果两个矩形有交集
            if (bullet.rect.intersects(tank.rect)){

                tank.die();
                bullet.die();
                int explodeX = tank.getX() + (tank.width/2) - (tank.expImages[0].getWidth()/2);
                int explodeY = tank.getY() + (tank.height/2) - (tank.expImages[0].getHeight()/2);
                GameModel.getInstance().add(new Explode(explodeX, explodeY, tank.expImages));

                return false;
            }
        }else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        }

        return true;
    }
}
