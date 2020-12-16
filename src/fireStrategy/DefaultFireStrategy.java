package fireStrategy;

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

        int bw= tank.bulBufImages[0].getWidth();
        int bh=tank.bulBufImages[0].getHeight();

        int bX = tank.getX() + tank.width/2 - bw/2;
        int bY = tank.getY() + tank.height/2 - bh/2;
        gm.add(new Bullet(bX, bY, tank.bulBufImages, tank.expImages, tank.getDir(), tank.getGroup(), gm));
    }
}
