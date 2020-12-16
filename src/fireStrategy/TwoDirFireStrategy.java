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

        int bw= tank.bulBufImages[0].getWidth();
        int bh=tank.bulBufImages[0].getHeight();
        int bX = tank.getX() + tank.width/2 - bw/2;
        int bY = tank.getY() + tank.height/2 - bh/2;

        gm.add(new Bullet(bX, bY, tank.bulBufImages, tank.expImages, tank.getDir(), tank.getGroup(), gm));
        gm.add(new Bullet(bX, bY, tank.bulBufImages, tank.expImages, tank.getOffetCurrentRightDir(), tank.getGroup(), gm));

    }
}
