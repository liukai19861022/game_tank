package fireStrategy;

import tank.*;

import java.util.List;

public class TwoDirFireStrategy implements FireStrategy {

    private TwoDirFireStrategy () {}

    private static final TwoDirFireStrategy INSTANCE = new TwoDirFireStrategy();

    public static TwoDirFireStrategy getInstance() {

        return INSTANCE;
    }

    @Override
    public void fire(GameModel gm, Tank tank) {

        int bw= Bullet.WID,bh=Bullet.HEI;
        int bX = tank.getX() + Tank.WID/2 - bw/2;
        int bY = tank.getY() + Tank.HEI/2 - bh/2;

        gm.add(new Bullet(bX, bY, tank.getDir(), tank.getGroup(), gm));
        gm.add(new Bullet(bX, bY, tank.getOffetCurrentRightDir(), tank.getGroup(), gm));

    }
}
