package fireStrategy;

import decorator.GODecorator;
import decorator.LineDecorator;
import decorator.ProtectiveCoverDecorator;
import decorator.RectDecorator;
import tank.*;

import java.util.List;

public class TwoDirFireStrategy implements FireStrategy {

    private TwoDirFireStrategy () {}

    private static final TwoDirFireStrategy INSTANCE = new TwoDirFireStrategy();

    public static TwoDirFireStrategy getInstance() {

        return INSTANCE;
    }

    @Override
    public void fire(Tank tank) {

        int bw= tank.bulBufImages[0].getWidth();
        int bh=tank.bulBufImages[0].getHeight();
        int bX = tank.getX() + tank.width/2 - bw/2;
        int bY = tank.getY() + tank.height/2 - bh/2;

        GODecorator goDecorator = new ProtectiveCoverDecorator(
            new RectDecorator(
                new Bullet(bX, bY, tank.bulBufImages, tank.expImages, tank.getDir(), tank.getGroup())
            )
        );
        GameModel.getInstance().add(goDecorator);
        GameModel.getInstance().add(new Bullet(bX, bY, tank.bulBufImages, tank.expImages, tank.getOffetCurrentRightDir(), tank.getGroup()));
    }
}
