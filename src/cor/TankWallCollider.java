package cor;

import tank.Bullet;
import tank.GameObject;
import tank.Tank;
import tank.Wall;

public class TankWallCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Tank && o2 instanceof Wall) {

            Tank t = (Tank)o1;
            Wall w = (Wall)o2;

            if (t.rect.intersects(w.rect)) {
                t.back();
            }
        }else if (o1 instanceof Wall && o2 instanceof Bullet) {
            return collide(o2, o1);
        }

        return true;
    }
}