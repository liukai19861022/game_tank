package tank;

import tank.Tank;
import tank.TankFrame;

public interface FireStrategy {
    void fire(GameModel gm, Tank tank);
}
