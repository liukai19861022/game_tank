package tank.fireStrategy;

import tank.*;

import java.util.List;

public class DefaultFireStrategy implements FireStrategy {

    private static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();

    private DefaultFireStrategy () {}

    public static DefaultFireStrategy getInstance() {

        return INSTANCE;
    }

    @Override
    public void fire(GameModel gm, Tank tank) {

        int bw= Bullet.WID,bh=Bullet.HEI;

        int bX = tank.getX() + Tank.WID/2 - bw/2;
        int bY = tank.getY() + Tank.HEI/2 - bh/2;
        List<Bullet> bullets = gm.getBullets();
        bullets.add(new Bullet(bX, bY, tank.getDir(), tank.getGroup(), gm));
    }
}
