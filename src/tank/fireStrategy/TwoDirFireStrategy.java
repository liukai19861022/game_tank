package tank.fireStrategy;

import tank.Bullet;
import tank.FireStrategy;
import tank.Tank;
import tank.TankFrame;

import java.util.List;

public class TwoDirFireStrategy implements FireStrategy {

    private TwoDirFireStrategy () {}

    private static final TwoDirFireStrategy INSTANCE = new TwoDirFireStrategy();

    public static TwoDirFireStrategy getInstance() {

        return INSTANCE;
    }

    @Override
    public void fire(TankFrame tf, Tank tank) {

        int bw= Bullet.WID,bh=Bullet.HEI;
        int bX = tank.getX() + Tank.WID/2 - bw/2;
        int bY = tank.getY() + Tank.HEI/2 - bh/2;

        List<Bullet> bullets = tf.getBullets();
        bullets.add(new Bullet(bX, bY, tank.getDir(), tank.getGroup(), tf));
        bullets.add(new Bullet(bX, bY, tank.getOffetCurrentRightDir(), tank.getGroup(), tf));

    }
}
